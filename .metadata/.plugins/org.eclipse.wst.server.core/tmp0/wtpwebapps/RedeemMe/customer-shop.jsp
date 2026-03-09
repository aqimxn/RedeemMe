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
     <title>Products | redeemMe</title>
      
      <!-- Favicon -->
      <link rel="shortcut icon" href="assets/images/favicon.ico" />
      <link rel="stylesheet" href="assets/css/backend-plugin.min.css">
      <link rel="stylesheet" href="assets/css/backend.css?v=1.0.0">
      <link rel="stylesheet" href="assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
      <link rel="stylesheet" href="assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">
      <link rel="stylesheet" href="assets/vendor/remixicon/fonts/remixicon.css"> 
      <link rel="stylesheet" href="assets/css/customer-style.css"> </head>

      <!-- css -->
      <style>
        .las.la-bars.wrapper-menu:hover, .ri-menu-line.wrapper-menu:hover {
            cursor: pointer;
        }

        .btn.border.sign-out{
            font-weight: bold;
            font-size: medium;
        }

        .btn.border.sign-out:hover{
            background-color: #e32323;
            color: #ffffff;
            transition: all 0.7s ease-in-out;
        }
        
		 .move {
		    animation: bounceLeftRight 2s infinite;
		    display: inline-block;
		}
		
		@keyframes bounceLeftRight {
		    0%, 100% {
		        transform: translateX(0); /* Start and end position */
		    }
		    50% {
		        transform: translateX(-10px); /* Move left */
		    }
		    70% {
		        transform: translateX(10px); /* Move right */
		    }
		}
		
		@media (max-width: 768px) {
	    .scrolling-container {
	        flex-wrap: wrap; /* Allow items to wrap on smaller screens */
	    }
	    .move {
	        margin: 5px; /* Adjust spacing between items for smaller screens */
	    }
	    
	    .tag-list{
	    	display: flex;
	    	flex-direction: column;
	    }
}

        
      </style>

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
                      <li class=" ">
                          <a href="ViewUserProfile" class="svg-icon">                        
                            <svg class="svg-icon" id="p-dash8" width="20" height="20" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                                <path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path>
                            </svg>
                              <span class="ml-4">Profile</span>
                          </a>
                      </li>
                      <li class="active">
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
                    Your Points: <c:out value="${user.points}"/> &#9733;
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
        <div class="container-fluid">
           <div class="row">
               <div class="col-lg-12">
                   <div class="d-flex flex-wrap flex-wrap align-items-center justify-content-between mb-4">
                       <div>
                           <h4 class="mb-3">Product List</h4>
                           <p class="mb-0"></p>
                       </div>
                   </div>
               </div>
               <div class="col-lg-12">
                   <div class="table-responsive rounded mb-3">
                   <div class="tag-list" style="display: flex; align-items: center; justify-content: space-evenly;">
                   		<span class="move" style="color: red; background-color: #EEE9E8; padding: 10px; border-radius: 3px; font-weight: bold; text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5);">&#x2022; &nbsp;Out Of Stock</span>
						<span class="move" style="color: #F5F51B; background-color: #EEE9E8; padding: 10px; border-radius: 3px; font-weight: bold; text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5);">&#x2022; &nbsp;In Demand</span>
						<span class="move" style="color: #86F768; background-color: #EEE9E8; padding: 10px; border-radius: 3px; font-weight: bold; text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.5);">&#x2022; &nbsp;Ready Stock</span>
                   </div><br>
                   <table class="data-tables table mb-0 tbl-server-info">
                       <thead class="bg-white text-uppercase">
                           <tr class="ligth ligth-data">
                               <th>Product</th>
                               <th>Name</th>
                               <th>Points Required</th>
                               <th>Available Quantity</th>
                               <th>Action</th>
                           </tr>
                       </thead>
                       <tbody class="ligth-body">
                           	<c:forEach items="${products}" var="product" varStatus="products">
                               <tr>   
                               		<td><img src="data:image/jpg;base64,${product.productImage}" width="100px" height="100px" /></td>
            						<td><c:out value="${product.productName}"/></td>   
            						<td><c:out value="${product.productPoints}"/></td>   
            						<td>
									    <c:choose>
									        <c:when test="${product.productQuantity == 0}">
									            <span style="color: red;"><c:out value="${product.productQuantity}"/></span>
									        </c:when>
									        <c:when test="${product.productQuantity >= 1 && product.productQuantity <= 100}">
									            <span style="color: #CFD822;"><c:out value="${product.productQuantity}"/></span>
									        </c:when>
									        <c:when test="${product.productQuantity > 100}">
									            <span style="color: green;"><c:out value="${product.productQuantity}"/></span>
									        </c:when>
									        <c:otherwise>
									            <span><c:out value="${product.productQuantity}"/></span>
									        </c:otherwise>
									    </c:choose>
									</td> 
									
                              		<td>
					                    <form action="ToCheckoutProduct?productId=${product.productId}" method="post" style="display: inline;">
										    <input type="hidden" name="productId" value="${product.productId}" />
										    <input type="hidden" name="productName" value="${product.productName}" />
										    <input type="hidden" name="productCategory" value="${product.productCategory}" />
										    <input type="hidden" name="productPoints" value="${product.productPoints}" />
										    <input type="hidden" name="productQuantity" value="${product.productQuantity}" />
										    
										    <c:choose>
										        <c:when test="${product.productQuantity > 0}">
										            <button type="submit" class="badge bg-warning mr-2" style="border: none;">
										                <i class="ri-eye-line mr-0" style="border: none;"></i> Check Out
										            </button>
										        </c:when>
										        <c:otherwise>
												    <span class="badge bg-danger mr-2">
												        <i class="ri-error-warning-line mr-0"></i> Out of Stock
												    </span>
												</c:otherwise>
										    </c:choose>
									    
										</form>

                              		</td>
                               </tr>
                        </c:forEach>
                       </tbody>
                   </table>
                   </div>
               </div>
           </div>
           <!-- Page end  -->
       </div>

       
</div>
       
         </div>
     
        <!-- Page end  -->

    <!-- Wrapper End-->
    <footer class="iq-footer">
            <div class="container-fluid">
            <div class="card">
                <div class="card-body" style="text-align: center;">
                    <span class="mr-1"><script>document.write(new Date().getFullYear())</script>©</span> <a href="ListProductControllerCustomer" class="">redeemMe</a>.
                </div>
            </div>
        </div>
        
<%
        String success = (String) request.getAttribute("success");
        if (success != null) {
%>
    <script>
        alert('<%= success %>');
    </script>
<%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("success");
    }
%>

<%
        String unsufficient = (String) request.getAttribute("unsufficient");
        if (unsufficient != null) {
%>
    <script>
        alert('<%= unsufficient %>');
    </script>
<%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("unsufficient");
    }
%>

    </footer>

    <!-- Javascript -->
    <script src="assets/js/admin-product.js"></script>

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