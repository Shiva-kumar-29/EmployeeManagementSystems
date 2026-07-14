<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login · Personnel Registry</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="auth-shell">
        <div class="auth-card badge-card">
            <div class="auth-head">
                <div class="registry-mark">
                    <span class="mark-chip">ER</span>
                    Personnel Registry
                </div>
                <h1>Sign in</h1>
                <p>Enter your credentials to access employee records.</p>
            </div>

            <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-error"><%= request.getAttribute("error") %></div>
            <% } %>

            <form action="LoginServlet" method="post">
                <div class="field-group">
                    <label class="field-label" for="username">Username</label>
                    <input class="field-input" type="text" id="username" name="username" placeholder="Enter your username" required autofocus />
                </div>

                <div class="field-group">
                    <label class="field-label" for="password">Password</label>
                    <input class="field-input" type="password" id="password" name="password" placeholder="••••••••" required />
                </div>

                <button type="submit" class="btn btn-primary btn-block">Sign in</button>
            </form>

            <div class="auth-foot">
                Don't have an account?<a href="${pageContext.request.contextPath}/register.jsp">Register</a>
            </div>
        </div>
    </div>
</body>
</html>