<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Manager Dashboard</title>
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
            <h2 class="text-center text-primary mb-4">Manager Dashboard</h2>

            <div class="alert alert-info">
                <h5>Welcome, <b>${manager.name}</b>!</h5>
                <p>Email: ${manager.email}</p>
            </div>

            <h4 class="mb-3">Manager Options</h4>
            <div class="list-group">
                <a href="addTenant" class="list-group-item list-group-item-action">
                    ➕ Add Tenant
                </a>
                <a href="viewTenants" class="list-group-item list-group-item-action">
                    👥 View All Tenants
                </a>
                <a href="manageRooms" class="list-group-item list-group-item-action">
                    🏠 Manage Rooms
                </a>
                <a href="reports" class="list-group-item list-group-item-action">
                    📊 View Reports
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
