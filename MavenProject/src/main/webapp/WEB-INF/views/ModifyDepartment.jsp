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
	
	<title>Add New Department</title>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script>
	$(document).ready(function(){
		
		addRow();
		$("#addRow").click(function() {
			addRow();
			return false;
		});
		
		function addRow(){
			
			var table = document.getElementById("tblData");
			  var noofRow = $('#tblData tr').length;
			  
			  var row = table.insertRow(noofRow);
			  var myRow = noofRow-1;
			  var cell1 = row.insertCell(0);
			  var cell2 = row.insertCell(1);
			  var cell3 = row.insertCell(2);
			
			  cell1.innerHTML = '<input type="text" name="emplist['+myRow+'].empname" required="required"></input>';
			  cell2.innerHTML = '<input type="tel" name="emplist['+myRow+'].empphone" required="required"></input>';
			  cell3.innerHTML = '<input type="email" name="emplist['+myRow+'].empmail" required="required"></input>';
		}
		
		$("#removeRow").click(function() {
			
			var table = document.getElementById("tblData");
			var noofRow = $('#tblData tr').length;
			if(noofRow != 2){
				table.deleteRow(noofRow-1);
			}
			return false;
		});
	});
	
	
	</script>
</head>
<body>
	<form  action="/MavenProject/modifydepartment" method="POST">
		<div class="panel panel-primary">
			  <div class="panel-heading">Add New Department</div>
			  <div class="panel-body">
				<table style="border-collapse:separate; border-spacing:15px;">
					<tr>
						<td>Department No.</td>
						<td><input type="text" readonly="readonly" id="deptno" name="deptno" value="${department.deptno}" class="form-control"></input></td>
					</tr>
					<tr>
						<td>Department Name</td>
						<td><input type="text" id="depname" name="depname" value="${department.depname}" class="form-control"></input></td>
					</tr>
					<tr>
						<td>Department Location</td>
						<td><input type="text" id="deplocation" name="deplocation" value="${department.deplocation}" class="form-control"></input></td>
					</tr>
					<tr>
						<td>Is enabled</td>
						<td><input type="text" readonly="readonly" id="isEnabled" name="isEnabled" value="${department.isEnabled}" class="form-control"></input></td>
					</tr>
				</table>
				
				<br></br><br></br>
				<input type="submit" id="addRow" value="Add Row"  class="btn btn-primary"></input>
				<input type="submit" id="removeRow" value="Remove Row"  class="btn btn-primary" ></input>
				<br></br><br></br>
				<table id="tblData" class="table table-striped">			
					<tbody>
					<tr class="info">
						<th>Employ Name</th>
						<th>Employ Phone</th>
						<th>Employ Email</th>
					</tr>
					<c:forEach items="${department.emplist}" var="emp" varStatus="idStat" >
						<tr>
							<td hidden="hidden"><input type="hidden" name="emplist[${idStat.index}].empno" value="${emp.empno}" ></input></td>
							<td><input type="text" name="emplist[${idStat.index}].empname" value="${emp.empname}" required="required"></input></td>
							<td><input type="text" name="emplist[${idStat.index}].empphone" value="${emp.empphone}" required="required"></input></td>
							<td><input type="text" name="emplist[${idStat.index}].empmail" value="${emp.empmail}" required="required"></input></td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<br></br><br></br>
				<input type="submit" value="Save" name="action" class="btn btn-primary"></input>
				<input type="submit" value="Cancel" name="action" class="btn btn-primary"></input>
			</div>
		</div>
	</form>
</body>
</html>