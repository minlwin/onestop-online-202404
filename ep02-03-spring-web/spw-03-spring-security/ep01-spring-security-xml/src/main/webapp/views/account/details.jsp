<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<app:layout>
	<h3><i class="bi-ui-checks"></i> Account Details</h3>
	
	<div class="row mt-3">
		<div class="col-3">
			<!-- Profile Image -->
			<div>
				<img class="profile-image img-thumbnail img-fluid" src="${root}/resources/images/default-profile.png" alt="Profile Image" />
			</div>
			
			<form action="${root}/admin/account/${result.id()}/status" method="post" class="card mt-3">
				<sec:csrfInput/>
				<div class="card-header">
					Account Status
				</div>
				<div class="card-body">
					<h5 class="text-center">${result.disabled() ? 'Disabled' : 'Active'}</h5>
					
					<button type="submit" class="btn ${result.disabled() ? 'btn-primary' : 'btn-danger'} d-block w-100 mt-3">
						${result.disabled() ? 'Adtivate' : 'De-Activate'}
					</button>
				</div>
			</form>
		</div>
		
		<div class="col">
			<!-- Personal Information -->
			<div class="list-group">
				<div class="list-group-item">
					<div class="text-secondary">Name</div>
					<h5>${result.name()}</h5>
				</div>
				<div class="list-group-item">
					<div class="text-secondary">Email</div>
					<h5>${result.email()}</h5>
				</div>
				<div class="list-group-item">
					<div class="text-secondary">Created At</div>
					<h5>${dateTimes.format(result.createdAt())}</h5>
				</div>
				<div class="list-group-item">
					<div class="text-secondary">Created By</div>
					<h5>${result.createdBy()}</h5>
				</div>
				<div class="list-group-item">
					<div class="text-secondary">Modified At</div>
					<h5>${dateTimes.format(result.modifiedAt())}</h5>
				</div>
				<div class="list-group-item">
					<div class="text-secondary">Modified By</div>
					<h5>${result.modifiedBy()}</h5>
				</div>
			
			</div>
		</div>
	</div>
</app:layout>