<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<app:layout-management title="MEMBERS">
	
	<div class="d-flex justify-content-between align-items-start">
		<app:page-title title="Member Management" />
		<button class="btn btn-danger">
			<i class="bi-x"></i> De-Activate
		</button>
	</div>
	
	<div class="row">
		<div class="col-3">
			<!-- Profile Information -->
			<img class="img-fluid img-thumbnail profile-image" src="${root}/resources/photos/profile.jpg" alt="Profile Image" />
		</div>
		
		<div class="col">
		
			<div class="row">
				<div class="col">
					<app:information-card label="Registered At" 
						icon="bi-person-plus" 
						bgColor="text-bg-info" 
						value="2025-01-01 10:00" />
					
				</div>
				<div class="col">
					<app:information-card label="Last Access" 
						icon="bi-calendar-check" 
						bgColor="text-bg-secondary" 
						value="2025-01-01 10:00" />

				</div>
				<div class="col">
					<app:information-card label="Status" 
						icon="bi-shield" 
						bgColor="text-bg-primary" 
						value="Active" />
				</div>
			</div>
			
			<div class="row mt-4">
				<div class="col">
					<app:personal-info />
				</div>
				
				<div class="col">
					<app:contact-info />
				</div>
			</div>			
		</div>
				
	</div>
	
	
</app:layout-management>