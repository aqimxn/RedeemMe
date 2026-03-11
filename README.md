# 🎁 RedeemMe – Reward Management System

## 📌 Overview

RedeemMe is a **Reward Management System** designed to help organizations reward employees through a structured **point-based incentive program**.

The system allows administrators to manage products, suppliers, and employee rewards while enabling employees to redeem accumulated points for available rewards.

This project demonstrates practical skills in **Java web development, database integration, and system design**.

---

## ❗ Problem Statement

Many organizations lack a structured system to track and reward employee achievements. Without a centralized platform, reward management becomes inconsistent and difficult to monitor.

RedeemMe solves this problem by providing a **centralized reward management platform** where administrators can manage reward items and employees can redeem their accumulated points.

---

## ✨ Key Features

* 👤 User management system
* 🎯 Employee reward point tracking
* 🛍️ Reward product catalog
* 📦 Supplier management
* 🧾 Order and redemption system
* 📊 Admin dashboard for system monitoring
* 🔐 Secure database connection

---

## 🛠️ Tech Stack

### 💻 Backend

* Java
* Java Servlets
* JSP (Java Server Pages)

### 🗄️ Database

* MySQL

### 🌐 Frontend

* HTML
* CSS
* JavaScript

### 🔧 Tools

* Eclipse IDE
* Apache Tomcat
* Git
* GitHub

---

## 📁 Project Structure

```
RedeemMe/
│
├── src/main/java/redeemMe/
│   ├── connection/        # Database connection configuration
│   ├── dashboard/         # Dashboard logic
│   ├── Order/             # Order and redemption management
│   ├── product/           # Product management
│   ├── supplier/          # Supplier management
│   └── user/              # User management
│
├── webapp/                # JSP pages and web resources
│
├── build/                 # Compiled project files
├── .settings/             # Eclipse configuration
│
└── Documentation          # User manual & demonstrations
└── redeemme.sql           # Database schema
└── redeemme.war           # Project WAR file
└── README.md              # Project documentation
```

---

## ⚙️ System Workflow

1️⃣ Administrator manages employees and reward products
2️⃣ Employees accumulate reward points through achievements
3️⃣ Employees browse available reward products
4️⃣ Employees redeem products using their points
5️⃣ The system records redemption orders and updates balances

---

## 🚀 Installation

### 1️⃣ Clone the repository

```
git clone https://github.com/aqimxn/RedeemMe.git
```

### 2️⃣ Import project into Eclipse

1. Open Eclipse
2. Import RedeemMe.war

### 3️⃣ Configure Apache Tomcat

* Install Apache Tomcat
* Add Tomcat server in Eclipse
* Deploy the project to Tomcat

### 4️⃣ Configure Database

1. Create a MySQL database
2. Import the SQL file
3. Update database credentials in:

```
connection/ConnectionManager.java
```

Example:

```
jdbc:mysql://localhost:3306/redeemme
```

### 5️⃣ Run the application

Start the Tomcat server and open:

```
http://localhost:8080/RedeemMe
```

---

## 📊 Learning Outcomes

This project demonstrates:

* Java web application development using Servlets and JSP
* Database integration using JDBC
* CRUD operations for multiple system modules
* Web application architecture
* Version control using Git

---

## 🔮 Future Improvements

* 📱 Mobile-responsive user interface
* 🔔 Notification system for reward updates
* 📈 Analytics dashboard for employee engagement
* 🐳 Docker containerization
* ☁️ Cloud deployment

---

## 👨‍💻 Author

**Muhammad Aqiman**

GitHub: https://github.com/aqimxn