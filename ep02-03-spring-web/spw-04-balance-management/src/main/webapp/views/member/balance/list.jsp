<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<app:layout-member title="BALANCES">
	
	<app:page-title title="Balance Report" />
	
	<!-- Search From -->
	<form class="row" id="searchForm">
		
		<input type="hidden" name="page" id="pageInput" />
		<input type="hidden" name="size" id="sizeInput" />

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
			<c:forEach var="item" items="${result.contents()}">
			<tr>
				<td>${dtf.formatDateTime(item.issueAt())}</td>
				<td>${item.ledgerName()}</td>
				<td>${item.particular()}</td>
				<td class="text-end">${item.expense()}</td>
				<td class="text-end">${item.income()}</td>
				<td class="text-end">${item.balance()}</td>
				<td class="text-center">
					<a href="${root}/member/balance/${item.code()}">
						<i class="bi-arrow-right"></i>
					</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<!-- Pagination -->
	<app:pagination pageResult="${result}" />
	
</app:layout-member>