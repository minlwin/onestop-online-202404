document.addEventListener('DOMContentLoaded', () => {
	
	const loadData = (url, setData) => {
		console.log(url)
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
		})
		.then(setData)
		.catch(error => {
			console.error('Error Fetching API', error)	
		})
	}
		
	am5.ready(() => {
		
		// Balance Chart
		let balanceRoot = am5.Root.new('blanceChart')

		balanceRoot.setThemes([
		  am5themes_Animated.new(balanceRoot)
		]);

		let chart = balanceRoot.container.children.push(am5xy.XYChart.new(balanceRoot, {
		  panX: false,
		  panY: false,
		  paddingLeft: 0,
		  wheelX: "panX",
		  wheelY: "zoomX",
		  layout: balanceRoot.verticalLayout
		}));
		
		// Add legend
		// https://www.amcharts.com/docs/v5/charts/xy-chart/legend-xy-series/
		let legend = chart.children.push(
		  am5.Legend.new(balanceRoot, {
		    centerX: am5.p50,
		    x: am5.p50
		  })
		);
		
		// Create axes
		// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
		let xRenderer = am5xy.AxisRendererX.new(balanceRoot, {
		  cellStartLocation: 0.1,
		  cellEndLocation: 0.9,
		  minorGridEnabled: true
		})

		let xAxis = chart.xAxes.push(am5xy.CategoryAxis.new(balanceRoot, {
		  categoryField: "date",
		  renderer: xRenderer,
		  tooltip: am5.Tooltip.new(balanceRoot, {})
		}));

		xRenderer.grid.template.setAll({
		  location: 1
		})

		let yAxis = chart.yAxes.push(am5xy.ValueAxis.new(balanceRoot, {
		  renderer: am5xy.AxisRendererY.new(balanceRoot, {
		    strokeOpacity: 0.1
		  })
		}));	
		
		function loadBalanceChart(data) {
			
			chart.series.clear()
			legend.data.clear()
			
			xAxis.data.setAll(data)
			// Add series
			// https://www.amcharts.com/docs/v5/charts/xy-chart/series/
			function makeSeries(name, fieldName) {
			  var series = chart.series.push(am5xy.ColumnSeries.new(balanceRoot, {
			    name: name,
			    xAxis: xAxis,
			    yAxis: yAxis,
			    valueYField: fieldName,
			    categoryXField: "date"
			  }));

			  series.columns.template.setAll({
			    tooltipText: "{name}, {categoryX}:{valueY}",
			    width: am5.percent(90),
			    tooltipY: 0,
			    strokeOpacity: 0
			  });

			  series.bullets.push(function () {
			    return am5.Bullet.new(balanceRoot, {
			      locationY: 0,
			      sprite: am5.Label.new(balanceRoot, {
			        text: "{valueY}",
			        fill: balanceRoot.interfaceColors.get("alternativeText"),
			        centerY: 0,
			        centerX: am5.p50,
			        populateText: true
			      })
			    });
			  });

			  legend.data.push(series);
			  series.data.setAll(data);
			}

			makeSeries("Incomes", "incomes");
			makeSeries("Expenses", "expenses");

			chart.appear(1000, 100);		
		}
		
		// Income Chart
		// Create root element
		// https://www.amcharts.com/docs/v5/getting-started/#Root_element
		let incomeRoot = am5.Root.new('incomesChart');

		// Set themes
		// https://www.amcharts.com/docs/v5/concepts/themes/
		incomeRoot.setThemes([
		  am5themes_Animated.new(incomeRoot)
		]);

		// Create chart
		// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
		let incomeChart = incomeRoot.container.children.push(
		  am5percent.PieChart.new(incomeRoot, {
		    endAngle: 270
		  })
		);

		// Create series
		// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
		let incomeSeries = incomeChart.series.push(
		  am5percent.PieSeries.new(incomeRoot, {
		    valueField: "value",
		    categoryField: "ledger",
		    endAngle: 270
		  })
		);

		incomeSeries.labels.template.set("forceHidden", true)
		incomeSeries.ticks.template.set("forceHidden", true)

		incomeSeries.states.create("hidden", {
		  endAngle: -90
		});		
		
		
		// Expense Chart
		// Create root element
		// https://www.amcharts.com/docs/v5/getting-started/#Root_element
		var expenseRoot = am5.Root.new('expensesChart');

		// Set themes
		// https://www.amcharts.com/docs/v5/concepts/themes/
		expenseRoot.setThemes([
		  am5themes_Animated.new(expenseRoot)
		]);

		// Create chart
		// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/
		var expenseChart = expenseRoot.container.children.push(
		  am5percent.PieChart.new(expenseRoot, {
		    endAngle: 270
		  })
		);

		// Create series
		// https://www.amcharts.com/docs/v5/charts/percent-charts/pie-chart/#Series
		var expenseSeries = expenseChart.series.push(
		  am5percent.PieSeries.new(expenseRoot, {
		    valueField: "value",
		    categoryField: "ledger",
		    endAngle: 270
		  })
		);

		expenseSeries.labels.template.set("forceHidden", true)
		expenseSeries.ticks.template.set("forceHidden", true)

		expenseSeries.states.create("hidden", {
		  endAngle: -90
		});	
		
		function loadLedgerCharts(data) {
			incomeSeries.data.setAll(data['Incomes'])		
			expenseSeries.data.setAll(data['Expenses'])		
		}	
		
		const loadSummary = (url) => loadData(url, (data) => {
			document.getElementById('incomes').innerText = data.incomes.toLocaleString()
			document.getElementById('expenses').innerText = data.expenses.toLocaleString()
			document.getElementById('balances').innerText = data.balances.toLocaleString()
		})

		const loadBalance = (url) => loadData(url, data => {
			loadBalanceChart(data)
		})
		
		const loadLedger = (url) => loadData(url, data => {
			loadLedgerCharts(data)
		}) 		
		
		const monthlyInput = document.getElementById('monthly')
		const yearlyInput = document.getElementById('yearly')
		
		monthlyInput.addEventListener('click', () => {
			loadSummary(monthlyInput.dataset['summaryUrl'])
			loadBalance(monthlyInput.dataset['balanceUrl'])
			loadLedger(monthlyInput.dataset['ledgerUrl'])
		})
		
		yearlyInput.addEventListener('click', () => {
			loadSummary(yearlyInput.dataset['summaryUrl'])
			loadBalance(yearlyInput.dataset['balanceUrl'])
			loadLedger(yearlyInput.dataset['ledgerUrl'])
		})
		
		loadSummary(monthlyInput.dataset['summaryUrl'])
		loadBalance(monthlyInput.dataset['balanceUrl'])
		loadLedger(monthlyInput.dataset['ledgerUrl'])
	})
})
