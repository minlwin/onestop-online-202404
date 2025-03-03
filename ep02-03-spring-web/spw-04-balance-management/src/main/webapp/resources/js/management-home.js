document.addEventListener('DOMContentLoaded', () => {
	
	am5.ready(() => {
		let date = new Date();
		date.setHours(0, 0, 0, 0);
		let value = 100;

		function generateData() {
		  value = Math.round((Math.random() * 10 - 5) + value);
		  am5.time.add(date, "day", 1);
		  return {
		    date: date.getTime(),
		    value: value
		  };
		}

		function generateDatas(count) {
		  var data = [];
		  for (var i = 0; i < count; ++i) {
		    data.push(generateData());
		  }
		  return data;
		}

		loadChart(generateDatas(1200))
	})
})


function loadChart(data) {
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


	// Generate random data


	// Create axes
	// https://www.amcharts.com/docs/v5/charts/xy-chart/axes/
	var xAxis = chart.xAxes.push(am5xy.DateAxis.new(root, {
	  maxDeviation: 0.2,
	  baseInterval: {
	    timeUnit: "day",
	    count: 1
	  },
	  renderer: am5xy.AxisRendererX.new(root, {
	    minorGridEnabled:true
	  }),
	  tooltip: am5.Tooltip.new(root, {})
	}));

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
	  tooltip: am5.Tooltip.new(root, {
	    labelText: "{valueY}"
	  })
	}));


	// Set data
	series.data.setAll(data);


	// Make stuff animate on load
	// https://www.amcharts.com/docs/v5/concepts/animations/
	series.appear(1000);
	chart.appear(1000, 100);		
}
