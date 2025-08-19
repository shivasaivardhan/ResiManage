<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>User Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(to right, #ffecd2, #fcb69f);
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .login-container {
            background-color: #fff;
            padding: 40px 35px;
            border-radius: 20px;
            box-shadow: 0 12px 20px rgba(0, 0, 0, 0.15);
            width: 100%;
            max-width: 450px;
        }

        .login-container h3 {
            font-weight: 600;
            margin-bottom: 30px;
            color: #343a40;
        }

        .form-control {
            height: 45px;
            font-size: 15px;
        }

        .btn-primary {
            height: 45px;
            font-weight: 500;
            background: linear-gradient(to right, #ff6a00, #ee0979);
            border: none;
        }

        .btn-primary:hover {
            background: linear-gradient(to right, #e65c00, #d30069);
        }

        .text-danger {
            font-size: 13px;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h3 class="text-center">User Login</h3>

    <form:form modelAttribute="user" method="post" action="/user/signin/verify">
                    <p style="color: red;"> ${msg} </p>

        <div class="mb-3">
            <form:label path="email" cssClass="form-label">Email</form:label>
            <form:input path="email" cssClass="form-control" />
            <form:errors path="email" cssClass="text-danger" />
        </div>

        <div class="mb-3">
            <form:label path="password" cssClass="form-label">Password</form:label>
            <form:password path="password" cssClass="form-control" />
            <form:errors path="password" cssClass="text-danger" />
        </div>

        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Login</button>
        </div>
    </form:form>
</div>

<!-- Bootstrap 5 JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
