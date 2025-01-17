<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<app:layout title="Products">

	<h3>Add New Product</h3>
	
	<div class="row">
		<div class="col-4">
			<div class="card">
				<div class="card-body">
					<form:form action="${root}/products/edit" method="post" modelAttribute="form">
						
						<form:hidden path="id"/>
						
						<div class="mb-3">
							<label class="form-label">Category</label>
							<form:select path="category" class="form-select">
								<option value="">Select One</option>
								<c:forEach var="item" items="${categories}">
									<option value="${item.id}" ${item.id eq form.category.id ? 'selected="selected"' : ''}>${item.name}</option>
								</c:forEach>
							</form:select>
							<form:errors path="category" />
						</div>
						
						<div class="mb-3">
							<label class="form-label">Name</label>
							<form:input path="name" type="text" class="form-control" />
							<form:errors path="name" />
						</div>

						<div class="mb-3">
							<label class="form-label">Price</label>
							<form:input path="price" class="form-control" />
							<form:errors path="price" />
						</div>
						
						<button type="submit" class="btn btn-primary">
							Save
						</button>
					</form:form >
				</div>
			</div>
		</div>
	</div>
	
</app:layout>