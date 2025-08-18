<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>User Registration</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          crossorigin="anonymous">
    <style>
        body {
            background: linear-gradient(to right, #00c6ff, #0072ff);
            font-family: 'Segoe UI', sans-serif;
        }
        .register-container {
            margin-top: 80px;
            max-width: 500px;
            padding: 40px;
            background-color: #fff;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }
        .form-title {
            font-size: 28px;
            font-weight: bold;
            text-align: center;
            margin-bottom: 30px;
            color: #0072ff;
        }
        .form-group label {
            font-weight: 500;
        }
        .btn-register {
            background-color: #0072ff;
            border: none;
        }
        .btn-register:hover {
            background-color: #0056cc;
        }
    </style>
</head>
<body>

<div class="container d-flex justify-content-center">
    <div class="register-container">
        <div class="form-title">User Registration</div>

        <form:form modelAttribute="user" method="post" action="/user/manager/save">

        <p style="color: red;"> ${msg} </p>
            <div class="form-group">
                <form:label path="name">Name</form:label>
                <form:input path="name" cssClass="form-control" required="true" />
                <form:errors path="name" cssClass="text-danger" />
            </div>

            <div class="form-group">
                <form:label path="email">Email</form:label>
                <form:input path="email" cssClass="form-control" type="email" required="true" />
                <form:errors path="email" cssClass="text-danger" />
            </div>

            <div class="form-group">
                <form:label path="password">Password</form:label>
                <form:password path="password" cssClass="form-control" required="true" />
                <form:errors path="password" cssClass="text-danger" />
            </div>

            <div class="form-group">
                <form:label path="age">Age</form:label>
                <form:input path="age" cssClass="form-control" type="number" min="1" required="true" />
                <form:errors path="age" cssClass="text-danger" />
            </div>

            <div class="form-group">
                <form:label path="gender">Gender</form:label>
                <div>
                    <form:radiobutton path="gender" value="Male" required="true" /> Male
                    <form:radiobutton path="gender" value="Female" /> Female
                    <form:radiobutton path="gender" value="Other" /> Other
                </div>
                <form:errors path="gender" cssClass="text-danger" />
            </div>

             <div class="form-group">
                    <form:label path="phoneNo">Phone Number</form:label>
                    <form:input path="phoneNo" cssClass="form-control" type="tel" required="true" />
                    <form:errors path="phoneNo" cssClass="text-danger" />
            </div>

           <div class="form-group form-check">
                <form:checkbox path="termsAccepted" cssClass="form-check-input" required="true" />
                <label class="form-check-label">I agree to the Terms & Conditions</label>
                <form:errors path="termsAccepted" cssClass="text-danger" />
            </div>

            <button type="submit" class="btn btn-register btn-block text-white">Register</button>
        </form:form>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>
</html>
