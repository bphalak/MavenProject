<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"></link>
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css"></link>
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	
	<title>Search Department</title>
	
	<script type="text/javascript">
		function submitter(btn) {
			document.getElementById('depid').value = parseInt(btn);
		}
		
	</script>
</head>

<body>
	<form action="/MavenProject/searchdepartment" method="POST">
	
		<div class="panel panel-primary">
			  <div class="panel-heading">Search Department</div>
			  <div class="panel-body">
				<table style="border-collapse: separate; border-spacing: 15px;">
					<tr>
						<td>Department No.</td>
						<td><input type="text" id="deptno" name="deptno" value="${department.deptno}" class="form-control"></input></td>
					</tr>
					<tr>
						<td>Department Name</td>
						<td><input type="text" id="depname" name="depname" value="${department.depname}" class="form-control"></input></td>
					</tr>
				</table>
				<br></br> 
				<br></br> 
				<input type="submit" value="Search" name="action" class="btn btn-primary"></input> 
				<input type="submit" value="New Department" name="action" class="btn btn-primary"></input>
				<br></br>
				<br></br>
				<table border="1" class="table table-striped">
					<tbody>
						<tr class="info">
							<th>Department No.</th>
							<th>Department Name</th>
							<th>Location</th>
							<th>Created Date</th>
						</tr>
						<c:forEach items="${deptList}" var="dept" varStatus="loopCounter" >
							<tr>
								<td><c:out value="${dept.deptno}"/></td>
								<td><c:out value="${dept.depname}"/></td>
								<td><c:out value="${dept.deplocation}"/></td>
								<td><fmt:formatDate value="${dept.createddate}" pattern="dd-MM-yyyy"/></td>
								<td><input type="submit" name="action" value="Modify" class="btn btn-primary"
										onclick="submitter(${dept.deptno});"></input>
									<input type="submit" name="action" value="Delete" class="btn btn-primary"
										onclick="submitter(${dept.deptno});'"></input>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<input type="hidden" id="depid" name="depid" class="form-control"></input>
			</div>
		</div>
	
	</form>
</body>
</html>