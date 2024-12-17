document.addEventListener('DOMContentLoaded', () => {
	
	const uploadBtn = document.getElementById('uploadBtn')
	const uploadForm = document.getElementById('uploadForm')
	const uploadFile = document.getElementById('uploadFile')
	
	if(uploadBtn && uploadForm && uploadFile) {
		uploadBtn.addEventListener('click', () => uploadFile.click())
		uploadFile.addEventListener('change', () => uploadForm.submit())
	}
})