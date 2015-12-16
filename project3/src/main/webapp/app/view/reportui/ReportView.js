Ext.define('Project3.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Project3.view.reportui.querycriteria.QueryCriteriaView',
			'Project3.view.reportui.datachart.DataChartViewTab',
			'Project3.view.reportui.datachart.DataChartViewPanel',
			'Project3.view.reportui.ReportViewController' ,
			'Project3.view.fw.MainDataPointPanel',
			'Project3.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
