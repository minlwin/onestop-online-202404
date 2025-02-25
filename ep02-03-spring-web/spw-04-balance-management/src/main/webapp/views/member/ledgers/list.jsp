<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
   
<app:layout-member title="LEDGERS">
	
	<app:page-title title="Ledger Management" />
	
	<!-- Search -->
	<form class="row">
		
		<app:form-group label="Type" cssClass="col-auto">
			<select class="form-select">
				<option value="">Search All</option>
				<c:forEach items="${balanceTypes}" var="item" >
					<option value="${item}">${item}</option>
				</c:forEach>
			</select>
		</app:form-group>
		
		<app:form-group cssClass="col-auto" label="Keyword">
			<input type="text" placeholder="Search Keyword" class="form-control" />
		</app:form-group>
		
		<div class="col btn-wrapper">
			<button class="btn btn-primary">
				<i class="bi-search"></i> Search
			</button>
			
			<button id="addNewBtn" type="button" class="btn btn-danger">
				<i class="bi-plus"></i> New Ledger
			</button>
		</div>
	</form>
	
	<table class="table table-striped table-bordered table-hover mt-3">
		<thead>
			<tr>
				<th>ID</th>
				<th>Type</th>
				<th>Name</th>
				<th>Status</th>
				<th>Created At</th>
				<th>Modified At</th>
				<th class="text-end">Total</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>1</td>
				<td>Incomes</td>
				<td>Service Charges</td>
				<td>Active</td>
				<td>2025-01-10 10:00</td>
				<td></td>
				<td class="text-end">100,000</td>
				<td class="text-center">
					<a href="#" class="icon-link">
						<i class="bi-pencil"></i>
					</a>
				</td>
			</tr>
		</tbody>
	</table>
	
	<div id="editDialog" class="modal fade">
		<div class="modal-dialog">
			<form class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">
						<i class="bi-pencil me-2"></i> Add New Category
					</h5>
				</div>
				
				<div class="modal-body">
					<app:form-group label="Type" cssClass="mb-3" >
						<select class="form-select">
							<c:forEach var="item" items="${balanceTypes}">
								<option value="${item}">${item}</option>
							</c:forEach>
						</select>
					</app:form-group>
					
					<app:form-group label="Ledger Name" cssClass="mb-3">
						<input type="text" class="form-control" placeholder="Enter Ledger Name" />
					</app:form-group>
					
					<div class="form-check">
						<input type="checkbox" class="form-check-input" id="status" />
						<label for="status" class="form-check-label">Active</label>
					</div>
				</div>
				
				<div class="modal-footer">
					<button class="btn btn-primary">
						<i class="bi-save"></i> Save Category
					</button>
				</div>
			</form>
		</div>
	</div>
	
	<script src="${root}/resources/js/ledger-management.js"></script>
	
</app:layout-member>