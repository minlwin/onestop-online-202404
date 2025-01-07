<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<app:layout>
	<h3>Validation Demo</h3>
	
	<c:if test="${message ne null}">
		<div class="alert alert-info">
			${message}
		</div>
	</c:if>
	
	<div class="row">
		
		<div class="col-3">
			<!-- Person Edit Form -->
			<form:form action="${root}/validation" modelAttribute="personForm" method="post">
				
				<form:hidden path="id"/>
				
				<app:form-group cssClass="mb-3" label="Name">
					<form:input path="name" placeholder="Enter Name" cssClass="form-control"/>
					<form:errors path="name" />
				</app:form-group>
				
				<app:form-group cssClass="mb-3" label="Gender">
					<form:select path="gender" cssClass="form-select">
						<option value="">Select Gender</option>
						<c:forEach items="${genders}" var="item">
							<option value="${item}" ${param.gender eq item ? 'selected="selected"' : (personForm.gender eq item ? 'selected="selected"' : '')}>${item}</option>
						</c:forEach>
					</form:select>
					<form:errors path="gender" />
				</app:form-group>

				<app:form-group cssClass="mb-3" label="Date of Birth">
					<form:input path="dob" type="date" cssClass="form-control"/>
					<form:errors path="dob" />
				</app:form-group>

				<app:form-group cssClass="mb-3" label="Phone">
					<form:input path="phone" type="tel" placeholder="Enter Phone Number" cssClass="form-control"/>
					<form:errors path="phone" />
				</app:form-group>
				
				<button type="submit" class="btn btn-outline-primary">
					Save Person
				</button>
			</form:form>
		</div>
		
		<div class="col">
			<!-- Person List -->
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Dob</th>
						<th>Gender</th>
						<th>Phone</th>
						<th></th>
					</tr>
				</thead>
				
				<tbody>
				<c:forEach var="item" items="${persons}">
					<tr>
						<td>${item.id()}</td>
						<td>${item.name()}</td>
						<td>${item.dob()}</td>
						<td>${item.gender()}</td>
						<td>${item.phone()}</td>
						<td class="text-center">
							<a href="${root}/validation/${item.id()}" class="icon-link">
								<i class="bi-pencil"></i>
							</a>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>	
	</div>
	
</app:layout>