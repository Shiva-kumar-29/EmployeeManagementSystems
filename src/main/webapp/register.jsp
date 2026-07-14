<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register · Personnel Registry</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"></head>
<body>
    <div class="auth-shell">
        <div class="auth-card badge-card">
            <div class="auth-head">
                <div class="registry-mark">
                    <span class="mark-chip">ER</span>
                    Personnel Registry
                </div>
                <h1>Create account</h1>
                <p>Register to get access to the employee registry.</p>
            </div>

            <% if (request.getAttribute("error") != null) { %>
                <div class="alert alert-error"><%= request.getAttribute("error") %></div>
            <% } %>

            <form action="RegisterServlet" method="post">
                <div class="field-group">
                    <label class="field-label" for="username">Username</label>
                    <input class="field-input" type="text" id="username" name="username" placeholder="Choose a username" required />
                </div>

                <div class="field-group">
                    <label class="field-label" for="email">Email</label>
                    <input class="field-input" type="email" id="email" name="email" placeholder="you@company.com" required />
                </div>

                <div class="field-group">
                    <label class="field-label" for="password">Password</label>
                    <input class="field-input" type="password" id="password" name="password" placeholder="At least 8 characters" required minlength="8" />
                    <span class="field-hint">Use 8+ characters with a mix of letters and numbers.</span>
                </div>

                <button type="submit" class="btn btn-primary btn-block">Create account</button>
            </form>

            <div class="auth-foot">
                Already registered? <a href="login.jsp">Sign in</a>
            </div>
        </div>
    </div>
</body>
</html>