<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List" %>
<%@page import="CarRent.Booking" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booked Cars</title>
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

    .booking-container {
        display: grid;
        grid-template-columns: repeat(auto-fit, minmax(350px, 1fr));
        gap: 20px;
    }

    .booking-card {
        background: #fff;
        padding: 20px;
        border-radius: 12px;
        box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        transition: transform 0.2s;
    }

    .booking-card:hover {
        transform: translateY(-5px);
    }

    .booking-info {
        margin-bottom: 15px;
    }

    .booking-info span {
        display: block;
        font-size: 14px;
        color: #555;
        margin: 4px 0;
    }

    form {
        margin-top: 10px;
    }

    button {
        padding: 10px;
        border: none;
        border-radius: 8px;
        background: #dc3545;
        color: white;
        font-size: 15px;
        cursor: pointer;
        transition: background 0.3s ease;
        width: 100%;
    }

    button:hover {
        background: #a71d2a;
    }
</style>
</head>
<body>

<h1>Booked Cars</h1>

<div class="booking-container">
<%
    List<Booking> carlist = (List<Booking>)request.getAttribute("carlist"); 

if (carlist == null || carlist.isEmpty()) {
%>
    <p style="color:red; text-align:center;">No Booked Cars Available</p>
<%
}
    for(Booking c:carlist){
%>
    <div class="booking-card">
    <div class="booking-info">
   
  
        <img src="<%= request.getContextPath() + "/" + c.getCarImage() %>" 
             width="200" height="150">
        <span><strong>Car ID:</strong> <%= c.getCarId()%></span>
        <span><strong>Booking ID:</strong> <%= c.getBookId()%></span>
        <span><strong>From Date:</strong> <%= c.getFromDate()%></span>
        <span><strong>To Date:</strong> <%= c.getToDate()%></span>
        
        <form action="delete">
        <input type="hidden" name="carId"  value="<%= c.getCarId()%>"/>
         <button type="submit">Delete Booking</button>
        </form>
       
    </div>


<% } %>
</div>

</body>
</html>
