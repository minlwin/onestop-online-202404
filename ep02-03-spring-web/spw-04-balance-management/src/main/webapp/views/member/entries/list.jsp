<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<app:layout-member title="${type.name().toUpperCase()}">
	
	<app:page-title title="${type} Management" />
	
	<!-- Search Form -->
	<form class="row">
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
			
			<a href="${root}/member/entry/add-new/${type.name().toLowerCase()}" class="btn btn-danger">
				<i class="bi-plus"></i> New Entry
			</a>
		</div>
	</form>
	
	<!-- Result Table -->
	<table class="table table-striped table-bordered table-hover my-3">
		<thead>
			<tr>
				<th>Code</th>
				<th>Issue At</th>
				<th>Category</th>
				<th>Particular</th>
				<th class="text-end">Amount</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>20240225-001</td>
				<td>2025-02-25 10:00</td>
				<td>Service Charge</td>
				<td>Maintenance Fees for POS</td>
				<td class="text-end">100,000</td>
				<td class="text-center">
					<a href="${root}/member/balance/20250225-001">
						<i class="bi-arrow-right"></i>
					</a>
				</td>
			</tr>
		</tbody>
	</table>
	
	
	<!-- Pagination -->
	<app:pagination />
	
</app:layout-member>