<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Email Verification</title>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/otp.css">

</head>

<body>

<div class="container">

    <div class="card">

        <h2>Email Verification</h2>

        <p class="subtitle">
            Enter the 6-digit OTP sent to your registered email.
        </p>

        <%
            String error = (String)request.getAttribute("error");

            if(error != null){
        %>

        <div class="error">
            <%=error%>
        </div>

        <%
            }
        %>

        <form action="<%=request.getContextPath()%>/VerifyOTPServlet" method="post">

            <label>OTP</label>

            <input
                type="text"
                name="otp"
                placeholder="Enter 6-digit OTP"
                maxlength="6"
                required>

            <button type="submit">
                Verify OTP
            </button>

        </form>

    </div>

</div>

</body>

</html>