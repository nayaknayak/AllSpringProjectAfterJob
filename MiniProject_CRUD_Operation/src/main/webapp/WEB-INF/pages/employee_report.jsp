<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:choose>
	<c:when test="${!empty listOfEmployee}">
		<table align = "center">
			<tr>
				<th>Empno</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>Sal</th>
			</tr>
			<c:forEach var= "emp" items="${listOfEmployee}">
				<tr>
					<td>${emp.empNo}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td><a href = "edit?no=${emp.empNo}"><img src="images/icons8-edit-64.png" width ="50" height = "50"></a><a href = "delete?no=${emp.empNo}"><img src="images/icons8-delete-user-data-48.png" width ="50" height = "50"></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose>

<br>
<br>
<hr>
<h1 style= "text-align:center"><a href="/add"><img src ="images/add.png" width ="50" height = "50"></a></h1>