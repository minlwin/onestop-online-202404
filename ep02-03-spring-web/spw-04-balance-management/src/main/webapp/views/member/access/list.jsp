<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout-member title="ACCESS">
	
	<app:page-title title="Access History"></app:page-title>
	
	<!-- Search Form -->
	<form class="row">
		<app:form-group label="Status" cssClass="col-auto">
			<select class="form-select">
				<option value="">Search All</option>
				<option value="Success">Success</option>
				<option value="Fails">Fails</option>
			</select>
		</app:form-group>
		
		<app:form-group label="Date From" cssClass="col-auto">
			<input type="date" class="form-control" />
		</app:form-group>

		<app:form-group label="Date To" cssClass="col-auto">
			<input type="date" class="form-control" />
		</app:form-group>
		
		<div class="col btn-wrapper">
			<button class="btn btn-primary">
				<i class="bi-search"></i> Search
			</button>
		</div>
	</form>
	
	<table class="table table-bordered table-striped table-hover my-3">
		<thead>
			<tr>
				<th>Access At</th>
				<th>Access Type</th>
				<th>Status</th>
				<th>Remark</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>2024-10-14 10:00</td>
				<td>Login</td>
				<td>Fails</td>
				<td>Wrong Password</td>
			</tr>
		</tbody>
	</table>

	<app:pagination />
</app:layout-member>