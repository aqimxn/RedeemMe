<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <title>Redeem Product | redeemMe</title>
      
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
              <a href="customer-shop.jsp" class="header-logo">
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
                          <a href="ViewCustomerProfile?userId=${user.userId}" class="svg-icon">                        
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
                        <a href="customer-purchases.jsp">
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
                      <a href="customer-shop.jsp" class="header-logo">
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
                                      <img src="assets/images/user/1.png" class="img-fluid rounded" alt="user">
                                  </a>
                                  <div class="iq-sub-dropdown dropdown-menu" aria-labelledby="dropdownMenuButton">
                                      <div class="card shadow-none m-0">
                                          <div class="card-body p-0 text-center">
                                              <div class="media-body profile-detail text-center">
                                                  <img src="assets/images/page-img/profile-bg.jpg" alt="profile-bg"
                                                      class="rounded-top img-fluid mb-4">
                                                  <img src="assets/images/user/1.png" alt="profile-img"
                                                      class="rounded profile-img img-fluid avatar-70">
                                              </div>
                                              <div class="p-3">
                                                  <p class="mb-0">customer email</p>
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
                   <table class="data-tables table mb-0 tbl-server-info">
                       <thead class="bg-white text-uppercase">
                           <tr class="ligth ligth-data">
                               <th>ID</th>
                               <th>Name</th>
                               <th>Category</th>
                               <th>Points Required</th>
                               <th>Quantity</th>
                               <th>Supplier</th>
                               <th>Action</th>
                           </tr>
                       </thead>
                       <tbody class="ligth-body">
                           	<c:forEach items="${products}" var="product" varStatus="products">
                               <tr>   
                               		<td><c:out value="${product.productId}"/></td>
            						<td><c:out value="${product.productName}"/></td>
            						<td><c:out value="${product.productCategory}"/></td>    
            						<td><c:out value="${product.productPoints}"/></td>   
            						<td><c:out value="${product.productQuantity}"/></td> 
            						<td>
									    <c:choose>
									        <c:when test="${product.supplierId == 0}">
									            <c:out value="-"/>
									        </c:when>
									        <c:otherwise>
									            <c:out value="${product.supplierName}"/>
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
										    
										    <button type="submit" class="badge bg-warning mr-2">
										        <i class="ri-eye-line mr-0"></i> Check Out
										    </button>
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
    </div>
      </div>
    </div>
    <!-- Wrapper End-->
    <footer class="iq-footer">
            <div class="container-fluid">
            <div class="card">
                <div class="card-body" style="text-align: center;">
                    <span class="mr-1"><script>document.write(new Date().getFullYear())</script>Â©</span> <a href="customer-shop.jsp" class="">redeemMe</a>.
                </div>
            </div>
        </div>
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