import testsite.entities.User;
import helpers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static testsite.TestEpamWebSite.mainPage;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

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
        mainPage.header.tryLogout();
        mainPage.header.loginOpen.clickCenter();
        Assert.assertTrue(mainPage.header.loginForm.isDisplayed());
        mainPage.header.loginForm.loginAs(user);
        Assert.assertEquals(mainPage.header.logoutButton.isDisplayed(), isCorrect);
    }

}
