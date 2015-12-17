Ext.define('Mineproj.mineproj.web.mineproj.view.location.CityMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "CityMainController",
     "restURL": "/City",
     "defaults": {
          "split": true
     },
     "requires": ["Mineproj.mineproj.shared.mineproj.model.location.CityModel", "Mineproj.mineproj.web.mineproj.controller.location.CityMainController", "Mineproj.mineproj.shared.mineproj.model.location.CountryModel", "Mineproj.mineproj.shared.mineproj.model.location.StateModel", "Mineproj.mineproj.shared.mineproj.viewmodel.location.CityViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "City",
               "name": "CityTreeContainer",
               "itemId": "CityTreeContainer",
               "restURL": "/City",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "CityTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": []
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "CityViewModel",
                    "xtype": "form",
                    "displayName": "City",
                    "title": "City",
                    "name": "City",
                    "itemId": "City",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "cityId",
                         "itemId": "cityId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Id<font color='red'> *<\/font>",
                         "fieldId": "45A43CE9-3D6B-441E-854F-4AFCD7F71837",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "cityId",
                         "bind": "{cityId}"
                    }, {
                         "name": "countryId",
                         "itemId": "countryId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "Country",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Country<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "AE44C5F2-D7AE-4DC8-BA01-1D174FF553FF",
                         "restURL": "Country",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mineproj.mineproj.shared.mineproj.model.location.CountryModel"
                         },
                         "bindable": "countryId",
                         "bind": "{countryId}",
                         "columnWidth": 0.5,
                         "listeners": {
                              "change": "onCountryIdChange"
                         }
                    }, {
                         "name": "stateId",
                         "itemId": "stateId",
                         "xtype": "combo",
                         "customWidgetType": "vdCombo",
                         "displayName": "State",
                         "margin": "5 5 5 5",
                         "fieldLabel": "State<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "2C55643C-F5D4-4EAB-B3DD-AC164843EE0C",
                         "restURL": "State",
                         "displayField": "primaryDisplay",
                         "valueField": "primaryKey",
                         "typeAhead": true,
                         "queryMode": "local",
                         "minChars": 2,
                         "store": {
                              "data": [],
                              "model": "Mineproj.mineproj.shared.mineproj.model.location.StateModel"
                         },
                         "bindable": "stateId",
                         "bind": "{stateId}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityName",
                         "itemId": "cityName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "447F5B1C-4ECE-43FF-8E01-7510F3162B70",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "cityName",
                         "bind": "{cityName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityCodeChar2",
                         "itemId": "cityCodeChar2",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "City Code",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Code<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "F7166CBF-7F83-486D-A707-927D9DF8B2A7",
                         "minLength": "0",
                         "maxLength": "32",
                         "bindable": "cityCodeChar2",
                         "bind": "{cityCodeChar2}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityCode",
                         "itemId": "cityCode",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Code1",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Code1<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D8E5E77D-487C-4A97-BEEA-2299E0F2A81C",
                         "minValue": "0",
                         "maxValue": "3",
                         "bindable": "cityCode",
                         "bind": "{cityCode}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityDescription",
                         "itemId": "cityDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "City Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Description",
                         "fieldId": "30920A21-B934-451E-809A-5337C850358C",
                         "bindable": "cityDescription",
                         "bind": "{cityDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityFlag",
                         "itemId": "cityFlag",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Flag",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Flag",
                         "fieldId": "297DDCB2-7361-4014-BC1C-51948719520E",
                         "minLength": "0",
                         "maxLength": "128",
                         "bindable": "cityFlag",
                         "bind": "{cityFlag}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityLatitude",
                         "itemId": "cityLatitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Latitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Latitude",
                         "fieldId": "E918EA1C-83E6-4D9F-B6A5-4F2D516CA55A",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "cityLatitude",
                         "bind": "{cityLatitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "cityLongitude",
                         "itemId": "cityLongitude",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "City Longitude",
                         "margin": "5 5 5 5",
                         "fieldLabel": "City Longitude",
                         "fieldId": "6055B318-661D-4FB1-BF1C-993C5D9EF2A7",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "cityLongitude",
                         "bind": "{cityLongitude}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "0E384D2E-D137-4F2C-8FA7-EE85585CBF31",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 667,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 667,
                              "customId": 199
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 667,
                              "customId": 200,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 667,
                              "customId": 201,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "City",
                    "title": "Details Grid",
                    "name": "CityGrid",
                    "itemId": "CityGrid",
                    "restURL": "/City",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "City Id",
                         "dataIndex": "cityId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Country",
                         "dataIndex": "countryId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "State",
                         "dataIndex": "stateId",
                         "renderer": "renderFormValue",
                         "flex": 1
                    }, {
                         "header": "City Name",
                         "dataIndex": "cityName",
                         "flex": 1
                    }, {
                         "header": "City Code",
                         "dataIndex": "cityCodeChar2",
                         "flex": 1
                    }, {
                         "header": "City Code1",
                         "dataIndex": "cityCode",
                         "flex": 1
                    }, {
                         "header": "City Description",
                         "dataIndex": "cityDescription",
                         "flex": 1
                    }, {
                         "header": "Flag",
                         "dataIndex": "cityFlag",
                         "flex": 1
                    }, {
                         "header": "City Latitude",
                         "dataIndex": "cityLatitude",
                         "flex": 1
                    }, {
                         "header": "City Longitude",
                         "dataIndex": "cityLongitude",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "CityViewModel",
               "xtype": "form",
               "displayName": "City",
               "title": "City",
               "name": "City",
               "itemId": "City",
               "bodyPadding": 10,
               "items": [{
                    "name": "cityId",
                    "itemId": "cityId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Id<font color='red'> *<\/font>",
                    "fieldId": "45A43CE9-3D6B-441E-854F-4AFCD7F71837",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "cityId",
                    "bind": "{cityId}"
               }, {
                    "name": "countryId",
                    "itemId": "countryId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "Country",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Country<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "AE44C5F2-D7AE-4DC8-BA01-1D174FF553FF",
                    "restURL": "Country",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mineproj.mineproj.shared.mineproj.model.location.CountryModel"
                    },
                    "bindable": "countryId",
                    "bind": "{countryId}",
                    "columnWidth": 0.5,
                    "listeners": {
                         "change": "onCountryIdChange"
                    }
               }, {
                    "name": "stateId",
                    "itemId": "stateId",
                    "xtype": "combo",
                    "customWidgetType": "vdCombo",
                    "displayName": "State",
                    "margin": "5 5 5 5",
                    "fieldLabel": "State<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "2C55643C-F5D4-4EAB-B3DD-AC164843EE0C",
                    "restURL": "State",
                    "displayField": "primaryDisplay",
                    "valueField": "primaryKey",
                    "typeAhead": true,
                    "queryMode": "local",
                    "minChars": 2,
                    "store": {
                         "data": [],
                         "model": "Mineproj.mineproj.shared.mineproj.model.location.StateModel"
                    },
                    "bindable": "stateId",
                    "bind": "{stateId}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityName",
                    "itemId": "cityName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "447F5B1C-4ECE-43FF-8E01-7510F3162B70",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "cityName",
                    "bind": "{cityName}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityCodeChar2",
                    "itemId": "cityCodeChar2",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "City Code",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Code<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "F7166CBF-7F83-486D-A707-927D9DF8B2A7",
                    "minLength": "0",
                    "maxLength": "32",
                    "bindable": "cityCodeChar2",
                    "bind": "{cityCodeChar2}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityCode",
                    "itemId": "cityCode",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Code1",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Code1<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D8E5E77D-487C-4A97-BEEA-2299E0F2A81C",
                    "minValue": "0",
                    "maxValue": "3",
                    "bindable": "cityCode",
                    "bind": "{cityCode}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityDescription",
                    "itemId": "cityDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "City Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Description",
                    "fieldId": "30920A21-B934-451E-809A-5337C850358C",
                    "bindable": "cityDescription",
                    "bind": "{cityDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityFlag",
                    "itemId": "cityFlag",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Flag",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Flag",
                    "fieldId": "297DDCB2-7361-4014-BC1C-51948719520E",
                    "minLength": "0",
                    "maxLength": "128",
                    "bindable": "cityFlag",
                    "bind": "{cityFlag}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityLatitude",
                    "itemId": "cityLatitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Latitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Latitude",
                    "fieldId": "E918EA1C-83E6-4D9F-B6A5-4F2D516CA55A",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "cityLatitude",
                    "bind": "{cityLatitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "cityLongitude",
                    "itemId": "cityLongitude",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "City Longitude",
                    "margin": "5 5 5 5",
                    "fieldLabel": "City Longitude",
                    "fieldId": "6055B318-661D-4FB1-BF1C-993C5D9EF2A7",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "cityLongitude",
                    "bind": "{cityLongitude}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "0E384D2E-D137-4F2C-8FA7-EE85585CBF31",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 667,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 667,
                         "customId": 199
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 667,
                         "customId": 200,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 667,
                         "customId": 201,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});