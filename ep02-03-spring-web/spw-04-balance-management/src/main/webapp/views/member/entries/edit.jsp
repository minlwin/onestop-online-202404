<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>   
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>   

<app:layout-member title="${type.name().toUpperCase()}">
	
	<div class="d-flex justify-content-between align-items-start">
		<app:page-title title="${form.id eq null ? 'Add New' : 'Edit'} Incomes" />
	</div>
	
	
	<sf:form id="editForm" action="${root}/member/entry/${urlType}/save" method="post" modelAttribute="form" class="row">
		
		<sf:hidden path="id"/>
		
		<!-- Summary -->
		<div class="col-4">
		
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">
						<i class="bi-flag"></i> Ledger Entry
					</h5>

					<!-- Ledger -->
					<app:form-group label="Ledger" cssClass="mb-3">
						<sf:select path="ledgerId" class="form-select">
							<option value="">Select Ledger</option>
							<c:forEach var="item" items="${ledgers}">
								<option value="${item.id()}" ${item.id() eq form.ledgerId ? 'selected' : ''}>${item.name()}</option>
							</c:forEach>
						</sf:select>
						<sf:errors path="ledgerId" cssClass="text-sm text-secondary" />
						${form.ledgerId}
					</app:form-group>
					
					<!-- Particular -->
					<app:form-group label="Particular" cssClass="mb-3">
						<sf:textarea path="particular" cols="40" rows="3" class="form-control" placeholder="Please enter prticular."></sf:textarea>
						<sf:errors path="particular" cssClass="text-sm text-secondary" />
					</app:form-group>
					
					<!-- Total -->
					<app:form-group label="Total Amount">
						<span id="allTotal" class="form-control">10,000</span>
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
					
					<div id="entryItemsContainer">
						<c:forEach var="item" varStatus="sts" items="${form.items}">
						
						<div class="row mt-2">
							<sf:hidden path="items[${sts.index}].deleted"/>
							<div class="col">
								<div class="input-group">
									<button data-delete-input-id="items${sts.index}.deleted" 
										data-delete-url="${root}/member/entry/${urlType}/item/remove" type="button" class="deleteBtn btn btn-outline-danger input-group-text">
										<i class="bi-trash"></i>
									</button>							
									<sf:input path="items[${sts.index}].itemName" type="text" class="form-control" placeholder="Enter Item Name" />
								</div>
							</div>
							
							<div class="col-2">
								<sf:input path="items[${sts.index}].unitPrice" type="number" class="form-control changesInput" />
							</div>
							
							<div class="col-2">
								<sf:input path="items[${sts.index}].quantity" type="number" class="form-control changesInput" />
							</div>
							<div class="col-2 text-end">
								<span id="row${sts.index}Total" class="form-control">0</span>
							</div>
						</div>
						</c:forEach>
					</div>
					
					<div class="mt-3">
						<button id="addItemBtn" data-add-url="${root}/member/entry/${urlType}/item/add" type="button" class="btn btn-outline-primary">
							<i class="bi-plus"></i> Add Item
						</button>
						
						<button type="submit" class="btn btn-outline-danger">
							<i class="bi-save"></i> Save Entry
						</button>
					</div>
				</div>
			</div>
		</div>
	</sf:form>
	
	<script src="${root}/resources/js/ledger-entry-edit.js"></script>
	
</app:layout-member>