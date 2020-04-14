<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  isELIgnored="false"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List - E-Loan Application</title>
<s:url var="url_css" value="/static/css/style/css"/>
<link href="${url_css}" rel="stylesheet" type="text/css">
</head>
<img alt="" src='<s:url  value="/images/bg.jpg"/>'>
<body background="${url_bg}">
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
   <h3>User List</h3>
   <table border="1">
     <tr>
     <td>SR</td>
     <td>USER_ID</td>
     <td>NAME</td>
     <td>PHONE_NO</td>
     <td>EMAIL_ID</td>
     <td>ADDRESS</td>
     <td>LOGIN_NAME</td>
     <td>ROLE</td>
     <td>LOGIN_STATUS</td>
     </tr>
     <c:forEach var ="u" items="${userList}" varStatus ="st">
      <td>${st.count}</td>
     <td>${u.userId}</td>
     <td>${u.name}</td>
     <td>${u.phone}</td>
     <td>${u.email}</td>
     <td>${u.address}</td>
     <td>${u.loginName}</td>
     <td>${u.role}</td>
     <td>${u.loginStatus}</td>
     </c:forEach>
   </table>
   
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
</html>