function getTotal(index) {
	const unitPrice = document.getElementById(`items${index}.unitPrice`).value
	const quantity = document.getElementById(`items${index}.quantity`).value
	return unitPrice * quantity
}

document.addEventListener('DOMContentLoaded', () => {
	
	const editForm = document.getElementById('editForm')
	const addItemBtn = document.getElementById('addItemBtn')
	
	const initialize = () => {
		const entryItemsContainer = document.getElementById('entryItemsContainer')
		
		const childList = Array.from(entryItemsContainer.children)
		
		let allTotal = 0
		
		for(let i = 0; i < childList.length; i ++) {
			const total = getTotal(i)
			
			// set row total
			document.getElementById(`row${i}Total`).innerText = total
			allTotal += total
		}
		
		// set all total
		document.getElementById('allTotal').innerText = allTotal
	}
	
	addItemBtn.addEventListener('click', () => {
		editForm.action = addItemBtn.dataset['addUrl']
		editForm.submit()
	})
	
	Array.from(document.getElementsByClassName('deleteBtn')).forEach(btn => {
		btn.addEventListener('click', () => {
			editForm.action = btn.dataset['deleteUrl']
			document.getElementById(btn.dataset['deleteInputId']).value = 'true'
			editForm.submit()
		})
	})
	
	Array.from(document.getElementsByClassName('changesInput')).forEach(input => {
		input.addEventListener('change', () => {
			initialize()
		})
	})
	
	initialize()
})

