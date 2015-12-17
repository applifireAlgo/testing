package mineproj.app.server.service;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import mineproj.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import mineproj.app.server.repository.StateRepository;
import mineproj.app.shared.location.State;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class StateTestCase {

    @Autowired
    private StateRepository<State> stateRepository;

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
            country.setCapital("xy599NiJRngqNB3ZPLuHtWiZnML2ulFD");
            country.setCapitalLatitude(6);
            country.setCapitalLongitude(9);
            country.setCountryCode1("yaM");
            country.setCountryCode2("GrQ");
            country.setCountryFlag("ulGjKnLlbV6Ha1P5gOi9x68yo872m1ZnwwSjZkb1BS7G4BETIX");
            country.setCountryName("kFapCkNQZhm6N84RC9vz1o78ZibNgnsip9BqmZMhGXQt9o3AiT");
            country.setCurrencyCode("h9p");
            country.setCurrencyName("KLrzlvTw32brNqAkJgIBSzdmUS1T2WFuB09BFwasmeuWIk82k3");
            country.setCurrencySymbol("vB9SDQk5P4XECEo8JZ7atGHrRdqKEXNH");
            country.setIsoNumeric(1);
            Country CountryTest = countryRepository.save(country);
            map.put("CountryPrimaryKey", country._getPrimarykey());
            State state = new State();
            state.setCountryId((java.lang.String) CountryTest._getPrimarykey());
            state.setStateCapital("aFJhKGK8DIzyDeetq5stRqnYyqDNfPnEBCEFUBhnXKBbnNhGS6");
            state.setStateCapitalLatitude(3);
            state.setStateCapitalLongitude(6);
            state.setStateCode(0);
            state.setStateCodeChar2("D4LIn2Ac79IGylOdvzKAUSnkjgXQzXxX");
            state.setStateCodeChar3("rSHI63uQkf0WQaRkRDfNnAvpjOOiEYm2");
            state.setStateDescription("bOTdOyMCyIRmG5myqo8sYzcqfDtJZIMlGGk5lEtRjqSktz4WQp");
            state.setStateFlag("9PrfkEIfqAVNJb35xab9h1fUbVzef8UuoUHp08ZPuHa38SAev0");
            state.setStateName("i3lwM3NcgomO9G0b9ZUbZid2iuqp6sQLiKDrJ1lyEkv9DeGyh2");
            state.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            state.setEntityValidator(entityValidator);
            state.isValid();
            stateRepository.save(state);
            map.put("StatePrimaryKey", state._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            State state = stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
            state.setStateCapital("dHSJUz4LVNi1haNKuHo1Mq6Q0xokH0TivhkbJ8QEAqsn4fesUo");
            state.setStateCapitalLatitude(2);
            state.setStateCapitalLongitude(0);
            state.setStateCode(1);
            state.setStateCodeChar2("Yub0Dmw7vTidGLG21wXISth5qSGQLjzw");
            state.setStateCodeChar3("ycy3bhP8pmpHY4waDYEB95dHH9RXibXh");
            state.setStateDescription("UG3lYl0WbPUcNJ3XmibRK8KFmaAQU7WMO5bcuGa8L9y0XExSn1");
            state.setStateFlag("QUHKB2MNGFvWGajtUKggVoLt4muRsRAW0ISCWhJfEfB31Vi5ai");
            state.setStateName("TU7YOKx8ySYbsQsqCKD9vPnq4C9l1EoKTQq6VeTqRe73EzBorw");
            state.setVersionId(1);
            state.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            stateRepository.update(state);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycountryId() {
        try {
            java.util.List<State> listofcountryId = stateRepository.findByCountryId((java.lang.String) map.get("CountryPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.findById((java.lang.String) map.get("StatePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("StatePrimaryKey"));
            stateRepository.delete((java.lang.String) map.get("StatePrimaryKey")); /* Deleting refrenced data */
            countryRepository.delete((java.lang.String) map.get("CountryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }
}
