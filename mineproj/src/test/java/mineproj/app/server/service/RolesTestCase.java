package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.RolesRepository;
import mineproj.app.shared.authorization.Roles;
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
import mineproj.app.shared.authorization.RoleMenuBridge;
import mineproj.app.shared.authorization.AppMenus;
import mineproj.app.server.repository.AppMenusRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RolesTestCase {

    @Autowired
    private RolesRepository<Roles> rolesRepository;

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
            Roles roles = new Roles();
            roles.setRoleDescription("ykkaQ11mekC3xD0UhuR3qsxPvzTVRB4ySTjs3OYmN2zDfEBYpV");
            roles.setRoleHelp("tZiT2evm66DH4LSZPsVeYcbE9KW1syksy07JnhnthwhjAzx2WC");
            roles.setRoleIcon("yOXGBURMmbkmQv0pY3voowABpkHpqbgsiJegDuELpuVpkchwNp");
            roles.setRoleName("KdLdCFd5EMQBcFiDoGgC0hcdUUnsz1bsOWoDlZR10Pgmt8quxh");
            java.util.List<RoleMenuBridge> listOfRoleMenuBridge = new java.util.ArrayList<RoleMenuBridge>();
            RoleMenuBridge rolemenubridge = new RoleMenuBridge();
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            AppMenus appmenus = new AppMenus();
            appmenus.setAppId("dLTiYv0wCfhKqnJrSUBV12hafvdBJbxPtbrjDNjQN3T43JJ9fu");
            appmenus.setAppType(1);
            appmenus.setMenuAccessRights(5);
            appmenus.setMenuAction("ZDMtLtJhWobSKc7ap9uOBiEuDPwhQpGJKs4lzxD293fca1A6Ka");
            appmenus.setMenuCommands("eyZ0OSyx0bP67raoqfjdJjUqXSdxNfEihCCfyGXX4UdWjS39Qu");
            appmenus.setMenuDisplay(true);
            appmenus.setMenuHead(true);
            appmenus.setMenuIcon("QCMdVUMuiHZip3SbEXDa4pcjLEQLZ9Rwhv6u9ephNgH5If5esI");
            appmenus.setMenuLabel("AcdKe5LXDM72x4G2IwVAo0teiWurKqtqPGqm8kNYI7iplnAAjd");
            appmenus.setMenuTreeId("9ejMp6jZzRCBfM03OLMD0XS4UJWeDQmNjqgw9Qo2vNt6W1UHa5");
            appmenus.setRefObjectId("QAwGsVp8U4we2Bmmr4GHmIsoIgdIZPk4uV2jrDWG9bxPWnobP9");
            appmenus.setUiType("dkn");
            AppMenus AppMenusTest = appmenusRepository.save(appmenus);
            map.put("AppMenusPrimaryKey", appmenus._getPrimarykey());
            rolemenubridge.setIsExecute(true);
            rolemenubridge.setIsRead(true);
            rolemenubridge.setIsWrite(true);
            rolemenubridge.setMenuId((java.lang.String) AppMenusTest._getPrimarykey());
            rolemenubridge.setRoles(roles);
            listOfRoleMenuBridge.add(rolemenubridge);
            roles.addAllRoleMenuBridge(listOfRoleMenuBridge);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roles.setEntityValidator(entityValidator);
            roles.isValid();
            rolesRepository.save(roles);
            map.put("RolesPrimaryKey", roles._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private AppMenusRepository<AppMenus> appmenusRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            Roles roles = rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
            roles.setRoleDescription("xRO1Y7PUimrcUhh8AJBT2Z8zfVHDbSNwG1Kupmnv2Vtaltgq4A");
            roles.setRoleHelp("dCs75g7A63cxYz2KE3x7zH5Ei1Tj8KfvHM6BLIEalqXXZxYC8O");
            roles.setRoleIcon("dflyctXSYNMV1ma9lEnS4lSZDVCkPu3cE4yXBcfFxwDwZFh57s");
            roles.setRoleName("vBWHXMCxwabsppf8TJgzlh1EchBnsIfFgCNR74P9qYvMSQjgOd");
            roles.setVersionId(1);
            roles.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            rolesRepository.update(roles);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.findById((java.lang.String) map.get("RolesPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RolesPrimaryKey"));
            rolesRepository.delete((java.lang.String) map.get("RolesPrimaryKey")); /* Deleting refrenced data */
            appmenusRepository.delete((java.lang.String) map.get("AppMenusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
