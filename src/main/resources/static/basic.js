$(document).ready(function () {
  showCourses();
  showStudents();
  showInstructors();
});

function showInstructors() {
  $.ajax({
    type: "GET",
    url: "api/instructors",
    success: function (response) {
      for (let i = 0; i < response.length; i++) {
        let instructor = response[i];
        let tempHtml = createInstructorHtml(instructor);
        $("#instructorList").append(tempHtml);
      }
    },
  });
}

function showStudents() {
  $.ajax({
    type: "GET",
    url: "api/students",
    success: function (response) {
      for (let i = 0; i < response.length; i++) {
        let student = response[i];
        let tempHtml = createStudentHtml(student);
        $("#studentList").append(tempHtml);
      }
    },
  });
}

function showCourses() {
  $.ajax({
    type: "GET",
    url: "/api/courses",
    success: function (response) {
      for (let i = 0; i < response.length; i++) {
        let course = response[i];
        let tempHtml = createCourseHtml(course);
        $("#courseList").append(tempHtml);
      }
    },
  });
}

function removeUnderscore(str) {
  return str.replace("_", " ");
}

function createInstructors(instructor) {
  $.ajax({
    type: "GET",
    url: "/api/instructors",
    success: function (response) {
      for (let i = 0; i < response.length; i++) {
        let instructor = response[i];
        let tempHtml = createInstructorHtml(instructor);
        $("#instructorList").append(tempHtml);
      }
    },
  });
}

function createInstructorHtml(instructor) {
  let fixedMajor = removeUnderscore(instructor.major);
  return `
        <tr>
            <td>${instructor.id}</td>
            <td>${instructor.firstname}</td>
            <td>${instructor.lastname}</td>
            <td>${instructor.address}</td>
            <td>${instructor.city}</td>
            <td>${instructor.state}</td>
            <td>${instructor.zipcode}</td>
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
            <td>${student.address}</td>
            <td>${student.city}</td>
            <td>${student.state}</td>
            <td>${student.zipcode}</td>
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
