<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>OTP Verification</title>

    <!-- Bootstrap 5 CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f4f6f8;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            font-family: Arial, sans-serif;
        }
        .otp-container {
            background: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.15);
            width: 100%;
            max-width: 400px;
        }
        .otp-container h2 {
            font-weight: bold;
            margin-bottom: 20px;
        }
        .form-control {
            text-align: center;
            font-size: 16px;
            padding: 10px;
        }
        .btn-primary {
            border-radius: 6px;
            font-size: 16px;
            padding: 10px;
        }
    </style>
</head>
<body>
    <div class="otp-container text-center">
        <h2 class="text-success">Registration Successful!</h2>
        <p class="text-muted">
            Thank you for registering! Please verify your account using the OTP sent to your registered email address.
        </p>
        <p class="text-muted">
            Once verified, you can log in and start using our services.
        </p>

        <form action="/otp/verify" method="post" class="mt-4">
            <div class="mb-3 text-start">
                <label for="email" class="form-label">Email</label>
                <input type="text" id="email" name="email" value="${email}" readonly class="form-control-plaintext fw-bold" />
            </div>

            <div class="mb-3">
                <input type="text" name="otp" placeholder="Enter OTP" maxlength="6" required class="form-control" />
            </div>

            <div class="d-grid">
                <button type="submit" class="btn btn-primary">Verify OTP</button>
            </div>
        </form>
    </div>

    <!-- Bootstrap JS (optional, for animations/components) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
