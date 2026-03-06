# Tomcat Servlet Login Application

This project demonstrates a basic **Java Servlet based web application** deployed on **Apache Tomcat**.
The application implements a simple login system with progressive validation rules using Servlets, JSP, and HTML.

---

## Technologies Used

* Java
* Java Servlets
* JSP (Java Server Pages)
* Apache Tomcat 9
* Maven
* Git & GitFlow
* IntelliJ IDEA

---

## Project Structure

```
src
 └ main
    ├ java
    │   └ com.bridgelabz
    │        ├ HelloServlet.java
    │        └ LoginServlet.java
    │
    └ webapp
        ├ login.html
        ├ LoginSuccess.jsp
        ├ index.jsp
        └ WEB-INF
            └ web.xml
```

---

# Use Cases Implemented

## UC1 – First Servlet

A basic servlet (`HelloServlet`) is created to display a simple message when accessed through the browser.

Example URL:

```
http://localhost:8080/FirstServletProject/hello
```

---

## UC2 – Simple Login with Predefined User

A login page (`login.html`) is created where the user enters:

* Username
* Password

The credentials are validated in `LoginServlet`.

Valid credentials:

```
Username : Narayan
Password : BridgeLabz
```

If the login is successful, the user is redirected to **LoginSuccess.jsp**.

---

## UC3 – Name Validation

The username must follow these rules:

* Must start with a **capital letter**
* Must have **minimum 3 characters**

Example:

| Username | Result  |
| -------- | ------- |
| Narayan  | Valid   |
| Shivani  | Valid   |
| shivani  | Invalid |
| Ab       | Invalid |

---

## UC4 – Password Validation

The password must satisfy the following rules:

1. Minimum **8 characters**
2. At least **1 uppercase letter**
3. At least **1 numeric digit**
4. Exactly **1 special character**

Example valid password:

```
BridgeLabz@1
```

Example invalid passwords:

| Password      | Reason                 |
| ------------- | ---------------------- |
| bridgelabz@1  | No uppercase           |
| BridgeLabz@@1 | Two special characters |
| BridgeLabz@   | No number              |

---

## How to Run the Project

### 1. Clone the repository

```
git clone https://github.com/ShivaniSivaprakasam/TomcatServlet.git
```

### 2. Build the project

```
mvn clean package
```

### 3. Deploy to Tomcat

Copy the generated WAR file from:

```
target/FirstServletProject.war
```

to

```
Tomcat/webapps/
```

### 4. Start Tomcat

```
startup.bat
```

### 5. Open in Browser

```
http://localhost:8080/FirstServletProject/login.html
```

---

## Author

**Shivani S**

