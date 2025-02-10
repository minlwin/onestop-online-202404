<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="d-flex justify-content-between mt-3">
	
	<div class="row">
		<!-- Page Select -->
		<div class="col-auto">
			<select id="pageSelect" class="form-select">
				<option value="10">10</option>
				<option value="25">25</option>
				<option value="50">50</option>
			</select>
		</div>
	
		<!-- Page Links -->
		<div class="col page-links">
			<!-- First -->
			<button class="btn btn-outline-primary">
				<i class="bi-arrow-left"></i>
			</button>
			
			<button class="btn btn-outline-primary">
				9
			</button>
			
			<button class="btn btn-outline-primary">
				10
			</button>
	
			<button class="btn btn-outline-primary">
				11
			</button>
	
			<!-- Last -->
			<button class="btn btn-outline-primary">
				<i class="bi-arrow-right"></i>
			</button>
		</div>
	</div>

	
	<!-- Page Informations -->
	<div class="d-flex">
		<!-- Total Page -->
		<div class="input-group me-2">
			<span class="input-group-text">Total Pages</span>
			<span class="form-control">3</span>
		</div>
		
		<!-- Total Records -->
		<div class="input-group">
			<span class="input-group-text">Total Count</span>
			<span class="form-control">28</span>
		</div>
	</div>
</div>