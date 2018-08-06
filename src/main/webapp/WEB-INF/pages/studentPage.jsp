<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Details</title>
</head>
<body>
<h1 align="center">Student Details</h1>
<c:if test="${!empty student}">
<form:form method="post" modelAttribute="student" action="updateStudent">
	<table>
		<tr>
			<td>Student Id:</td>
			<td>
				<form:hidden path="studId"  value="${student.studId}" readonly="true"/>
				${student.studId}
			</td>
		</tr>
	
		<tr>
			<td>Student Name:</td>
			<td>
				<form:input path="studName"  value="${student.studName}"/>
			</td>
		</tr>
		
		<tr>
			<td>Student Location:</td>
			<td>
				<%-- <form:input path="studLocation"  value="${student.studLocation}"/> --%>
				<form:select path="studLocation" value="${student.studLocation}">
					<c:if test="${!empty locations }">
						<c:forEach items="${locations}" var="location">
						<form:option value="${location}"></form:option>
						</c:forEach>
					</c:if>
				</form:select>
				
			</td>
		</tr>
		
		<c:if test="${student.studId == 0}">
		<tr>
			<td></td>
			<td>
				<input type="submit" value="Save">
			</td>
		</tr>
		</c:if>
		<c:if test="${student.studId != 0 }">
		<tr>
			<td></td>
			<td>
				<input type="submit" value="Update">
			</td>
		</tr>
		</c:if>
		
	</table>
</form:form>
</c:if>
<c:if test="${!empty studs}">
	<table>
		<tr>
			<th>StudentID</th>
			<th>StudentName</th>
			<th>StudentLocation</th>
		</tr>
		<c:forEach items="${studs}" var="student" >
			<tr>
				<td>${student.studId}</td>
				<td>${student.studName}</td>
				<td>${student.studLocation}</td>
				<td>
					<a href="update/${student.studId}">Update</a>
				</td>
			</tr>		
		</c:forEach>
	</table>
</c:if>
</body>
</html>