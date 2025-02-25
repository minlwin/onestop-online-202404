document.addEventListener('DOMContentLoaded', () => {
	
	const addNewBtn = document.getElementById('addNewBtn')
	
	const editDialog = new bootstrap.Modal('#editDialog')
	
	addNewBtn.addEventListener('click', () => {
		editDialog.show()
	})
})