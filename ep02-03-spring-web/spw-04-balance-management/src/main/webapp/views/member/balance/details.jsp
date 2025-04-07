<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<app:layout-member title="BALANCES">
	
	<div class="d-flex justify-content-between align-items-start">
		<app:page-title title="Incomes Details" />
		
		<c:url var="editUrl" value="${root}/member/entry/incomes/edit">
			<c:param name="id" value="${details.code()}"></c:param>
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
							<c:forEach var="item" items="${details.items()}" varStatus="sts">
							<tr>
								<td>${sts.index + 1}</td>
								<td>${item.itemName()}</td>
								<td class="text-end">${item.unitPrice()}</td>
								<td class="text-end">${item.quantity()}</td>
								<td class="text-end">${item.total}</td>
							</tr>
							</c:forEach>
							<tr>
								<td colspan="4">All Total</td>
								<td class="text-end">${details.total}</td>
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
							<div>${details.code()}</div>
						</div>
					
						<div class="list-group-item">
							<div>Ledger</div>
							<div>${details.ledgerName()}</div>
						</div>

						<div class="list-group-item">
							<div>Amount</div>
							<div>${details.amount()} MMK</div>
						</div>

						<div class="list-group-item">
							<div>Issue At</div>
							<div>${dtf.formatDateTime(details.issueAt())}</div>
						</div>
						
						<div class="list-group-item">
							<div>Particular</div>
							<div>${details.particular()}</div>
						</div>
						
					</div>
				</div>
			</div>
		
		</div>		
	</div>
	
</app:layout-member>