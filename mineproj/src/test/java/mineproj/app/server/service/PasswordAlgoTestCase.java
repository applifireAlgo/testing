package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.PasswordAlgoRepository;
import mineproj.app.shared.authentication.PasswordAlgo;
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
public class PasswordAlgoTestCase {

    @Autowired
    private PasswordAlgoRepository<PasswordAlgo> passwordalgoRepository;

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
            PasswordAlgo passwordalgo = new PasswordAlgo();
            passwordalgo.setAlgoDescription("01KsCwNN5bWwi63pZ1gGuNtRT2JrdNOG8ZLVX6T0rUb51DP8sB");
            passwordalgo.setAlgoHelp("vhlkKjKo9bbjKSSe9zrGIiulH0Yx2CSgkHKNkLEXaxhgeJ3nfI");
            passwordalgo.setAlgoIcon("NaNNJxzb3Y6vn5zgmU5r175IXuI2ofvnJD4txwO9HqRGao1bRP");
            passwordalgo.setAlgoName("PcptLkao6WMOfm926a4FKQaBYcqxcBXGrZaSZyh8bHTRKPmdbC");
            passwordalgo.setAlgorithm(9);
            passwordalgo.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            passwordalgo.setEntityValidator(entityValidator);
            passwordalgo.isValid();
            passwordalgoRepository.save(passwordalgo);
            map.put("PasswordAlgoPrimaryKey", passwordalgo._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordAlgoPrimaryKey"));
            PasswordAlgo passwordalgo = passwordalgoRepository.findById((java.lang.String) map.get("PasswordAlgoPrimaryKey"));
            passwordalgo.setAlgoDescription("i9l2X26zhpgqnYXZyATiAMzSBfD8KUW0vBU7VcvCFNMCWpkAVW");
            passwordalgo.setAlgoHelp("i3RJTyfD3VVX91XG2lzTM1DyxOmPA36ZMiTxpuhXsnzsb9KSCs");
            passwordalgo.setAlgoIcon("WrU5WJ6ST5I4OnoDeK97c5BiIkzs9FzuDyPskcq4gloVY5SlFW");
            passwordalgo.setAlgoName("2jFERoSuZjWQrw5KMaistQXQSMMY5xc1aJI2vRVClseUUg9Y5y");
            passwordalgo.setAlgorithm(7);
            passwordalgo.setVersionId(1);
            passwordalgo.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            passwordalgoRepository.update(passwordalgo);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordAlgoPrimaryKey"));
            passwordalgoRepository.findById((java.lang.String) map.get("PasswordAlgoPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("PasswordAlgoPrimaryKey"));
            passwordalgoRepository.delete((java.lang.String) map.get("PasswordAlgoPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
