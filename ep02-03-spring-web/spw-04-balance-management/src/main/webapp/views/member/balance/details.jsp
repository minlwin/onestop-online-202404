<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<app:layout-member title="BALANCES">
	
	<div class="d-flex justify-content-between align-items-start">
		<app:page-title title="Incomes Details" />
		
		<c:url var="editUrl" value="${root}/member/entry/incomes/edit">
			<c:param name="id" value="20250401-001"></c:param>
		</c:url>
		<a href="${editUrl}" class="btn btn-danger">
			<i class="bi-pencil"></i> Edit Entry
		</a>
	</div>
	
	<div class="row">
		
		<!-- Entry Items -->
		<div class="col">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">
						<i class="bi-list"></i> Entry Items
					</h5>
					
					<table class="table table-striped">
						<thead>
							<tr>
								<th>No.</th>
								<th>Item Name</th>
								<th class="text-end">Price</th>
								<th class="text-end">Quantity</th>
								<th class="text-end">Total</th>
							</tr>
						</thead>
						
						<tbody>
							<tr>
								<td>1</td>
								<td>Print Paper</td>
								<td class="text-end">35,000</td>
								<td class="text-end">2</td>
								<td class="text-end">70,000</td>
							</tr>
							<tr>
								<td>2</td>
								<td>Maintenance Fees</td>
								<td class="text-end">30,000</td>
								<td class="text-end">1</td>
								<td class="text-end">30,000</td>
							</tr>
							<tr>
								<td colspan="4">All Total</td>
								<td class="text-end">30,000</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
		
		<!-- Header -->
		<div class="col-3">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">
						<i class="bi-flag"></i> Summary 
					</h5>
					
					<div class="list-group list-group-flush">
						<div class="list-group-item">
							<div>Code</div>
							<div>20250225-001</div>
						</div>
					
						<div class="list-group-item">
							<div>Ledger</div>
							<div>Service Charges</div>
						</div>

						<div class="list-group-item">
							<div>Amount</div>
							<div>100,000 MMK</div>
						</div>

						<div class="list-group-item">
							<div>Issue At</div>
							<div>2025-02-25 10:00</div>
						</div>
						
						<div class="list-group-item">
							<div>Particular</div>
							<div>Maintenance Fees for POS</div>
						</div>
						
					</div>
				</div>
			</div>
		
		</div>		
	</div>
	
</app:layout-member>