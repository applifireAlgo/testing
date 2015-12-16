DROP TABLE IF EXISTS `ast_Timezone_M`;

CREATE TABLE `ast_Timezone_M` ( `timeZoneId` VARCHAR(64) NOT NULL, `utcdifference` INT(11) NOT NULL, `gmtLabel` VARCHAR(256) NULL DEFAULT NULL, `timeZoneLabel` VARCHAR(256) NULL DEFAULT NULL, `country` VARCHAR(256) NULL DEFAULT NULL, `cities` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`timeZoneId`));

DROP TABLE IF EXISTS `ast_Language_M`;

CREATE TABLE `ast_Language_M` ( `languageId` VARCHAR(64) NOT NULL, `language` VARCHAR(256) NOT NULL, `languageType` VARCHAR(32) NULL DEFAULT NULL, `languageDescription` VARCHAR(256) NULL DEFAULT NULL, `languageIcon` VARCHAR(128) NULL DEFAULT NULL, `alpha2` VARCHAR(2) NULL DEFAULT NULL, `alpha3` VARCHAR(3) NULL DEFAULT NULL, `alpha4` VARCHAR(4) NULL DEFAULT NULL, `alpha4parentid` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`languageId`));

DROP TABLE IF EXISTS `ast_Country_M`;

CREATE TABLE `ast_Country_M` ( `countryId` VARCHAR(64) NOT NULL, `countryName` VARCHAR(128) NOT NULL, `countryCode1` VARCHAR(3) NULL DEFAULT NULL, `countryCode2` VARCHAR(3) NULL DEFAULT NULL, `countryFlag` VARCHAR(64) NULL DEFAULT NULL, `capital` VARCHAR(32) NULL DEFAULT NULL, `currencyCode` VARCHAR(3) NULL DEFAULT NULL, `currencyName` VARCHAR(128) NULL DEFAULT NULL, `currencySymbol` VARCHAR(32) NULL DEFAULT NULL, `capitalLatitude` INT(11) NULL DEFAULT NULL, `capitalLongitude` INT(11) NULL DEFAULT NULL, `isoNumeric` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`countryId`));

DROP TABLE IF EXISTS `ast_Currency_M`;

CREATE TABLE `ast_Currency_M` ( `currencyId` VARCHAR(64) NOT NULL, `countryId` VARCHAR(64) NOT NULL, `currencyCode` VARCHAR(128) NULL DEFAULT NULL, `unicodeDecimal` VARCHAR(128) NULL DEFAULT NULL, `unicodeHex` VARCHAR(128) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`currencyId`));

DROP TABLE IF EXISTS `ast_State_M`;

CREATE TABLE `ast_State_M` ( `stateId` VARCHAR(64) NOT NULL, `countryId` VARCHAR(64) NOT NULL, `stateName` VARCHAR(256) NOT NULL, `stateCode` INT(2) NULL DEFAULT NULL, `stateCodeChar2` VARCHAR(32) NOT NULL, `stateCodeChar3` VARCHAR(32) NULL DEFAULT NULL, `stateDescription` VARCHAR(256) NULL DEFAULT NULL, `stateFlag` VARCHAR(128) NULL DEFAULT NULL, `stateCapital` VARCHAR(128) NULL DEFAULT NULL, `stateCapitalLatitude` INT(11) NULL DEFAULT NULL, `stateCapitalLongitude` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`stateId`));

DROP TABLE IF EXISTS `ast_Region_M`;

CREATE TABLE `ast_Region_M` ( `regionId` VARCHAR(64) NOT NULL, `countryId` VARCHAR(64) NOT NULL, `stateId` VARCHAR(64) NOT NULL, `regionName` VARCHAR(256) NOT NULL, `regionCode1` INT(3) NOT NULL, `regionCodeChar2` VARCHAR(32) NOT NULL, `regionDescription` VARCHAR(256) NULL DEFAULT NULL, `regionFlag` VARCHAR(128) NULL DEFAULT NULL, `regionLatitude` INT(11) NULL DEFAULT NULL, `regionLongitude` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`regionId`));

DROP TABLE IF EXISTS `ast_District_M`;

CREATE TABLE `ast_District_M` ( `districtId` VARCHAR(64) NOT NULL, `countryId` VARCHAR(64) NOT NULL, `stateId` VARCHAR(64) NOT NULL, `regionId` VARCHAR(64) NOT NULL, `Name` VARCHAR(256) NOT NULL, `code2` VARCHAR(32) NOT NULL, `districtDescription` VARCHAR(128) NULL DEFAULT NULL, `districtFlag` VARCHAR(128) NULL DEFAULT NULL, `districtLatitude` INT(11) NULL DEFAULT NULL, `districtLongitude` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`districtId`));

DROP TABLE IF EXISTS `ast_City_M`;

CREATE TABLE `ast_City_M` ( `cityId` VARCHAR(64) NOT NULL, `countryId` VARCHAR(64) NOT NULL, `stateId` VARCHAR(64) NOT NULL, `cityName` VARCHAR(256) NOT NULL, `cityCodeChar2` VARCHAR(32) NOT NULL, `cityCode` INT(3) NOT NULL, `cityDescription` VARCHAR(128) NULL DEFAULT NULL, `cityFlag` VARCHAR(128) NULL DEFAULT NULL, `cityLatitude` INT(11) NULL DEFAULT NULL, `cityLongitude` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`cityId`));

DROP TABLE IF EXISTS `ast_Taluka_M`;

CREATE TABLE `ast_Taluka_M` ( `talukaId` VARCHAR(64) NOT NULL, `countryId` VARCHAR(64) NOT NULL, `stateId` VARCHAR(64) NOT NULL, `regionId` VARCHAR(64) NOT NULL, `districtId` VARCHAR(64) NOT NULL, `talukaName` VARCHAR(256) NOT NULL, `talukaCode` VARCHAR(32) NOT NULL, `talukaDescription` VARCHAR(128) NULL DEFAULT NULL, `talukaFlag` VARCHAR(128) NULL DEFAULT NULL, `talukaLatitude` INT(11) NULL DEFAULT NULL, `talukaLongitude` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`talukaId`));

DROP TABLE IF EXISTS `ast_Village_M`;

CREATE TABLE `ast_Village_M` ( `villageId` VARCHAR(64) NOT NULL, `villageName` VARCHAR(256) NOT NULL, `villageDescription` VARCHAR(256) NULL DEFAULT NULL, `villageFlag` VARCHAR(64) NULL DEFAULT NULL, `countryId` VARCHAR(64) NOT NULL, `stateId` VARCHAR(64) NOT NULL, `regionId` VARCHAR(64) NOT NULL, `districtId` VARCHAR(64) NOT NULL, `talukaaId` VARCHAR(64) NOT NULL, `villageCode` VARCHAR(32) NOT NULL, `villageLatitude` VARCHAR(11) NULL DEFAULT NULL, `villageLongtitude` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`villageId`));

DROP TABLE IF EXISTS `ast_AddressType_M`;

CREATE TABLE `ast_AddressType_M` ( `addressTypeId` VARCHAR(64) NOT NULL, `addressType` VARCHAR(128) NOT NULL, `addressTypeDesc` VARCHAR(256) NULL DEFAULT NULL, `addressTypeIcon` VARCHAR(128) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`addressTypeId`));

DROP TABLE IF EXISTS `ast_Address_T`;

CREATE TABLE `ast_Address_T` ( `addressId` VARCHAR(64) NOT NULL, `addressTypeId` VARCHAR(64) NOT NULL, `addressLabel` VARCHAR(11) NULL DEFAULT NULL, `address1` VARCHAR(256) NULL DEFAULT NULL, `address2` VARCHAR(256) NULL DEFAULT NULL, `address3` VARCHAR(256) NULL DEFAULT NULL, `countryId` VARCHAR(64) NOT NULL, `stateId` VARCHAR(64) NOT NULL, `cityId` VARCHAR(64) NOT NULL, `zipcode` VARCHAR(6) NOT NULL, `latitude` VARCHAR(64) NULL DEFAULT NULL, `longitude` VARCHAR(64) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`addressId`));

DROP TABLE IF EXISTS `ast_AddressExtended_TP`;

CREATE TABLE `ast_AddressExtended_TP` ( `addExtId` VARCHAR(64) NOT NULL, `addressId` VARCHAR(64) NOT NULL, `villageId` VARCHAR(64) NOT NULL, `talukaId` VARCHAR(64) NOT NULL, `districtId` VARCHAR(64) NOT NULL, `regionId` VARCHAR(64) NOT NULL, `villageName` VARCHAR(128) NOT NULL, `talukaName` VARCHAR(128) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`addExtId`));

DROP TABLE IF EXISTS `ast_ContactType_M`;

CREATE TABLE `ast_ContactType_M` ( `contactTypeId` VARCHAR(64) NOT NULL, `contactType` VARCHAR(128) NOT NULL, `contactTypeDesc` VARCHAR(256) NULL DEFAULT NULL, `contactTypeIcon` VARCHAR(128) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`contactTypeId`));

DROP TABLE IF EXISTS `ast_CommunicationGroup_M`;

CREATE TABLE `ast_CommunicationGroup_M` ( `commGroupId` VARCHAR(64) NOT NULL, `commGroupName` VARCHAR(128) NOT NULL, `commGroupDescription` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`commGroupId`));

DROP TABLE IF EXISTS `ast_CommunicationType_M`;

CREATE TABLE `ast_CommunicationType_M` ( `commType` VARCHAR(64) NOT NULL, `commTypeName` VARCHAR(128) NOT NULL, `commTypeDescription` VARCHAR(256) NULL DEFAULT NULL, `commGroupId` VARCHAR(64) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`commType`));

DROP TABLE IF EXISTS `ast_Gender_M`;

CREATE TABLE `ast_Gender_M` ( `genderId` VARCHAR(64) NOT NULL, `gender` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`genderId`));

DROP TABLE IF EXISTS `ast_Title_M`;

CREATE TABLE `ast_Title_M` ( `titleId` VARCHAR(64) NOT NULL, `titles` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`titleId`));

DROP TABLE IF EXISTS `ast_CoreContacts_T`;

CREATE TABLE `ast_CoreContacts_T` ( `contactId` VARCHAR(64) NOT NULL, `titleId` VARCHAR(64) NOT NULL, `firstName` VARCHAR(256) NOT NULL, `middleName` VARCHAR(256) NULL DEFAULT NULL, `lastName` VARCHAR(256) NOT NULL, `nativeLanguageCode` VARCHAR(64) NULL DEFAULT NULL, `nativeTitle` VARCHAR(128) NULL DEFAULT NULL, `nativeFirstName` VARCHAR(256) NULL DEFAULT NULL, `nativeMiddleName` VARCHAR(256) NULL DEFAULT NULL, `nativeLastName` VARCHAR(256) NULL DEFAULT NULL, `genderId` VARCHAR(64) NOT NULL, `dateofbirth` DATE NULL DEFAULT NULL, `age` INT(11) NULL DEFAULT NULL, `approximateDOB` DATE NULL DEFAULT NULL, `emailId` VARCHAR(256) NOT NULL, `phoneNumber` VARCHAR(20) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `timeZone` VARCHAR(64) NULL DEFAULT NULL, `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`contactId`));

DROP TABLE IF EXISTS `ast_AddressMap_B`;

CREATE TABLE `ast_AddressMap_B` ( `addMapId` INT(11) NOT NULL AUTO_INCREMENT, `contactId` VARCHAR(64) NOT NULL, `addressId` VARCHAR(64) NOT NULL, PRIMARY KEY (`addMapId`));

DROP TABLE IF EXISTS `ast_CommunicationData_TP`;

CREATE TABLE `ast_CommunicationData_TP` ( `commDataId` VARCHAR(64) NOT NULL, `commGroupId` VARCHAR(64) NOT NULL, `commType` VARCHAR(64) NOT NULL, `commData` TEXT NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`commDataId`));

DROP TABLE IF EXISTS `ast_CommunicationMap_B`;

CREATE TABLE `ast_CommunicationMap_B` ( `commMapId` INT(11) NOT NULL AUTO_INCREMENT, `contactId` VARCHAR(64) NOT NULL, `commDataId` VARCHAR(64) NOT NULL, PRIMARY KEY (`commMapId`));

DROP TABLE IF EXISTS `ast_PasswordAlgo_M`;

CREATE TABLE `ast_PasswordAlgo_M` ( `algoId` VARCHAR(64) NOT NULL, `algorithm` INT(11) NOT NULL, `algoName` VARCHAR(256) NOT NULL, `algoDescription` VARCHAR(256) NULL DEFAULT NULL, `algoIcon` VARCHAR(64) NULL DEFAULT NULL, `algoHelp` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`algoId`));

DROP TABLE IF EXISTS `ast_PasswordPolicy_M`;

CREATE TABLE `ast_PasswordPolicy_M` ( `policyId` VARCHAR(64) NOT NULL, `policyName` VARCHAR(256) NOT NULL, `policyDescription` VARCHAR(512) NULL DEFAULT NULL, `maxPwdLength` INT(11) NULL DEFAULT NULL, `minPwdLength` INT(11) NOT NULL, `minCapitalLetters` INT(11) NULL DEFAULT NULL, `minSmallLetters` INT(11) NULL DEFAULT NULL, `minNumericValues` INT(11) NULL DEFAULT NULL, `minSpecialLetters` INT(11) NULL DEFAULT NULL, `allowedSpecialLetters` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`policyId`));

DROP TABLE IF EXISTS `ast_Question_M`;

CREATE TABLE `ast_Question_M` ( `questionId` VARCHAR(64) NOT NULL, `levelid` INT(11) NOT NULL, `question` VARCHAR(256) NOT NULL, `questionDetails` TEXT NULL DEFAULT NULL, `questionIcon` VARCHAR(64) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`questionId`));

DROP TABLE IF EXISTS `ast_UserAccessLevel_M`;

CREATE TABLE `ast_UserAccessLevel_M` ( `userAccessLevelId` VARCHAR(64) NOT NULL, `userAccessLevel` INT(11) NOT NULL, `levelName` VARCHAR(256) NOT NULL, `levelDescription` VARCHAR(256) NOT NULL, `levelHelp` VARCHAR(2048) NULL DEFAULT NULL, `levelIcon` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`userAccessLevelId`), UNIQUE KEY (`userAccessLevel`));

DROP TABLE IF EXISTS `ast_UserAccessDomain_M`;

CREATE TABLE `ast_UserAccessDomain_M` ( `userAccessDomainId` VARCHAR(64) NOT NULL, `userAccessDomain` INT(11) NOT NULL, `domainName` VARCHAR(256) NOT NULL, `domainDescription` VARCHAR(256) NOT NULL, `domainHelp` VARCHAR(2048) NULL DEFAULT NULL, `domainIcon` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`userAccessDomainId`), UNIQUE KEY (`userAccessDomain`));

DROP TABLE IF EXISTS `ast_User_T`;

CREATE TABLE `ast_User_T` ( `userId` VARCHAR(64) NOT NULL, `userAccessCode` INT(11) NULL DEFAULT NULL, `userAccessLevelId` VARCHAR(64) NULL DEFAULT NULL, `userAccessDomainId` VARCHAR(64) NULL DEFAULT NULL, `multiFactorAuthEnabled` INT(1) NULL DEFAULT NULL, `genTempOneTimePassword` INT(1) NULL DEFAULT NULL, `allowMultipleLogin` INT(1) NULL DEFAULT NULL, `isLocked` INT(1) NULL DEFAULT NULL, `isDeleted` INT(1) NULL DEFAULT NULL, `changePasswordNextLogin` INT(1) NULL DEFAULT NULL, `passwordExpiryDate` TIMESTAMP NULL DEFAULT NULL, `passwordAlgo` VARCHAR(64) NULL DEFAULT '1', `lastPasswordChangeDate` TIMESTAMP NULL DEFAULT NULL, `sessionTimeout` INT(11) NULL DEFAULT '1800', `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`userId`));

DROP TABLE IF EXISTS `ast_Login_T`;

CREATE TABLE `ast_Login_T` ( `loginPk` VARCHAR(64) NOT NULL, `loginId` VARCHAR(200) NOT NULL, `serverAuthImage` VARCHAR(64) NULL DEFAULT NULL, `serverAuthText` VARCHAR(32) NULL DEFAULT NULL, `userId` VARCHAR(64) NOT NULL, `contactId` VARCHAR(64) NOT NULL, `failedLoginAttempts` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`loginPk`));

DROP TABLE IF EXISTS `ast_LoginSession_T`;

CREATE TABLE `ast_LoginSession_T` ( `AppSessionId` VARCHAR(256) NOT NULL, `userId` VARCHAR(64) NOT NULL, `AppServerSessionId` VARCHAR(256) NOT NULL, `loginTime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, `lastAccessTime` TIMESTAMP NULL, `logoutTime` TIMESTAMP NULL, `clientIPAddress` VARCHAR(128) NOT NULL, `clientIPAddressInt` BIGINT NULL DEFAULT NULL, `clientNetworkAddress` INT(11) NULL DEFAULT NULL, `clientBrowser` VARCHAR(256) NOT NULL, `sessionData` TEXT NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`AppSessionId`));

DROP TABLE IF EXISTS `ast_UserAppState_T`;

CREATE TABLE `ast_UserAppState_T` ( `appStateId` VARCHAR(64) NOT NULL, `AppSessionId` VARCHAR(256) NOT NULL, `TabId` VARCHAR(11) NOT NULL, `isActive` INT(11) NOT NULL DEFAULT '0', `sessionDataType` VARCHAR(11) NULL DEFAULT NULL, `sessionData` VARCHAR(4000) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`appStateId`));

DROP TABLE IF EXISTS `ast_PassRecovery_TP`;

CREATE TABLE `ast_PassRecovery_TP` ( `passRecoveryId` VARCHAR(64) NOT NULL, `userId` VARCHAR(64) NOT NULL, `questionId` VARCHAR(64) NOT NULL, `answer` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`passRecoveryId`));

DROP TABLE IF EXISTS `ast_UserData_TP`;

CREATE TABLE `ast_UserData_TP` ( `userDataId` VARCHAR(64) NOT NULL, `userId` VARCHAR(64) NOT NULL, `password` VARCHAR(512) NOT NULL, `oneTimePassword` VARCHAR(32) NULL DEFAULT NULL, `oneTimePasswordExpiry` INT(11) NULL DEFAULT NULL, `oneTimePasswordGenDate` TIMESTAMP NULL DEFAULT NULL, `last5Passwords` VARCHAR(500) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`userDataId`));

DROP TABLE IF EXISTS `ast_SessionData_T`;

CREATE TABLE `ast_SessionData_T` ( `dataId` VARCHAR(256) NOT NULL, `customerId` VARCHAR(64) NOT NULL, `userId` VARCHAR(64) NOT NULL, `sessionKey` VARCHAR(64) NOT NULL, `dataType` INT(10) NOT NULL, `numberValue` INT(10) NULL DEFAULT NULL, `dateTimeValue` TIMESTAMP NULL DEFAULT NULL, `stringValue` VARCHAR(64) NULL DEFAULT NULL, `booleanValue` TINYINT(1) NULL DEFAULT NULL, `jsonValue` TEXT NULL DEFAULT NULL, `appSessionId` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`dataId`));

DROP TABLE IF EXISTS `ast_Roles_T`;

CREATE TABLE `ast_Roles_T` ( `roleId` VARCHAR(64) NOT NULL, `RoleName` VARCHAR(256) NOT NULL, `RoleDescription` VARCHAR(256) NOT NULL, `RoleIcon` VARCHAR(64) NULL DEFAULT NULL, `roleHelp` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`roleId`));

DROP TABLE IF EXISTS `ast_AppMenus_M`;

CREATE TABLE `ast_AppMenus_M` ( `menuId` VARCHAR(64) NOT NULL, `menuTreeId` VARCHAR(256) NOT NULL, `menuIcon` VARCHAR(256) NOT NULL, `menuAction` VARCHAR(256) NOT NULL, `menuCommands` VARCHAR(64) NOT NULL, `menuDisplay` TINYINT(1) NOT NULL, `menuHead` TINYINT(1) NOT NULL, `menuLabel` VARCHAR(256) NOT NULL, `uiType` VARCHAR(3) NOT NULL, `RefObjectId` VARCHAR(256) NULL DEFAULT NULL, `menuAccessRights` INT(11) NOT NULL, `appType` INT(1) NULL DEFAULT NULL, `appId` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`menuId`));

DROP TABLE IF EXISTS `ast_RoleMenuBridge_TP`;

CREATE TABLE `ast_RoleMenuBridge_TP` ( `roleMenuMapId` VARCHAR(64) NOT NULL, `roleId` VARCHAR(64) NOT NULL, `menuId` VARCHAR(64) NOT NULL, `isRead` TINYINT(1) NOT NULL, `isWrite` TINYINT(1) NOT NULL, `isExecute` TINYINT(1) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`roleMenuMapId`));

DROP TABLE IF EXISTS `ast_UserRoleBridge_T`;

CREATE TABLE `ast_UserRoleBridge_T` ( `roleUserMapId` VARCHAR(64) NOT NULL, `roleId` VARCHAR(64) NOT NULL, `userId` VARCHAR(64) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`roleUserMapId`));

DROP TABLE IF EXISTS `ast_AppCustomerType_M`;

CREATE TABLE `ast_AppCustomerType_M` ( `appcustTypeId` VARCHAR(64) NOT NULL, `customerType` VARCHAR(256) NOT NULL, `defaults` INT(10) NULL DEFAULT NULL, `sequenceId` INT(10) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`appcustTypeId`));

DROP TABLE IF EXISTS `ast_AppCustomerCategory_M`;

CREATE TABLE `ast_AppCustomerCategory_M` ( `appcustCategoryId` VARCHAR(64) NOT NULL, `customerCategory` VARCHAR(256) NOT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`appcustCategoryId`));

DROP TABLE IF EXISTS `ast_AppCustomer_M`;

CREATE TABLE `ast_AppCustomer_M` ( `appCustomerId` VARCHAR(64) NOT NULL, `customerName` VARCHAR(256) NOT NULL, `contactId` VARCHAR(64) NOT NULL, `appCustomerType` VARCHAR(64) NOT NULL, `appCustomerCategory` VARCHAR(64) NOT NULL, `deploymentModel` TINYINT(1) NOT NULL DEFAULT '1', `customerStatus` INT(10) NOT NULL DEFAULT '1', `userRequested` INT(10) NOT NULL DEFAULT '1', `evalTimePeriod` INT(10) NOT NULL DEFAULT '60', `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` DATETIME NULL DEFAULT '1900-01-01', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` DATETIME NULL DEFAULT '1900-01-01', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`appCustomerId`));

