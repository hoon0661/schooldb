let categoryButton = "course";
let searchParam;

$(document).ready(function () {
    $("#courseBtn").on("click", function () {
        categoryButton = "course";
        $("#courseList").removeClass("noDisplay");
        $("#instructorList").addClass("noDisplay");
        $("#studentList").addClass("noDisplay");
        $("#courseBtn").addClass("selected");
        $("#instructorBtn").removeClass("selected");
        $("#studentBtn").removeClass("selected");
        createCategoryForCourse();
        showCourses();
    })

    $("#instructorBtn").on("click", function () {
        categoryButton = "instructor";
        $("#instructorList").removeClass("noDisplay");
        $("#courseList").addClass("noDisplay");
        $("#studentList").addClass("noDisplay");
        $("#courseBtn").removeClass("selected");
        $("#instructorBtn").addClass("selected");
        $("#studentBtn").removeClass("selected");
        createCategoryForStudentAndInstructor();
        showInstructors();
    })

    $("#studentBtn").on("click", function () {
        categoryButton = "student";
        $("#studentList").removeClass("noDisplay");
        $("#instructorList").addClass("noDisplay");
        $("#courseList").addClass("noDisplay");
        $("#courseBtn").removeClass("selected");
        $("#instructorBtn").removeClass("selected");
        $("#studentBtn").addClass("selected");
        createCategoryForStudentAndInstructor();
        showStudents();
    })

    $("#query").on("input", function () {
        searchParam = $("#category option:selected").val();
        getResultFromSearch();
    })

    $("body").on("click", function () {
        $("#suggestion").css("display", "none");
    })

    $("#register-button").on("click", function () {
        register();
    })

    createCategoryForCourse();
    showCourses();
    $("#courseBtn").addClass("selected");
});

function register() {
    const firstname = $("#firstname").val();
    const lastname = $("#lastname").val();
    const major = $("#major").val();
    const address = $("#address").val();
    const city = $("#city").val();
    const state = $("#state").val();
    const zipcode = $("#zipcode").val();
    const email = $("#email").val();
    const phone = $("#phone").val();

    const data = {firstname, lastname, major, address, city, state, zipcode, email, phone}
    console.log("called!");

    $.ajax({
        type: "POST",
        url: `/api/${categoryButton}s`,
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            console.log(response);
            window.location.href = "/";
        }
    })
}

function getResultFromSearch() {
    const str = $("#query").val();
    searchParam = $("#category option:selected").val();
    $.ajax({
        type: "GET",
        url: `api/search?str=${str}&searchParam=${searchParam}&category=${categoryButton}`,
        success: function (response) {
            $("#suggestion-box").empty();
            $("#suggestion").css("display", "block");
            for (let i = 0; i < response.length; i++) {
                let data = response[i];
                let tempHtml = createSearchResult(data);
                $("#suggestion-box").append(tempHtml);
            }

        },
    });
}

function createSearchResult(response) {
    if (categoryButton === "course") {
        if (searchParam === "courseName") {
            return `<li>${response.courseName}</li>`
        }
    } else if (categoryButton === "instructor" || categoryButton === "student") {
        if (searchParam === "firstName") {
            return `<li>${response.firstname}</li>`
        } else if (searchParam === "lastName") {
            return `<li>${response.lastname}</li>`
        } else if (searchParam === "major") {
            return `<li>${response.major}</li>`
        }
    }
}

function showInstructors() {
    var sortBy = "id";
    var isAsc = true;
    $("#pagination").pagination({
        dataSource: `/api/instructors?sortBy=${sortBy}&isAsc=${isAsc}`,
        locator: "content",
        alias: {
            pageNumber: "page",
            pageSize: "size"
        },
        totalNumberLocator: (response) => {
            return response.totalElements;
        },
        pageSize: 10,
        showPrevious: true,
        showNext: true,
        ajax: {
            beforeSend: function () {
            }
        },
        callback: function (response, pagination) {
            $("#instructorList").empty();
            for (let i = 0; i < response.length; i++) {
                let course = response[i];
                let tempHtml = createInstructorHtml(course);
                $("#instructorList").append(tempHtml);
            }
        }

    })
}

function showStudents() {
    // $("#studentList").empty();
    // $.ajax({
    //     type: "GET",
    //     url: "api/students",
    //     success: function (response) {
    //         for (let i = 0; i < response.length; i++) {
    //             let student = response[i];
    //             let tempHtml = createStudentHtml(student);
    //             $("#studentList").append(tempHtml);
    //         }
    //     },
    // });
    var sortBy = "id";
    var isAsc = true;
    $("#pagination").pagination({
        dataSource: `/api/students?sortBy=${sortBy}&isAsc=${isAsc}`,
        locator: "content",
        alias: {
            pageNumber: "page",
            pageSize: "size"
        },
        totalNumberLocator: (response) => {
            return response.totalElements;
        },
        pageSize: 10,
        showPrevious: true,
        showNext: true,
        ajax: {
            beforeSend: function () {
            }
        },
        callback: function (response, pagination) {
            $("#studentList").empty();
            for (let i = 0; i < response.length; i++) {
                let course = response[i];
                let tempHtml = createStudentHtml(course);
                $("#studentList").append(tempHtml);
            }
        }

    })
}

function showCourses() {

    // $.ajax({
    //     type: "GET",
    //     url: "/api/courses",
    //     success: function (response) {
    //         for (let i = 0; i < response.length; i++) {
    //             let course = response[i];
    //             let tempHtml = createCourseHtml(course);
    //             $("#courseList").append(tempHtml);
    //         }
    //     },
    // });
    var sortBy = "id";
    var isAsc = true;
    $("#pagination").pagination({
        dataSource: `/api/courses?sortBy=${sortBy}&isAsc=${isAsc}`,
        locator: "content",
        alias: {
            pageNumber: "page",
            pageSize: "size"
        },
        totalNumberLocator: (response) => {
            return response.totalElements;
        },
        pageSize: 10,
        showPrevious: true,
        showNext: true,
        ajax: {
            beforeSend: function () {
            }
        },
        callback: function (response, pagination) {
            $("#courseList").empty();
            for (let i = 0; i < response.length; i++) {
                let course = response[i];
                let tempHtml = createCourseHtml(course);
                $("#courseList").append(tempHtml);
            }
        }

    })
}

function createInstructorHtml(instructor) {
    let fixedMajor = removeUnderscore(instructor.major);
    return `
        <tr>
            <td>${instructor.id}</td>
            <td>${instructor.firstname}</td>
            <td>${instructor.lastname}</td>
            <td>${fixedMajor}</td>
            <td>${instructor.email}</td>
            <td>${instructor.phone}</td>
        </tr>
    `;
}

function createStudentHtml(student) {
    let fixedMajor = removeUnderscore(student.major);
    return `
        <tr>
            <td>${student.id}</td>
            <td>${student.firstname}</td>
            <td>${student.lastname}</td>
            <td>${fixedMajor}</td>
            <td>${student.email}</td>
            <td>${student.phone}</td>
        </tr>
    `;
}

function createCourseHtml(course) {
    return `
          <tr>
              <td>${course.id}</td>
              <td>${course.courseName}</td>
              <td>${course.capacity}</td>
              <td>${course.description}</td>
          </tr>
      `;
}

function removeUnderscore(str) {
    return str.replace("_", " ");
}

function createCategoryForStudentAndInstructor() {
    $("#category").empty();
    $("#category").append($('<option>').val("firstName").text("Firstname").prop("selected", true));
    $("#category").append($('<option>').val("lastName").text("Lastname"));
    $("#category").append($('<option>').val("major").text("Major"));
}

function createCategoryForCourse() {
    $("#category").empty();
    $("#category").append($('<option>').val("courseName").text("Course name").prop("selected", true));
}

function createCourseHeader(course) {
}

function createInstructorHeader(instructer) {
}

function createStudentHeader(student) {
}