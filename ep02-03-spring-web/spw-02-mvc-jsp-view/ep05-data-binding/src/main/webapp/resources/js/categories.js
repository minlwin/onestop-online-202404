document.addEventListener('DOMContentLoaded', () => {
	const uploadFile = document.getElementById('uploadFile');
	const uploadBtn = document.getElementById('uploadBtn');
	const uploadForm = document.getElementById('uploadForm');
	
	if(uploadBtn && uploadFile && uploadForm) {
		uploadBtn.addEventListener('click', () => uploadFile.click())
		uploadFile.addEventListener('change', () => uploadForm.submit())
	}
})
