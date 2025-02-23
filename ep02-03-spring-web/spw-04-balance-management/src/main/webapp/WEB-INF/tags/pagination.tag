<%@ tag language="java" pageEncoding="UTF-8"%>

<div class="d-flex justify-content-between">

	<div class="d-flex">
		<!-- Page Select -->
		<div class="input-group me-2">
			<span class="input-group-text">Size</span>
			<select class="form-select">
				<option value="10">10</option>
				<option value="25">25</option>
				<option value="50">50</option>
			</select>
		</div>
		
		<!-- Page Links -->
		<div class="d-flex page-links">
			<a href="#" class="btn btn-outline-primary me-1">
				<i class="bi-arrow-left"></i>
			</a>

			<a href="#" class="btn btn-outline-primary me-1">
				1
			</a>
			<a href="#" class="btn btn-primary me-1">
				20
			</a>
			<a href="#" class="btn btn-outline-primary me-1">
				3
			</a>

			<a href="#" class="btn btn-outline-primary">
				<i class="bi-arrow-right"></i>
			</a>
		</div>
	</div>
	
	<!-- Page Result Info -->
	<div class="d-flex">
		<div class="input-group me-2">
			<span class="input-group-text">Total Pages</span>
			<span class="form-control">10</span>
		</div>
		
		<div class="input-group">
			<span class="input-group-text">Total Result</span>
			<span class="form-control">96</span>
		</div>
	</div>
</div>
