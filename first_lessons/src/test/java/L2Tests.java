import helpers.DataProviders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

/**
 * Created by sergeybp on 04.05.17.
 */
public class L2Tests {

    private WebDriver driver;

    @BeforeSuite
    public void init() {
        System.setProperty("webdriver.gecko.driver", "/home/sergeybp/geckodriver");
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    public void clearCookies() {
        // Clean cookies to test another users
        driver.manage().deleteAllCookies();
    }


    @Test(dataProvider = "usersSetCsv", dataProviderClass = DataProviders.class)
    // Test login to epam test site using data from CSV file supplied by custom dataProvider
    public void testLoginCSV(String userName, String userPassword, Boolean isCorrect) {
        testLogin(userName, userPassword, isCorrect);
    }

    @Test(dataProvider = "usersSetHardcoded",dataProviderClass = DataProviders.class)
    // Test login to epam test site using data from hardcoded set supplied by custom dataProvider
    public void testLoginHardcodedSet(String userName, String userPassword, Boolean isCorrect) {
        testLogin(userName, userPassword, isCorrect);
    }


    // Source of login method general for all tests
    private void testLogin(String userName, String userPassword, Boolean isCorrect) {

        // Moving to epam test site
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        // Wait for page loading complete
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("profile-photo"))).click();

        // Setting userName
        WebElement textField = driver.findElement(By.id("Login"));
        textField.sendKeys(userName);

        //Setting userPassword
        textField = driver.findElement(By.id("Password"));
        textField.sendKeys(userPassword);

        // Click login button
        driver.findElement(By.className("uui-button")).click();

        // Checking login status
        assert (!driver.findElement(By.className("login-txt")).isDisplayed() == isCorrect);
    }


    @AfterSuite
    public void onExit() {
        driver.close();
    }

}
