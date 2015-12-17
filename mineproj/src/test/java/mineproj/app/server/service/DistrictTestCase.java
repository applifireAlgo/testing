package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.DistrictRepository;
import mineproj.app.shared.location.District;
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
import mineproj.app.shared.location.Region;
import mineproj.app.server.repository.RegionRepository;
import mineproj.app.shared.location.State;
import mineproj.app.server.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DistrictTestCase {

    @Autowired
    private DistrictRepository<District> districtRepository;

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
            country.setCapital("ONpzl5BCYsKrSISQWBkDMG2p4qDzik8u");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(2);
            country.setCountryCode1("PU6");
            country.setCountryCode2("f7q");
            country.setCountryFlag("FMQ8wqpc9bdKMsWRgRCagYSxS7wHqyPOBzcVCaQwqxahdF0KaV");
            country.setCountryName("MiciqpoJk7dAMrGLhyGd1qZDV9J06ncR3ZMrMg5JuYgpkvNKFo");
            country.setCurrencyCode("D9A");
            country.setCurrencyName("MhD8by8sh9ImxU2cEy2UfpshgQw7q0jgMzXUI53kAEcv32NAnI");
            country.setCurrencySymbol("K8WHi68EnENO19YUi6Y5vRISOJBjSMnJ");
            country.setIsoNumeric(8);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("TjZSOZzC022MTPwmHqStk5rpu9n5XQz61DBQ2THyXqXxtbqW9R");
            state.setStateCapitalLatitude(9);
            state.setStateCapitalLongitude(0);
            state.setStateCode(1);
            state.setStateCodeChar2("1TBQp34Qq8sUCQ3wMHiHzebPoqIzLzx9");
            state.setStateCodeChar3("cVjrWU21vWDWV9bh22jq0Q4RnzD2GNlx");
            state.setStateDescription("JYaxY8ByNGbXNPgLvEK0nS9id7gwj0kdYkDzQR7vXUls9YAhJU");
            state.setStateFlag("KbbqVFdDekvwNJ3u5JyqKf9rZTiFVnIpejCFOo9MAR8hstsNmY");
            state.setStateName("9dskk8qbtGq1vhXwSv0i8iKHM63PVyOhL4pEUkh5WC0YxXAI40");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(0);
            region.setRegionCodeChar2("QU7iOC4oxD9qheSzJqk2skl1J3kUFanh");
            region.setRegionDescription("Z8eqbcKPjXGhws3CCZjkAIGYA66b85y2KunVDkyW4gynEaOR1k");
            region.setRegionFlag("f2fGxXCqS6HpU2vfNizf6SZNUOaSvL6QZ7QPOs2WpT5gOkuLuU");
            region.setRegionLatitude(4);
            region.setRegionLongitude(4);
            region.setRegionName("SEGaC3f4P22lzAb7rqdxpt9FiawOhiaw99d83eH0Pqowu4CRVG");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            District district = new District();
            district.setCode2("8ganRRhgDYBSoVgvUDwtfCzSEg9SCMTl");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("55YIJnKhjkkQfxGvBXh0PBxmLEaaSuEcgO3HD0yx1Mb224s1ib");
            district.setDistrictFlag("knZ2Gujz59FfFW68ktZozrJ3pZXBJ4qjd0YhDt7PlRAwJiBAQn");
            district.setDistrictLatitude(0);
            district.setDistrictLongitude(2);
            district.setName("9LFq4LOtMvprc4UxRS3sX9RQzsETPqi8DTVkDNXW7H3N7sqNCJ");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey());
            district.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            district.setEntityValidator(entityValidator);
            district.isValid();
            districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private RegionRepository<Region> regionRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            District district = districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
            district.setCode2("Cbm8tou9basemcJbvYsIYR2wtweFJIcu");
            district.setDistrictDescription("E5qctbGGYZFTTOkO1wmJVk3QNmrvD9mHt0CQoIaH6OY0lSNHdT");
            district.setDistrictFlag("PzNmQQ7ORrbTDWmSdOsY3q4lA7eCbbJZVrB8zLd8mdnPNjogJZ");
            district.setDistrictLatitude(9);
            district.setDistrictLongitude(7);
            district.setName("XHgqD0BAdhbaJ8gcJG7ZBDnIBR160cUxXhJrPfCvPYIocxw4wI");
            district.setVersionId(1);
            district.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            districtRepository.update(district);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<District> listofcountryId = districtRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
            districtRepository.findById((java.lang.String) map.get("DistrictPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregionId() {
        try {
            java.util.List<District> listofregionId = districtRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<District> listofstateId = districtRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("DistrictPrimaryKey"));
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
