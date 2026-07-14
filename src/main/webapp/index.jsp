<!DOCTYPE html>
<html>
<head>
<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>Employee Management System</title>
<link rel="stylesheet"
      href="${pageContext.request.contextPath}/css/addEmployee.css"></head>

<body>

<div class="container">

    <h1>Employee Management System</h1>
    <p class="subtitle">Manage employee records quickly and efficiently</p>

    <div class="button-group">

        <form action="addEmployee.jsp">
            <button class="btn add-btn" type="submit">
                ➕ Add Employee
            </button>
        </form>

        <form action="ViewEmployeeServlet" method="get">
            <button class="btn view-btn" type="submit">
                👥 View All Employees
            </button>
        </form>

    </div>

    <%
        Object user = session.getAttribute("username");
    %>

    <% if (user != null) { %>

    <div class="welcome-box">
        <span>Welcome, <strong><%= user %></strong></span>

        <a class="logout-btn" href="LogoutServlet">
            Logout
        </a>
    </div>

    <% } %>

</div>

</body>
</html>