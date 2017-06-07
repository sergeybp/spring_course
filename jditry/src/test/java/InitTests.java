import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.testng.testRunner.TestNGBase;
import com.epam.web.matcher.verify.Verify;
import testsite.TestEpamWebSite;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

/**
 * Created by sergeybp on 22.05.17.
 **/
public class InitTests extends TestNGBase{

    @BeforeSuite(alwaysRun = true)
    public static void setUp() throws Exception {

        WebSite.init(TestEpamWebSite.class);
        logger.info("Run Tests");
    }

    @AfterMethod
    public void tearDown() {
        Verify.getFails();
    }

}
