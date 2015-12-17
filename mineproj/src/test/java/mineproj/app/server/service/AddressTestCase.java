package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.AddressRepository;
import mineproj.app.shared.location.Address;
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
public class AddressTestCase {

    @Autowired
    private AddressRepository<Address> addressRepository;

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
            AddressType addresstype = new AddressType();
            addresstype.setAddressType("zq325LqHO0RmFF6jKJLZOkdYO3Lgt1yzuOp7waDPRzOCFSfkVM");
            addresstype.setAddressTypeDesc("0vSZnCOisF7woy7UILIpfSlKLRTxYWeN6NFc5XdJZTCYltSvU5");
            addresstype.setAddressTypeIcon("CYPOVi4XvyrmJrPnEAOtXVNlN8qpaLV57fILRjkPhyvhU55gL7");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(1);
            city.setCityCodeChar2("CYPfgOt7cCm4ldQibVTsRY5azjVQwrwd");
            city.setCityDescription("D8qAhrMD4FCpoGZhm1K7pnR1yVthulurk2Kr4eYl7l24ISGJyF");
            city.setCityFlag("q8efjPS7znhRINwYvNlA6dEeMXX4J3ThTMO5bYURroNosTZ0sr");
            city.setCityLatitude(0);
            city.setCityLongitude(2);
            city.setCityName("GVXQWcZoLmBZYf61nWacamxmUhoBbeljvjHZ6aoWIqXuVJI5Pc");
            Country country = new Country();
            country.setCapital("F9m1V20OvKHWxILU1KWC87FqSTC9dBqE");
            country.setCapitalLatitude(10);
            country.setCapitalLongitude(2);
            country.setCountryCode1("lu4");
            country.setCountryCode2("LkT");
            country.setCountryFlag("UAbq6uazLLZDgn3t7LTBIdqNTfpsnHpRqxWSrX9eTAP1PBJP1q");
            country.setCountryName("IDKLXEsy9iPUtRj2GnBwjnSqHCblkPFByWDmppVrPF29HQndKv");
            country.setCurrencyCode("YT2");
            country.setCurrencyName("aW9x8C9qvEiVZjhRRCsLcNHajausZkPbCljxfS3SNHaUsZiswv");
            country.setCurrencySymbol("tvofwBQ0SCoErGrWNhOmRSmudcJSghNb");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("T6C7h4e8rYLT9QVgFZ27GusvzniYMfIVgZcbDINDEilN8pI59J");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(7);
            state.setStateCode(0);
            state.setStateCodeChar2("3ZyoppBBu9UJEHKijdkef1LaqHDi0dcJ");
            state.setStateCodeChar3("5A3w7C1oS0Nq5kyiiWl7ko8sh2ipijWG");
            state.setStateDescription("QaGv2E9A2S8XacsKtxrNcHYof6YqqPxf1ZgJIE6KeNxxYXa4Jo");
            state.setStateFlag("O38EqkdL0ICXywjBlGAX4xFEF7RMFJ2BcB83BneqiBc0VyI9yl");
            state.setStateName("u7N3JWtMXbxP2pOKQKeZygvHUrAT2yUtceTLvBREV5SfJpY1Oz");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("uStwlsgU9UPQ4deM29hepTBDG4HUr2ME");
            city.setCityDescription("oiFGU76scpelaRnlFzaEmPAzlOfDlcmjrRJvjhUsBtvvGZJwVV");
            city.setCityFlag("0uWX45NNiaMMO27b2l8hZcz4xUkD8Jcddw0zDFJ0hUzBFkYFdy");
            city.setCityLatitude(2);
            city.setCityLongitude(9);
            city.setCityName("jOdPrblYQzxzDSYizrKMewVizfJvlQRHp73lPr7x3O2f5IXKa8");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("16MrMf4vv1EFIkuTFDYcPt8Yl3mfF3gAMs6K5JG0RrayvApAEd");
            address.setAddress2("mfkqRoE0La0iNFq45ZKoeLenzDxSxb7GQS6jYcxhNfI9CvPWMG");
            address.setAddress3("AS3VTwQ87LxVKMwcjw0zciJZUFJCHaS2u7RKXtXZGZPHsKBPmy");
            address.setAddressLabel("KsXjZKuzRrI");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("ylkVsViSDxqeYKLJpecF0mYy77LTtZ6Myvq4XUpTFIojpxg7xq");
            address.setLongitude("ejXBskyAjaPT3N85AfDEV7MqP2JubxjSYSgiqmXGLxiGnw0SgY");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("xfyxyI");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            address.setEntityValidator(entityValidator);
            address.isValid();
            addressRepository.save(address);
            map.put("AddressPrimaryKey", address._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            Address address = addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
            address.setAddress1("GuXPpuuOVEmvYbDFWENTW7R0S7PW6AkGPs1BIlMyCDoPrBanlq");
            address.setAddress2("PiCGmLNCapJBaBD6AnKC24qG9KrOYWhdqILTtJDvN647i6f2NS");
            address.setAddress3("srgr2Ujzzl28HHLB8nFd92T4NAXxMxadKUoFJGL5SccL9O9mpK");
            address.setAddressLabel("dmkTQlg0nhv");
            address.setLatitude("kAFP7kHPiqjMyqjqaWLp0wMBSvMlAaiFLqlmq8x3OWQ1JSdXHx");
            address.setLongitude("vFQsJCyPbENR8pldgshzDat0h8tFLj4ziWPT3Afcnq0Ih7UB30");
            address.setVersionId(1);
            address.setZipcode("pXOBkd");
            address.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            addressRepository.update(address);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.findById((java.lang.String) map.get("AddressPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByaddressTypeId() {
        try {
            java.util.List<Address> listofaddressTypeId = addressRepository.findByAddressTypeId((java.lang.String) map.get("AddressTypePrimaryKey"));
            if (listofaddressTypeId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycityId() {
        try {
            java.util.List<Address> listofcityId = addressRepository.findByCityId((java.lang.String) map.get("CityPrimaryKey"));
            if (listofcityId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Address> listofcountryId = addressRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
            if (listofcountryId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Address> listofstateId = addressRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
            if (listofstateId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AddressPrimaryKey"));
            addressRepository.delete((java.lang.String) map.get("AddressPrimaryKey")); /* Deleting refrenced data */
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey")); /* Deleting refrenced data */
            addresstypeRepository.delete((java.lang.String) map.get("AddressTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
