<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<app:layout-member title="BALANCES">
	
	<app:page-title title="Balance Report" />
	
	<!-- Search From -->
	<form class="row">
		<app:form-group label="Date From" cssClass="col-auto">
			<input name="dateFrom" type="date" class="form-control" />
		</app:form-group>

		<app:form-group label="Date To" cssClass="col-auto">
			<input name="dateTo" type="date" class="form-control" />
		</app:form-group>
		
		<div class="col btn-wrapper">
			<button class="btn btn-primary">
				<i class="bi-search"></i> Search
			</button>
		</div>
	</form>
	
	<!-- List -->
	<table class="table table-striped table-bordered table-hover my-3">
		<thead>
			<tr>
				<th>Issue At</th>
				<th>Ledger</th>
				<th>Particular</th>
				<th class="text-end">Expenses</th>
				<th class="text-end">Incomes</th>
				<th class="text-end">Balance</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>2025-02-25 10:00</td>
				<td>Service Charges</td>
				<td>Maintenance Fees for POS</td>
				<td class="text-end">0</td>
				<td class="text-end">100,000</td>
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