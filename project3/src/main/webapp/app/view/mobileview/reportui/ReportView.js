Ext.define('Project3.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Project3.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Project3.view.mobileview.reportui.datachart.DataChartViewTab',
			'Project3.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Project3.view.mobileview.reportui.ReportViewController' ,
			'Project3.view.mobileview.fw.DataPointPanel',
			'Project3.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
