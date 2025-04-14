document.addEventListener('DOMContentLoaded', () => {
	
	am5.ready(() => {
		
		// Initialize Chart
		// Create root element
		// https://www.amcharts.com/docs/v5/getting-started/#Root_element
		var root = am5.Root.new("adminChart");


		// Set themes
		// https://www.amcharts.com/docs/v5/concepts/themes/
		root.setThemes([
		  am5themes_Animated.new(root)
		]);


		// Create chart
		// https://www.amcharts.com/docs/v5/charts/xy-chart/
		var chart = root.container.children.push(am5xy.XYChart.new(root, {
		  panX: true,
		  panY: true,
		  wheelX: "panX",
		  wheelY: "zoomX",
		  pinchZoomX:true,
		  paddingLeft: 0
		}));

		// Add cursor
		// https://www.amcharts.com/docs/v5/charts/xy-chart/cursor/
		var cursor = chart.set("cursor", am5xy.XYCursor.new(root, {
		  behavior: "none"
		}));
		cursor.lineY.set("visible", false);


		// Create axes
		// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
		var xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(root, {
			categoryField: 'date',
			renderer: am5xy.AxisRendererX.new(root, {
				minorGridEnabled:true
			}),
			tooltip: am5.Tooltip.new(root, {})					
		}))

		var yAxis = chart.yAxes.push(am5xy.ValueAxis.new(root, {
		  renderer: am5xy.AxisRendererY.new(root, {
		    pan:"zoom"
		  })  
		}));


		// Add series
		// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
		var series = chart.series.push(am5xy.LineSeries.new(root, {
		  name: "Series",
		  xAxis: xAxis,
		  yAxis: yAxis,
		  valueYField: "value",
		  valueXField: "date",
		  categoryXField: "date",
		  tooltip: am5.Tooltip.new(root, {
		    labelText: "{valueY}"
		  })
		}));
		
		const loadChart = (data) => {
			// Set data
			xAxis.data.setAll(data)
			series.data.setAll(data)

			// Make stuff animate on load
			// https://www.amcharts.com/docs/v5/concepts/animations/
			series.appear(1000);
			chart.appear(1000, 100);		
		}		

		// Load Data
		const loadData = (url) => {
			fetch(url, {
				method: 'GET',
				headers : {
					'Content-Type' : 'application-json'
				}
			}).then(response => {
				if(!response.ok) {
					console.log(response.json())
					throw new Error(`API Error : ${response.status}`)
				}
				return response.json()	
			}).then(data => {
				loadChart(data)
			})
			.catch(error => {
				console.error('Error Fetching API', error)	
			})
		}
		
		const monthly = document.getElementById('monthly')
		const yearly = document.getElementById('yearly')
		
		monthly.addEventListener('click', () => loadData(monthly.dataset['restApi']))
		yearly.addEventListener('click', () => loadData(yearly.dataset['restApi']))
		
		const monthlyUrl = monthly.dataset['restApi']
		loadData(monthlyUrl)
		
	})
})
