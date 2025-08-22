<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tenant Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .dashboard-container {
            max-width: 900px;
            margin: 50px auto;
        }
        .card {
            border-radius: 12px;
            box-shadow: 0px 4px 10px rgba(0,0,0,0.1);
        }
        .logout-btn {
            background-color: #dc3545;
            color: white;
        }
        .logout-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="container dashboard-container">
        <div class="card p-4">
            <h2 class="text-center text-success mb-4">Tenant Dashboard</h2>

            <div class="alert alert-info">
                <h5>Welcome, <b>${tenant.name}</b>!</h5>
                <p>Email: ${tenant.email}</p>
            </div>

            <h4 class="mb-3">Tenant Options</h4>
            <div class="list-group">
                <a href="viewRoom" class="list-group-item list-group-item-action">
                    🏠 View Room Details
                </a>
                <a href="payRent" class="list-group-item list-group-item-action">
                    💳 Pay Rent
                </a>
                <a href="meterReading" class="list-group-item list-group-item-action">
                    🔌 Submit Meter Reading
                </a>
                <a href="notices" class="list-group-item list-group-item-action">
                    📢 View Notices
                </a>
            </div>

            <div class="text-center mt-4">
                <a href="/user/logout" class="btn logout-btn px-4">Logout</a>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
