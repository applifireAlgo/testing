package project3.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import project3.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import project3.app.server.repository.LoginRepository;
import project3.app.shared.authentication.Login;
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
import project3.app.shared.contacts.CoreContacts;
import project3.app.server.repository.CoreContactsRepository;
import project3.app.shared.contacts.Gender;
import project3.app.server.repository.GenderRepository;
import project3.app.shared.location.Language;
import project3.app.server.repository.LanguageRepository;
import project3.app.shared.location.Timezone;
import project3.app.server.repository.TimezoneRepository;
import project3.app.shared.contacts.Title;
import project3.app.server.repository.TitleRepository;
import project3.app.shared.authentication.User;
import project3.app.server.repository.UserRepository;
import project3.app.shared.authentication.UserAccessDomain;
import project3.app.server.repository.UserAccessDomainRepository;
import project3.app.shared.authentication.UserAccessLevel;
import project3.app.server.repository.UserAccessLevelRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class LoginTestCase {

    @Autowired
    private LoginRepository<Login> loginRepository;

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
            CoreContacts corecontacts = new CoreContacts();
            corecontacts.setAge(86);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("HF1kBWTJTnaOMvvvsFj10a6gv23ADIcFyJarv4h24iJ7TXPqn2");
            corecontacts.setFirstName("wfy1RDZMJ7lfxy0clMPcb8U0NNWkSpUnLTweYIhWv0BSljxNbo");
            Gender gender = new Gender();
            gender.setGender("jXzSLFjSp4KIOenPIgRbiF0Lcw8IH6wD10YVVuM8sQL6iJ1HMR");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("cu");
            language.setAlpha3("tTG");
            language.setAlpha4("mbHl");
            language.setAlpha4parentid(7);
            language.setLanguage("h2AhV60mLEea4wfiogBd4WusknTQCXcj0tR6q7iPW4hu9hSs6t");
            language.setLanguageDescription("lgI04NI9nk84vqbeOymQAsDprAJzn5NYfGk34POA0bMmamNKW4");
            language.setLanguageIcon("e023tTZTuegrVROY6bOWwZQBQVyrNWTzkvwy8HvGoEPmoPviuO");
            language.setLanguageType("YAgpujC921nggMKIH374gqKpcmZpmZ01");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("PlKlqaJCPMQqC7vD8s7RFk5X2DFu3mAF0m21TtCdLKi7SHGspy");
            timezone.setCountry("IfdlOVBxD6EGxLsMhyF2kqrbJ1coYzl4nuQseABcfZ7eUBQxEq");
            timezone.setGmtLabel("RrXAv9DItl1y3AZDyjm41bGBMQTfFygsDalHEZDTzRyLt9YaU6");
            timezone.setTimeZoneLabel("oGaB5CFc3fWPdgFInSOmgrc4x2iA92dy82eeuDD9WHVhszbhc2");
            timezone.setUtcdifference(3);
            Timezone TimezoneTest = timezoneRepository.save(timezone);
            map.put("TimezonePrimaryKey", timezone._getPrimarykey());
            Title title = new Title();
            title.setTitles("NQPNZSkzRBkjgjN0WsiGeaWhLJiO9hoxuuUE4v7ACq8k9qHmtA");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(110);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("NiqXWC0pSiy8zcPfxBRiBR5CgyGSGmR8HLC2EW4aJ6ivs4uG0W");
            corecontacts.setFirstName("IhuMTfFpRUYfuSQh3oP51eUk3n8m4h9PdBAwMZQuh3v1JpTKR1");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("pC1ai0iVSOq7OEPRF1HYqk5rX68MrytjwdA7opP3u1xml24tmj");
            corecontacts.setMiddleName("mkYOaFyMtGFKtLkvlg6IIOUzijiUEqSuJgXAwdrRcFmbssbQ7C");
            corecontacts.setNativeFirstName("YZxbgqqgtRhoe0SjHTlGvAdFmk4ITcWhfbvPpFnXc5bBmy7dgd");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("Nrpk5hus6w6bkU8gNsnito7YcY5jBLQb5hfMb9CuQDmgZ08uW1");
            corecontacts.setNativeMiddleName("jXn3xxnM8t2KlMJQ1aj8dT6mXJSoZbPGh2JwTkbLgOULguD8mr");
            corecontacts.setNativeTitle("44HgmMYWw5pSYxukzqHYL9YLxMHgFE7TQHURN5OCZjqvphiFG3");
            corecontacts.setPhoneNumber("LVrp0wxvlwpBx88YBArG");
            corecontacts.setTimeZone((java.lang.String) TimezoneTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("W6jlWR0aRy3R9ph6CjUPadqfxpgwwoneoOZWCasump3j9H2Lyc");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(3000);
            user.setUserAccessCode(6);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("DwQqyNUgDdDeDUde6H6qPp3WviTi69cioUZhujlMv3dBIZkGdf");
            useraccessdomain.setDomainHelp("6zDV610wGCiQrrgCpR6N7nDgNCkUM5KjJahMHBQtPsFtYX1ld1");
            useraccessdomain.setDomainIcon("XjqJi2Q2IUrPO1CSB9S7h7gltmaMay5ruhjBXKbDQMomImsWef");
            useraccessdomain.setDomainName("Z1IzS5eajycTkAdKPdmfooc4jlISCtcQL8YSIsGDtvHQN4X4Cn");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("aLClIZ7etwuE32kcLT6JLPLbvMUMShkqqSWt6xc4gjsobbUUqW");
            useraccesslevel.setLevelHelp("9QerjOHoSyso1afb3saYgPYjMmkQCjwtmPqSZg7P6x8qKEUbml");
            useraccesslevel.setLevelIcon("ZZO8A1ewIYqxwtgh5SQZMLBWitbMplPhtoM5oB53cvcil36GOb");
            useraccesslevel.setLevelName("4ptmlMJroGpjQ7gaMTPeEPOa62WIUpdI10oIL6iTIIB7uyxrm0");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(1);
            user.setIsDeleted(1);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("o4M0UErs22sAXTuKIGuQdgCA2CISlhrDNB0xbsjChku31bWib1");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2988);
            user.setUserAccessCode(0);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(5);
            login.setIsAuthenticated(true);
            login.setLoginId("mlsrgnNjHKweHvL7oFjTN3QWSGRpg0IbQvNcyB2DKQenRQNjwH");
            login.setServerAuthImage("6DYNrugHiey8ktNqN0G6VeMlXtMIIGeH");
            login.setServerAuthText("Rri7LReOUGqUBNAn");
            login.setUser(user);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            login.setEntityValidator(entityValidator);
            login.isValid();
            loginRepository.save(login);
            map.put("LoginPrimaryKey", login._getPrimarykey());
            map.put("CoreContactsPrimaryKey", login.getCoreContacts()._getPrimarykey());
            map.put("UserPrimaryKey", login.getUser()._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

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

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

    @Autowired
    private UserAccessLevelRepository<UserAccessLevel> useraccesslevelRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            Login login = loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
            login.setFailedLoginAttempts(7);
            login.setLoginId("mav7Gl8nia8MHicoMButkZbqIqce5jXWeoPXbWWLRHDOAlXCBF");
            login.setServerAuthImage("iMsNBGLphnGvDvGDwESckkSSqhTD80J7");
            login.setServerAuthText("yXe0OCnihqvnggsR");
            login.setVersionId(1);
            login.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            loginRepository.update(login);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.findById((java.lang.String) map.get("LoginPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void testNQFindUnMappedUser() {
        try {
            loginRepository.FindUnMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
