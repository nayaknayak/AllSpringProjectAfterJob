<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

<c:choose>
	<c:when test="${!empty listOfEmployee.getContent()}">
		<table class="table table-hover" >
			<tr>
				<th>Empno</th>
				<th>EmpName</th>
				<th>Job</th>
				<th>Sal</th>
				<th></th>
				<th></th>
				
			</tr>
			<c:forEach var= "emp" items="${listOfEmployee.getContent()}">
				<tr>
					<td>${emp.empNo}</td>
					<td>${emp.ename}</td>
					<td>${emp.job}</td>
					<td>${emp.sal}</td>
					<td><a href = "edit?no=${emp.empNo}"><img src="images/icons8-edit-64.png" width ="50" height = "50"></a></td>
					<td><a href = "delete?no=${emp.empNo}"><img src="images/icons8-delete-user-data-48.png" width ="50" height = "50"></a></td>
				</tr>
			</c:forEach>
		</table>
	</c:when>
</c:choose>


<p style = "text-align:center">
	<c:if test ="${listOfEmployee.hasPrevious()}">
		<a href="report?page=listOfEmployee.getNumber()-1">previous</a>
	</c:if>	
	<c:if test="${!listOfEmployee.isFirst()}">
		<a href="report?page=0">first</a>
	</c:if>
	<c:forEach var="i" begin ="1" end= "${listOfEmployee.getTotalPages()}" step= "1">
		<a href="report?page=${i-1}">${i}</a>
	</c:forEach>
	<c:if test="${!listOfEmployee.isLast()}">
	   <a href="report?page=${listOfEmployee.getTotalPages()-1}">last</a>
	</c:if>
	<c:if test ="${listOfEmployee.hasNext()}">
			<a href="report?page=${listOfEmployee.getNumber()+1}">next</a>
	</c:if>	
</p>



<br>
<br>
<hr>
<h1 style= "text-align:center"><a href="/add"><img src ="images/add.png" width ="50" height = "50"></a></h1>