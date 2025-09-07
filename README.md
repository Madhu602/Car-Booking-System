# 🚗 Car Rental System  

## 📌 Overview  
This is a Java-based Car Rental System built using Servlets, JSP, and PostgreSQL for database management.  
The system allows users to:  

- Register cars with details and images  
- View available cars  
- Book cars with rental dates  
- Manage car booking records  

## 📂 Project Structure  

```
CarRent/
├── src/
│   └── CarRent/
│       ├── Car.java              # Entity class for Car
│       ├── Booking.java          # Entity class for Booking
│       ├── Savecar.java          # Servlet for car registration
│       ├── SeeAllCars.java       # Servlet for viewing available cars
│       ├── BookingServlet.java   # Servlet for handling bookings
│       └── Bookedcars.java       # Servlet for viewing booked cars
├── WebContent/
│   ├── index.html                # Home page
│   ├── register.html             # Car registration form
│   ├── Showcars.jsp              # Display available cars
│   ├── showbookedcars.jsp        # Display booked cars
│   ├── book.html                 # Booking confirmation page
│   └── uploads/                  # Directory for car images
└── META-INF/
    └── persistence.xml           # JPA configuration
```
    

## ✨ Features  

### 🚘 Car Registration  
- Register new cars with details and images  
- File upload capability for car images  

### 📊 Car Management  
- View all available cars  
- View all booked cars  
- Update car status (**Available / Booked**)  

### 📅 Booking System  
- Book available cars with date selection  
- Store booking information with customer details  

### 🖼️ Image Handling  
- Upload and store car images  
- Display images in car listings  

## 🛠 Technologies Used  
- **Backend:** Java Servlets, JPA (Hibernate)  
- **Frontend:** HTML, CSS, JSP  
- **Database:** PostgreSQL  
- **File Handling:** Multipart form data for image uploads  

## 🗄 Database Schema  

### Car Table  
| Column       | Type     | Description        |  
|--------------|----------|--------------------|  
| carId        | INTEGER  | Primary Key        |  
| carName      | VARCHAR  | Car name           |  
| carModel     | VARCHAR  | Car model          |  
| carNumber    | INTEGER  | License number     |  
| carOwnerName | VARCHAR  | Owner's name       |  
| status       | VARCHAR  | Available/Booked   |  
| image        | VARCHAR  | Path to car image  |  

### Booking Table  
| Column    | Type     | Description                  |  
|-----------|----------|------------------------------|  
| bookId    | INTEGER  | Primary Key (Auto-generated) |  
| carId     | INTEGER  | Foreign Key → Car            |  
| userName  | VARCHAR  | Customer name                |  
| fromDate  | VARCHAR  | Start date of booking        |  
| toDate    | VARCHAR  | End date of booking          |  
| carImage  | VARCHAR  | Path to car image            |  

## ⚙️ Setup Instructions  

### ✅ Prerequisites  
- Java JDK 8 or higher  
- Apache Tomcat  
- PostgreSQL database  
- Maven (for dependency management)  

### 🛠 Database Setup  
1. Create a PostgreSQL database named **`car_rental`**  
2. Update `persistence.xml` with your database credentials  
3. JPA will auto-create the tables  

### 🚀 Deployment  
1. Clone or download the project  
2. Configure your Tomcat server  
3. Deploy the application to Tomcat  
4. Start the server  

## 🎯 Usage  
- **Home Page:** Open `index.html` → Main menu  
- **Register Car:** Add a new car to the system  
- **View Available Cars:** List all cars that can be booked  
- **View Booked Cars:** See all current bookings  
- **Book a Car:** Select dates and provide user details  


## 🌐 API Endpoints  

| Method | Endpoint             | Description            |  
|--------|----------------------|------------------------|  
| POST   | `/registercar`       | Register a new car     |  
| GET    | `/seeallcars`        | Get all available cars |  
| GET    | `/seeallbookedcars`  | Get all booked cars    |  
| GET    | `/booking`           | Create a new booking   |  


## 🔑 Key Features Implementation  

### 📷 Image Upload  
- Uses `@MultipartConfig` for file upload  
- Stores images in `uploads/` directory  
- Saves relative path in the database  

### 📅 Booking Management  
- Updates car status → **Booked**  
- Creates a new booking record with details  

### 🚦 Car Status Management  
- **Available:** Can be booked  
- **Booked:** Currently rented out  


## 🚀 Future Enhancements  
- User authentication & authorization  
- Payment integration  
- Email notifications for bookings  
- Advanced search & filtering  
- Admin dashboard  
- Rental pricing & billing system  


## 🐛 Troubleshooting  
- **Image upload issues:** Ensure `uploads/` exists with write permissions  
- **Database connection errors:** Verify PostgreSQL is running & credentials in `persistence.xml`  
- **JPA errors:** Check persistence configuration  


## 📜 License  
This project is for **educational purposes**.  
Feel free to **modify and extend** as needed.  
