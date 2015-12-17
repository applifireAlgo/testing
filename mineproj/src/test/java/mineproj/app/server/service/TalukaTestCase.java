package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.TalukaRepository;
import mineproj.app.shared.location.Taluka;
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
import mineproj.app.shared.location.District;
import mineproj.app.server.repository.DistrictRepository;
import mineproj.app.shared.location.Region;
import mineproj.app.server.repository.RegionRepository;
import mineproj.app.shared.location.State;
import mineproj.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class TalukaTestCase {

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

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
            country.setCapital("gCDSZ4xhvaQSpV7TqoUW2FUA6n24xOab");
            country.setCapitalLatitude(3);
            country.setCapitalLongitude(9);
            country.setCountryCode1("vGV");
            country.setCountryCode2("Eee");
            country.setCountryFlag("Q183ydF9d2Y0yl5hIZSSTokj5GHuzXNssnr16TCJ92KuDR3JKD");
            country.setCountryName("7yXe5JjR50KnbRY4TQao9J7EVBRDgXsJwMdBXDIjGprp6mrrAa");
            country.setCurrencyCode("CTf");
            country.setCurrencyName("wk1ct70g4EHJ8rCWWuAZBVas0PvYNAprgyrRf4s1QYlRLmJVrx");
            country.setCurrencySymbol("UAftx5OOB0JnBkzNXn3fZK8g2sBfJlin");
            country.setIsoNumeric(7);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("AHsAM2R9946vPEenxzVNaI7vTM4pCczw");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("Is6S762QV2yCJmVW1WgUIeMO6tyNd03iYdLziYqtx9GxxqGwyH");
            state.setStateCapitalLatitude(1);
            state.setStateCapitalLongitude(8);
            state.setStateCode(1);
            state.setStateCodeChar2("izXxuA0WuZMuG2M45qROdukgCxyg1wOh");
            state.setStateCodeChar3("zXgs9AF4ljkQr4ubz1gMrkCKXUiwwf4f");
            state.setStateDescription("AJfFksfbeeivYQRFbA0KTQN4MEDk54sMvuz9FIGB46t6L7NmNt");
            state.setStateFlag("6Zs8VkIqrGyQBaBql2AhbaPUSpO0Vi67CtE81dCci7FF3Say44");
            state.setStateName("PsVLUHGudc6QdK2G51GCjyJV2QXybEhzMn6f39c3pMMdPIp5DD");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(1);
            region.setRegionCodeChar2("yYMzMJlNTEEO1xyd55OnSOtRj1TMF1cL");
            region.setRegionDescription("29oMUf0cQNfUY0iEikC2TVGkHQ6c9LNkLo5naYyCeRq4ZR16uM");
            region.setRegionFlag("TcHwwPg25ofQBFdCPWojCimC0aJQtasndChU1e5niZTUuNBlSh");
            region.setRegionLatitude(0);
            region.setRegionLongitude(2);
            region.setRegionName("zpz6xg7rSbJNpNHJPNGTMHuXEzzEpEgHg72Hm5xr9I6smXApYV");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("IuQmXDR8UEkpT2N6DpDJC3MpOkqJCT3w");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("6ANUpibnO7XYAdsXsXRysOwqtUUzN76ijgHhfov8tDPzbTU6Ct");
            district.setDistrictFlag("5CS5IEAAO2BzMuQvQLusQzQKAPwoqjYNLU0zxjoMZFcaBG174H");
            district.setDistrictLatitude(5);
            district.setDistrictLongitude(8);
            district.setName("47u6zF0UEboQskl1LLaEerh9Pyy6gYfnP3exXG77tsWzEObN4k");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey());
            taluka.setTalukaCode("xN4yiCAW0ZmEyHHmZrjkJgLWQ9dDNIgc");
            taluka.setTalukaDescription("DBwtfDQmQEoOXtaqprWLKwnpy9NJzp8KG7svxMYr51edqy5t4o");
            taluka.setTalukaFlag("hAzRoBMWlUvzZesbzFDI9UOIVbFYCuS9lTTLnS7pofbIuCH6t6");
            taluka.setTalukaLatitude(5);
            taluka.setTalukaLongitude(1);
            taluka.setTalukaName("dlapGdlrXDPoOdHKmNOYMDsMA0MP0lyjHJVfPwuHm9NdxswDQb");
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            taluka.setEntityValidator(entityValidator);
            taluka.isValid();
            talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private DistrictRepository<District> districtRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            Taluka taluka = talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
            taluka.setTalukaCode("A3C8lXmPbm6S1N4ibTOfLFHxQO7WjEKc");
            taluka.setTalukaDescription("JGEwmvWYWiK2EEiWo7NA7WGTbkqPrCFQvHDGzrxhzJaUKP7ysU");
            taluka.setTalukaFlag("vtjZX9GyHHDPpfW8S7jzxgxSY8AwcsJ010kers6Xd6U3uUubQC");
            taluka.setTalukaLatitude(5);
            taluka.setTalukaLongitude(11);
            taluka.setTalukaName("PwiKuvLdeV4RjcnvIME0hg9IZZPlpjVUEse7XsaAriPLYupijw");
            taluka.setVersionId(1);
            taluka.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            talukaRepository.update(taluka);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Taluka> listofcountryId = talukaRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
    public void test3findBydistrictId() {
        try {
            java.util.List<Taluka> listofdistrictId = talukaRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
            if (listofdistrictId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<Taluka> listofregionId = talukaRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
            if (listofregionId.size() == 0) {
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
            java.util.List<Taluka> listofstateId = talukaRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.findById((java.lang.String) map.get("TalukaPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("TalukaPrimaryKey"));
            talukaRepository.delete((java.lang.String) map.get("TalukaPrimaryKey")); /* Deleting refrenced data */
            districtRepository.delete((java.lang.String) map.get("DistrictPrimaryKey")); /* Deleting refrenced data */
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
