<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<app:layout>
	<h3><i class="bi-cart"></i> Check Out</h3>
	
	<table class="table table-bordered table-hover">
		<thead>
			<tr>
				<th>Product</th>
				<th>Category</th>
				<th class="text-end">Unit Price</th>
				<th class="text-center">Quantity</th>
				<th class="text-end">Amount</th>
			</tr>
		</thead>
		
		<tbody>
		<c:forEach items="${cart.items}" var="item">
			<tr>
				<td>${item.product.name}</td>
				<td>${item.product.category}</td>
				<td class="text-end">
					<fmt:formatNumber value="${item.product.price}" /> MMK
				</td>
				<td class="text-center">
					<a href="${root}/checkout/remove/${item.product.id}" class="icon-link me-2">
						<i class="bi-dash"></i>
					</a>
					<fmt:formatNumber value="${item.quantity}" />
					<a href="${root}/checkout/add/${item.product.id}" class="icon-link ms-2">
						<i class="bi-plus"></i>
					</a>
				</td>
				<td class="text-end">
					<fmt:formatNumber value="${item.product.price * item.quantity}" /> MMK
				</td>
			</tr>
		</c:forEach>
		</tbody>
		
		<tfoot>
			<tr>
				<th colspan="3" class="text-end">Total</th>
				<th class="text-center">
					<fmt:formatNumber value="${cart.totalItems}" />
				</th>
				<th class="text-end">
					<fmt:formatNumber value="${cart.totalAmount}" /> MMK
				</th>
			</tr>
		</tfoot>
	</table>
	
	<form method="post" action="${root}/checkout" class="text-end">
		
		<a href="${root}/checkout/clear" class="btn btn-outline-danger">
			<i class="bi-trash"></i> Clear Cart
		</a>

		<button type="submit" class="btn btn-outline-primary">
			<i class="bi-check"></i> Check Out
		</button>
	
	</form>
</app:layout>