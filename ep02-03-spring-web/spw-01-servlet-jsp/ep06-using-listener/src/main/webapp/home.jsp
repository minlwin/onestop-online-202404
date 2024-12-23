<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<app:layout title="Home">
	
	<app:header icon="bi-house" value="The Shops"></app:header>
	
	<div class="row mt-4">
		<!-- Category -->
		<div class="col-3">
			<div class="list-group">
			<c:forEach var="item" items="${categories}">
				<c:url value="/home" var="home">
					<c:param name="categoryId" value="${item.id}"></c:param>
				</c:url>
				<a href="${home}" class="list-group-item ${categoryId eq item.id ? 'active' : ''}">${item.name}</a>
			</c:forEach>
			</div>
		</div>		
		
		<!-- Products -->
		<div class="col">
			<div class="row row-cols-3">
			
				<c:forEach items="${products}" var="item">
					<div class="col">
						<div class="card">
							<img class="img-fluid w-100 card-image" src="${pageContext.request.contextPath}/static/images/${item.defaultImage}" alt="" />
							
							<div class="card-body d-flex justify-content-between align-items-start">
								<div>
									<h6>${item.name}</h6>
									<span>
										<fmt:formatNumber value="${item.price}" /> MMK
									</span>
								</div>
								
								<c:url value="/cart" var="cart">
									<c:param name="productId" value="${item.id}" />
									<c:param name="categoryId" value="${categoryId}"></c:param>
								</c:url>
								<a href="${cart}" class="icon-link">
									<i class="bi-cart"></i>
								</a>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
	
</app:layout>