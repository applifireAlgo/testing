package project3.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project3.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project3.app.server.repository.AddressRepository;
import project3.app.shared.location.Address;
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
            addresstype.setAddressType("HKgbqUi31NJWy4ZnzzzFSzu8QLWeQ5PC7kPCkRHoR4U8JCSnx2");
            addresstype.setAddressTypeDesc("SumHOtbdflcFNTVyCyChmMt8O8VsjKRF9ld09TV2At4d54vCLZ");
            addresstype.setAddressTypeIcon("pCoh3p8jaxNmg919rWewP7mcdZ41Rgn51eoyAlmV5786xg0aAb");
            AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
            map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
            City city = new City();
            city.setCityCode(3);
            city.setCityCodeChar2("onOaoAUxLP0NH3X6I4WyG2LRW3ii1DhE");
            city.setCityDescription("MAuF5epg5hyPFCqVusnhy9Lei6EJc0CUkQwlzkxNiUT9hKLH1x");
            city.setCityFlag("JOniElEuNKXVnNW0X2rbNaWp9Zw82mJyoPXG9ZUWzxXel8BXlI");
            city.setCityLatitude(7);
            city.setCityLongitude(6);
            city.setCityName("SHS4ufmzB5KLkR5r60u28QEK4BdWMPPz0XDPL5GsCLRvOQINzY");
            Country country = new Country();
            country.setCapital("d4X0n55WIU7Bg5zW359RdgI2D9SClKcI");
            country.setCapitalLatitude(5);
            country.setCapitalLongitude(11);
            country.setCountryCode1("0cq");
            country.setCountryCode2("b1r");
            country.setCountryFlag("652I4B9lVe7NalHEz21ZC8JkhB3GwdvD4f1E1GD5EOR2oUzIey");
            country.setCountryName("06HVqcppGKbTKuaJVwglO70b5c63M3mOabGzPhWTFeeKMoaprZ");
            country.setCurrencyCode("auR");
            country.setCurrencyName("Ep2XpEjRZZB5kg6lhDJqPCAzanJqYyWd4sZ41wgQFK4tUarK3g");
            country.setCurrencySymbol("Pbz87C3xbLzlB5fvmiOjZwLCprZKbNPz");
            country.setIsoNumeric(5);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("irBxKIyogiJWKWymGz4ltkwoI6oV9D4KUpj94DOg7jAP8WBla5");
            state.setStateCapitalLatitude(5);
            state.setStateCapitalLongitude(0);
            state.setStateCode(2);
            state.setStateCodeChar2("eD2o7r4ZLU1gfDzNT7VKYuOuKRnhdcq9");
            state.setStateCodeChar3("sGopbXrZV3VFHUiFD9bNf6FSgRkcemYP");
            state.setStateDescription("jomWURlC2HBt1roLe9dJcn3UaSX2hDXrXwJtbrtuesgKBtrnGj");
            state.setStateFlag("2v2RwF5dSug7Fwhx3FpTIdvpoxR2z6Ohf38GGNJzUdYaQ25CMj");
            state.setStateName("1pu5l8fL8eXozqSUpxdvEFklk6ppNM72CutEu3ZBEMjmhQVpl2");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            city.setCityCode(0);
            city.setCityCodeChar2("0CKztTen9PkTkPMlZ2imXhZZLi2B3vUV");
            city.setCityDescription("ARhwW8jusB4LMsFjlAK1aCCholHCGVGGdWDKCbIjNtsbruAL3h");
            city.setCityFlag("XzppH3JLg0bjRdqts3U53LFqXkXhFztcvtAxkwuKD8uePOjlHZ");
            city.setCityLatitude(4);
            city.setCityLongitude(11);
            city.setCityName("7cO0l82ACzU3JJzoewtsqcfF7NkpVdzZUUoA4adbpuI7OiZxsn");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            City CityTest = cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
            Address address = new Address();
            address.setAddress1("RrSIIOpoxKFDqAHXAZzf7l2N6941NzO59k4bHYfRCcsWkOLVii");
            address.setAddress2("WhmFJrsCvNBzARb6Ld5UdyjU2lP3onfIniJDgyAVhQUFqiMfZo");
            address.setAddress3("6GTOXVC2FF9GMraZsao41fHAoufoHyzIIznk4LTBSF6bEe9Gwk");
            address.setAddressLabel("lYjYdFon6OU");
            address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            address.setLatitude("NuCfjdPxD23mRurk6EIjh9TOxKimfZZfNCpAn28H4jHvsnnhnI");
            address.setLongitude("BeVxKrIMqdHS5sSB5zQMYNkq9FN5HBjILz2JvYTPJaa3YjVlFA");
            address.setStateId((java.lang.String) StateTest._getPrimarykey());
            address.setZipcode("nxWReQ");
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
            address.setAddress1("DtpzE26E4sk6rZ2VtHaTC0Ru9E5szXKVLuKVF36FnBci84x0ij");
            address.setAddress2("rISlMlWeB1i8spdP5BLOUYALN9q8VAKMSnadcEglzaIlPlnuy4");
            address.setAddress3("T8OAKmBem3kth8YFEsgGlIFbSGSRbAnL8WRPfLXyE4p22R3Uzw");
            address.setAddressLabel("KDuKuIWEjzj");
            address.setLatitude("Z6DMdy24OR2Q0Quu8FjGCQJd6zDpveolTjV0edE7qve7OXNFJ1");
            address.setLongitude("fq1z9Lq4IjWQEewEPSH0PJckz47bDA2QOsluv7rBZRfdBuNIyJ");
            address.setVersionId(1);
            address.setZipcode("BZm3aT");
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
