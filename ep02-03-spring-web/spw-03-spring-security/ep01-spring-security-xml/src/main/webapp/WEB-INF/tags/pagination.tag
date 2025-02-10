<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="d-flex justify-content-between">
	
	<div class="d-flex">
		<!-- Page Select -->
		<select id="pageSelect" class="form-select">
			<option value="10">10</option>
			<option value="25">25</option>
			<option value="50">50</option>
		</select>
	
		<!-- Page Links -->
		<div>
			<!-- First -->
			<button class="btn btn-outline-primary">
				<i class="bi-arrow-left"></i>
			</button>
			
			<button class="btn btn-outline-primary">
				1
			</button>
			
			<button class="btn btn-outline-primary">
				2
			</button>
	
			<button class="btn btn-outline-primary">
				3
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
		<div class="input-group">
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