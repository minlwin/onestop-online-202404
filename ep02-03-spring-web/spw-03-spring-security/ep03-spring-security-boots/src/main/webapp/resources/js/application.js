document.addEventListener('DOMContentLoaded', () => {
	const logoutMenu = document.getElementById('logoutMenu')
	const logoutForm = document.getElementById('logoutForm')
	
	if(logoutForm && logoutMenu) {
		logoutMenu.addEventListener('click', (e) => {
			e.preventDefault()
			logoutForm.submit()
		})
	}
})