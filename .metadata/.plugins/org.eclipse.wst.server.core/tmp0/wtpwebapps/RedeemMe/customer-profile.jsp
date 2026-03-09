<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	if (session == null || session.getAttribute("sessionId") == null || session.getAttribute("customer") == null) {
		request.setAttribute("errorAccess", "Session expired or user not logged in. Please log in again.");
	    response.sendRedirect("login.jsp");
	}
	
	// Prevent caching
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	response.setDateHeader("Expires", 0); // Proxies.
%>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <title>Profile | redeemMe</title>
      
      <!-- Favicon -->
      <link rel="shortcut icon" href="assets/images/favicon.ico" />
      <link rel="stylesheet" href="assets/css/backend-plugin.min.css">
      <link rel="stylesheet" href="assets/css/backend.css?v=1.0.0">
      <link rel="stylesheet" href="assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
      <link rel="stylesheet" href="assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
      <link rel="stylesheet" href="assets/vendor/remixicon/fonts/remixicon.css"> 
      <link rel="stylesheet" href="assets/css/customer-profile.css">
      <link rel="stylesheet" href="assets/css/customer-profile-update.css">
      <link rel="stylesheet" href="assets/css/customer-profile-update-password.css">
      
      <style>
      @media only screen and (max-width: 768px) {
			.modal-left-right {
				display: flex;
				flex-direction: column;
				gap: 15px;
			}
			
			.customer-attribute{
				align-items: center;
			}
		}
		
      </style>
    </head>

  <body class="  ">
    <!-- loader Start -->
    <div id="loading">
          <div id="loading-center">
          </div>
    </div>
    <!-- loader END -->
    <!-- Wrapper Start -->
    <div class="wrapper">
      
      <div class="iq-sidebar  sidebar-default ">
          <div class="iq-sidebar-logo d-flex align-items-center justify-content-between">
              <a href="ListProductControllerCustomer" class="header-logo">
                  <img src="assets/images/logo.png" class="img-fluid rounded-normal light-logo" alt="logo"><h5 class="logo-title light-logo ml-3">redeemMe</h5>
              </a>
              <div class="iq-menu-bt-sidebar ml-0">
                  <i class="las la-bars wrapper-menu"></i>
              </div>
          </div>
          <div class="data-scrollbar" data-scroll="1">
            <nav class="iq-sidebar-menu">
                <ul id="iq-sidebar-toggle" class="iq-menu">
                    <li class="active">
                        <a href="ViewUserProfile" class="svg-icon">                        
                          <svg class="svg-icon" id="p-dash8" width="20" height="20" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                              <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                          </svg>
                            <span class="ml-4">Profile</span>
                        </a>
                    </li>
                    <li class=" ">
                        <a href="ListProductControllerCustomer">
                          <svg class="svg-icon" id="p-dash2" width="20" height="20"  xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle>
                              <path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path>
                          </svg>
                            <span class="ml-4">Shop</span>
                        </a>
                    </li>
                    <li class=" ">
                      <a href="ListOrderControllerCustomer">
                          <svg class="svg-icon" id="p-dash5" width="20" height="20" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect x="1" y="4" width="22" height="16" rx="2" ry="2"></rect>
                              <line x1="1" y1="10" x2="23" y2="10"></line>
                          </svg>
                          <span class="ml-4">Purchases</span>
                      </a>
                    </li>
                </ul>
            </nav>
            <div id="sidebar-bottom" class="position-relative sidebar-bottom"></div>
        </div>
          </div>      <div class="iq-top-navbar">
          <div class="iq-navbar-custom">
              <nav class="navbar navbar-expand-lg navbar-light p-0">
                  <div class="iq-navbar-logo d-flex align-items-center justify-content-between">
                      <i class="ri-menu-line wrapper-menu"></i>
                      <a href="ListProductControllerCustomer" class="header-logo">
                          <img src="assets/images/logo.png" class="img-fluid rounded-normal" alt="logo">
                          <h5 class="logo-title ml-3">redeemMe</h5>
                      </a>
                  </div>
                  <div class="current-points">
                    Your Points: <c:out value="${user.points}"/>&#9733;
                  </div>
                  <div class="d-flex align-items-center">
                      <button class="navbar-toggler" type="button" data-toggle="collapse"
                          data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                          aria-label="Toggle navigation">
                          <i class="ri-menu-3-line"></i>
                      </button>
                      <div class="collapse navbar-collapse" id="navbarSupportedContent">
                          <ul class="navbar-nav ml-auto navbar-list align-items-center">
                              <li class="nav-item nav-icon dropdown" style="display: flex; align-self: end;">
                                  <p>Hi, <span style="color: red;"><c:out value="${user.firstName}"/></span></p>
                              </li>
                              <li class="nav-item nav-icon dropdown caption-content">
                                  <a href="#" class="search-toggle dropdown-toggle" id="dropdownMenuButton4"
                                      data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                      <img src="data:image/jpg;base64,${user.picture}" width="100px" class="img-fluid rounded" alt="user">
                                  </a>
                                  <div class="iq-sub-dropdown dropdown-menu" aria-labelledby="dropdownMenuButton">
                                      <div class="card shadow-none m-0">
                                          <div class="card-body p-0 text-center">
                                              <div class="media-body profile-detail text-center">
                                                  <img src="assets/images/page-img/profile-bg.jpg" alt="profile-bg"
                                                      class="rounded-top img-fluid mb-4">
                                                   <img src="data:image/jpg;base64,${user.picture}" width="50px" class="rounded profile-img img-fluid avatar-70" alt="profile-img">
                                                      
                                              </div>
                                              <div class="p-3">
                                                  <p class="mb-0"><c:out value="${user.email}"/></p>
                                                  <div class="d-flex align-items-center justify-content-center mt-3">
                                                      <a href="login.jsp" class="btn border sign-out">Sign Out</a>
                                                  </div>
                                              </div>
                                          </div>
                                      </div>
                                  </div>
                              </li>
                          </ul>
                      </div>
                  </div>
              </nav>
          </div>
      </div>    <div class="content-page">
<!-- Starts here -->
<div class="wrapper">
    <div class="modal-container-view">
        <h3>User Information</h3>

        <div class="modal-left-right">
            <div class="modal-left-image">
                <img src="data:image/jpg;base64,${user.picture}" width="150px" class="img-fluid rounded" alt="user">
            </div>
    
            <div class="modal-right-info">
                <span class="customer-attribute"><b>ID: &nbsp;</b> <c:out value="${user.userId}"/></span>
                <span class="customer-attribute"><b>Name: &nbsp;</b> <c:out value="${user.firstName} ${user.lastName}"/></span>
                <span class="customer-attribute"><b style="margin-right: 5px;">Address: &nbsp;</b> <c:out value="${user.address1}, ${user.address2}, ${user.postcode}, ${user.city}, ${user.state}"/></span>
                <span class="customer-attribute"><b>Phone No: &nbsp;</b> <c:out value="${user.mobile}"/></span>
                <span class="customer-attribute"><b>Email: &nbsp;</b> <c:out value="${user.email}"/></span>
                <span class="customer-attribute"><b>Points: &nbsp;</b> <c:out value="${user.points}"/></span>
            </div>

        </div>
        <div class="update">
            <button class="update-button" onclick="openUpdateCustomer()">Update</button>
            <button class="password-button" onclick="openUpdatePassword()">Change Password</button>
        </div>

    </div>
</div>

<!-- Modal Update -->
<div id="modal-update" class="modal" style="display: none;">
    <div class="modal-container">

     <form action="ToUpdateUserInfo" method="POST" enctype="multipart/form-data">
         <div class="form first">
             <span id="modal-close" class="close" onclick="closeUpdateCustomer()">&times;</span>
             <div class="details personal">
                <span class="title">Personal Details</span>

                <div class="fields">
                    <div class="input-field">
                        <label>Name</label>
                        <input name="customer-name" type="text" class="form-control" value="${user.firstName} ${user.lastName}" placeholder="Enter your first name" readonly>
                    </div>

                    <div class="input-field">
                        <label>Email</label>
                        <input type="email" name="customer-email" value="${user.email}" placeholder="Enter your email" required pattern=".+\.com$" title="Please enter a valid email ending with .com">
                    </div>

                    <div class="input-field">
                        <label>Mobile Number</label>
                        <input type="text" name="customer-contact" value="${user.mobile}" placeholder="Enter your mobile number" required pattern="01\d{8,9}" maxlength="11" title="Please enter a valid phone number">
                    </div>

                    <div class="input-field">
                        <label>Profile picture</label>
                        <input type="file" name="customer-image" id="image" name="image" accept="image/jpeg, image/png" 
                        <c:if test="${not empty user.picture}">
			               required
			           	</c:if>>
                    </div>
                </div>
            </div>

             <div class="details ID">
                 <span class="title">Address Details</span>

                 <div class="fields">
                     <div class="input-field">
                         <label>Address 1</label>
                         <input type="text" name="customer-address1" placeholder="Enter Supplier First Address" value="${user.address1}" required>
                     </div>

                     <div class="input-field">
                         <label>Address 2</label>
                         <input type="text" name="customer-address2" placeholder="Enter Supplier Second Address" value="${user.address2}" required>
                     </div>

                     <div class="input-field">
                         <label>Postcode</label>
                         <input type="text" name="customer-postcode" placeholder="Enter Supplier Postcode" value="${user.postcode}" required pattern="\d{5}" maxlength="5" title="Please enter a valid postcode">
                     </div>

                     <div class="input-field">
                         <label>City</label>
                         <input type="text" name="customer-city" placeholder="Enter Supplier City" value="${user.city}" required pattern="[A-Za-z ]+" title="Please enter a valid city">
                     </div>

                     <div class="input-field">
                         <label for="state">State</label>
							<select id="state" name="customer-state" required style="color: black;">
							    <option value="Johor" <c:if test="${user.state == 'Johor'}">selected</c:if>>Johor</option>
							    <option value="Kedah" <c:if test="${user.state == 'Kedah'}">selected</c:if>>Kedah</option>
							    <option value="Kelantan" <c:if test="${user.state == 'Kelantan'}">selected</c:if>>Kelantan</option>
							    <option value="Melaka" <c:if test="${user.state == 'Melaka'}">selected</c:if>>Melaka</option>
							    <option value="Negeri Sembilan" <c:if test="${user.state == 'Negeri Sembilan'}">selected</c:if>>Negeri Sembilan</option>
							    <option value="Pahang" <c:if test="${user.state == 'Pahang'}">selected</c:if>>Pahang</option>
							    <option value="Perak" <c:if test="${user.state == 'Perak'}">selected</c:if>>Perak</option>
							    <option value="Perlis" <c:if test="${user.state == 'Perlis'}">selected</c:if>>Perlis</option>
							    <option value="Pulau Pinang" <c:if test="${user.state == 'Pulau Pinang'}">selected</c:if>>Pulau Pinang</option>
							    <option value="Sabah" <c:if test="${user.state == 'Sabah'}">selected</c:if>>Sabah</option>
							    <option value="Sarawak" <c:if test="${user.state == 'Sarawak'}">selected</c:if>>Sarawak</option>
							    <option value="Selangor" <c:if test="${user.state == 'Selangor'}">selected</c:if>>Selangor</option>
							    <option value="Terengganu" <c:if test="${user.state == 'Terengganu'}">selected</c:if>>Terengganu</option>
							    <option value="Wilayah Persekutuan Kuala Lumpur" <c:if test="${user.state == 'Wilayah Persekutuan Kuala Lumpur'}">selected</c:if>>Wilayah Persekutuan Kuala Lumpur</option>
							</select>
                     </div>
                     

                 </div>
                 <div class="submit-btn">
                    <button type="button" onclick="closeUpdateCustomer()" style="background-color: #E08DB4;">
                        Cancel
                        <i class="uil uil-navigator"></i>
                    </button>
                     <button type="submit">
                         Submit
                         <i class="uil uil-navigator"></i>
                     </button>
                 </div>
                 
             </div> 
         </div>
     </form>
 </div>
</div>

<!-- Modal Update Password -->
<div id="modal-update-password" style="display: none;">

    <form action="ToUpdateUserPassword" method="POST" enctype="multipart/form-data">
        <div class="modal-container-update-password">
            <h3>Change Password</h3>
            <label>Current Password: </label><br><input name="current-password" type="password" required><br>
            <label>New Password: </label><br><input name="new-password" type="password" required><br>
    
            <div class="btn">
                <button class="btn-cancel" onclick="closeUpdatePassword()">Cancel</button>
                <button class="btn-confirm" type="submit">Confirm</button>
            </div>
        </div>
    </form>

</div>



<!-- Ends -->
         </div>
     
        <!-- Page end  -->
    </div>

    <!-- Wrapper End-->
    <footer class="iq-footer">
            <div class="container-fluid">
            <div class="card">
                <div class="card-body" style="text-align: center;">
                    <span class="mr-1"><script>document.write(new Date().getFullYear())</script>©</span> <a href="ListProductControllerCustomer" class="">redeemMe</a>.
                </div>
            </div>
        </div>
        
            <!-- Update Profile -->
  	<%
        String successUpdateInfo = (String) request.getAttribute("successUpdateInfo");
        if (successUpdateInfo != null) {
    %>
    <script>
        alert('<%= successUpdateInfo %>');
    </script>
    <%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("successUpdateInfo");
    }
	%>
	
		<%
	        String failUpdateInfo = (String) request.getAttribute("failUpdateInfo");
	        if (failUpdateInfo != null) {
	    %>
	    <script>
	        alert('<%= failUpdateInfo %>');
	    </script>
	    <%
	        // Remove the attribute to prevent it from appearing again on page refresh
	        request.removeAttribute("failUpdateInfo");
	    }
		%>
		
		
            <!-- Update Password -->
  	<%
        String successUpdatePass = (String) request.getAttribute("successUpdatePass");
        if (successUpdatePass != null) {
    %>
    <script>
        alert('<%= successUpdatePass %>');
    </script>
    <%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("successUpdatePass");
    }
	%>
	
		<%
	        String failUpdatePass = (String) request.getAttribute("failUpdatePass");
	        if (failUpdatePass != null) {
	    %>
	    <script>
	        alert('<%= failUpdatePass %>');
	    </script>
	    <%
	        // Remove the attribute to prevent it from appearing again on page refresh
	        request.removeAttribute("failUpdatePass");
	    }
		%>
		
		
  	<%
        String sameUpdatePass = (String) request.getAttribute("sameUpdatePass");
        if (sameUpdatePass != null) {
    %>
    <script>
        alert('<%= sameUpdatePass %>');
    </script>
    <%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("sameUpdatePass");
    }
	%>
	
		<%
	        String errorMessage = (String) request.getAttribute("errorMessage");
	        if (errorMessage != null) {
	    %>
	    <script>
	        alert('<%= errorMessage %>');
	    </script>
	    <%
	        // Remove the attribute to prevent it from appearing again on page refresh
	        request.removeAttribute("errorMessage");
	    }
		%>
		
  	<%
        String emptyFieldProfile = (String) request.getAttribute("emptyFieldProfile");
        if (emptyFieldProfile != null) {
    %>
    <script>
        alert('<%= emptyFieldProfile %>');
    </script>
    <%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("emptyFieldProfile");
    }
	%>
    </footer>

    <script src="assets/js/customer-profile.js"></script>

    <!-- Backend Bundle JavaScript -->
    <script src="assets/js/backend-bundle.min.js"></script>
    
    <!-- Table Treeview JavaScript -->
    <script src="assets/js/table-treeview.js"></script>
    
    <!-- Chart Custom JavaScript -->
    <script src="assets/js/customizer.js"></script>
    
    <!-- Chart Custom JavaScript -->
    <script async src="assets/js/chart-custom.js"></script>
    
    <!-- app JavaScript -->
    <script src="assets/js/app.js"></script>
  </body>
</html>