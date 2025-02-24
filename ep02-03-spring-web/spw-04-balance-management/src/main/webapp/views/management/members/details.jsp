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
					<div class="card text-bg-info">
						<div class="card-body">
							<h5><i class="bi-person-plus"></i> Registered At</h5>
							<h3 class="mt-4">2025-01-01 10:00</h3>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card text-bg-secondary">
						<div class="card-body">
							<h5><i class="bi-calendar-check"></i> Last Access</h5>
							<h3 class="mt-4">2025-01-01 10:00</h3>
						</div>
					</div>
				</div>
				<div class="col">
					<div class="card text-bg-primary">
						<div class="card-body">
							<h5><i class="bi-shield"></i> Status</h5>
							<h3 class="mt-4">Active</h3>
						</div>
					</div>
				</div>
			</div>
			
			<div class="row mt-4">
				<div class="col">
					<div class="card text-bg-light">
						<div class="card-body">
							<h5><i class="bi-person"></i> Personal Info</h5>
							
							<div class="mb-3">
								<span class="text-secondary">Name</span>
								<div>Thidar Aung</div>
							</div>

							<div class="mb-3">
								<span class="text-secondary">Date of Birth</span>
								<div>2000-01-21</div>
							</div>

							<div class="mb-3">
								<span class="text-secondary">Gender</span>
								<div>Female</div>
								<br />
							</div>
						</div>
					</div>
				</div>
				
				<div class="col">
					<div class="card text-bg-light">
						<div class="card-body">
							<h5><i class="bi-telephone"></i> Contact Info</h5>
							
							<div class="mb-3">
								<span class="text-secondary">Phone</span>
								<div>09-1111-2222</div>
							</div>
							
							<div class="mb-3">
								<span class="text-secondary">Email</span>
								<div>thidar@gmail.com</div>
							</div>

							<div class="mb-3">
								<span class="text-secondary">Address</span>
								<div>No.20 / 1F, Yadanar Myaing Street, Kamayut 1 Quarter, Kamayut, Yangon</div>
							</div>
						</div>
					</div>
				</div>
			</div>			
		</div>
				
	</div>
	
	
</app:layout-management>