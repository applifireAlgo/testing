package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.CityRepository;
import mineproj.app.shared.location.City;
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
import mineproj.app.shared.location.Country;
import mineproj.app.server.repository.CountryRepository;
import mineproj.app.shared.location.State;
import mineproj.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CityTestCase {

    @Autowired
    private CityRepository<City> cityRepository;

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
            Country country = new Country();
            country.setCapital("7UHhp7nXfIEir353BYbEW8xEKZaA7kYf");
            country.setCapitalLatitude(11);
            country.setCapitalLongitude(10);
            country.setCountryCode1("wdT");
            country.setCountryCode2("vlU");
            country.setCountryFlag("Mq5OrttDeM35r1MWxa6Gx7dkytIJMUGA5KeTWHSW2zAUuDl7rL");
            country.setCountryName("BtFKkzO1wnA81ZMTxZIrwQFWjWxFvLurHN468nBGFeqvAHUKqD");
            country.setCurrencyCode("tPx");
            country.setCurrencyName("Q2g90hxmvu98aofeZLcrftdZIbg0FRQMerqKROValgfWayzTcX");
            country.setCurrencySymbol("kUY0qouansfxsowyVD2JeSRas3kEma4C");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("6LGGtGnDqMFXkz5v6HLWYMiZb3HcoUjaZd3kJ9ALQpvGiN1FsI");
            state.setStateCapitalLatitude(8);
            state.setStateCapitalLongitude(2);
            state.setStateCode(2);
            state.setStateCodeChar2("3m0zaYEdYMkSh2b0KtGXlXIdAaDWGGt6");
            state.setStateCodeChar3("e9DFH5aEeAwx0ycp4IaE6BvW6wmHZNYy");
            state.setStateDescription("7S2cygqIvnOUv45F16ZuWZI8FCF9XXiTXVq597vLf9ksVHcWa4");
            state.setStateFlag("UjLFfDclIadma7c8LsyWuKvqebjHyuWxvcDHTf4Wke3SJl8Css");
            state.setStateName("7TH2HDjyn95g6tjl1z1RrCla0z9MhA5ujotGnkN5qtnpGfogPL");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            City city = new City();
            city.setCityCode(0);
            city.setCityCodeChar2("wwF9s0e4c1LRMqzfLliTmQX4YzhsBzPY");
            city.setCityDescription("A8T0TS9zPA4RrJw6gc9U5Y3ZAngTpye7cTFAWpjOgkyKBvvSLM");
            city.setCityFlag("etC7jzGHiwuhX4cD1rWhG4Jl6TC0Ay9xJ2E4mWXFF1inbgsC16");
            city.setCityLatitude(0);
            city.setCityLongitude(9);
            city.setCityName("THmkbueowstfNE739SlhYrJv95HL3fjcSZezdorfbfslJRzT9a");
            city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            city.setStateId((java.lang.String) StateTest._getPrimarykey());
            city.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            city.setEntityValidator(entityValidator);
            city.isValid();
            cityRepository.save(city);
            map.put("CityPrimaryKey", city._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            City city = cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
            city.setCityCode(2);
            city.setCityCodeChar2("ggukeYsnPondwOsZYk1sqaJNnxFLgyl0");
            city.setCityDescription("Vusz4OwitxZuhAoQqg2LIUSZHv8va1izi9BYScW4Jskhok8UKV");
            city.setCityFlag("fu7aFbYOnaZtA2K7ekxOEn96RamJgOjulbBup3gCzqzurKgMA0");
            city.setCityLatitude(1);
            city.setCityLongitude(9);
            city.setCityName("VeP3D3uQ3Zx6z3QHQqG0w1h1JUQILkAybHTky0CCvDjTxKTnHJ");
            city.setVersionId(1);
            city.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            cityRepository.update(city);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.findById((java.lang.String) map.get("CityPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<City> listofcountryId = cityRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<City> listofstateId = cityRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("CityPrimaryKey"));
            cityRepository.delete((java.lang.String) map.get("CityPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
