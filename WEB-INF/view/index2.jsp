<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manager Login- E-Loan Application</title>
<s:url var="url_css" value="/static/css/"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href='<s:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>

<!--  <body background='<s:url value="/resources/img/bg.png"/>'>
<table border="1" width="80%" align="center">
   <tr>
   <td height="80px">
   <%-- Header --%>
    <jsp:include page="include/header.jsp"/>
   </td>
   </tr>
    <tr>
   <td height="25px">
   <%-- Menu --%>
    <jsp:include page="include/menu.jsp"/> 
   </td>
   </tr>
    <tr>
   <td height="350px" valign="top">
   <%-- Page Content Area --%>
   <h3>User Login</h3>
   <s:url var="url_login" value="/login"/>
   <f:form action="login" modelAttribute="command">
   <table border="1">
   <tr>
   <td>Username</td>
   <td><f:input path="loginName"/></td>
   </tr>
   <tr>
   <td>Password</td>
   <td><f:input path="password"/></td>
   </tr>
   <tr>
   <td colspan="2" align="right">
   <button>Login</button><br>
      <a href="reg_form">New User Registration</a>
   </td>
   </tr>
   </table>
   </f:form>
   </td>
   </tr>
   
    <tr>
   <td height="25px">
   <%-- Footer --%>
    <jsp:include page="include/footer.jsp"/> 
   </td>
   </tr>
</table>
</body>
</html>-->
<body>
	<div class="top">
		<div class="top-ul">
			<ul >
  			<li>About us |</li>
  			<li>Cotact us |</li>
  			<li><i class="fa fa-envelope-o"></i> Bank@Cognizant.com</li>
			</ul>  
		</div><!----------end oftop-ul--->
		<div class="top-ul-icon ">
			<ul class="">
             <li class=" "><i class="fa fa-facebook"></i> </li>
             <li class=""><i class="fa fa-twitter"></i> </li>
             <li class=""><i class="fa fa-youtube"></i> </li>
             <li class=""><i class="fa fa-instagram"></i> </li>
            </ul>
           
            </div><!------end of ul-icon--->
			
		</div><!-----end of header 1-------------->
<!--------------------------------------------------------------------------------------------->
<div class="header">
	<div class="logo1"><img src='<s:url  value="/images/loan.png"/>'>
	</div>
	<div class="logo">
		<ul>
  		<li><a class="active" href="#home">Home</a></li>
  		<li><a href="/home/News">News</a></li>
  		<li><a href="/home/Contact">Contact</a></li>
 		 <li><a href="/home/login">Login</a></li>
		</ul>
	</div>
</div>

<!------------------------------------------------------------------------------------------->
<div class="grey-box">
	<h2>Login</h2>
</div>
<!----------------------------------------------------------------------------------------------->
<div class="box">
	 <f:form action="loginMag" modelAttribute="command" class="input-form">
	
  <div class="container">
   

    <label for="email"><b>Username</b></label>
    <f:input path="loginName" class="input-type"/>
   

    <label for="psw"><b>Password</b></label>
    <f:input path="password"  class="input-type"/>
    

    <p>By Logging in your account you agree to our <a href="#">Terms & Privacy</a>.</p>

    <button type="submit" class="registerbtn">Login</button>
    
  </div>
  
 </f:form>
</div>
<!-------------------------footer----------------------------------------------->
<footer class="footer-distributed">

			<div class="footer-left">
			<img src='<s:url  value="/images/loan.png"/>' class="fotter-img">

				

				<p class="footer-links">
					<a href="#" class="link-1">Home</a>
					
					<a href="#">Blog</a>
				
					<a href="#">Pricing</a>
				
					<a href="#">About</a>
					
					<a href="#">Faq</a>
					
					<a href="#">Contact</a>
				</p>

				<p class="footer-company-name">Company Name © 2020</p>
			</div>

			<div class="footer-center">

				<div>
					<i class="fa fa-map-marker"></i>
					<p><span> Ave</span>Hinjewadi Phase 3, Pune</p>
				</div>

				<div>
					<i class="fa fa-phone"></i>
					<p>+91-95606-23-178</p>
				</div>

				<div>
					<i class="fa fa-envelope"></i>
					<p><a href="mailto:support@company.com">support@cognizant.com</a></p>
				</div>

			</div>

			<div class="footer-right">

				<p class="footer-company-about">
					<span>About the company</span>
					Lorem ipsum dolor sit amet, consectateur adispicing elit. Fusce euismod convallis velit, eu auctor lacus vehicula sit amet.
				</p>

				<div class="footer-icons">

					<a href="#"><i class="fa fa-facebook"></i></a>
					<a href="#"><i class="fa fa-twitter"></i></a>
					<a href="#"><i class="fa fa-linkedin"></i></a>
					<a href="#"><i class="fa fa-github"></i></a>

				</div>

			</div>

		</footer>	
</body>
</html>