<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 isELIgnored="false"   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Login- E-Loan Application</title>
<s:url var="url_css" value="/static/css/"/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href='<s:url value="/resources/css/style.css"/>' rel="stylesheet">
</head>
	<title>Clerk List </title>
	
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
	<div class="logo1"><img src='<s:url  value="/images/loan.png"/>'">
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
	<h2>Clerk List</h2><br>
	<table border="1" align="center">
	<tr>
	<th>User_name</th>
	<th>Password</th>
	<th>Confirm password</th>
	<th>Role</th>
	<th>Action</th>
	</tr>
	<c:forEach var="t" items="${clerkList}" >
	<tr>
	<td>${t.userName}</td>
	<td>${t.password}</td>
	<td>${t.confirmPassword}</td>
	<td>${t.role}</td>
	<s:url var ="url_del" value="deleteClerk">
	  <s:param name="uname" value="${t.userName}"></s:param>
	</s:url>
	
	<s:url  var="url_edit" value="editClerk">
	<s:param name="uname" value="${t.userName}"></s:param>
	</s:url>
	<td><a href="${url_edit}">Edit</a> | <a href="${url_del}">Delete</a></td>
	</tr>
	
	</c:forEach>
	</table>
	
</div>
<!----------------------------------------------------------------------------------------------->

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