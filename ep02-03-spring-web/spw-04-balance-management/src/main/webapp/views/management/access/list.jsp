<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<app:layout-management title="ACCESS">
	
	<app:page-title title="Access History" />
	
	<!-- Search Form -->
	<form class="row">
		<app:form-group label="Status" cssClass="col-auto">
			<select name="status" class="form-select">
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
		
		<app:form-group label="Keyword" cssClass="col-auto">
			<input class="form-control" placeholder="Search Keyword" />
		</app:form-group>
		
		<div class="col btn-wrapper">
			<button class="btn btn-primary">
				<i class="bi-search"></i> Search
			</button>
		</div>
		
	</form>
	
	<!-- Result Table -->
	<table class="table table-striped table-bordered table-hover my-3">
		<thead>
			<tr>
				<th>Member</th>
				<th>Access At</th>
				<th>Access Type</th>
				<th>Status</th>
				<th>Remark</th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>Thidar Aung</td>
				<td>2025-02-24 10:00</td>
				<td>Login</td>
				<td>Success</td>
				<td></td>
			</tr>
		</tbody>
	</table>
	
	<!-- Pagination -->
	<app:pagination />
	
</app:layout-management>