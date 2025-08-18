<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>PG Management System</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
          crossorigin="anonymous">

    <style>
        body {
            background-color: #f4f6f9;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        .navbar {
            background-color: #007bff;
        }

        .navbar-brand, .nav-link, .footer {
            color: #fff !important;
        }

        .card {
            border-radius: 15px;
            transition: 0.3s;
        }

        .card:hover {
            box-shadow: 0 8px 16px rgba(0,0,0,0.15);
        }

        .footer {
            background-color: #007bff;
            color: white;
            padding: 10px 0;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }

        .card-title {
            font-weight: bold;
        }
    </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg">
    <div class="container">
        <a class="navbar-brand" href="#">PG Management</a>
        <div class="ml-auto">
            <a class="nav-link" href="/login">Login</a>
        </div>
    </div>
</nav>

<!-- Main Content -->
<div class="container mt-5">
    <div class="text-center mb-4">
        <h2>Welcome to the PG/Hostel Management System</h2>
        <p class="text-muted">Manage rooms, tenants, meter readings, and more.</p>
    </div>

    <div class="row text-center">
        <!-- Admin Card -->
        <div class="col-md-4 mb-4">
            <div class="card p-4">
                <h5 class="card-title">Admin Panel</h5>
                <p class="card-text">Manage all PGs, view reports, and control access.</p>
                <a href="/admin/login" class="btn btn-primary">Admin Login</a>
            </div>
        </div>

        <!-- Manager Card -->
        <div class="col-md-4 mb-4">
            <div class="card p-4">
                <h5 class="card-title">Manager Panel</h5>
                <p class="card-text">Manage your PGs, tenants, rent, and readings.</p>
                <a href="/manager/login" class="btn btn-success">Manager Login</a>
            </div>
        </div>

        <!-- Tenant Card -->
        <div class="col-md-4 mb-4">
            <div class="card p-4">
                <h5 class="card-title">Tenant Dashboard</h5>
                <p class="card-text">View bills, meter readings, and personal info.</p>
                <a href="/tenant/login" class="btn btn-info">Tenant Login</a>
            </div>
        </div>
    </div>
</div>

<!-- Footer -->
<div class="footer">
    &copy; 2025 PG Management System | All rights reserved
</div>

<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>
</html>
