package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.VillageRepository;
import mineproj.app.shared.location.Village;
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
import mineproj.app.shared.location.Taluka;
import mineproj.app.server.repository.TalukaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class VillageTestCase {

    @Autowired
    private VillageRepository<Village> villageRepository;

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
            country.setCapital("15evnS1cs05ma9MnY9OHGCfY3C22c1AG");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(3);
            country.setCountryCode1("3b4");
            country.setCountryCode2("j72");
            country.setCountryFlag("ScxlQdiy9qtxHq7jRr3Ln5PfexFVbaiU3Q3S03zwaLxbQazsCV");
            country.setCountryName("3abf6mqrMjFUvHOQpsV7992jSzJNH8BychkxsIyTbZ6D7QqSh0");
            country.setCurrencyCode("hWX");
            country.setCurrencyName("5qPoASkspTgoeKtaQPXq2GK6AZWHP88sNdQyybgiEFEzebnsTc");
            country.setCurrencySymbol("XzgfQSgA7sVia7XN3xZ2y7w2rit6A6AQ");
            country.setIsoNumeric(9);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            District district = new District();
            district.setCode2("iuFr2c6XVsegaOdo8nOR9m1YfyBLsLpz");
            Region region = new Region();
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            state.setStateCapital("0WC412M3CxSuuUK2pLQNjV9N3pdRvL6rvpun081sHE7WximPLw");
            state.setStateCapitalLatitude(6);
            state.setStateCapitalLongitude(9);
            state.setStateCode(2);
            state.setStateCodeChar2("dmfBblzfSi7vfpbSvssbs2ETv1DXKdn4");
            state.setStateCodeChar3("y5FqpxlaUaLX7qOxEDUT8aoZ6H6vaLut");
            state.setStateDescription("Ka5m7lIClYAn4e9Z0CQty79aauNuNfMsbyIwIrLDZRQG5eBXOE");
            state.setStateFlag("hKsP8rnPblHCmgYc9XC74sEkPSM0Cptf4KwkinhY98AiZIILCr");
            state.setStateName("T5naAXFRDxYfrhb5WQiSe1KMAxUSPi9bqQL9nof6sNuAQtSAvW");
            State StateTest = stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
            region.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            region.setRegionCode1(2);
            region.setRegionCodeChar2("KHLMDU7hs0SsXL8bNCdXZb1HtXuUW0Lx");
            region.setRegionDescription("2U0ZGgzgcGtOtLdzjCggjFI67CgqIRRKvQWA3UMjICg8t51eNw");
            region.setRegionFlag("LgGLZuNDJXJd5MUq5hch7aat06kvjU8zGTudfgaw4Hzukk5HUR");
            region.setRegionLatitude(10);
            region.setRegionLongitude(4);
            region.setRegionName("TYdBx8wq4XQMmF4kGtF4BaFlWrgHAIHKbPA303QqrR5thnTAOl");
            region.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            Region RegionTest = regionRepository.save(region);
            map.put("RegionPrimaryKey", region._getPrimarykey());
            district.setCode2("uLw1Zxu2U1QQq3N5MC1YLAEe3hB9cUmx");
            district.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setDistrictDescription("PurQCnBE244tYRZXVpKZd3ymsPX2ezj9LFOukQU6ngZWD65dFB");
            district.setDistrictFlag("iLyEdX0zpxthRmiz02BfWBuH6pHnZFGsXEBAEpAt2kEn4zscfb");
            district.setDistrictLatitude(9);
            district.setDistrictLongitude(6);
            district.setName("SpIm9jFr4VTsfwbx3DutfRAhDZ5tzyRxy8MEK7WlkeFMs9wokd");
            district.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            district.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            District DistrictTest = districtRepository.save(district);
            map.put("DistrictPrimaryKey", district._getPrimarykey());
            Taluka taluka = new Taluka();
            taluka.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            taluka.setTalukaCode("Vc9lQSt6AKYWGXVEg7Hhle64srrDMNKk");
            taluka.setTalukaDescription("2YqyqgyPEVg4JBQe9xnmEldqpYB67mYsuZ158qVDOF5VJcO4pG");
            taluka.setTalukaFlag("bcivBvI2rpheZ1t3XZ8UVQH7Owoa7nmZp0NdzHBfKvacRfAOPR");
            taluka.setTalukaLatitude(5);
            taluka.setTalukaLongitude(1);
            taluka.setTalukaName("nfkQyewpaw5HBQinqtTQJNU0a0uLI9LfbTi7ak7hKlOkQFBEDv");
            Taluka TalukaTest = talukaRepository.save(taluka);
            map.put("TalukaPrimaryKey", taluka._getPrimarykey());
            Village village = new Village();
            village.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setDistrictId((java.lang.String) DistrictTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setRegionId((java.lang.String) RegionTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
            village.setTalukaaId((java.lang.String) TalukaTest._getPrimarykey());
            village.setVillageCode("9oROXUh23BlZYL9C0lMmeeg5XU10MmSu");
            village.setVillageDescription("E366OqzLoFKt1kUWmekUEvr0vSknIpvbUTlv7jzZzNx5D92zqh");
            village.setVillageFlag("FtqE20LZJcESAy5cdRyWDlJ9QvTTRbYy0amARkZMBedO1pO650");
            village.setVillageLatitude("XwXQOFhULjg");
            village.setVillageLongtitude(7);
            village.setVillageName("qJyKDyTUEOAQnqqoDhLN8OxC2Crqr3P5VBxmS4UWwvv5oZWwEG");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            village.setEntityValidator(entityValidator);
            village.isValid();
            villageRepository.save(village);
            map.put("VillagePrimaryKey", village._getPrimarykey());
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

    @Autowired
    private TalukaRepository<Taluka> talukaRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            Village village = villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
            village.setVersionId(1);
            village.setVillageCode("cIG3f1HPbizmN6V0xIwDxz2iN1gopdG1");
            village.setVillageDescription("7z02l8f6THWv0PzHr7q7bPCfiDdwrzihHe7igs7J8k4RjgIu9A");
            village.setVillageFlag("QwpqCsvGB2Z1DP4YkyTNnAQ2Ttnj5noi9f4whVPc7FISNybbXb");
            village.setVillageLatitude("MydYKOGjKAK");
            village.setVillageLongtitude(3);
            village.setVillageName("vpan5RtXNI4Icj2kcUjyo0ffjm98LtWwem3AJpR2PDfKtfshz3");
            village.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            villageRepository.update(village);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<Village> listofcountryId = villageRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            java.util.List<Village> listofdistrictId = villageRepository.findByDistrictId((java.lang.String) map.get("DistrictPrimaryKey"));
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
            java.util.List<Village> listofregionId = villageRepository.findByRegionId((java.lang.String) map.get("RegionPrimaryKey"));
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
            java.util.List<Village> listofstateId = villageRepository.findByStateId((java.lang.String) map.get("StatePrimaryKey"));
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
    public void test3findBytalukaaId() {
        try {
            java.util.List<Village> listoftalukaaId = villageRepository.findByTalukaaId((java.lang.String) map.get("TalukaPrimaryKey"));
            if (listoftalukaaId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.findById((java.lang.String) map.get("VillagePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("VillagePrimaryKey"));
            villageRepository.delete((java.lang.String) map.get("VillagePrimaryKey")); /* Deleting refrenced data */
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
