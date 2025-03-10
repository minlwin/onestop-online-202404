<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>
    
<app:layout-management title="MEMBERS">
	
	<app:page-title title="Member Management" />
	
	<!-- Search Form -->
	<form class="row">
		<app:form-group label="Status" cssClass="col-auto">
			<select name="status" class="form-select">
				<option value="">Search All</option>
				<option value="true">Active</option>
				<option value="false">Denied</option>
			</select>
		</app:form-group>
		
		<app:form-group label="Registered From" cssClass="col-auto">
			<input name="dateFrom" type="date" class="form-control" />
		</app:form-group>

		<app:form-group label="Registered To" cssClass="col-auto">
			<input name="dateTo" type="date" class="form-control" />
		</app:form-group>
		
		<app:form-group label="Name" cssClass="col-auto">
			<input name="name" class="form-control" placeholder="Search Name" />
		</app:form-group>
		
		<div class="col btn-wrapper">
			<button class="btn btn-primary">
				<i class="bi-search"></i> Search
			</button>
		</div>
		
	</form>
	
	<!-- Result Table -->
	<table class="table table-bordered table-striped table-hover my-3">
		
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Registered At</th>
				<th>Last Login</th>
				<th>Status</th>
				<th>Change At</th>
				<th>Remark</th>
				<th></th>
			</tr>
		</thead>
		
		<tbody>
			<tr>
				<td>1</td>
				<td>Aung Aung</td>
				<td>2025-02-23 10:00</td>
				<td>2025-02-23 10:00</td>
				<td>Active</td>
				<td></td>
				<td></td>
				<td class="text-center">
					<a href="${root}/admin/member/1" class="icon-link">
						<i class="bi-arrow-right"></i>
					</a>
				</td>
			</tr>
		</tbody>
	
	</table>
	
	<!-- Pagination -->
	<app:pagination />
	
</app:layout-management>