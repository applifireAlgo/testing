package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.LoginRepository;
import mineproj.app.shared.authentication.Login;
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
import mineproj.app.shared.authentication.User;
import mineproj.app.server.repository.UserRepository;
import mineproj.app.shared.authentication.UserAccessDomain;
import mineproj.app.server.repository.UserAccessDomainRepository;
import mineproj.app.shared.authentication.UserAccessLevel;
import mineproj.app.server.repository.UserAccessLevelRepository;

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
            corecontacts.setAge(31);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("EGNxC0RCtLVSqpqSln8W49ofFQYihokiHq2Ke0VYUGePAS44iI");
            corecontacts.setFirstName("TKPYtzOsi2NlLiq2DjvgTvXtzJyg2YhkJ9Mv0eiNKJPpJAOs2O");
            Gender gender = new Gender();
            gender.setGender("dOzrZELgMhoIBV4iuBbIVvKeCNzkXetLLcwqtvBAGGAJPHPBV8");
            Gender GenderTest = genderRepository.save(gender);
            map.put("GenderPrimaryKey", gender._getPrimarykey());
            Language language = new Language();
            language.setAlpha2("gi");
            language.setAlpha3("Flh");
            language.setAlpha4("I94B");
            language.setAlpha4parentid(10);
            language.setLanguage("8qDsVEY7liKEY7aIp90ZPWm0UQpYVjmTzUiBXIlbgZA4JAdrJ3");
            language.setLanguageDescription("GcP6iAVnPbShhypy5K30MYsR5S4Hq1jehLm8wHT8UyN5IUdQl2");
            language.setLanguageIcon("1bsNWDklv56Kdg7IbM2cydL0AP1MZbptuyPRESiH5NvV3FBfiM");
            language.setLanguageType("35aMHLmGlVNMi5X2TR9r9omHqWWkb09f");
            Language LanguageTest = languageRepository.save(language);
            map.put("LanguagePrimaryKey", language._getPrimarykey());
            Timezone timezone = new Timezone();
            timezone.setCities("t026gw2M6yPWJ94LZ5IxgYHKLkxOZw7oOvRoIMgn8S1Jyzl3zh");
            timezone.setCountry("VoRRcBhbxt1MiGiZMfIwmQ94ZVlwq9U66Acp6mc42gy2uyQjKr");
            timezone.setGmtLabel("bQL2oWLqh5p6Pk9CjPPN5zhUWqiF1wyM8hX2mQ87xEWsXcLYF1");
            timezone.setTimeZoneLabel("o1SKyxTGzEz7XcXNrlZaWaBHVgW5nymjxj5n132s3yASwRSQp2");
            timezone.setUtcdifference(3);
            Title title = new Title();
            title.setTitles("HOs9fjf1BWglm7xcUnnQocJRbbQ4QjSXPuui0CG3HLsLP51fm2");
            Title TitleTest = titleRepository.save(title);
            map.put("TitlePrimaryKey", title._getPrimarykey());
            corecontacts.setAge(50);
            corecontacts.setApproximateDOB(new java.sql.Date(123456789));
            corecontacts.setDateofbirth(new java.sql.Date(123456789));
            corecontacts.setEmailId("w5yrP7Mc7GAe3Ezw90rHrV0SF8023DKKWhFRNuAjBsOcvGIYk7");
            corecontacts.setFirstName("54AGx2m8GemwnAwgwe5HnB9x0q9O0GWSYHVZEhA2dqhVVRMayk");
            corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setLastName("9ZFtMsgYKWjtALGCy5jm0aLz9u4OkCqZdCAIn1RymO6XZK9YJv");
            corecontacts.setMiddleName("Hnrf5jesIuTDTnNYPrgucLaVP9y4QBdXOd4CydPfX9gWZ0A9oi");
            corecontacts.setNativeFirstName("W9HNJEENmXZNqy4jtvDtCW88QR5KTRXVAvRoIlGNFoHUgGVBZn");
            corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
            corecontacts.setNativeLastName("ztmLfn0AMFLJbu8HGva98seeVXBNhjxFsZdAfukvL9PXFsveec");
            corecontacts.setNativeMiddleName("9Mpp2bUWHGo5p22IM5sAAFLdFpesESl4aH3jbM5LMmrUZ1pRZz");
            corecontacts.setNativeTitle("4Prxif1kpo0J91oM1SblanCiFH5KhQMUuWrECI5BiusrgLqyEz");
            corecontacts.setPhoneNumber("soPASDxPJlhC98G9AnH7");
            corecontacts.setTimezone(timezone);
            corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
            User user = new User();
            user.setAllowMultipleLogin(1);
            user.setChangePasswordNextLogin(1);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(1);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(0);
            user.setPasswordAlgo("sqs3nPQG2GYyNCDbuF7MRjp7Qh6zqWuckDMJq4I3TPBSEye41O");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(940);
            user.setUserAccessCode(11);
            UserAccessDomain useraccessdomain = new UserAccessDomain();
            useraccessdomain.setDomainDescription("i0nelb5Es8BDjhpNCztkyn16VGGNHFaf16PLqPGGDpX7WTZzi7");
            useraccessdomain.setDomainHelp("HVAyluJwTgM28H357PKjvr9deq2fYGfTOoamRJj5swQl2YhSKD");
            useraccessdomain.setDomainIcon("iVXFEiraXXk5y0WyIa14M0FRBmYVozKScsPpM91NfHE18J0bLk");
            useraccessdomain.setDomainName("yIPI8xA5oqKNSwwF73PxTxDENs7uCq0aKnWR8oLi6v91TuwzWy");
            useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
            UserAccessDomain UserAccessDomainTest = useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
            UserAccessLevel useraccesslevel = new UserAccessLevel();
            useraccesslevel.setLevelDescription("B3jhkipBaMmmlJ8OvoIpoSqeu5oUdGQ5z3iBSJGpAebwshGxfa");
            useraccesslevel.setLevelHelp("Fi2g0RicwBqywseoyxxzsxxCTP8aRIPze7K0vpj5q7HVK2GtGf");
            useraccesslevel.setLevelIcon("UvW2BrXPlr7nGG4Lo6vKo0fpainwBq8jndo91AvRPg6584IWSo");
            useraccesslevel.setLevelName("5zlY0scuLtrGr2SDlCUGghj14y9dDgnyfvw2wODWuyuiRSBkTm");
            useraccesslevel.setUserAccessLevel(valueGenerator.getRandomInteger(99999, 0));
            UserAccessLevel UserAccessLevelTest = useraccesslevelRepository.save(useraccesslevel);
            map.put("UserAccessLevelPrimaryKey", useraccesslevel._getPrimarykey());
            user.setAllowMultipleLogin(0);
            user.setChangePasswordNextLogin(0);
            user.setGenTempOneTimePassword(0);
            user.setIsDeleted(0);
            user.setIsLocked(0);
            user.setLastPasswordChangeDate(new java.sql.Timestamp(123456789));
            user.setMultiFactorAuthEnabled(1);
            user.setPasswordAlgo("Y9A4vkbURqTm7KbEK5KGjWO5uOCzNYSgyHlXArCF7alxiTL0yI");
            user.setPasswordExpiryDate(new java.sql.Timestamp(123456789));
            user.setSessionTimeout(2301);
            user.setUserAccessCode(5);
            user.setUserAccessDomainId((java.lang.String) UserAccessDomainTest._getPrimarykey()); /* ******Adding refrenced table data */
            user.setUserAccessLevelId((java.lang.String) UserAccessLevelTest._getPrimarykey());
            Login login = new Login();
            login.setCoreContacts(corecontacts);
            login.setFailedLoginAttempts(1);
            login.setIsAuthenticated(true);
            login.setLoginId("lC1DqMjriRGU9beiDkUQxvsY4rha1VIZAc7E0y0rvvS7UXqw9Z");
            login.setServerAuthImage("m1QJkWzWcxAmXonovH42zCkxsaFlncng");
            login.setServerAuthText("iesMwaSHu8HVRe8m");
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
            login.setFailedLoginAttempts(6);
            login.setLoginId("cjyToNDoYMq3iDEqJhQ1PQa54VzF8o7fhheD8mHGi8CLrbsRkX");
            login.setServerAuthImage("JqEat7IHz7TFBrucD0J46xV1GSyNDh3g");
            login.setServerAuthText("3zsIL0iS8ewsxiUB");
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
    public void testNQFindMappedUser() {
        try {
            loginRepository.FindMappedUser();
        } catch (Exception e) {
            e.printStackTrace();
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
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("LoginPrimaryKey"));
            loginRepository.delete((java.lang.String) map.get("LoginPrimaryKey")); /* Deleting refrenced data */
            useraccesslevelRepository.delete((java.lang.String) map.get("UserAccessLevelPrimaryKey")); /* Deleting refrenced data */
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey")); /* Deleting refrenced data */
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
