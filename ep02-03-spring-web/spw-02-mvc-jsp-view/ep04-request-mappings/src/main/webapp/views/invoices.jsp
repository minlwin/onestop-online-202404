<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
    
<app:layout>
	<h3><i class="bi-calender"></i> Invoice Management</h3>
	
	<c:if test="${message ne null}">
		<div class="alert alert-info">
			${message}
		</div>
	</c:if>
	
	<table class="table table-bordered table-hover mt-3">
		<thead>
			<tr>
				<th>ID</th>
				<th>Issue At</th>
				<th class="text-end">Total Items</th>
				<th class="text-end">Total Amount</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach var="item" items="${list}">
			<tr>
				<td>${item.id()}</td>
				<td>${dateTimes.format(item.issueAt())}</td>
				<td class="text-end">${item.totalCount()}</td>
				<td class="text-end">
					<fmt:formatNumber value="${item.totalAmount()}" /> MMK
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</app:layout>