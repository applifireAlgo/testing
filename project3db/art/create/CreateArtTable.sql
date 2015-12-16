DROP TABLE IF EXISTS `art_query`;

CREATE TABLE `art_query` (
`query_id` varchar(64) NOT NULL ,
`jpql_query` text,
`query_type` tinyint(1) DEFAULT NULL,
`query_json` text,
`name` varchar(256) DEFAULT NULL,
`hidden_name` varchar(256) DEFAULT NULL,
`app_creator_id` varchar(256) DEFAULT NULL,
`project_id` varchar(256) DEFAULT NULL,
`project_version_id` varchar(256) DEFAULT NULL,
`created_by` int(11) DEFAULT NULL,
`created_date` datetime DEFAULT NULL,
`updated_by` int(11) DEFAULT NULL,
`updated_date` datetime DEFAULT NULL,
`version_id` int(11) DEFAULT NULL,
`active_status` tinyint(1) DEFAULT NULL,
`sql_query` text,
`user_access` tinyint(1) DEFAULT '0',
PRIMARY KEY (`query_id`)
);

DROP TABLE IF EXISTS `art_enum`;

CREATE TABLE `art_enum` (
  `enum_id` int(11) NOT NULL DEFAULT '0',
  `enum_code` varchar(20) DEFAULT NULL,
  `enum_desc` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`enum_id`)
) ;

DROP TABLE IF EXISTS `art_enum_details`;

CREATE TABLE `art_enum_details` (
  `enum_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `type_value` varchar(100) DEFAULT NULL,
  `type_desc` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`enum_id`,`type_id`),
  KEY `enum_id` (`enum_id`)
) ;

DROP TABLE IF EXISTS `art_report_ui`;

CREATE TABLE `art_report_ui` (
  `report_name` VARCHAR(256) DEFAULT NULL,
  `report_id` VARCHAR(64) NOT NULL,
  `query_id` VARCHAR(64) DEFAULT NULL,
  `data_json` TEXT,
  `chart_json` LONGTEXT,
  `created_by` VARCHAR(64) NOT NULL,
  `created_date` DATE NOT NULL,
  `updated_by` VARCHAR(64) NOT NULL,
  `updated_date` DATE NOT NULL,
  `project_id` VARCHAR(256) NOT NULL,
  `project_version_id` INT(11) NOT NULL,
  `app_creator_id` VARCHAR(256) NOT NULL,
  `active_status` INT(1) NOT NULL,
  `version_id` INT(11) NOT NULL,
  `search_json` TEXT,
  `advance_config_json` TEXT,
  PRIMARY KEY (`report_id`)
) ;

DROP TABLE IF EXISTS `art_table_details`;

CREATE TABLE `art_table_details` (
  `table_id` varchar(64) NOT NULL,
  `entity_name` varchar(256) NOT NULL,
  `table_name` varchar(256) NOT NULL,
  `display_entity_name` varchar(256) NOT NULL,
  `table_type` varchar(2) NOT NULL DEFAULT 'M',
  `domain` varchar(256) DEFAULT NULL,
  `project_id` varchar(256) NOT NULL,
  `app_creator_id` varchar(256) DEFAULT NULL,
  `project_version_id` varchar(256) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`table_id`)
);

DROP TABLE IF EXISTS `art_table_field_details`;

CREATE TABLE `art_table_field_details` (
  `field_id` varchar(64) NOT NULL ,
  `table_id` varchar(64) NOT NULL ,
  `field_name` varchar(256) NOT NULL,
  `data_type` varchar(256) NOT NULL,
  `datatype_precision` varchar(45) DEFAULT NULL,
  `is_pkey` tinyint(1) NOT NULL DEFAULT '0',
  `is_null` tinyint(1) NOT NULL DEFAULT '1',
  `is_auto_inc` tinyint(1) NOT NULL DEFAULT '0',
  `is_unique` tinyint(1) NOT NULL DEFAULT '0',
  `is_fkey` tinyint(1) NOT NULL DEFAULT '0',
  `reff_key` varchar(256) DEFAULT NULL,
  `reff_table` varchar(256) DEFAULT NULL,
  `primary_display` tinyint(1) DEFAULT NULL,
  `default_value` varchar(256) DEFAULT NULL,
  `system_field` tinyint(1) NOT NULL DEFAULT '0',
  `column_sequence` varchar(256) DEFAULT NULL,
  `display_json` text,
  `project_id` varchar(256) NOT NULL,
  `app_creator_id` varchar(256) NOT NULL,
  `project_version_id` varchar(256) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT '1',
  `field_order` int(5) DEFAULT NULL,
  `field_group` varchar(256) DEFAULT NULL,
  `target_field` varchar(256) DEFAULT NULL,
  `transient_field` tinyint(1) DEFAULT NULL,
  `ui_permission` int(10) DEFAULT '0',
  PRIMARY KEY (`field_id`),
  UNIQUE KEY `uniqueID` (`table_id`,`field_name`),
  CONSTRAINT `FK` FOREIGN KEY (`table_id`) REFERENCES `art_table_details` (`table_id`)
);

DROP TABLE IF EXISTS `art_table_entity_relation`;

CREATE TABLE `art_table_entity_relation` (
  `id` varchar(64) NOT NULL ,
  `relation_type` varchar(256) DEFAULT NULL,
  `direction_type` varchar(256) DEFAULT NULL,
  `cascade_type` varchar(256) DEFAULT NULL,
  `fetch_type` varchar(256) DEFAULT NULL,
  `owning_cascade` varchar(256) DEFAULT NULL,
  `owning_table_id` varchar(64) NOT NULL ,
  `owning_key_id` varchar(64) NOT NULL ,
  `reff_table_id` varchar(64) NOT NULL ,
  `reff_key_id` varchar(64) NOT NULL ,
  `project_id` varchar(256) DEFAULT NULL,
  `project_version_id` varchar(256) DEFAULT NULL,
  `app_creator_id` varchar(256) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT '1',
  `owing_entity` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_art_table_entity_1_idx` (`owning_table_id`),
  CONSTRAINT `fk_art_table_entity_relation_1` FOREIGN KEY (`owning_table_id`) REFERENCES `art_table_details` (`table_id`) 
);

DROP TABLE IF EXISTS `art_database_aggregate`;

CREATE TABLE `art_database_aggregate` (
  `id` varchar(64) NOT NULL ,
  `name` varchar(256) DEFAULT NULL,
  `json` text NOT NULL,
  `active_status` int(1) DEFAULT '1',
  `version_id` int(11) DEFAULT '-1',
  `updated_date` datetime DEFAULT '1900-01-01 00:00:00',
  `updated_by` int(11) DEFAULT '-1',
  `created_date` datetime DEFAULT '1900-01-01 00:00:00',
  `created_by` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `art_database_function`;

CREATE TABLE `art_database_function` (
  `id` varchar(64) NOT NULL ,
  `name` varchar(256) DEFAULT NULL,
  `json` text NOT NULL,
  `active_status` int(1) DEFAULT '1',
  `version_id` int(11) DEFAULT '-1',
  `updated_date` datetime DEFAULT '1900-01-01 00:00:00',
  `updated_by` int(11) DEFAULT '-1',
  `created_date` datetime DEFAULT '1900-01-01 00:00:00',
  `created_by` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
 );

DROP TABLE IF EXISTS `art_database_operators`;

CREATE TABLE `art_database_operators` (
  `id` varchar(64) NOT NULL ,
  `name` varchar(256) DEFAULT NULL,
  `json` text NOT NULL,
  `active_status` int(1) DEFAULT '1',
  `version_id` int(11) DEFAULT '-1',
  `updated_date` datetime DEFAULT '1900-01-01 00:00:00',
  `updated_by` int(11) DEFAULT '-1',
  `created_date` datetime DEFAULT '1900-01-01 00:00:00',
  `created_by` int(11) DEFAULT '-1',
  PRIMARY KEY (`id`)
 );

DROP TABLE IF EXISTS `art_component_config`;

CREATE TABLE `art_component_config` (
  `id` varchar(64) NOT NULL,
  `component_name` varchar(256) NOT NULL,
  `initializer` varchar(256) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `project_id` varchar(256) NOT NULL,
  `project_version_id` varchar(256) DEFAULT NULL,
  `app_creator_id` varchar(256) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS `art_log_severity_m`;

CREATE TABLE `art_log_severity_m` ( `severity_id` varchar(64) NOT NULL, `log_config_id` INT(11) DEFAULT NULL, `severity` INT(11) NOT NULL, `label` VARCHAR(256) NOT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` TIMESTAMP NULL DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` TINYINT(1) DEFAULT NULL, PRIMARY KEY (`severity_id`) ) ;

DROP TABLE IF EXISTS `art_log_events_t`;

CREATE TABLE `art_log_events_t` (
  `event_id` bigint NOT NULL,
  `customer_id` int(11) NOT NULL,
  `app_name` varchar(20) NOT NULL,
  `time_stamp` datetime,
  `alarm_id` int(20),
  `severity` varchar(64),  
  `user_id` varchar(200) ,
  `ip_address` varchar(30),
  `module` varchar(100) ,
  `class_name` varchar(300) ,
  `method_name` varchar(100),  
  `message` varchar(2000) ,  
  `throwable_message` TEXT NULL DEFAULT NULL,
  FOREIGN KEY (severity) REFERENCES art_log_severity_m(severity_id)
);

DROP TABLE IF EXISTS `art_chart_json`;

CREATE TABLE `art_chart_json` (

  `chart_json_id` varchar(64) NOT NULL ,

  `chart_json` longtext NOT NULL,

  `json_data_structure` longtext NOT NULL,

  `java_class` varchar(2048) DEFAULT NULL,

  `created_by` int(11) NOT NULL,

  `created_date` date NOT NULL,

  `updated_by` int(11) NOT NULL,

  `updated_date` date NOT NULL,

  `version_id` int(11) NOT NULL,

  `active_status` int(1) NOT NULL,

  `data_field_id` VARCHAR(64) DEFAULT NULL,

  PRIMARY KEY (`chart_json_id`)

);

DROP TABLE IF EXISTS `art_chart_category`;

CREATE TABLE `art_chart_category` (

  `chart_id` varchar(64) NOT NULL ,

  `chart_tree_id` varchar(30) NOT NULL,

  `chart_label` varchar(100) NOT NULL,

  `chart_description` varchar(200) DEFAULT NULL,

  `chart_json_id` VARCHAR(64) NOT NULL,

  `created_by` int(11) NOT NULL,

  `created_date` date NOT NULL,

  `updated_by` int(11) NOT NULL,

  `updated_date` date NOT NULL,

  `version_id` int(11) NOT NULL,

  `active_status` int(1) NOT NULL,

  `chart_point` int(1) NOT NULL DEFAULT '0',

  PRIMARY KEY (`chart_id`),

  KEY `Foreign Key` (`chart_json_id`),

  CONSTRAINT `Foreign Key` FOREIGN KEY (`chart_json_id`) REFERENCES `art_chart_json` (`chart_json_id`) ON DELETE CASCADE

);



DROP TABLE IF EXISTS `art_chart_type`;

CREATE TABLE `art_chart_type` (

  `chart_type_id` varchar(64) NOT NULL ,

  `chart_id` VARCHAR(64) NOT NULL,

  `chart_type` varchar(100) NOT NULL,

  `chart_default` varchar(1) NOT NULL,

  `created_by` int(11) NOT NULL,

  `created_date` date NOT NULL,

  `updated_by` int(11) NOT NULL,

  `updated_date` date NOT NULL,

  `version_id` int(11) NOT NULL,

  `active_status` int(1) NOT NULL,

  PRIMARY KEY (`chart_type_id`),

  KEY `ForeignKey` (`chart_id`),

  CONSTRAINT `ForeignKey` FOREIGN KEY (`chart_id`) REFERENCES `art_chart_category` (`chart_id`) ON DELETE CASCADE

);

DROP TABLE IF EXISTS `art_chart_data_field_json`;

CREATE TABLE `art_chart_data_field_json` (

  `data_field_id` varchar(64) NOT NULL ,

  `data_field_name` varchar(256) DEFAULT NULL,

  `data_field_json` text,

  `created_by` int(11) DEFAULT NULL,

  `created_date` date DEFAULT NULL,

  `updated_by` int(11) DEFAULT NULL,

  `updated_date` date DEFAULT NULL,

  `version_id` int(11) DEFAULT NULL,

  `active_status` int(1) DEFAULT NULL,

  PRIMARY KEY (`data_field_id`)

);

DROP TABLE IF EXISTS `art_lang_master`;

CREATE TABLE `art_lang_master` (

  `lang_id` varchar(64) NOT NULL ,

  `lang_name` varchar(50) DEFAULT NULL,

  `country_code` varchar(10) NOT NULL,

  `country_name` varchar(100) DEFAULT NULL,

  `updated_by` int(11) NOT NULL,

  `updated_date` date NOT NULL,

  `created_by` int(11) NOT NULL,

  `created_date` date NOT NULL,

  `version_id` int(11) NOT NULL,

  `active_status` int(1) NOT NULL,

  PRIMARY KEY (`lang_id`,`country_code`)

);

DROP TABLE IF EXISTS `art_chart_properties`;

CREATE TABLE `art_chart_properties` (

  `property_id` varchar(64) NOT NULL,

  `property_name` varchar(300) NOT NULL,

  `widgets` varchar(300) NOT NULL,

  `widgets_json` text,

  `created_by` int(11) NOT NULL,

  `created_date` date NOT NULL,

  `updated_by` int(11) NOT NULL,

  `updated_date` date NOT NULL,

  `version_id` int(11) NOT NULL,

  `active_status` int(1) NOT NULL,

  PRIMARY KEY (`property_id`)

);

DROP TABLE IF EXISTS `art_chart_prop_language`;

CREATE TABLE `art_chart_prop_language` (

  `label_id` varchar(64) NOT NULL,

  `property_id` varchar(64) NOT NULL,

  `display_name` varchar(200) NOT NULL,

  `lang_id` varchar(64) NOT NULL,

  `created_by` int(11) NOT NULL,

  `created_date` date NOT NULL,

  `updated_by` int(11) NOT NULL,

  `updated_date` date NOT NULL,

  `version_id` int(11) NOT NULL,

  `active_status` int(1) NOT NULL,

  PRIMARY KEY (`label_id`),

  KEY `property_id` (`property_id`),

  KEY `art_mst_chart_prop_language`	 (`lang_id`),

  CONSTRAINT `art_chart_prop_language` FOREIGN KEY (`lang_id`) REFERENCES `art_lang_master` (`lang_id`),

  CONSTRAINT `art_chart_prop_language1` FOREIGN KEY (`property_id`) REFERENCES `art_chart_properties` (`property_id`)

);

DROP TABLE IF EXISTS `art_chart_template`;

CREATE TABLE `art_chart_template` (

  `template_id` varchar(64) NOT NULL ,

  `template_name` varchar(500) NOT NULL,

  `template_json` longtext NOT NULL,

  `created_by` int(11) NOT NULL,

  `created_date` date NOT NULL,

  `updated_by` int(11) NOT NULL,

  `updated_date` date NOT NULL,

  `version_id` int(11) NOT NULL,

  `project_id` VARCHAR(256),

  `project_version_id` INT(11),

  `active_status` int(1) NOT NULL,

  `app_creator_id` varchar(256),

  PRIMARY KEY (`template_id`)

);

DROP TABLE IF EXISTS `art_report_builder_details`;

CREATE TABLE `art_report_builder_details` (
  `report_id` VARCHAR(64) NOT NULL,
  `report_name` VARCHAR(256) NOT NULL,
  `report_synopsis` TEXT,
  `report_help` TEXT,
  `query_criteria_json` TEXT,
  `grid_conf_json` TEXT,
  `chart_properties` TEXT,
  `drilldown_json` TEXT,
  `dataEndPoint_json` TEXT,
  `created_by` VARCHAR(64) NOT NULL,
  `created_date` DATE NOT NULL,
  `updated_by` VARCHAR(64) NOT NULL,
  `updated_date` DATE NOT NULL,
  `project_id` VARCHAR(256) NOT NULL,
  `project_version_id` INT(11) NOT NULL,
  `app_creator_id` VARCHAR(256) NOT NULL,
  `active_status` INT(1) NOT NULL,
  `version_id` INT(11) NOT NULL,
  `query_info` TEXT,
  `other_properties_json` TEXT,
  `search_json` TEXT,
  `edit_flag` INT(1) DEFAULT NULL,
  `bounded_context` VARCHAR(64) DEFAULT NULL,
  `system_flag` INT(1) DEFAULT '0',
  `data_browser` INT(1) DEFAULT '0',
  `advance_config_json` TEXT,
  PRIMARY KEY (`report_id`)
) ;

DROP TABLE IF EXISTS `art_service`;

CREATE TABLE `art_service` (
  `service_id` varchar(64) NOT NULL ,
  `service_name` varchar(256) NOT NULL,
  `service_class` varchar(256) NOT NULL,
  `service_json` text,
  `source_details` text,
  `status` varchar(1) DEFAULT 'I',
  `project_id` varchar(256) DEFAULT NULL,
  `app_creator_id` varchar(256) DEFAULT NULL,
  `project_version_id` varchar(256) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `version_id` int(11) NOT NULL,
  `active_status` tinyint(1) NOT NULL DEFAULT '1',
  `dao_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ;

DROP TABLE IF EXISTS `art_service_operation`;

CREATE TABLE `art_service_operation` (
  `operation_id` varchar(64) NOT NULL ,
  `service_id` varchar(64) NOT NULL ,
  `operation_name` varchar(256) NOT NULL,
  `dao_class` varchar(256) NOT NULL,
  `operation_json` longtext,
  `source_details` text,
  `project_id` varchar(256) DEFAULT NULL,
  `app_creator_id` varchar(256) DEFAULT NULL,
  `project_version_id` varchar(256) DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT '1',
  `dao_id` varchar(64) DEFAULT NULL,
  `dao_operation_id` varchar(64) DEFAULT NULL,
  `operation_type` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`operation_id`)
); 

DROP TABLE IF EXISTS `art_log_config_m`;

CREATE TABLE `art_log_config_m` ( `log_config_id` varchar(64) NOT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` TIMESTAMP NULL DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` TINYINT(1) DEFAULT NULL, PRIMARY KEY (`log_config_id`) );

DROP TABLE IF EXISTS `art_log_config_attributes`;

CREATE TABLE `art_log_config_attributes` ( `attribute_id` varchar(64) NOT NULL , `log_config_id` varchar(64) NOT NULL , `attribute_name` VARCHAR(256) DEFAULT NULL, `attribute_value` VARCHAR(256) DEFAULT NULL, `attribute_comment` VARCHAR(1000) DEFAULT NULL, `attribute_display_name` VARCHAR(256) DEFAULT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` TIMESTAMP NULL DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` TINYINT(1) DEFAULT NULL, PRIMARY KEY (`attribute_id`), KEY `LogFK` (`log_config_id`), CONSTRAINT `ArtLogFK` FOREIGN KEY (`log_config_id`) REFERENCES `art_log_config_m` (`log_config_id`) ) ;

DROP TABLE IF EXISTS `art_log_connector_m`;

CREATE TABLE `art_log_connector_m` ( `connector_id`  varchar(64) NOT NULL , `log_config_id` varchar(64) NOT NULL , `connector_log_level` INT(11) NOT NULL, `cid` INT(11) NOT NULL, `id` VARCHAR(256) DEFAULT NULL, `enabled` TINYINT(1) NOT NULL, `connector_name` VARCHAR(256) NOT NULL, `class_name` VARCHAR(256) NOT NULL, `system_defined` TINYINT(1) DEFAULT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` TIMESTAMP NULL DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` TINYINT(1) DEFAULT NULL, PRIMARY KEY (`connector_id`), KEY `LogConfigFK` (`log_config_id`), CONSTRAINT `ArtLogConfigFK` FOREIGN KEY (`log_config_id`) REFERENCES `art_log_config_m` (`log_config_id`) ) ;

DROP TABLE IF EXISTS `art_log_connector_attributes_m`;

CREATE TABLE `art_log_connector_attributes_m` ( `attribute_id` varchar(64) NOT NULL, `connector_id` varchar(64) NOT NULL , `attribute_name` VARCHAR(256) NOT NULL, `attribute_value` VARCHAR(256) NOT NULL, `attribute_comment` VARCHAR(1024) DEFAULT NULL, `attribute_display_name` VARCHAR(256) DEFAULT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` TIMESTAMP NULL DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` TINYINT(1) DEFAULT NULL, PRIMARY KEY (`attribute_id`), KEY `ConnectorFK` (`connector_id`), CONSTRAINT `ArtConnectorFK` FOREIGN KEY (`connector_id`) REFERENCES `art_log_connector_m` (`connector_id`) );

DROP TABLE IF EXISTS `zen_health`;

CREATE TABLE `zen_health` (
  `monitor_id` varchar(64) NOT NULL ,
  `class_Unloaded` int(11) NOT NULL,
  `gc_Collection_Time` int(11) NOT NULL,
  `non_Heap_Committed` bigint(20) NOT NULL,
  `start_Time` datetime NOT NULL,
  `cpu_Time` double NOT NULL,
  `cpu_Load_Time` double NOT NULL DEFAULT '0',
  `non_Heap_used` bigint(20) NOT NULL,
  `up_Time` int(11) NOT NULL,
  `free_Physical_Size` bigint(20) NOT NULL,
  `total_Thread` double NOT NULL,
  `heap_Committed` bigint(20) NOT NULL,
  `total_Physical_Memory_Size` bigint(20) NOT NULL,
  `thread_Peak_Count` double NOT NULL,
  `scheduled_DateTime` datetime NOT NULL,
  `max_Memory` bigint(20) NOT NULL,
  `cpu_Load` double NOT NULL DEFAULT '0',
  `thread_Started_Count` double NOT NULL,
  `thread_Daemon_Count` double NOT NULL,
  `server_Instance_Id` int(32) NOT NULL,
  `total_Class` varchar(256) NOT NULL,
  `free_Memory` bigint(20) NOT NULL,
  `free_Swap_Size` bigint(20) NOT NULL,
  `server_Ip_Address` varchar(30) NOT NULL,
  `class_Loaded` varchar(32) NOT NULL,
  `heap_Used` bigint(20) NOT NULL,
  `system_Load_Average` double NOT NULL,
  `thread_Cpu_Time` double NOT NULL,
  `total_Memory` bigint(20) NOT NULL,
  `total_Swap_Size` bigint(20) NOT NULL,
  `available_Processor` double NOT NULL,
  `gc_Memory_Name` varchar(256) NOT NULL,
  `thread_User_Time` varchar(45) DEFAULT NULL,
  `used_Memory` bigint(20) DEFAULT NULL,
  `used_Swap_Size` bigint(20) DEFAULT NULL,
  `used_Physical_Memory` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`monitor_id`)
);

DROP TABLE IF EXISTS `zen_health_counter`;

CREATE TABLE `zen_health_counter` (  `counter_id` varchar(64) NOT NULL ,  `server_Instance_Id` int(11) NOT NULL,  `http_Status` varchar(256) NOT NULL,  `server_Ip_Address` varchar(256) NOT NULL,  `service_Name` varchar(32) NOT NULL,  `scheduled_DateTime` datetime NOT NULL,  `status_Count` int(2) NOT NULL,  `method_Name` varchar(100) NOT NULL,  `counter_Type` int(4) NOT NULL,  PRIMARY KEY (`counter_id`)) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `zen_health_gauge`;

CREATE TABLE `zen_health_gauge` (  `gauge_id` varchar(64) NOT NULL ,  `scheduled_DateTime` datetime NOT NULL,  `method_Hit_Count` double NOT NULL,  `server_Instance_Id` int(11) NOT NULL,  `method_Hit_Time` double NOT NULL,  `server_Ip_Address` varchar(256) NOT NULL,  `service_Name` varchar(256) NOT NULL,  `method_Name` varchar(32) NOT NULL,  PRIMARY KEY (`gauge_id`)) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `zen_health_status`;

CREATE TABLE `zen_health_status` (  `healthId` varchar(64) NOT NULL ,  `scheduled_DateTime` datetime NOT NULL,  `free_Space` double NOT NULL,  `status` varchar(256) NOT NULL,  `server_Instance_Id` int(3) NOT NULL,  `used_Space` double NOT NULL,  `server_Ip_Address` varchar(30) NOT NULL,  `total_Space` double NOT NULL,  PRIMARY KEY (`healthId`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `zen_request_details`;

CREATE TABLE `zen_request_details` (
  `requestId` varchar(46) NOT NULL,
  `class_Name` varchar(150) DEFAULT NULL,
  `ip_Address` varchar(45) DEFAULT NULL,
  `request_Time` datetime DEFAULT NULL,
  `request_Method` varchar(45) DEFAULT NULL,
  `http_Status` varchar(45) DEFAULT NULL,
  `return_Status` varchar(45) DEFAULT NULL,
  `execution_Time` double DEFAULT NULL,
  `method_Name` varchar(45) DEFAULT NULL,
  `end_Time` datetime NOT NULL,
  `typeofClass` varchar(11) DEFAULT NULL,
  `callSeqId` int(11) DEFAULT NULL,
  `exceptionId` int(11) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  `appSessionId` varchar(45) DEFAULT NULL
);

DROP TABLE IF EXISTS `art_loginSession`;

CREATE TABLE `art_loginSession` (
  `sessionid` varchar(45) NOT NULL,
  `loginTime` timestamp NULL DEFAULT NULL,
  `logoutTime` timestamp NULL DEFAULT NULL,
  `clientIPAddress` varchar(45) DEFAULT NULL,
  `clientIPAddressInt` int(11) DEFAULT NULL,
  `clientNetworkAddress` int(11) DEFAULT NULL,
  `clientBrowser` varchar(1000) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sessionid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `art_session_data`;

CREATE TABLE `art_session_data` (
  `sessionid` varchar(45) NOT NULL,
  `sno` int(11) NOT NULL AUTO_INCREMENT,
  `sessionDataType` varchar(45) DEFAULT NULL,
  `sessionData` text,
  `version_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sno`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `art_user_last_status`;

CREATE TABLE `art_user_last_status` (

  `id` VARCHAR(64) NOT NULL,

  `user_id` VARCHAR(64) DEFAULT NULL,

  `menu_id` VARCHAR(64) DEFAULT NULL,

  `json` TEXT,

  `project_id` VARCHAR(256) DEFAULT NULL,

  `project_version_id` VARCHAR(256) DEFAULT NULL,

  `updated_by` INT(11) DEFAULT NULL,

  `updated_date` DATETIME DEFAULT NULL,

  `created_by` INT(11) DEFAULT NULL,

  `created_date` DATETIME DEFAULT NULL,

  `version_id` INT(11) DEFAULT NULL,

  `active_status` TINYINT(1) DEFAULT NULL,

  `app_creator_id` VARCHAR(256) DEFAULT NULL,

  PRIMARY KEY (`id`)

) ;

DROP TABLE IF EXISTS `art_log_module`;

CREATE TABLE `art_log_module` ( `id` varchar(64) NOT NULL , `log_module_name` VARCHAR(100) DEFAULT NULL, `connector_order_id` VARCHAR(45) DEFAULT NULL, `severity` INT(11) DEFAULT NULL, `id_range_starts_with` INT(11) DEFAULT NULL, `system_defined` TINYINT(1) DEFAULT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` DATETIME DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` INT(1) DEFAULT NULL, PRIMARY KEY (`id`), KEY `alm_idx` (`connector_order_id`) ) ;

DROP TABLE IF EXISTS `art_app_alarm`;

CREATE TABLE `art_app_alarm` ( `id` varchar(64) NOT NULL , `alarm_id` INT(11) DEFAULT NULL, `severity` INT(11) DEFAULT NULL, `connector_order_id` VARCHAR(45) DEFAULT NULL, `message` TEXT, `diagnose` TEXT, `solution` TEXT, `log_module_id` varchar(64) NOT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` DATETIME DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` INT(1) DEFAULT NULL, PRIMARY KEY (`id`), KEY `fk_art_app_alarm_co_idx` (`connector_order_id`), KEY `fk_art_app_alarm_lm_idx` (`log_module_id`), CONSTRAINT `fk_art_app_alarm_log_module` FOREIGN KEY (`log_module_id`) REFERENCES `art_log_module` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION ) ;

DROP TABLE IF EXISTS `art_password_algorithm`;

CREATE TABLE `art_password_algorithm` ( `algoId` varchar(256) NOT NULL, `algorithm` varchar(256) NOT NULL, `algoName` varchar(256) NOT NULL, `algoDescription` varchar(256) DEFAULT NULL, `active_status` int(1) DEFAULT '1', `created_date` datetime DEFAULT '1900-01-01 00:00:00', `updated_by` int(11) DEFAULT '-1', `version_id` int(11) DEFAULT '-1', `created_by` int(11) DEFAULT '-1', `updated_date` datetime DEFAULT '1900-01-01 00:00:00', PRIMARY KEY (`algoId`) );

DROP TABLE IF EXISTS `art_password_policy`;

CREATE TABLE `art_password_policy` ( `policyId` VARCHAR (256) NOT NULL, `policyName` VARCHAR (256) NOT NULL, `policyDescription` VARCHAR (512) NOT NULL, `minPwdLength` INT (11) NOT NULL, `maxPwdLength` INT (11) NOT NULL, `minCapitalLetters` INT (11) NOT NULL, `minSmallLetters` INT (11) NOT NULL, `minNumericValues` INT (11) NOT NULL, `minSpecialLetters` INT (11) NOT NULL, `allowedSpecialLetters` VARCHAR (256) DEFAULT NULL, `active_status` INT (1) DEFAULT '1', `version_id` INT (11) DEFAULT '-1', `updated_date` DATETIME DEFAULT '1900-01-01 00:00:00', `updated_by` INT (11) DEFAULT '-1', `created_date` DATETIME DEFAULT '1900-01-01 00:00:00', `created_by` INT (11) DEFAULT '-1', PRIMARY KEY (`policyId`) ) ;

DROP TABLE IF EXISTS `art_health_scheduler_config_m`;

CREATE TABLE `art_health_scheduler_config_m` ( `schedulerId` varchar(64) NOT NULL , `schedulerkey` VARCHAR(45) DEFAULT NULL, `refreshTime` INT(11) DEFAULT NULL, `refreshUnit` VARCHAR(45) DEFAULT NULL, `batchSize` INT(11) DEFAULT NULL, `enabled` VARCHAR(45) DEFAULT NULL, `connectorClass` VARCHAR(100) DEFAULT NULL, `dataModel` VARCHAR(100) DEFAULT NULL, `schedulerName` VARCHAR(45) DEFAULT NULL, `threadPoolSize` INT(11) DEFAULT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` TIMESTAMP NULL DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` TINYINT(1) DEFAULT NULL, PRIMARY KEY (`schedulerId`) );

DROP TABLE IF EXISTS `art_health_status_config_m`;

CREATE TABLE `art_health_status_config_m` ( `statusConfigId` varchar(64) NOT NULL , `diskPath` VARCHAR(100) DEFAULT NULL, `diskThreshold` INT(11) DEFAULT NULL, `executeSql` VARCHAR(250) DEFAULT NULL, `version_id` INT(11) DEFAULT NULL, `created_by` INT(11) DEFAULT NULL, `created_date` TIMESTAMP NULL DEFAULT NULL, `updated_by` INT(11) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` TINYINT(1) DEFAULT NULL, PRIMARY KEY (`statusConfigId`) );

DROP TABLE IF EXISTS `cloud_drive_file_content_type`;

CREATE TABLE `cloud_drive_file_content_type` ( `id` int(11) NOT NULL AUTO_INCREMENT, `application_type` varchar(300) NOT NULL, `file_mime_type` varchar(300) DEFAULT NULL, `extension` varchar(25) DEFAULT NULL, `image` varchar(25) DEFAULT NULL, PRIMARY KEY (`id`) );

DROP TABLE IF EXISTS `cloud_drive_tags`;

CREATE TABLE `cloud_drive_tags` ( `tag_id` varchar(64) NOT NULL, `tag_hierachy` VARCHAR(100) DEFAULT NULL, `tag_name` VARCHAR(50) DEFAULT NULL, `tag_image` VARCHAR(50) DEFAULT NULL, `created_by` VARCHAR(64) DEFAULT NULL, `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, `updated_by` VARCHAR(64) DEFAULT NULL, `updated_date` TIMESTAMP NULL DEFAULT NULL, `version_id` INT(11) DEFAULT NULL, `active_status` INT(1) DEFAULT NULL, `app_creator_id` VARCHAR(64) DEFAULT NULL, KEY `tag_id` (`tag_id`) );

DROP TABLE IF EXISTS `cloud_drive_files`;

CREATE TABLE `cloud_drive_files` ( `file_id` varchar(64) NOT NULL, `file_name` VARCHAR(50) DEFAULT NULL, `file_extension` VARCHAR(100) DEFAULT NULL, `file_application_type` VARCHAR(300) DEFAULT NULL, `file_mime_type` VARCHAR(300) DEFAULT NULL, `system_name` VARCHAR(100) DEFAULT NULL, `system_path` VARCHAR(500) DEFAULT NULL, `size1` DECIMAL(10,0) DEFAULT NULL, `file_scope` CHAR(1) DEFAULT NULL, `created_by` VARCHAR(64) DEFAULT NULL, `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, `updated_by` VARCHAR(64) DEFAULT NULL, `updated_date` TIMESTAMP NULL DEFAULT NULL, `version_id` VARCHAR(11) DEFAULT NULL, `app_creator_id` VARCHAR(64) DEFAULT NULL, `active_status` INT(1) DEFAULT NULL, PRIMARY KEY (`file_id`), KEY `file_id` (`file_id`), KEY `fk_file_content_id` (`file_mime_type`) );

DROP TABLE IF EXISTS `cloud_drive_tags_file`;

CREATE TABLE `cloud_drive_tags_file` ( `id` int(11) NOT NULL AUTO_INCREMENT, `file_id` varchar(64) DEFAULT NULL, `tag_id` varchar(64) DEFAULT NULL, PRIMARY KEY (`id`), KEY `fk_file_id` (`file_id`), CONSTRAINT `fk_file_id` FOREIGN KEY (`file_id`) REFERENCES `cloud_drive_files` (`file_id`) );

DROP TABLE IF EXISTS `cloud_drive_file_versions`;

CREATE TABLE `cloud_drive_file_versions` ( `base_file_Id` varchar(64) DEFAULT NULL, `file_id` varchar(64) NOT NULL, `file_version_id` INT(5) NOT NULL, `created_by` VARCHAR(64) DEFAULT NULL, `created_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, `updated_by` VARCHAR(64) DEFAULT NULL, `updated_date` TIMESTAMP NULL DEFAULT NULL, `version_id` INT(5) DEFAULT NULL, `active_status` INT(1) DEFAULT NULL, PRIMARY KEY (`file_id`,`file_version_id`), CONSTRAINT `fk_file_version_id` FOREIGN KEY (`file_id`) REFERENCES `cloud_drive_files` (`file_id`) );

DROP TABLE IF EXISTS `cloud_drive_tag_shared`;

CREATE TABLE `cloud_drive_tag_shared` ( `tag_id` int(11) DEFAULT NULL, `shared_user_id` varchar(64) DEFAULT NULL, `updated_by` varchar(64) DEFAULT NULL, `updated_date` timestamp NULL DEFAULT NULL, `created_by` varchar(64) DEFAULT NULL, `created_date` timestamp NULL DEFAULT  NULL, `version_id` int(11) DEFAULT NULL, `active_status` int(1) DEFAULT NULL, `id` varchar(64) NOT NULL, PRIMARY KEY (`id`) );

DROP TABLE IF EXISTS `cloud_drive_file_shared`;

CREATE TABLE `cloud_drive_file_shared` ( `file_id` varchar(64) DEFAULT NULL, `shared_user_id` varchar(64) DEFAULT NULL, `updated_by` varchar(64) DEFAULT NULL, `updated_date` TIMESTAMP NULL DEFAULT NULL, `created_by` varchar(64) DEFAULT NULL, `created_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP, `version_id` int(11) DEFAULT NULL, `active_status` int(1) DEFAULT NULL, `id` varchar(64) NOT NULL, PRIMARY KEY (`id`) );

DROP TABLE IF EXISTS `art_rules`;

CREATE TABLE `art_rules` (`rule_id` VARCHAR(64) NOT NULL,`rule_name` VARCHAR(256) NOT NULL, `rule_drl` LONGTEXT DEFAULT NULL,`updated_by` INT(11) DEFAULT NULL,`updated_date` DATETIME DEFAULT NULL,`created_by` INT(11) DEFAULT NULL,`created_date` DATETIME DEFAULT NULL,`version_id` INT(11) DEFAULT NULL,`active_status` TINYINT(1) DEFAULT '1',`project_id` VARCHAR(256) ,`project_version_id` VARCHAR(256),`app_creator_id` VARCHAR(256) DEFAULT NULL, PRIMARY KEY (`rule_id`));

DROP TABLE IF EXISTS `art_external_integration`;

CREATE TABLE `art_external_integration` (
  `integration_id` varchar(64) NOT NULL,
  `integration_name` VARCHAR(500) DEFAULT NULL,
  `integration_config_json` TEXT,
  `integration_dsl` TEXT,
  `project_id` VARCHAR(50) DEFAULT NULL,
  `project_version_id` VARCHAR(50) DEFAULT NULL,
  `created_by` VARCHAR(64) DEFAULT NULL,
  `created_date` DATETIME DEFAULT NULL,
  `app_creator_id` VARCHAR(500) DEFAULT NULL,
  `updated_by` VARCHAR(64) DEFAULT NULL,
  `updated_date` DATETIME DEFAULT NULL,
  `version_id` INT(16) DEFAULT NULL,
  `active_status` TINYINT(1) DEFAULT NULL,
 `connectorId`  varchar(50) DEFAULT NULL,
  PRIMARY KEY (`integration_id`)
);



DROP TABLE IF EXISTS `art_job_details`;

CREATE TABLE `art_job_details` (
  `jobId` varchar(64) NOT NULL,
  `jobName` varchar(128) DEFAULT NULL,
  `uiJson` text NOT NULL,
  `processJson` text,
  `project_id` varchar(256) DEFAULT NULL,
  `app_creator_id` varchar(256) DEFAULT NULL,
  `project_version_id` varchar(256) DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(64) DEFAULT NULL,
  `updated_date` datetime DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT NULL,
  `beanName` varchar(64) DEFAULT NULL,
  `currentStatus` varchar(64) DEFAULT NULL,
  `statusTime` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`jobId`)
);

DROP TABLE IF EXISTS `art_scheduler_details`;

CREATE TABLE `art_scheduler_details` (
  `schedulerId` varchar(64) NOT NULL,
  `schedulerExpression` varchar(64) DEFAULT NULL,
  `jobId` varchar(64) DEFAULT NULL,
  `project_id` varchar(64) DEFAULT NULL,
  `app_creator_id` varchar(64) DEFAULT NULL,
  `project_version_id` varchar(64) DEFAULT NULL,
  `created_by` varchar(64) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `updated_by` varchar(64) DEFAULT NULL,
  `version_id` int(11) DEFAULT NULL,
  `active_status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`schedulerId`)
) ;

DROP TABLE IF EXISTS `art_schedule_config`;

CREATE TABLE `art_schedule_config` ( `schedule_id` VARCHAR(64) NOT NULL, `schedule_name` VARCHAR(256) NOT NULL, `schedule_job` VARCHAR(64) NOT NULL, `scheduler_expression` VARCHAR(256) DEFAULT NULL, `schedule_strategy` LONGTEXT NOT NULL, `created_by` VARCHAR(64) DEFAULT '-1', `created_date` DATETIME DEFAULT '1900-01-01 00:00:00', `updated_by` VARCHAR(64) DEFAULT '-1', `updated_date` DATETIME DEFAULT '1900-01-01 00:00:00', `version_id` INT(11) DEFAULT '-1', `active_status` INT(1) DEFAULT '1', PRIMARY KEY (`schedule_id`) ) ;

