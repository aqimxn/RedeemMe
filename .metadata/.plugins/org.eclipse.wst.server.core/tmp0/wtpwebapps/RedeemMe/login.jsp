<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<%

  // Invalidate the session
  session.invalidate();
  
  // Set Cache-Control header to instruct browsers and intermediate caches not to cache the response
  response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
  
  // Set Pragma header to prevent caching in older browsers
  response.setHeader("Pragma", "no-cache");
  
  // Set Expires header to ensure that the response is not cached by proxies or the client's browser
  response.setDateHeader("Expires", 0);

%>

<!doctype html>
<html lang="en">
  <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Login</title>
  <link rel="shortcut icon" href="assets/images/favicon.ico" />
  <link rel="stylesheet" href="assets/css/login.css">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"/>
</head>
<body>
  <div class="wrapper">
    <header>Login Form</header>
    <form action="LoginController" method="POST">
      <div class="field email">
        <div class="input-area">
          <input type="text" name="email" placeholder="Email Address" required>
          <i class="icon fas fa-envelope"></i>
          <i class="error error-icon fas fa-exclamation-circle"></i>
        </div>
        <div class="error error-txt">Email can't be blank</div>
      </div>
      <div class="field password">
        <div class="input-area">
          <input type="password" name="password" placeholder="Password" required>
          <i class="icon fas fa-lock"></i>
          <i class="error error-icon fas fa-exclamation-circle"></i>
        </div>
        <div class="error error-txt">Password can't be blank</div>
      </div>
      <input type="submit" value="Login">
    </form>
    <div class="sign-txt">Don't have an account? <a href="sign-up.jsp">Signup now</a></div>
  </div>
  
  	<%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <script>
        alert('<%= error %>');
    </script>
    <%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("error");
    }
	%>
    
    
    <%
        String successful = (String) request.getAttribute("successful");
        if (successful != null) {
    %>
    <script>
        alert('<%= successful %>');
    </script>
	<%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("successful");
    }
	%>
	
	
	    <%
        String errorAccess = (String) request.getAttribute("errorAccess");
        if (errorAccess != null) {
    %>
    <script>
        alert('<%= errorAccess %>');
    </script>
	<%
        // Remove the attribute to prevent it from appearing again on page refresh
        request.removeAttribute("errorAccess");
    }
	%>
    

</body>
</html>