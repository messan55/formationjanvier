<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello</title>
</head>
<body>
<h2>liste des taches</h2>
<table border="1">
<tr><th>ID</th><th>libelle</th><th>completed</th><th>categorie</th></tr>
<s:iterator value="taches" >
<tr>
<td><s:property value="id" /></td>
<td><s:property value="libelle" /></td>
<td><s:property value="completed" /></td>
<td><s:property value="category" /></td>
</tr>
</s:iterator>
</table>
</body>
</html>