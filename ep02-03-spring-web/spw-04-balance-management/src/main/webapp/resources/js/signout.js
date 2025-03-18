document.addEventListener('DOMContentLoaded', () => {
	const signOutForm = document.getElementById('signOutForm')
	const signOutMenu = document.getElementById('signOutMenu')
	
	signOutMenu.addEventListener('click', (event) => {
		event.preventDefault()
		signOutForm.submit()
	})
})