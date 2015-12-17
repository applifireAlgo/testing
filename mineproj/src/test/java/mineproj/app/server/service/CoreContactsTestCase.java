package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.CoreContactsRepository;
import mineproj.app.shared.contacts.CoreContacts;
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
import mineproj.app.shared.contacts.Gender;
import mineproj.app.server.repository.GenderRepository;
import mineproj.app.shared.location.Language;
import mineproj.app.server.repository.LanguageRepository;
import mineproj.app.shared.location.Timezone;
import mineproj.app.server.repository.TimezoneRepository;
import mineproj.app.shared.contacts.Title;
import mineproj.app.server.repository.TitleRepository;
import mineproj.app.shared.contacts.CommunicationData;
import mineproj.app.shared.contacts.CommunicationGroup;
import mineproj.app.server.repository.CommunicationGroupRepository;
import mineproj.app.shared.contacts.CommunicationType;
import mineproj.app.server.repository.CommunicationTypeRepository;
import mineproj.app.shared.location.Address;
import mineproj.app.server.repository.AddressRepository;
import mineproj.app.shared.location.AddressType;
import mineproj.app.server.repository.AddressTypeRepository;
import mineproj.app.shared.location.City;
import mineproj.app.server.repository.CityRepository;
import mineproj.app.shared.location.Country;
import mineproj.app.server.repository.CountryRepository;
import mineproj.app.shared.location.State;
import mineproj.app.server.repository.StateRepository;

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
            gender.setGender("BXxuADCGfwWUomTV2GtVpU4tiO0NkCHnfta9fdpp1NVNYyRELd");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("y2");
            language.setAlpha3("pwO");
            language.setAlpha4("h6Jw");
            language.setAlpha4parentid(9);
            language.setLanguage("8S5xV9DkQG2ujrSQNM1hJYMRCr1CCsAJ88WIu1gQ7HCYLYFYOI");
            language.setLanguageDescription("vAlPGe9JhgYWU5bedKWQfaNSd7UaLfyS7MqWItwVFZ7HLGfpJu");
            language.setLanguageIcon("TarwF2iZGaUr4Hh6WJAL4r1yn498PBpP1msK3aVRlpU1IxE6Fj");
            language.setLanguageType("Q1x6Lsss0j4oDsMmcTyVjp3fyh6h9XTJ");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("jOwJXzOGl5XuMVp0IrEv7OWtgv2utumxSMLRDX9ckrlkgkwDbS");
            timezone.setCountry("JugZyEuwjtxQV89MqFDtgLckdqnUBNcHZFQdjlJz7os3bQdn26");
            timezone.setGmtLabel("RxP10ChAPzVXYORTlKZqC1ItmnAWK7Pilbreb25x2XYeD9k7tW");
            timezone.setTimeZoneLabel("DgPyVHhacozMVIbayC0n1vQ46SmiqqgShpRCIbBphc5h4THtmD");
            timezone.setUtcdifference(0);
            Title title = new Title();
            title.setTitles("uLvRRvRc7BESbzX17jtwaRPCwRFmgI4rYn2OhHeNa8ryKj0nid");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(57);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("WywTwQ6gHzdTgks8ZPPs95DEa4CfP7VXkzZEiRa21ECURsJJma");
            corecontacts.setFirstName("U6g4uwtEr7hc0R6Fp3LPVvXsBuWiUHRhxufyYgbeNT5kp49EzW");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("k0GSifH94aaTl58OxY76Vax5ATTwwVxY6HmXIIi0egQjKOgzrg");
            corecontacts.setMiddleName("NZ7tziOqKuIqKups6tbQShQELXHe8nGB6yxa63nr5v2xvlFu3P");
            corecontacts.setNativeFirstName("VXo9G26riOizX3PBFVt7YJnkxJ3atjoe4Qq7rxCvziAoJaxIzn");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("T5zt7fMRzf572qxoewn9luAog8NEY1hDZ460atVAYqf1n8ePKh");
            corecontacts.setNativeMiddleName("CwPu4Py2dwkVp3yBt8INtrN0KCaKq0gfEH9X993WQ1gOH5p6Fy");
            corecontacts.setNativeTitle("h6ZetulXO8X9zEtrJaAw3AOUwL5mUQmEmx18MBcZkhZMHRTHDX");
            corecontacts.setPhoneNumber("5cEgIGFrRDRbOsIsxWxJ");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
            CommunicationData communicationdata = new CommunicationData();
            communicationdata.setCommData("stH");
            CommunicationGroup communicationgroup = new CommunicationGroup();
            communicationgroup.setCommGroupDescription("ZxMSqvSYahgNnMTlGTHCv4MdjSUrqqSu2tDcBOwc3W1WDbaSMk");
            communicationgroup.setCommGroupName("Rd8ZJ2FeiLnJOydVjTHmKfmTSMXmEcUwBBtp8mdxRwemRylAB8");
            CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
            map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
            CommunicationType communicationtype = new CommunicationType();
            communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationtype.setCommTypeDescription("8GB4AMkahZJ71VKJ9cB3379nN6jQHzmenUz1y9KxbZmJy4nkqw");
            communicationtype.setCommTypeName("6FO5Zv5f6gjZlOgcittXgrMYP0EAzzC4NPjxOLIiVIECud9BHw");
            CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
            map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
            communicationdata.setCommData("aTa");
            communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
            communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            listOfCommunicationData.add(communicationdata);
            corecontacts.addAllCommunicationData(listOfCommunicationData);
            java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
            Address address = new Address();
            address.setAddress1("jhw2C18XapJsHSZxKKIRILwoveVdmYeVlhC1zMbhRB7NTgpaS7");
            address.setAddress2("IaHm3r9rrlvL9KUmTqNzCmnnSLrZKND2j6BUVXP29JzAteSE5L");
            address.setAddress3("M7QL7AQL5piiSX10ixkhiZmMyZSMlTlctjoakkWT14Yi1PLQzo");
            address.setAddressLabel("l72UF0iHCYQ");
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("mKJEF3JRuteFwdKdbhSOXGk5AJtx9Fz7xxN2cCk664dawIwTQW");
            addresstype.setAddressTypeDesc("Y3TuzmrUZcIk1KrNNtJ1AxuU0svB3ZnePfAz66faHuhXlEBLLZ");
            addresstype.setAddressTypeIcon("Qa65qFPThFCjj1Lu1qtrv6FBwPg6clClpbwS9mP3urTcCuf7vc");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(2);
            city.setCityCodeChar2("MBHZmxpdXeKEyK5GgucKKwiPAvCI1Byl");
            city.setCityDescription("EAe0WPxnaPgxUIAS2WRsegQ8OMAIIme1RVRGfRCwYRNBkNIdod");
            city.setCityFlag("BfXcKsf3bmZksO6JQ3GQM4GeBxexI6prJAgMVVehMN7GQX8Dmu");
            city.setCityLatitude(6);
            city.setCityLongitude(7);
            city.setCityName("HqkDHkxUnHGnH1WyBIFivtkJnYQMZXuv2VUbG5wnU2mVTpSixw");
            Country country = new Country();
            country.setCapital("04VpqRwVGQDzr3maaqLoVYerX0FbWEbJ");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(1);
            country.setCountryCode1("Qyc");
            country.setCountryCode2("QyH");
            country.setCountryFlag("vDWaMlaj1hLQIpELjT2yozGUELQC36705sCOAi3PhZgesi6nOr");
            country.setCountryName("EfWYfs7f4ES0nUQ3IBQW2MMpvXWp3qTSWoF6SjirbthhRuPaHG");
            country.setCurrencyCode("CX4");
            country.setCurrencyName("7JEMhuOkdNEuqRM5UKN91Rb8X5VzAnScCxlE0t1zfXGKNPannV");
            country.setCurrencySymbol("QMttk7R8Xsgp7ekgGlFKllsoISFzzBer");
            country.setIsoNumeric(6);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("XKd64XCR651Cf1OVAj4y66FlhwRHJ25ZLbNTWaTZ8TnBbzytVC");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(11);
            state.setStateCode(1);
            state.setStateCodeChar2("xfXmFwZHnwlR9i3LK30JPf5w8WttX8sr");
            state.setStateCodeChar3("0hG6k8R14QR6vb2QffjX2RtzaZedzXpc");
            state.setStateDescription("RAw8gW1WQtDC2PDrIsDJfT7i5GNVEhNSUb1mKwYCdsXNQcfEVJ");
            state.setStateFlag("N0xS9V5WimwGhm2eCXNoAJ8jPrLrhDF2fW6AFhA7DaZvuFj10k");
            state.setStateName("RLk6lurMkUNHWjN8o38sH7GfXrLYlNjfPT5dBxVqiaYVb1RbKN");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(2);
            city.setCityCodeChar2("QftLTvhEy0mbWQBWmVzTopRKLq2vn9EN");
            city.setCityDescription("gDLOTtYAmnwAF842XDXP2DPtHRM77ACinYnBXy48HocFaTjjJY");
            city.setCityFlag("nU56vm2p0FV4yJ6w6EshljYFblWjClUaEDBn5HxceXtl2Hgfdr");
            city.setCityLatitude(1);
            city.setCityLongitude(7);
            city.setCityName("BdEGZesYRTWrh4zqRaeIEdOxzsIY3dNh5FruUfqiXi7rQkO3q8");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            address.setAddress1("DHNe5utjOJTJgpWQdAl4l2A2jQqNPMkTFeDdD5FLD9iNZZuK5W");
            address.setAddress2("OR0fWhzA1hRg0zExqSEOwSdJ7ZzGoPg8SOIgKW6gGPZO2f1eGx");
            address.setAddress3("U0nzM2jbLOAhtTd3dFNYN2cZHCyVreolYvwJ9DW6p9qrwbVRQN");
            address.setAddressLabel("vpIJurChEAY");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("1nGr1KzEZ1JcpMOuKmxL1gUmGLqKxq9SJ7zLfGCP5HR68iO6kB");
            address.setLongitude("ckLKaIeobxxyrIs9vPZhODoUlAi1Ntq85quzI0AYxkrpn1pg80");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("vF7jxk");
            listOfAddress.add(address);
            corecontacts.addAllAddress(listOfAddress);
            corecontacts.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            corecontacts.setEntityValidator(entityValidator);
            corecontacts.isValid();
            corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            map.put("TimezonePrimaryKey", corecontacts.getTimezone()._getPrimarykey());
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
            corecontacts.setAge(50);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("NalCYlfV5oZsHcP077Vkc0tKkM07N55u1ateUEkjIkiVmyEs1I");
            corecontacts.setFirstName("DwkiLw0X39o6P0xJWzvukWsoqVlBWRB95MpKZMlQy74jubPDYG");
            corecontacts.setLastName("85NuDxPcgKzIANBfwt5GEPMqsCPqe6cuuPO31rGwAg9zG3S0yR");
            corecontacts.setMiddleName("AMYONYhMundMrEbaD5I2DgKZfiJXGvVU9tXXDApIu6Lav11ujv");
            corecontacts.setNativeFirstName("yND19iKSInEtAW1D3H1muOJyL4JB1qKFSkcJDCVosJg5D7xdy2");
            corecontacts.setNativeLastName("rxQf8beUVhmVR1O9GdkBfCbxbskY7aAakMzUj3O5FjU7BjyjPc");
            corecontacts.setNativeMiddleName("xwqDBm1LBe95UKoB5Rl8pF2f7XTj1aXZRc2tHizW4dE9y2jnRr");
            corecontacts.setNativeTitle("zA6CsxOPPPeK4rOWi9f244hEboTA3QfLcfcvAJmk5e1K0lMEtZ");
            corecontacts.setPhoneNumber("d2A6YHt3xT0ewqPZ3qAi");
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
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
