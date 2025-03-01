<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>   

<app:layout-member title="${type.name().toUpperCase()}">
	
	<div class="d-flex justify-content-between align-items-start">
		<app:page-title title="Edit Incomes" />
		
	</div>
	
	
	<form action="${root}/member/entry/save" method="post" class="row">
		<!-- Summary -->
		<div class="col-4">
		
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">
						<i class="bi-flag"></i> Ledger Entry
					</h5>

					<!-- Ledger -->
					<app:form-group label="Ledger" cssClass="mb-3">
						<select class="form-select">
							<option value="">Select Ledger</option>
						</select>
					</app:form-group>
					
					<!-- Particular -->
					<app:form-group label="Particular" cssClass="mb-3">
						<textarea cols="40" rows="3" class="form-control" placeholder="Please enter prticular."></textarea>
					</app:form-group>
					
					<!-- Total -->
					<app:form-group label="Total Amount">
						<span class="form-control">10,000</span>
					</app:form-group>
				
				</div>
			</div>
		
		</div>
		
		<!-- Entry Items -->
		<div class="col">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">
						<i class="bi-list"></i> Entry Items
					</h5>
					
					<div class="row">
						<div class="col">Item Name</div>
						<div class="col-2">Unit Price</div>
						<div class="col-2">Quantity</div>
						<div class="col-2 text-end">Total</div>
					</div>
					
					<div>
						<div class="row mt-2">
							<div class="col">
								<div class="input-group">
									<button type="button" class="btn btn-outline-danger input-group-text">
										<i class="bi-trash"></i>
									</button>							
									<input type="text" class="form-control" placeholder="Enter Item Name" />
								</div>
							</div>
							
							<div class="col-2">
								<input type="number" class="form-control" />
							</div>
							
							<div class="col-2">
								<input type="number" class="form-control" />
							</div>
							<div class="col-2 text-end">
								<span class="form-control">0</span>
							</div>
						</div>
					</div>
					
					<div class="mt-3">
						<button type="button" class="btn btn-outline-primary">
							<i class="bi-plus"></i> Add Item
						</button>
						
						<button class="btn btn-outline-danger">
							<i class="bi-save"></i> Save Entry
						</button>
					</div>
				</div>
			</div>
		</div>
	</form>
	
</app:layout-member>