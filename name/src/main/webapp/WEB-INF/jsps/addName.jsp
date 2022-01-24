<%@ page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${msg}
<form action="postName" method="post">
id:<input type="text" name="id"/>
name:<input type="text" name="naming"/>
<input type="submit"/>
</form>

</body>
</html>