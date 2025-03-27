<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
<app:layout-management title="MEMBERS">
	
	<div class="d-flex justify-content-between align-items-start">
		<app:page-title title="Member Management" />
		<button id="statusChangeBtn" class="btn btn-danger">
			<i class="${result.status() eq 'Active' ? 'bi-x' : 'bi-check'}"></i> ${result.status() eq 'Active' ? 'Denined' : 'Activate'}
		</button>
	</div>
	
	<div class="row">
		<div class="col-3">
			<!-- Profile Information -->
			<img class="img-fluid img-thumbnail profile-image" src="${root}/resources/photos/${result.profileImage()}" alt="Profile Image" />
		</div>
		
		<div class="col">
		
			<div class="row">
				<div class="col">
					<app:information-card label="Registered At" 
						icon="bi-person-plus" 
						bgColor="text-bg-info" 
						value="${dtf.formatDateTime(result.registeredAt())}" />
					
				</div>
				<div class="col">
					<app:information-card label="Last Access" 
						icon="bi-calendar-check" 
						bgColor="text-bg-secondary" 
						value="${dtf.formatDateTime(result.lastAccessAt())}" />

				</div>
				<div class="col">
					<app:information-card label="Status" 
						icon="bi-shield" 
						bgColor="text-bg-primary" 
						value="${result.status()}" />
				</div>
			</div>
			
			<div class="row mt-4 d-flex align-items-stretch">
				<div class="col">
					<app:personal-info 
						name="${result.name()}" 
						dob="${result.dateOfBirth()}" 
						gender="${result.gender()}"/>
				</div>
				
				<div class="col">
					<app:contact-info 
						phone="${result.phone()}"
						email="${result.email()}"
						address="${result.displayAddress}" />
				</div>
			</div>			
		</div>
				
	</div>
	
	<div id="statusChangeDialog" class="modal">
		<div class="modal-dialog">
			<form action="${root}/admin/member/${result.id()}/update" method="post" class="modal-content">
				<sec:csrfInput/>
				<input type="hidden" name="status" value="${result.status() ne 'Active'}" />
				
				<div class="modal-header">
					<h5 class="modal-title">${result.status() eq 'Active' ? 'Denied' : 'Activate'} Access</h5>
				</div>
				
				<div class="modal-body">
					<app:form-group label="Reason">
						<textarea name="reason" class="form-control" required="required"></textarea>
					</app:form-group>
				</div>
				
				<div class="modal-footer">
					<button class="btn btn-outline-primary">
						<i class="bi-save"></i> Change Status
					</button>
				</div>
				
			</form>
		</div>
	</div>
	
	<script src="${root}/resources/js/member-details.js"></script>
	
</app:layout-management>