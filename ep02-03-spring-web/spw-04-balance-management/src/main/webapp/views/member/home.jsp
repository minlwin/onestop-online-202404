<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<app:layout-member title="HOME">
	
	<div class="d-flex justify-content-between align-items-start">
		<app:page-title title="Member Home" />
		
		<div class="btn-group">
			<input type="radio" name="display" class="btn-check" checked id="monthly" />
			<label for="monthly" class="btn btn-outline-primary">Monthly</label>
			
			<input type="radio" name="display" class="btn-check" id="yearly" />
			<label for="yearly" class="btn btn-outline-primary">Yearly</label>
		</div>
	</div>
	
	<div class="row">
		<div class="col-3">
			<!-- Profile -->
			<div class="card">
				<div class="card-body">
					<div class="d-flex justify-content-between align-items-start">
						<h5 class="card-title">
							<i class="bi-person"></i> Profile
						</h5>
						<a href="#" class="btn-link">
							<i class="bi-pencil"></i>
						</a>					
					</div>
				</div>
				
				<img src="${root}/resources/photos/profile.jpg" class="profile-image" alt="Profile Image" />
			
				<div class="card-body">
					<div class="list-group list-group-flush">
						<div class="list-group-item">
							<i class="bi-person"></i> Thidar Aung
						</div>
						<div class="list-group-item">
							<i class="bi-telephone"></i> 09-1234-1234
						</div>
						<div class="list-group-item">
							<i class="bi-envelope"></i> thidar@gmail.com
						</div>
						
					</div>
				</div>
			</div>
			
			<!-- Access History -->
		</div>
		
		<div class="col">
			<!-- Summary -->
			<div class="row">
				<div class="col">
					<app:summary-info title="Expenses" value="100,000" icon="bi-cart" color="text-bg-danger" />
				</div>
				<div class="col">
					<app:summary-info title="Incomes" value="500,000" icon="bi-flag" color="text-bg-warning" />
				</div>
				<div class="col">
					<app:summary-info title="Balances" value="400,000" icon="bi-bar-chart" color="text-bg-primary" />
				</div>
			</div>
			
			<!-- Charts -->
			<div class="row mt-4">
				<div class="col-8">
					<!-- Bar Chart -->
				</div>
				
				<div class="col">
					<!-- Pie Charts -->
				</div>
			</div>
		</div>
	</div>
	
</app:layout-member>