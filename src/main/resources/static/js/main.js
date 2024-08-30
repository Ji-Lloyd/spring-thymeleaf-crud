$(document).ready(function () {

    $(' .table .uBtn').on('click', function (event) {
        event.preventDefault();
        var href = $(this).attr('href');
        var text = $(this).text();

        if (text === 'Update') {
            $.get(href, function (employee, status) {
                $('.myUpdateForm #employeeId').val(employee.employeeId);
                $('.myUpdateForm #firstNameUpdate').val(employee.firstName);
                $('.myUpdateForm #middleNameUpdate').val(employee.middleName);
                $('.myUpdateForm #lastNameUpdate').val(employee.lastName);
                $('.myUpdateForm #birthdateUpdate').val(employee.birthdate);
                $('.myUpdateForm #designationIdUpdate').val(employee.designation.designationId);

                // Set the gender radio button based on the employee's gender
                if (employee.gender === 'Male') {
                    $('#genderMaleUpdate').prop('checked', true);
                } else if (employee.gender === 'Female') {
                    $('#genderFemaleUpdate').prop('checked', true);
                }
            });

            $('.myUpdateForm #updateEmployeeModal').modal();
        } else {
        }
    });

});