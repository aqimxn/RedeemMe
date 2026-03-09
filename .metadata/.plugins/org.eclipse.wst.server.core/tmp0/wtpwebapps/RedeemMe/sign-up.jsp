<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    // Prevent caching
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setDateHeader("Expires", 0); // Proxies.

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!----======== CSS ======== -->
    <link rel="stylesheet" href="assets/css/sign-up.css">
     
    <!----===== Iconscout CSS ===== -->
    <link rel="shortcut icon" href="assets/images/favicon.ico" />
    <link rel="stylesheet" href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">

   <title>Registration Form</title>
</head>
<body>
    <div class="container">
        <header>
            <span>Registration</span>
            <span class="goto-login">Already have account? <a href="login.jsp">log in</a></span>
        </header>

        <form id="myForm" action="AddUserController" method="POST" enctype="multipart/form-data">
            <div class="form first">
                <div class="details personal">
                    <span class="title">Personal Details</span>

                    <div class="fields">
                        <div class="input-field">
                            <label>First Name</label>
                            <input type="text" name="first-name" placeholder="Enter your first name" required pattern="[A-Za-z ]+" title="Please enter a valid name">
                        </div>

                        <div class="input-field">
                            <label>Last Name</label>
                            <input type="text" name="last-name" placeholder="Enter your last name" required pattern="[A-Za-z ]+" title="Please enter a valid name">
                        </div>

                        <div class="input-field">
                            <label>Email</label>
                            <input type="email" name="email" placeholder="Enter your email" required pattern=".+\.com$" title="Please enter a valid email ending with .com">
                        </div>

                        <div class="input-field">
                            <label>Password</label>
                            <input type="password" name="password" placeholder="Enter your password" required>
                        </div>

                        <div class="input-field">
                            <label>Mobile Number</label>
                            <input type="text" name="contact" placeholder="Enter your mobile number" required pattern="01\d{8,9}" maxlength="11" title="Please enter a valid phone number starting with 01 and contains 10-11 digits">
                        </div>

                        <div class="input-field">
                            <label>Profile picture (optional)</label>
                            <input type="file" id="image" name="image" accept="image/jpeg, image/png">
                        </div>
                    </div>
                </div>

                <div class="details ID">
                    <span class="title">Identity Details</span>

                    <div class="fields">
                        <div class="input-field">
                            <label>Address 1</label>
                            <input type="text" name="address1" placeholder="Enter your first address" required>
                        </div>

                        <div class="input-field">
                            <label>Address 2</label>
                            <input type="text" name="address2" placeholder="Enter your second address" required>
                        </div>

                        <div class="input-field">
                            <label>Postcode</label>
                            <input type="text" name="postcode" placeholder="Enter your postcode" required pattern="\d{5}" maxlength="5" title="Please enter a valid postcode that contains exactly 5 digits">
                        </div>

                        <div class="input-field">
                            <label>City</label>
                            <input type="text" name="city" placeholder="Enter your city" required pattern="[A-Za-z ]+" title="Please enter a valid city">
                        </div>

                        <div class="input-field">
                            <label for="state">State</label>
                            <select id="state" name="state" required>
                                <option disabled selected value="">Select state</option>
                                <option value="Johor">Johor</option>
                                <option value="Kedah">Kedah</option>
                                <option value="Kelantan">Kelantan</option>
                                <option value="Melaka">Melaka</option>
                                <option value="Negeri Sembilan">Negeri Sembilan</option>
                                <option value="Pahang">Pahang</option>
                                <option value="Perak">Perak</option>
                                <option value="Perlis">Perlis</option>
                                <option value="Pulau Pinang">Pulau Pinang</option>
                                <option value="Sabah">Sabah</option>
                                <option value="Sarawak">Sarawak</option>
                                <option value="Selangor">Selangor</option>
                                <option value="Terengganu">Terengganu</option>
                                <option value="Wilayah Persekutuan Kuala Lumpur">Wilayah Persekutuan Kuala Lumpur</option>
                            </select>
                        </div>

                    </div>

                    <button class="nextBtn" type="submit">
                        Submit
                        <i class="uil uil-navigator"></i>
                    </button>
                    
                </div> 
            </div>
        </form>
    </div>
    
<%
    String sqlError = (String) request.getAttribute("sqlError");
    if (sqlError != null) {
%>
    <script>
        alert('<%= sqlError %>');
    </script>
<%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("sqlError");
    }
%>

<%
    String emptyField = (String) request.getAttribute("emptyField");
    if (emptyField != null) {
%>
    <script>
        alert('<%= emptyField %>');
    </script>
<%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("emptyField");
    }
%>

    
</body>
</html>