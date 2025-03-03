document.addEventListener('DOMContentLoaded', () => {
	const profilePhotForm = document.getElementById('profilePhotForm')
	const profilePhotoInput = document.getElementById('profilePhotoInput')
	const profilePhotoBtn = document.getElementById('profilePhotoBtn')
	
	if(profilePhotoBtn && profilePhotoInput && profilePhotForm) {
		profilePhotoBtn.addEventListener('click', () => profilePhotoInput.click())
		profilePhotoInput.addEventListener('change', () => profilePhotForm.submit())
	}
})