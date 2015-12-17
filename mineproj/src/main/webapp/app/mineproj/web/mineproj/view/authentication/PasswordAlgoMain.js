Ext.define('Mineproj.mineproj.web.mineproj.view.authentication.PasswordAlgoMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "PasswordAlgoMainController",
     "restURL": "/PasswordAlgo",
     "defaults": {
          "split": true
     },
     "requires": ["Mineproj.mineproj.shared.mineproj.model.authentication.PasswordAlgoModel", "Mineproj.mineproj.web.mineproj.controller.authentication.PasswordAlgoMainController", "Mineproj.mineproj.shared.mineproj.viewmodel.authentication.PasswordAlgoViewModel"],
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
               "displayName": "Password Algo",
               "name": "PasswordAlgoTreeContainer",
               "itemId": "PasswordAlgoTreeContainer",
               "restURL": "/PasswordAlgo",
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
                    "itemId": "PasswordAlgoTree",
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
                    "items": [{
                         "name": "algoName",
                         "itemId": "algoName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "31A0BD70-15C8-4224-998B-8BF5EFB6E05D",
                         "minLength": "0",
                         "maxLength": "256"
                    }]
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
                    "viewModel": "PasswordAlgoViewModel",
                    "xtype": "form",
                    "displayName": "Password Algo",
                    "title": "Password Algo",
                    "name": "PasswordAlgo",
                    "itemId": "PasswordAlgo",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "algoId",
                         "itemId": "algoId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Algo Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Algo Id<font color='red'> *<\/font>",
                         "fieldId": "537919F3-AD31-49DE-83FE-F15547812824",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "algoId",
                         "bind": "{algoId}"
                    }, {
                         "name": "algorithm",
                         "itemId": "algorithm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Algorithm",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Algorithm<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "C1439075-5267-47EA-B383-1C138DF5DDB6",
                         "minLength": "0",
                         "maxLength": "11",
                         "bindable": "algorithm",
                         "bind": "{algorithm}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoName",
                         "itemId": "algoName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "31A0BD70-15C8-4224-998B-8BF5EFB6E05D",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "algoName",
                         "bind": "{algoName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoDescription",
                         "itemId": "algoDescription",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Description",
                         "fieldId": "BABDDFA2-97AA-4C4B-8EDB-A16C7B3163C6",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "algoDescription",
                         "bind": "{algoDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoIcon",
                         "itemId": "algoIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon",
                         "fieldId": "91D43194-5637-49CA-B9FB-27A93A27DC19",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "algoIcon",
                         "bind": "{algoIcon}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoHelp",
                         "itemId": "algoHelp",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Help",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Help",
                         "fieldId": "F691DA4F-5E16-4B1C-BDCD-60DDBBD14C6E",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "algoHelp",
                         "bind": "{algoHelp}",
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
                         "fieldId": "2C85D145-B365-4C04-907F-C85D014ED819",
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
                         "customId": 775,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 775,
                              "customId": 87
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 775,
                              "customId": 88,
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
                              "parentId": 775,
                              "customId": 89,
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
                    "displayName": "Password Algo",
                    "title": "Details Grid",
                    "name": "PasswordAlgoGrid",
                    "itemId": "PasswordAlgoGrid",
                    "restURL": "/PasswordAlgo",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Algo Id",
                         "dataIndex": "algoId",
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
                         "header": "Algorithm",
                         "dataIndex": "algorithm",
                         "flex": 1
                    }, {
                         "header": "Name",
                         "dataIndex": "algoName",
                         "flex": 1
                    }, {
                         "header": "Description",
                         "dataIndex": "algoDescription",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "algoIcon",
                         "flex": 1
                    }, {
                         "header": "Help",
                         "dataIndex": "algoHelp",
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
               "viewModel": "PasswordAlgoViewModel",
               "xtype": "form",
               "displayName": "Password Algo",
               "title": "Password Algo",
               "name": "PasswordAlgo",
               "itemId": "PasswordAlgo",
               "bodyPadding": 10,
               "items": [{
                    "name": "algoId",
                    "itemId": "algoId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Algo Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Algo Id<font color='red'> *<\/font>",
                    "fieldId": "537919F3-AD31-49DE-83FE-F15547812824",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "algoId",
                    "bind": "{algoId}"
               }, {
                    "name": "algorithm",
                    "itemId": "algorithm",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Algorithm",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Algorithm<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "C1439075-5267-47EA-B383-1C138DF5DDB6",
                    "minLength": "0",
                    "maxLength": "11",
                    "bindable": "algorithm",
                    "bind": "{algorithm}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoName",
                    "itemId": "algoName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "31A0BD70-15C8-4224-998B-8BF5EFB6E05D",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "algoName",
                    "bind": "{algoName}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoDescription",
                    "itemId": "algoDescription",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Description",
                    "fieldId": "BABDDFA2-97AA-4C4B-8EDB-A16C7B3163C6",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "algoDescription",
                    "bind": "{algoDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoIcon",
                    "itemId": "algoIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Icon",
                    "fieldId": "91D43194-5637-49CA-B9FB-27A93A27DC19",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "algoIcon",
                    "bind": "{algoIcon}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoHelp",
                    "itemId": "algoHelp",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Help",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Help",
                    "fieldId": "F691DA4F-5E16-4B1C-BDCD-60DDBBD14C6E",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "algoHelp",
                    "bind": "{algoHelp}",
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
                    "fieldId": "2C85D145-B365-4C04-907F-C85D014ED819",
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
                    "customId": 775,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 775,
                         "customId": 87
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 775,
                         "customId": 88,
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
                         "parentId": 775,
                         "customId": 89,
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