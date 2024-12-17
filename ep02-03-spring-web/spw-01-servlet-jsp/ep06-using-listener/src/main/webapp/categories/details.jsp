<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Category">
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/product-upload.js"></script>

	<app:header icon="bi-tag" value="${category.name}"></app:header>
	
	<!-- Category Information -->
	<div class="card">
		<div class="card-body">
		
			<div class="row">
				<!-- Status --> 
				<app:form-group cssClass="col-auto" label="Status">
					<span class="form-control pe-4">
						${category.status}
					</span>
				</app:form-group>
				<!-- Created At -->
				<app:form-group cssClass="col-auto" label="Created At">
					<span class="form-control pe-4">
						${dateTimes.format(category.createdAt)}
					</span>
				</app:form-group>
				<!-- Updated At -->
				<app:form-group cssClass="col-auto" label="Updated At">
					<span class="form-control pe-4">
						${dateTimes.format(category.updatedAt)}
					</span>
				</app:form-group>
				
				<div class="col btn-wrapper">
					<c:url var="edit" value="/categories/edit">
						<c:param name="id" value="${category.id}"></c:param>
					</c:url>
					<a href="${edit}" class="btn btn-outline-primary">
						<i class="bi-pencil"></i> Edit Category
					</a>
					
				</div>
			
			</div>		
		
		</div>
	</div>
	
	
	<!-- Products in Category -->
	<section class="mt-4">
		<div class="d-flex justify-content-between">
			<app:sub-header icon="bi-gift" value="Products in Category"></app:sub-header>
			
			<div>
			
				<c:url var="addProduct" value="/products/edit">
					<c:param name="categoryId" value="${category.id}"></c:param>
				</c:url>
				<a href="${addProduct}" class="btn btn-outline-danger">
					<i class="bi-plus"></i> Add Product
				</a>
				
				<button id="uploadBtn" class="btn btn-outline-danger">
					<i class="bi-upload"></i> Upload Product
				</button>
			</div>	
		</div>
		
		
		<c:choose>
		
			<c:when test="${not empty products}">
				<table class="table table-bordered mt-3">
					<thead>
						<tr>
							<th class="text-end">ID</th>
							<th>Name</th>
							<th class="text-end">Price</th>
							<th>Status</th>
							<th class="text-end">Sales</th>
							<th class="text-end">Remains</th>
							<th>Created At</th>
							<th>Updated At</th>
							<th></th>
						</tr>
					</thead>
					
					<tbody>
					<c:forEach var="item" items="${products}">
						<tr>
							<td class="text-end">1</td>
							<td>Product Name</td>
							<td class="text-end">25,000</td>
							<td>Available</td>
							<td class="text-end">5</td>
							<td class="text-end">20</td>
							<td>2024-10-12 10:00</td>
							<td>2024-10-12 10:00</td>
							<td class="text-center">
								<a href="" class="icon-link">
									<i class="bi-chevron-right"></i>
								</a>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:when>
			
			<c:otherwise>
				<div class="alert alert-info mt-3">
					There is no product in this category.
				</div>
			</c:otherwise>
		</c:choose>

	
	</section>
	
	<form id="uploadForm" action="${pageContext.request.contextPath}/products/upload" method="post" enctype="multipart/form-data" class="d-none" >
		<input type="hidden" name="categoryId" value="${category.id}" />
		<input id="uploadFile" type="file" name="file"  />
	</form>
	

</app:layout>