document.addEventListener('DOMContentLoaded', () => {
	const uploadBtn = document.getElementById('uploadBtn')
	const uploadForm = document.getElementById('uploadForm')
	const uploadFiles = document.getElementById('uploadFiles')
	
	if(uploadBtn && uploadFiles && uploadForm) {
		uploadBtn.addEventListener('click', () => uploadFiles.click())
		uploadFiles.addEventListener('change', () => uploadForm.submit())
	}
})