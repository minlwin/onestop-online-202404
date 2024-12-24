<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<app:layout title="Check Out">
	
	<app:header icon="bi-cart" value="Check Out"></app:header>
	
	<div class="row">
		
		<div class="col">
			<!-- Cart Information -->
			<c:forEach items="${cart.items}" var="item">
				<div class="row">
					<!-- Image -->
					<div class="col-3">
						<img src="${root}/static/images/${item.image}" class="img-fluid cover-image" />
					</div>
					<div class="col">
						<div>
							<div>Product Name</div>
							<h4>${item.productName}</h4>
							<h5>${item.category}</h5>
						</div>
					</div>
					<div class="col">
						<div class="text-end">Price & Quantity</div>
						<h4 class="text-end"><fmt:formatNumber value="${item.salePrice}" /> MMK </h4>
						<div class="d-flex justify-content-end">
							<h5>
								<c:url var="removeOne" value="/checkout/remove">
									<c:param name="productId" value="${item.productId}" />
								</c:url>
								<a href="${removeOne}" class="icon-link">
									<i class="bi-dash"></i>
								</a>
							</h5>
							<h5 class="px-2">${item.quantity}</h5>
							<h5>
								<c:url var="addOne" value="/checkout/add">
									<c:param name="productId" value="${item.productId}" />
								</c:url>
								<a href="${addOne}" class="icon-link">
									<i class="bi-plus"></i>
								</a>
							</h5>
						</div>
					</div>
					<div class="col">
						<div>
							<div class="text-end">Total</div>
							<h4 class="text-end"><fmt:formatNumber value="${item.total}" /> MMK </h4>
						</div>
					</div>
				</div>
			</c:forEach>
			<div class="row">
				<div class="col text-end">
					All Total
					<h4 class="text-end"><fmt:formatNumber value="${cart.totalPrice}" /> MMK </h4>
				</div>
			</div>
		</div>
		
		<div class="col-3">
			<div class="card">
				<div class="card-body">
					<h4 class="cart-title">
						<i class="bi-person"></i> Customer Information
					</h4>
					
					<form action="${root}/checkout" method="post">
						<app:form-group cssClass="mb-3" label="Custmer Name">
							<input name="name" required="required" type="text" class="form-control" placeholder="Enter Customer Name" />
						</app:form-group>
						<app:form-group cssClass="mb-3" label="Phone Number">
							<input name="phone" required="required" type="tel" class="form-control" placeholder="Enter Phone Number" />
						</app:form-group>
						<app:form-group cssClass="mb-3" label="Email Address">
							<input name="email" required="required" type="email" class="form-control" placeholder="Enter Email Address" />
						</app:form-group>
						
						<button class="btn btn-outline-primary d-block w-100">
							<i class="bi-cart"></i> Check Out
						</button>
					</form>
				</div>
			</div>
		</div>
		
	</div>
	

</app:layout>