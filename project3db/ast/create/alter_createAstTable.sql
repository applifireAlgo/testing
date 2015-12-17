

ALTER TABLE `ast_Currency_M` ADD CONSTRAINT FOREIGN KEY (`countryId`) REFERENCES `ast_Country_M`(`countryId`);



ALTER TABLE `ast_State_M` ADD CONSTRAINT FOREIGN KEY (`countryId`) REFERENCES `ast_Country_M`(`countryId`);



ALTER TABLE `ast_Region_M` ADD CONSTRAINT FOREIGN KEY (`stateId`) REFERENCES `ast_State_M`(`stateId`);



ALTER TABLE `ast_Region_M` ADD CONSTRAINT FOREIGN KEY (`countryId`) REFERENCES `ast_Country_M`(`countryId`);



ALTER TABLE `ast_District_M` ADD CONSTRAINT FOREIGN KEY (`stateId`) REFERENCES `ast_State_M`(`stateId`);



ALTER TABLE `ast_District_M` ADD CONSTRAINT FOREIGN KEY (`regionId`) REFERENCES `ast_Region_M`(`regionId`);



ALTER TABLE `ast_District_M` ADD CONSTRAINT FOREIGN KEY (`countryId`) REFERENCES `ast_Country_M`(`countryId`);



ALTER TABLE `ast_City_M` ADD CONSTRAINT FOREIGN KEY (`stateId`) REFERENCES `ast_State_M`(`stateId`);



ALTER TABLE `ast_City_M` ADD CONSTRAINT FOREIGN KEY (`countryId`) REFERENCES `ast_Country_M`(`countryId`);



ALTER TABLE `ast_Taluka_M` ADD CONSTRAINT FOREIGN KEY (`districtId`) REFERENCES `ast_District_M`(`districtId`);



ALTER TABLE `ast_Taluka_M` ADD CONSTRAINT FOREIGN KEY (`stateId`) REFERENCES `ast_State_M`(`stateId`);



ALTER TABLE `ast_Taluka_M` ADD CONSTRAINT FOREIGN KEY (`regionId`) REFERENCES `ast_Region_M`(`regionId`);



ALTER TABLE `ast_Taluka_M` ADD CONSTRAINT FOREIGN KEY (`countryId`) REFERENCES `ast_Country_M`(`countryId`);



ALTER TABLE `ast_Village_M` ADD CONSTRAINT FOREIGN KEY (`districtId`) REFERENCES `ast_District_M`(`districtId`);



ALTER TABLE `ast_Village_M` ADD CONSTRAINT FOREIGN KEY (`stateId`) REFERENCES `ast_State_M`(`stateId`);



ALTER TABLE `ast_Village_M` ADD CONSTRAINT FOREIGN KEY (`regionId`) REFERENCES `ast_Region_M`(`regionId`);



ALTER TABLE `ast_Village_M` ADD CONSTRAINT FOREIGN KEY (`talukaaId`) REFERENCES `ast_Taluka_M`(`talukaId`);



ALTER TABLE `ast_Village_M` ADD CONSTRAINT FOREIGN KEY (`countryId`) REFERENCES `ast_Country_M`(`countryId`);



ALTER TABLE `ast_Address_T` ADD CONSTRAINT FOREIGN KEY (`cityId`) REFERENCES `ast_City_M`(`cityId`);



ALTER TABLE `ast_Address_T` ADD CONSTRAINT FOREIGN KEY (`addressTypeId`) REFERENCES `ast_AddressType_M`(`addressTypeId`);



ALTER TABLE `ast_Address_T` ADD CONSTRAINT FOREIGN KEY (`stateId`) REFERENCES `ast_State_M`(`stateId`);



ALTER TABLE `ast_Address_T` ADD CONSTRAINT FOREIGN KEY (`countryId`) REFERENCES `ast_Country_M`(`countryId`);



ALTER TABLE `ast_AddressExtended_TP` ADD CONSTRAINT FOREIGN KEY (`villageId`) REFERENCES `ast_Village_M`(`villageId`);



ALTER TABLE `ast_AddressExtended_TP` ADD CONSTRAINT FOREIGN KEY (`districtId`) REFERENCES `ast_District_M`(`districtId`);



ALTER TABLE `ast_AddressExtended_TP` ADD CONSTRAINT FOREIGN KEY (`regionId`) REFERENCES `ast_Region_M`(`regionId`);



ALTER TABLE `ast_AddressExtended_TP` ADD CONSTRAINT FOREIGN KEY (`talukaId`) REFERENCES `ast_Taluka_M`(`talukaId`);



ALTER TABLE `ast_AddressExtended_TP` ADD CONSTRAINT FOREIGN KEY (`addressId`) REFERENCES `ast_Address_T`(`addressId`);



ALTER TABLE `ast_CommunicationType_M` ADD CONSTRAINT FOREIGN KEY (`commGroupId`) REFERENCES `ast_CommunicationGroup_M`(`commGroupId`);



ALTER TABLE `ast_CoreContacts_T` ADD CONSTRAINT FOREIGN KEY (`nativeLanguageCode`) REFERENCES `ast_Language_M`(`languageId`);



ALTER TABLE `ast_CoreContacts_T` ADD CONSTRAINT FOREIGN KEY (`titleId`) REFERENCES `ast_Title_M`(`titleId`);



ALTER TABLE `ast_CoreContacts_T` ADD CONSTRAINT FOREIGN KEY (`timeZone`) REFERENCES `ast_Timezone_M`(`timezoneId`);



ALTER TABLE `ast_CoreContacts_T` ADD CONSTRAINT FOREIGN KEY (`genderId`) REFERENCES `ast_Gender_M`(`genderId`);



ALTER TABLE `ast_AddressMap_B` ADD CONSTRAINT FOREIGN KEY (`contactId`) REFERENCES `ast_CoreContacts_T`(`contactId`);



ALTER TABLE `ast_AddressMap_B` ADD CONSTRAINT FOREIGN KEY (`addressId`) REFERENCES `ast_Address_T`(`addressId`);



ALTER TABLE `ast_CommunicationData_TP` ADD CONSTRAINT FOREIGN KEY (`commGroupId`) REFERENCES `ast_CommunicationGroup_M`(`commGroupId`);



ALTER TABLE `ast_CommunicationData_TP` ADD CONSTRAINT FOREIGN KEY (`commType`) REFERENCES `ast_CommunicationType_M`(`commType`);



ALTER TABLE `ast_CommunicationMap_B` ADD CONSTRAINT FOREIGN KEY (`contactId`) REFERENCES `ast_CoreContacts_T`(`contactId`);



ALTER TABLE `ast_CommunicationMap_B` ADD CONSTRAINT FOREIGN KEY (`commDataId`) REFERENCES `ast_CommunicationData_TP`(`commDataId`);



ALTER TABLE `ast_User_T` ADD CONSTRAINT FOREIGN KEY (`userAccessDomainId`) REFERENCES `ast_UserAccessDomain_M`(`userAccessDomainId`);



ALTER TABLE `ast_User_T` ADD CONSTRAINT FOREIGN KEY (`userAccessLevelId`) REFERENCES `ast_UserAccessLevel_M`(`userAccessLevelId`);



ALTER TABLE `ast_Login_T` ADD CONSTRAINT FOREIGN KEY (`userId`) REFERENCES `ast_User_T`(`userId`);



ALTER TABLE `ast_Login_T` ADD CONSTRAINT FOREIGN KEY (`contactId`) REFERENCES `ast_CoreContacts_T`(`contactId`);



ALTER TABLE `ast_LoginSession_T` ADD CONSTRAINT FOREIGN KEY (`userId`) REFERENCES `ast_User_T`(`userId`);



ALTER TABLE `ast_UserAppState_T` ADD CONSTRAINT FOREIGN KEY (`AppSessionId`) REFERENCES `ast_LoginSession_T`(`AppSessionId`);



ALTER TABLE `ast_PassRecovery_TP` ADD CONSTRAINT FOREIGN KEY (`questionId`) REFERENCES `ast_Question_M`(`questionId`);



ALTER TABLE `ast_PassRecovery_TP` ADD CONSTRAINT FOREIGN KEY (`userId`) REFERENCES `ast_User_T`(`userId`);



ALTER TABLE `ast_UserData_TP` ADD CONSTRAINT FOREIGN KEY (`userId`) REFERENCES `ast_User_T`(`userId`);



ALTER TABLE `ast_RoleMenuBridge_TP` ADD CONSTRAINT FOREIGN KEY (`menuId`) REFERENCES `ast_AppMenus_M`(`menuId`);



ALTER TABLE `ast_RoleMenuBridge_TP` ADD CONSTRAINT FOREIGN KEY (`roleId`) REFERENCES `ast_Roles_T`(`roleId`);



ALTER TABLE `ast_UserRoleBridge_T` ADD CONSTRAINT FOREIGN KEY (`userId`) REFERENCES `ast_User_T`(`userId`);



ALTER TABLE `ast_UserRoleBridge_T` ADD CONSTRAINT FOREIGN KEY (`roleId`) REFERENCES `ast_Roles_T`(`roleId`);



ALTER TABLE `ast_AppCustomer_M` ADD CONSTRAINT FOREIGN KEY (`appCustomerCategory`) REFERENCES `ast_AppCustomerCategory_M`(`appcustCategoryId`);



ALTER TABLE `ast_AppCustomer_M` ADD CONSTRAINT FOREIGN KEY (`contactId`) REFERENCES `ast_CoreContacts_T`(`contactId`);



ALTER TABLE `ast_AppCustomer_M` ADD CONSTRAINT FOREIGN KEY (`appCustomerType`) REFERENCES `ast_AppCustomerType_M`(`appcustTypeId`);

