<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style = "background-color: orange">
<h1>Customer Detail Adding: </h1>
<form action="save" method="post">
Customer ID : <input type="text" name="cid" ><br><br>
Customer Name : <input type="text" name="cname" ><br><br>
Customer Email : <input type="text" name="email" ><br><br><br>
<input type="Submit" ><br><br>

</form><br><br>
<h4><a href="findbyid">Find Customer</a></h4><br><br>
<h3><a href="customers">All Customers</a></h3>



</body>
</html>