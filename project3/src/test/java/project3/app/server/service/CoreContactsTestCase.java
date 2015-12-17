package project3.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project3.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project3.app.server.repository.CoreContactsRepository;
import project3.app.shared.contacts.CoreContacts;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import project3.app.shared.contacts.Gender;
import project3.app.server.repository.GenderRepository;
import project3.app.shared.location.Language;
import project3.app.server.repository.LanguageRepository;
import project3.app.shared.location.Timezone;
import project3.app.server.repository.TimezoneRepository;
import project3.app.shared.contacts.Title;
import project3.app.server.repository.TitleRepository;
import project3.app.shared.contacts.CommunicationData;
import project3.app.shared.contacts.CommunicationGroup;
import project3.app.server.repository.CommunicationGroupRepository;
import project3.app.shared.contacts.CommunicationType;
import project3.app.server.repository.CommunicationTypeRepository;
import project3.app.shared.location.Address;
import project3.app.server.repository.AddressRepository;
import project3.app.shared.location.AddressType;
import project3.app.server.repository.AddressTypeRepository;
import project3.app.shared.location.City;
import project3.app.server.repository.CityRepository;
import project3.app.shared.location.Country;
import project3.app.server.repository.CountryRepository;
import project3.app.shared.location.State;
import project3.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CoreContactsTestCase {

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
    }

    @Test
    public void test1Save() {
        try {
            Gender gender = new Gender();
            gender.setGender("IRswqi9IlNKdo9gGZur7QwITLQJipatqCsvPsB1hf1ylLL0Zyi");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("Vg");
            language.setAlpha3("Ng3");
            language.setAlpha4("ok7G");
            language.setAlpha4parentid(1);
            language.setLanguage("O1rkeK3lOFCUsPyKIGJLOCfCshSqJzYgrXeSY0rzEuM8y1DzI2");
            language.setLanguageDescription("wRCQJxnm7Z9xl7fVHlVYBCGR7uoJL8J7Sn3maltXo7Q2O3fnkc");
            language.setLanguageIcon("6mWKgakash69jSAOswog5uGN3wPCV4uObSYLW1SH739IyRxstQ");
            language.setLanguageType("JDoR3l6y6E6zqPsy8LzfRK0BkHhT9BtB");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("xaKvRLZAZWZxELHPuB5ld2E1XM4W9otCR0yYULhnNRhLyQBHDW");
            timezone.setCountry("iFKGJzLNQZFzsgu9lqTLRGCH57pPqGVzvmGprUHGmSJjhowSZ0");
            timezone.setGmtLabel("Kh7ZIFQbUw1S7SWbUOLlfP0e4gJCFHwYMdWtzbi3RlqFhwbK5m");
            timezone.setTimeZoneLabel("FYnRxOudxVV11YCUf2psbiRhqkaEJF4mV3Bpafn4vfR7UQrd38");
            timezone.setUtcdifference(4);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("mPCPS4aVoDX6kwHA3RpW6vlebl8Td0DeSdA1J1d9dSyv8Jfz9Q");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(20);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("8Tx2AciToPloL7gIbGAeAyQDpLTLXIUiEYWWpLuhI4JTVCFonu");
            corecontacts.setFirstName("gsDMozqI1Ggwad9IhLtePsK6ByJ8k8RBH7EKwuKkN7vKvDq1Oj");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("468oBQMmd4nn1LJF3Pt1bVfy3dogZzUGXQ7HqlCUp2vcOex2Lb");
            corecontacts.setMiddleName("YEKPKvTcEB2ZPSrQmVaybepproqHN7cQffmWZxdM0T77fmpO0t");
            corecontacts.setNativeFirstName("9v3CH1YHDFywD8Zp11y80dU7jxGhGCTFjhOKL7dePESyCxsevz");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("xoiqTumbadoZGUkKctVw7ZUKLb6BIYIkjRGb71LLS2vwDws7ak");
            corecontacts.setNativeMiddleName("xhvLAG8pKwJybRcLir2hkdeYPR67yfxyrX8TEHUA9HJgoV4vVg");
            corecontacts.setNativeTitle("e29fSn6o1SdQHRWcla0bi0dVdRMkAod7FKK2vZMrEWP6bvEbAU");
            corecontacts.setPhoneNumber("xwE6oHrXuUUvPnIJgmIU");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("sjT");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("CcCf2GXsTHVPlV0uqcaZkpcsoDf825wGk9kKTTTqOaTLH1CSZG");
            communicationgroup.setCommGroupName("37FmndAfGMwi9vOjP9KfETEI3nE2VUpE86j4rnsXdsHhbrUhK5");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("FXaNZmqUjG9Qnf4hn6IqgwdjANqoiDZTAHDosxCE9WKEBOGUB4");
            communicationtype.setCommTypeName("38f4lQPYqWGeg6heIBb60HteM016cH0XbAR6cj40WwtDQWjtRm");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("IQR");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("Ygnn6Zn0RoIc5CZolF6LoCoIix48s48B73zjipPBRE4JXS44Q6");
            address.setAddress2("vbJtY64toswDDnV6CiyDH21BNSAsjN4oJ9xZya6cRP8t4i4u9L");
            address.setAddress3("wcZZJ6UlqG3ht1rWpD5JM7NueatYR4bY5Er4niiB29VApGShSl");
            address.setAddressLabel("a842wRZOMlw");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("0165qnXGKPJSBkJFygOsEpEmbb5dZTJtxPd5feQ0uHzKKRrOOB");
            addresstype.setAddressTypeDesc("09tAaciRpMkXeYpzE01w71vVcOXMQyYn3L1cchV5W7pHUgGB6R");
            addresstype.setAddressTypeIcon("uWb0VD6jGDL10jnYi60anaxvMnTujC2hoD8GsgKvoCeyGr7jbp");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("bPvh74iuk3bRbU3Y0iuNoYxcJYfqOJt5");
            city.setCityDescription("TFBaroVgMdxZT0c1L7tpfuHT9M4BbQ2ZuxVJLhQfRZPStwfEzE");
            city.setCityFlag("4KY7zKQD8BpV2cM6acbJY3cMnb7FGrkBPU6bMB98PwDYm3tTxZ");
            city.setCityLatitude(8);
            city.setCityLongitude(1);
            city.setCityName("0mrvKrsRyVewQZLeAuqiO2rEvYgw5WkbQrDw39lOSB6uJ7V0dz");
            Country country = new Country();
            country.setCapital("gKrRaKrzrySu2sz9OtcjpeZ6VIqmWEeJ");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(7);
            country.setCountryCode1("F2f");
            country.setCountryCode2("tMz");
            country.setCountryFlag("IWPGg4bS2EP1c51yFy5hgiK3HRRNKiT8d6y2nPYYeD64AyJ3hf");
            country.setCountryName("1hL7E6vXPEqhg2H3piZX0SjjCkaKnPHRUFF2sY63Kt2slaMO8x");
            country.setCurrencyCode("zG1");
            country.setCurrencyName("ADR98jzIXtjRJp5kYlNVMKiAxBMm4fPK4hDk9mWlpAuHRV9lVR");
            country.setCurrencySymbol("aDNLXzeGUMVRkqZWlcaJ38YPDHf97VXy");
            country.setIsoNumeric(0);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("EiKmzuZeo3qwFbymciREiJNYrNLrGnjUX2ekON76QOyWB4TuiA");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(2);
            state.setStateCode(1);
            state.setStateCodeChar2("7YprgduOKDajKmla7kIw9SWKv0eSWdVc");
            state.setStateCodeChar3("ap7f4HhiyXJVrDTqvtqVSuZEij2Z093V");
            state.setStateDescription("W9Db4nrUXwtP9xarOmI2fX3dldudzOCAhCWn74s0JODXEh5SMi");
            state.setStateFlag("bAkQGSiKWWRPupueKx8WHrSHU1VcEhYcpqITd6TQCK4zx2Fc0a");
            state.setStateName("2NHGID7PDuuFO0oasTP8ls32VM9e5Trwk8M6DRcFRjCwutb9Rz");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(1);
            city.setCityCodeChar2("hLvxDRrvL7DaQJjmaVr9PFQe8sVpbsCi");
            city.setCityDescription("HmCCsK5lvOrqyXzFZOSUwuMcCmjg8AQjlMLuerBFuUuFGOZggU");
            city.setCityFlag("ko087mvWpwQXoxq1kVtsc5D1osycPZDA7aqbxnlOmrScR1Wkag");
            city.setCityLatitude(2);
            city.setCityLongitude(0);
            city.setCityName("cuNZLtXeDcvfE2jFN7FH6AaHtWSTvrj7mm5FmfQLE56qX2vwD8");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("HQyllipnOcsdTKRkJTc3ejEis2qHniKlXDG1FoIy4QevceeCqw");
            address.setAddress2("kxQXrlynTVXMrGZ1YHmhmxrCMa4Y33BJKiCMo8Ox4TSB4It45F");
            address.setAddress3("doSIiGBL8WBvSmwr7IWrNAkgr4sL16MYS4D8QdcBGOs0S9fq3K");
            address.setAddressLabel("FzxiwBO8H4V");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("PppThLYLKkayn8SYszQ80GgY4DutEzsfV2jPG9Yx8BKCggFgmL");
            address.setLongitude("xYiyTaR3Ku3LXrzDtkGtIA39iLaRuKYHYAa2sJGD67izlKhh1V");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("8CJsBN");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            CoreContacts corecontacts = corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
            corecontacts.setAge(102);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("43bzAe1a6Mhe4f2aljUQcrGALC62Tk0VbXmE2LLTfKE1SJFTvy");
            corecontacts.setFirstName("5qOuWDKvKyZjCgRdQWodCP1NshJaBxOaLpdJa6iRpQ73Icu5P5");
            corecontacts.setLastName("vBlq6cZDgl4UqqvNhBEulDxiPCUsM4EtQU7km1lKng9ElCxuZZ");
            corecontacts.setMiddleName("5cBjkqdB0XIAqmgSQWFara1r8wSyya1I2V0nTvThx8N74AKQR9");
            corecontacts.setNativeFirstName("HKJer7vKPzQTCq5qLyOV6veuVD8vSCzyrztvy9D6oIcBxLDQw7");
            corecontacts.setNativeLastName("fbYvIQemYlPlMzbjSnvElTPnXQcM3qX4JN6hJR2aKsQdDJRb8O");
            corecontacts.setNativeMiddleName("zeWJckafGwQJKDIkdwk6v2BE2V7JXwld478nYQR2legKxX2eYZ");
            corecontacts.setNativeTitle("oWq8HoIwR67Uz5vwWkxfwMxUiunOZ0eWvhBuKgqYEUQROI9OtL");
            corecontacts.setPhoneNumber("VFy74ABYYUQeBjGPUmX3");
            corecontacts.setVersionId(1);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            corecontactsRepository.update(corecontacts);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.findById((java.lang.String) map.get("CoreContactsPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBygenderId() {
        try {
            java.util.List<CoreContacts> listofgenderId = corecontactsRepository.findByGenderId((java.lang.String) map.get("GenderPrimaryKey"));
            if (listofgenderId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBynativeLanguageCode() {
        try {
            java.util.List<CoreContacts> listofnativeLanguageCode = corecontactsRepository.findByNativeLanguageCode((java.lang.String) map.get("LanguagePrimaryKey"));
            if (listofnativeLanguageCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytimeZone() {
        try {
            java.util.List<CoreContacts> listoftimeZone = corecontactsRepository.findByTimeZone((java.lang.String) map.get("TimezonePrimaryKey"));
            if (listoftimeZone.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBytitleId() {
        try {
            java.util.List<CoreContacts> listoftitleId = corecontactsRepository.findByTitleId((java.lang.String) map.get("TitlePrimaryKey"));
            if (listoftitleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CoreContactsPrimaryKey"));
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey")); /* Deleting refrenced data */
            communicationtypeRepository.delete((java.lang.String) map.get("CommunicationTypePrimaryKey")); /* Deleting refrenced data */
            communicationgroupRepository.delete((java.lang.String) map.get("CommunicationGroupPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            timezoneRepository.delete((java.lang.String) map.get("TimezonePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
