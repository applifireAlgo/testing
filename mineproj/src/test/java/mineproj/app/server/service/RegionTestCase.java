package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.RegionRepository;
import mineproj.app.shared.location.Region;
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
public class RegionTestCase {

    @Autowired
    private RegionRepository<Region> regionRepository;

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
            country.setCapital("4GfvyCmf245LgcW2sqFI9khe5pGuuaYt");
            country.setCapitalLatitude(1);
            country.setCapitalLongitude(9);
            country.setCountryCode1("1BO");
            country.setCountryCode2("yGS");
            country.setCountryFlag("n62thYFs9t1LAHdmCCSuxmKqUXubYFGJOg2RxTZQxfZxwHn4Cm");
            country.setCountryName("x4iNs8yALbzXXL3JCEZAiraL6PmTILhSG7hQ0Brzs9Kv0p4lTY");
            country.setCurrencyCode("Aip");
            country.setCurrencyName("gg3OC70ufKUkyOsDRswHS4zGdaPrSJF6NYxEt7654JHpowDRq3");
            country.setCurrencySymbol("1XeRqXvnzfCGbzZ41DV28Ut4zsFpGT8W");
            country.setIsoNumeric(11);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("rJCDfTyrn7K67Ahzf6yvH9Cn8ZtUOM6AGI6RVB6YXf63oCC8g1");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(10);
            state.setStateCode(2);
            state.setStateCodeChar2("biI6OmTKLa3y0h25mRN5paew7t5fQpXf");
            state.setStateCodeChar3("JH06KQPBASuRiXzE2ho9Q8ETNwtXALMv");
            state.setStateDescription("U5fUq1o8o8gRb2FKa4loeZdzKUUEErjpEXH3USm4iMbDWfEmx3");
            state.setStateFlag("WjG8hA9jfZzCCt01UT8bjhm880b8K4X2YsceOLFX7nyjAmKEk4");
            state.setStateName("AMRqku26v3SUoqCMtgmOsk6yRdLtB1mtTuFUTGoDlBEIBztcWO");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            Region region = new Region();
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(3);
            region.setRegionCodeChar2("FKTkIqy9jfSebZLadleX3g9IY5mIMjRz");
            region.setRegionDescription("MXXQob0Bk8Zq21LtAljvtoqWDNs0nuPW2aBnVBs8mfP6pocgEc");
            region.setRegionFlag("xIbR70mfUbYMBjz45X9IpBps1YNvmHK6Pb0F2M5vXWO4bKJdSh");
            region.setRegionLatitude(7);
            region.setRegionLongitude(7);
            region.setRegionName("vDRXoHHvo24ii6qPzABKDvEVVGjYvO8OWj28ZU02PYv4mYa6s5");
            region.setStateId((java.lang.String) StateTest._getPrimarykey());
            region.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            region.setEntityValidator(entityValidator);
            region.isValid();
            regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            Region region = regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
            region.setRegionCode1(3);
            region.setRegionCodeChar2("Kh0eFJhaRa5gMBiaTP54hOhKqNAmqIt9");
            region.setRegionDescription("eF1kHhjbi74GRdOHj165uu8eoaXjMUXzYb7ZVaNGkQGjOnLqXk");
            region.setRegionFlag("BBcN1eH3QnhhRJPTADmesQoOT5qrya5RE5vHefLYOCM8vv6jNT");
            region.setRegionLatitude(10);
            region.setRegionLongitude(10);
            region.setRegionName("D4xpgGEOUQ2aojvPepq3imfqClg0r4XtcZIWyAxJU0qnUmVUGY");
            region.setVersionId(1);
            region.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            regionRepository.update(region);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Region> listofcountryId = regionRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.findById((java.lang.String) map.get("RegionPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBystateId() {
        try {
            java.util.List<Region> listofstateId = regionRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("RegionPrimaryKey"));
            regionRepository.delete((java.lang.String) map.get("RegionPrimaryKey")); /* Deleting refrenced data */
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
