document.addEventListener('DOMContentLoaded', () => {
	
	const regionSelect = document.getElementById('region')
	const districtSelect = document.getElementById('district')
	const townshipSelect = document.getElementById('township')
	
	
	const selectOneOption = () => {
		const option = document.createElement('option')
		option.innerText = "Select One"
		return option
	}
	
	if(regionSelect && districtSelect && townshipSelect) {
		
		const setDistrict = (result) => {

			Array.from(districtSelect.children).forEach(option => {
				districtSelect.removeChild(option)
			})				
			districtSelect.appendChild(selectOneOption())

			Array.from(townshipSelect.children).forEach(option => {
				townshipSelect.removeChild(option)
			})				
			townshipSelect.appendChild(selectOneOption())

			if(result) {
				Array.from(result).map(item => {
					const option = document.createElement('option')
					option.value = item.id
					option.innerText = item.name
					return option
				}).forEach(option => districtSelect.appendChild(option))
			}
		}
		
		regionSelect.addEventListener('change', () => {
			const regionId = regionSelect.value;
			
			if(regionId) {
				const fetchApi = `${regionSelect.dataset['fetchApi']}?regionId=${regionId}`
				fetch(fetchApi).then(async (response) => {
					const result = await response.json();
					setDistrict(result)
				})
			} else {
				setDistrict()
			}
		})
		
		const setTownship = (result) => {
			
			Array.from(townshipSelect.children).forEach(option => {
				townshipSelect.removeChild(option)
			})				

			townshipSelect.appendChild(selectOneOption())

			if(result) {
				Array.from(result).map(item => {
					const option = document.createElement('option')
					option.value = item.id
					option.innerText = item.name
					return option
				}).forEach(option => townshipSelect.appendChild(option))
			}					
		}
		
		districtSelect.addEventListener('change', () => {
			const townshipId = districtSelect.value;
			
			if(townshipId) {
				const fetchApi = `${districtSelect.dataset['fetchApi']}?districtId=${townshipId}`
				fetch(fetchApi).then(async (response) => {
					const result = await response.json();
					setTownship(result)
				})
			} else {
				setTownship()
			}
		})
	}
})