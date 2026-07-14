<%@ page import="model.Employee" %>

<%
Employee employee = (Employee) request.getAttribute("employee");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Edit Employee</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/editEmployee.css">

</head>

<body>

<div class="container">

    <div class="card">

        <h2>Edit Employee</h2>

        <form action="<%=request.getContextPath()%>/updateEmployeeServlet" method="post">

            <input type="hidden"
                   name="id"
                   value="<%=employee.getId()%>">

            <div class="form-group">

                <label>Name</label>

                <input type="text"
                       name="name"
                       value="<%=employee.getName()%>"
                       required>

            </div>

            <div class="form-group">

                <label>Email</label>

                <input type="email"
                       name="email"
                       value="<%=employee.getEmail()%>"
                       required>

            </div>

            <div class="form-group">

                <label>Phone</label>

                <input type="text"
                       name="number"
                       value="<%=employee.getPhone()%>"
                       required>

            </div>

            <div class="form-group">

                <label>Department</label>

                <input type="text"
                       name="department"
                       value="<%=employee.getDepartment()%>"
                       required>

            </div>

            <div class="form-group">

                <label>Salary</label>

                <input type="number"
                       name="salary"
                       value="<%=employee.getSalary()%>"
                       required>

            </div>

            <div class="form-group">

                <label>Joining Date</label>

                <input type="date"
                       name="joiningdate"
                       value="<%=employee.getJoiningDate()%>"
                       required>

            </div>

            <button type="submit">
                Update Employee
            </button>

        </form>

    </div>

</div>

</body>
</html>