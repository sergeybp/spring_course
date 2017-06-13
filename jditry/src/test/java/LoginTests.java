import org.testng.annotations.AfterClass;
import testsite.entities.User;
import helpers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static testsite.TestEpamWebSite.mainPage;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;
import static testsite.enums.States.LOGGED_IN;
import static testsite.enums.States.LOGGED_OUT;

/**
 * Created by sergeybp on 22.05.17.
 **/
public class LoginTests extends InitTests {

    @BeforeMethod
    public void tryLogout() {
        mainPage.shouldBeOpened();
    }

    @Test(dataProvider = "usersSetCsv", dataProviderClass = DataProviders.class)
    // Test login to epam test site using data from CSV file supplied by custom dataProvider
    public void testLoginCSV(User user, Boolean isCorrect) {
        logger.info("Login test started. DataProvider: CSV file.");
        testLogin(user, isCorrect);
    }

    @Test(dataProvider = "usersSetHardcoded", dataProviderClass = DataProviders.class)
    // Test login to epam test site using data from hardcoded set supplied by custom dataProvider
    public void testLoginHardcodedSet(User user, Boolean isCorrect) {
        logger.info("Login test started. DataProvider: Hardcoded set.");
        testLogin(user, isCorrect);
    }

    public void testLogin(User user, boolean isCorrect){
        isInState(LOGGED_OUT);
        mainPage.login(user);
        Assert.assertEquals(mainPage.isLoggedIn(), isCorrect);
    }

    @AfterClass
    public void logout(){
        isInState(LOGGED_OUT);
    }

}
