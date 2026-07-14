# Employee Management System

A full-stack **Employee Management System** developed using **Java, JSP, Servlets, JDBC, MySQL, HTML, CSS, and Apache Tomcat**. This web application allows organizations to manage employee records securely with user authentication and email verification.

---

## Features

### User Authentication
- User Registration
- Email OTP Verification
- Secure Password Hashing
- User Login
- Session Management
- Authentication Filter

### Employee Management
- Add Employee
- View Employee List
- Update Employee Details
- Delete Employee
- Search Employee (if implemented)

### Security
- Password hashing before storing in the database
- Email verification using OTP
- Session-based authentication
- Protected pages using Servlet Filter

---

## Technologies Used

### Backend
- Java
- JSP
- Servlets
- JDBC

### Frontend
- HTML5
- CSS3

### Database
- MySQL

### Server
- Apache Tomcat 9

### Development Tools
- Eclipse IDE
- Git
- GitHub

---

## Project Structure

```
EmployeeManagementSystems
│
├── src/main/java
│   ├── dao
│   ├── model
│   ├── servlet
│   └── util
│
├── src/main/webapp
│   ├── css
│   ├── images
│   ├── login.jsp
│   ├── register.jsp
│   ├── otp.jsp
│   ├── dashboard.jsp
│   ├── addEmployee.jsp
│   ├── editEmployee.jsp
│   └── WEB-INF
│
└── README.md
```

---

## Database

Create a MySQL database named:

```sql
employee_management
```

### Users Table

```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE,
    password VARCHAR(255),
    role VARCHAR(30),
    email VARCHAR(150)
);
```

### Employees Table

```sql
CREATE TABLE employee (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(150),
    phone VARCHAR(20),
    department VARCHAR(100),
    salary DOUBLE,
    joining_date DATE
);
```

---

## How to Run

1. Clone this repository

```bash
git clone https://github.com/Shiva-kumar-29/EmployeeManagementSystems.git
```

2. Import the project into Eclipse.

3. Configure Apache Tomcat 9.

4. Create the MySQL database.

5. Update the database credentials in:

```
DBConnection.java
```

6. Run the project on Tomcat.

7. Open:

```
http://localhost:8080/EmployeeManagementSystems
```

---

## Screenshots



---

## Future Improvements

- Admin Dashboard
- Employee Profile Picture Upload
- Pagination
- Sorting
- Search Filters
- Password Reset via Email
- Attendance Management
- Payroll Module
- Export Employee Data to Excel/PDF
- REST API Integration

---

## Learning Outcomes

Through this project I learned:

- Java Servlet Architecture
- MVC Design Pattern
- JDBC Database Connectivity
- Session Management
- Authentication & Authorization
- Email OTP Verification
- Password Hashing
- CRUD Operations
- Git & GitHub
- Responsive UI Design

---

## Author

**Chityala Shiva Kumar**

Bachelor of Technology (Computer Science & Engineering - Cyber Security)

Email:chityalashivakumar7@gmail.com

GitHub:
https://github.com/Shiva-kumar-29

LinkedIn:
(www.linkedin.com/in/chityala-shivakumar-567048392)

---

## License

This project is developed for educational and portfolio purposes.
