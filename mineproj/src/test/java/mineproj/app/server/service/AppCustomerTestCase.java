package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.AppCustomerRepository;
import mineproj.app.shared.customers.AppCustomer;
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
import mineproj.app.shared.customers.AppCustomerCategory;
import mineproj.app.server.repository.AppCustomerCategoryRepository;
import mineproj.app.shared.customers.AppCustomerType;
import mineproj.app.server.repository.AppCustomerTypeRepository;
import mineproj.app.shared.contacts.CoreContacts;
import mineproj.app.server.repository.CoreContactsRepository;
import mineproj.app.shared.contacts.Gender;
import mineproj.app.server.repository.GenderRepository;
import mineproj.app.shared.location.Language;
import mineproj.app.server.repository.LanguageRepository;
import mineproj.app.shared.location.Timezone;
import mineproj.app.server.repository.TimezoneRepository;
import mineproj.app.shared.contacts.Title;
import mineproj.app.server.repository.TitleRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppCustomerTestCase {

    @Autowired
    private AppCustomerRepository<AppCustomer> appcustomerRepository;

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
            AppCustomerCategory appcustomercategory = new AppCustomerCategory();
            appcustomercategory.setCustomerCategory("c9UdlinGnInnWmJGGGrs211CyDX8gaSxuVriaXoPDzTiKRnAcW");
            AppCustomerCategory AppCustomerCategoryTest = appcustomercategoryRepository.save(appcustomercategory);
            map.put("AppCustomerCategoryPrimaryKey", appcustomercategory._getPrimarykey());
            AppCustomerType appcustomertype = new AppCustomerType();
            appcustomertype.setCustomerType("3SR1ZYpVV9KiF5kAXWoNdmScAUeauZD61AmqneCRhJxRDntvny");
            appcustomertype.setDefaults(1);
            appcustomertype.setSequenceId(2147483647);
            AppCustomerType AppCustomerTypeTest = appcustomertypeRepository.save(appcustomertype);
            map.put("AppCustomerTypePrimaryKey", appcustomertype._getPrimarykey());
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(76);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("WTL7p3IStTvV1h5YRNfl6MV8rm3oBAbJaw8xTLK8P61748bdGC");
            corecontacts.setFirstName("35va0wiLzOnUjJy8WwlADCWrDxzb11sRBWPggyECILIm4k9kKH");
            Gender gender = new Gender();
            gender.setGender("EmY0gon2HNDzN7Upl2prQSweqzny6Iy9tm8SuWl0coRruR3SCs");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("oq");
            language.setAlpha3("7fE");
            language.setAlpha4("CRdU");
            language.setAlpha4parentid(8);
            language.setLanguage("eUrxDpVQ0Ez7cPNwEHocLJI4xDpJ6UDVwL71eKTlr39xIACScw");
            language.setLanguageDescription("hpr5tuYBfj9AdfpZT0MENES0xFOHDArrFDSghh7ib7pHue17Mm");
            language.setLanguageIcon("Y7Me1FAg32lmDrJjoa2RRVlQFVrzCAnY7dRvGAfdmmo5Sf6aNr");
            language.setLanguageType("0yMhtS1R6wKkwaHcIghHNtmL48Ycvgkh");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("a8IdIyajziwbP1Jdau1PggG3X9YWTfiYBgzw5ZwIsJzEkzrDF3");
            timezone.setCountry("617huL6wxOJ6TZvafEmL7L5j1R61Ej9TRyHQ8TcfxP4gtzUroH");
            timezone.setGmtLabel("0AyOCh2bRN45z3AbbAq5Cv6in9kIFwMGcc54zo3QKX2nhmrwoC");
            timezone.setTimeZoneLabel("Q3FmPMNkzNMH4IYneJx5bfpLyVs1Dk7AjSTFxSVtRYwtfxrZZp");
            timezone.setUtcdifference(7);
            Title title = new Title();
            title.setTitles("qxY3J4iArrHU95wxvZE0mOHfktZUF5cCjMxd8IZjapuG6iNk9T");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(112);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("f8TYSeiJsh7zVuwV8Yooni9sJDarVZCEAcpRqTWGxaCPB35nGz");
            corecontacts.setFirstName("TKugLYIkFvE9tyZ5FEXSKJUvW9EwWwNjcFxQLRuSf0z4FMeGQt");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("AisauvXb2XURmU8eyGbaxIrXYgol6M07pSvihCdEW5Yo9i97Pa");
            corecontacts.setMiddleName("fLXpDYx8l833KJzJntkSwyIY7nBQP1EpXjEryfna7kSxYPDIlv");
            corecontacts.setNativeFirstName("1L43PZQTy0Ehi9qsRwIYs7CJPuwNxdssqN5YqDtdnZANKiUfLU");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("Ik6uTCnweOt2PMkyFnqu8PY2qk5lI0ejfo5RLiQ8zbZF1etYJW");
            corecontacts.setNativeMiddleName("5iyrZik7ZIDVEnRKJJpxEibOUq1X56N5IhEPm7lxkKfOqLfU2K");
            corecontacts.setNativeTitle("5AcMxkQalKNITGJw76sljUcikOLfLjItw0OFt03vLwCm5MuALd");
            corecontacts.setPhoneNumber("KBaFSfa7qJLRfoGETDog");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
            map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
            AppCustomer appcustomer = new AppCustomer();
            appcustomer.setAppCustomerCategory((java.lang.String) AppCustomerCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setAppCustomerType((java.lang.String) AppCustomerTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
            appcustomer.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
            appcustomer.setCustomerName("X7bVaGAKuuOvRn8v8nzte9lrWnE72cJGrcfoWfSnG3b9FGQXrc");
            appcustomer.setCustomerStatus(1);
            appcustomer.setDeploymentModel(true);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appcustomer.setEntityValidator(entityValidator);
            appcustomer.isValid();
            appcustomerRepository.save(appcustomer);
            map.put("AppCustomerPrimaryKey", appcustomer._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppCustomerCategoryRepository<AppCustomerCategory> appcustomercategoryRepository;

    @Autowired
    private AppCustomerTypeRepository<AppCustomerType> appcustomertypeRepository;

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            AppCustomer appcustomer = appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
            appcustomer.setCustomerName("DCteMq7uK40iP4SVkl9ByExEsBwZXtqbroi4TnfQrpxTGiSuRn");
            appcustomer.setCustomerStatus(1);
            appcustomer.setEvalTimePeriod(2147483647);
            appcustomer.setUserRequested(2147483647);
            appcustomer.setVersionId(1);
            appcustomer.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appcustomerRepository.update(appcustomer);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerCategory() {
        try {
            java.util.List<AppCustomer> listofappCustomerCategory = appcustomerRepository.findByAppCustomerCategory((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
            if (listofappCustomerCategory.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.findById((java.lang.String) map.get("AppCustomerPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByappCustomerType() {
        try {
            java.util.List<AppCustomer> listofappCustomerType = appcustomerRepository.findByAppCustomerType((java.lang.String) map.get("AppCustomerTypePrimaryKey"));
            if (listofappCustomerType.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<AppCustomer> listofcontactId = appcustomerRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("AppCustomerPrimaryKey"));
            appcustomerRepository.delete((java.lang.String) map.get("AppCustomerPrimaryKey")); /* Deleting refrenced data */
            corecontactsRepository.delete((java.lang.String) map.get("CoreContactsPrimaryKey")); /* Deleting refrenced data */
            titleRepository.delete((java.lang.String) map.get("TitlePrimaryKey")); /* Deleting refrenced data */
            languageRepository.delete((java.lang.String) map.get("LanguagePrimaryKey")); /* Deleting refrenced data */
            genderRepository.delete((java.lang.String) map.get("GenderPrimaryKey")); /* Deleting refrenced data */
            appcustomertypeRepository.delete((java.lang.String) map.get("AppCustomerTypePrimaryKey")); /* Deleting refrenced data */
            appcustomercategoryRepository.delete((java.lang.String) map.get("AppCustomerCategoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
