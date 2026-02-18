<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h1 style="text-align:center;color:red">Registation Page</h1>
<form:form modelAttribute="emp" bgcolor="cyan" align="center" method= "POST" action = "save">
	<table border="1" style= "text-align:center" align="center">
		<tr>
			<td>Employee Name:</td>
			<td><form:input path= "ename"/></td>
		</tr>
		<tr>
			<td>Employee Designation:</td>
			<td><form:input path= "job" /></td>   
		</tr>
		<tr>
			<td>Employee Salary:</td>
			<td><form:input path= "sal"/></td>
		</tr>
		<tr>
			<td colspan = "2" align = "center"><input type = "submit" value = "Submit"></td>
		</tr>
	</table>
</form:form>