document.addEventListener('DOMContentLoaded', () => {
	
	const addNewBtn = document.getElementById('addNewBtn')
	
	const editDialog = new bootstrap.Modal('#editDialog')
	
	addNewBtn.addEventListener('click', () => {
		document.getElementById('editFormTitle').innerText = 'Add New Category'

		document.getElementById('id').value = undefined
		document.getElementById('type').value = ''
		document.getElementById('name').value = ''
		document.getElementById('status').checked = false

		editDialog.show()
	})
	
	const statusCheck = document.getElementById('status')
	const statusLabel = document.getElementById('statusLabel')
	
	statusCheck.addEventListener('change', () => {
		if(statusCheck.checked) {
			statusLabel.innerText = 'Deleted'
		} else {
			statusLabel.innerText = 'Active'
		}
	})
	
	
	Array.from(document.getElementsByClassName('edit-link')).forEach(link => {
		link.addEventListener('click', (event) => {
			event.preventDefault()
			
			document.getElementById('editFormTitle').innerText = 'Edit Category'
			
			document.getElementById('id').value = link.dataset['editId']
			document.getElementById('type').value = link.dataset['editType']
			document.getElementById('name').value = link.dataset['editName']
			document.getElementById('status').checked = link.dataset['editStatus']
			document.getElementById('statusLabel').innerText = link.dataset['editStatus'] ? 'Deleted' : 'Active'
			editDialog.show()
		})
	})
})