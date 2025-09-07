<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="CarRent.Car" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Booking</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background: #f4f7fb;
        margin: 0;
        padding: 20px;
    }

    h1 {
        text-align: center;
        margin-bottom: 30px;
        color: #333;
    }

    .car-container {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
        gap: 20px;
    }

    .car-card {
        background: #fff;
        padding: 20px;
        border-radius: 12px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        transition: transform 0.2s;
    }

    .car-card:hover {
        transform: translateY(-5px);
    }

    .car-info {
        margin-bottom: 15px;
    }

    .car-info span {
        display: block;
        font-size: 14px;
        color: #555;
        margin: 4px 0;
    }

    form {
        display: flex;
        flex-direction: column;
        gap: 10px;
    }

    input[type="text"], input[type="date"] {
        padding: 8px 10px;
        border: 1px solid #ccc;
        border-radius: 8px;
        font-size: 14px;
        width: 100%;
    }

    button {
        padding: 10px;
        border: none;
        border-radius: 8px;
        background: #007bff;
        color: white;
        font-size: 15px;
        cursor: pointer;
        transition: background 0.3s ease;
    }

    button:hover {
        background: #0056b3;
    }
</style>
</head>
<body>

<h1>Available Cars for Booking</h1>

<div class="car-container">
<%
    List<Car> carlist = (List<Car>)request.getAttribute("carlist"); 
    for(Car c:carlist){
%>
    <div class="car-card">
        <div class="car-info">
       <img src="<%= request.getContextPath() + "/" + c.getImage() %>" width="200" height="150">



            <span><strong>Car ID:</strong> <%= c.getCarId()%></span>
            <span><strong>Car Name:</strong> <%= c.getCarName()%></span>
            <span><strong>Car Model:</strong> <%= c.getCarModel()%></span>
            <span><strong>Car Number:</strong> <%= c.getCarNumber()%></span>
            <span><strong>Owner:</strong> <%= c.getCarOwnerName()%></span>
        </div>

        <form action="booking">
            <input type="hidden" name="carid" value="<%= c.getCarId()%>">
            <input type="text" name="username" placeholder="Enter your username" required>
            <input type="date" name="from" required>
            <input type="date" name="to" required>
            <button type="submit">Book Car</button>
        </form>
    </div>
<% } %>
</div>

</body>
</html>
