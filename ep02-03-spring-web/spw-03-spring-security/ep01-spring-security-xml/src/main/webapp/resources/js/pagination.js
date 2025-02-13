document.addEventListener('DOMContentLoaded', () => {
	
	const searchForm = document.getElementById('searchForm')
	const pageInput = document.getElementById('pageInput')
	const sizeInput = document.getElementById('sizeInput')
	
	if(searchForm && pageInput && sizeInput) {
		
		const searchBtn = document.getElementById('searchBtn')
		searchBtn.addEventListener('click', () => {
			pageInput.value = '0'
			searchForm.submit()
		})

		const pageSelect = document.getElementById('pageSelect')
		pageSelect.addEventListener('change', (event) => {
			sizeInput.value = event.target.value
			pageInput.value = '0'
			searchForm.submit()
		})
				
		const links = document.getElementsByClassName('pageLink')
		Array.from(links).forEach(link => {
			link.addEventListener('click', () => {
				pageInput.value = link.dataset['page']
				searchForm.submit()
			})
		})
		
	}
	
})