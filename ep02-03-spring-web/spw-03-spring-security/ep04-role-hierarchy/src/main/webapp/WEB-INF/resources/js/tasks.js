document.addEventListener('DOMContentLoaded', () => {
	const uploadForm = document.getElementById('uploadForm')
	const fileInput = document.getElementById('fileInput')
	const uploadBtn = document.getElementById('uploadBtn')
	
	if(uploadBtn && fileInput && uploadForm) {
		uploadBtn.addEventListener('click', () => fileInput.click())
		fileInput.addEventListener('change', () => uploadForm.submit())
	}
})