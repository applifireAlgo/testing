package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.AppMenusRepository;
import mineproj.app.shared.authorization.AppMenus;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class AppMenusTestCase {

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

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
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("lBXohs3jouT5XAPgG2CF5qpox0iprT8UqX5x15d8Jyarz8MZm6");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(2);
            appmenus.setMenuAction("wO37bCvKLO9rM1mbPgehJxzdYG7kekFxKjESJ9kkM18dIDbHyU");
            appmenus.setMenuCommands("HLhqxgiPZmq1sWm7ZESIEw2DZFBfeCHBFJk6NmJckMW1Xhcg04");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("uJIW8U1nwEWqFp7lPpkVNIu3vam84WG4mBKyYjft41uZ8GQsvV");
            appmenus.setMenuLabel("kA2vYKYblGFx8qf6mEMTZJh99mhQCv0DCBqe3CZl9Fo535qdkC");
            appmenus.setMenuTreeId("E6O7qt92Fx2b2foy2fDnFB0XLmyGTVZxJUVf2Yj5szb6o5ZeKM");
            appmenus.setRefObjectId("RRZocMh0LtvVt7YrZnvozpWuiYGMYzaFbZMTXcpXrbNBLe0bZj");
            appmenus.setUiType("Eax");
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            appmenus.setEntityValidator(entityValidator);
            appmenus.isValid();
            appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            AppMenus appmenus = appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
            appmenus.setAppId("NJO8G6JvMdUJ0hBFpe815DsrvFC6opZY2RSd36KE1RTYCOf5cT");
            appmenus.setAppType(2);
            appmenus.setMenuAccessRights(3);
            appmenus.setMenuAction("pAjczjDVuIS3MmGpiueJxX4Ak1ztIFrP1x3M3sWel6eNx4Ptjm");
            appmenus.setMenuCommands("16zCqWD64hMIiHYy4OsGkFJrd07rqET84AOeOGTm0XUFRXNc9x");
            appmenus.setMenuIcon("SR9GXZLrudhU5NmvgBwkWk5McFTpaW0E4FE1aHumFse5NI0OOH");
            appmenus.setMenuLabel("KibjeTBRvRgx6cyMubs9nofTo4sduKo2v9Y0GeVbBLSkIXSK9a");
            appmenus.setMenuTreeId("cmBsnMWrnFYXhNDT32LsZ8a8wSixORjK242SQD2MCbbmXCrTNJ");
            appmenus.setRefObjectId("kbLcmdBrwJ8qdLxP7c2gGPA4qubCYrKQbO0fbVucf47nYUnU1B");
            appmenus.setUiType("2XQ");
            appmenus.setVersionId(1);
            appmenus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            appmenusRepository.update(appmenus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.findById((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("AppMenusPrimaryKey"));
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
