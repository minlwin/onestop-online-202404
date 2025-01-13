<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout title="Products">

	<h3>Add New Product</h3>
	
	<div class="row">
		<div class="col-4">
			<div class="card">
				<div class="card-body">
					<form action="${root}/products/edit" method="post">
						
						<div class="mb-3">
							<label class="form-label">Category</label>
							<select name="category" class="form-select" required="required">
								<option value="">Select One</option>
								<c:forEach var="item" items="${categories}">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="mb-3">
							<label class="form-label">Name</label>
							<input name="name" type="text" class="form-control" />
						</div>

						<div class="mb-3">
							<label class="form-label">Price</label>
							<input name="price" type="number" class="form-control" />
						</div>
						
						<button type="submit" class="btn btn-primary">
							Save
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	
</app:layout>