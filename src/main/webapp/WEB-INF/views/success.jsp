<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Successful</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          crossorigin="anonymous">

    <style>
        body {
            background: linear-gradient(to right, #43cea2, #185a9d);
            font-family: 'Segoe UI', sans-serif;
            color: #fff;
            text-align: center;
            padding-top: 100px;
        }

        .card {
            background: #fff;
            color: #333;
            border-radius: 12px;
            padding: 40px 30px;
            max-width: 500px;
            margin: auto;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
        }

        .card h2 {
            color: #28a745;
            margin-bottom: 20px;
        }

        .btn-home {
            background-color: #007bff;
            color: white;
            margin-top: 25px;
        }

        .btn-home:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="card">
    <h2>Registration Successful!</h2>
    <p>Thank you for registering! To complete your login, please verify your account using the OTP sent to your registered email address.</p>
    <p>Once verified, you can log in and start using our services.</p>

       <form:form modelAttribute="user" method="post" action="/otp/email">
           <div class="mb-3">
               <form:label path="email" cssClass="form-label">Email</form:label>
               <form:input path="email"value="${email}" read-only="true" cssClass="form-control" />
           </div>

           <div class="d-grid">
               <button type="submit" class="btn btn-primary">Verify OTP</button>
           </div>
       </form:form>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>
</html>
