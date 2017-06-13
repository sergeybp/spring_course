import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ICell;
import com.epam.jdi.uitests.core.interfaces.complex.interfaces.IColumn;
import com.epam.jdi.uitests.core.interfaces.complex.interfaces.IRow;
import com.epam.jdi.uitests.core.interfaces.complex.interfaces.Row;
import com.epam.jdi.uitests.web.settings.WebSettings;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testsite.entities.CustomDate;
import testsite.entities.User;
import testsite.enums.Months;

import java.util.List;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static testsite.TestEpamWebSite.datesPage;
import static testsite.TestEpamWebSite.mainPage;
import static testsite.TestEpamWebSite.simpleTablePage;
import static testsite.enums.States.LOGGED_IN;
import static testsite.enums.States.LOGGED_OUT;

/**
 * Created by sergeybp on 29.05.17.
 */
public class SimpleTableTests extends InitTests {

    @BeforeClass
    public void openMainAndLogout(){
        mainPage.shouldBeOpened();
        isInState(LOGGED_IN);
        simpleTablePage.shouldBeOpened();
    }

    @Test
    public void testSize(){
        WebSettings.getDriver().switchTo().window(WebSettings.getDriver().getWindowHandle());
        IRow rows = simpleTablePage.table.rows();
        Assert.assertEquals(rows.count(), 6);
        IColumn colums = simpleTablePage.table.columns();
        Assert.assertEquals(colums.count(), 3);
    }

    @Test
    public void testTableNames(){
        for(int i = 1 ; i <= 6; i++ ){
            for(int j = 1; j <=3; j ++){
                simpleTablePage.table.cell(j,i).click();
                Assert.assertTrue(simpleTablePage.log.getText().contains(simpleTablePage.table.cell(j,i).getText()));
            }
        }
    }

    @Test
    public void checkContent(){
        Assert.assertEquals(simpleTablePage.table.getValue(), "||X||||\n" +
                "||1||Drivers|Selenium Custom|JavaScript, Appium, WinAPI, Sikuli||\n" +
                "||2||Test Runner|TestNG, JUnit Custom|MSTest, NUnit, Epam||\n" +
                "||3||Asserter|TestNG, JUnit, Custom|MSTest, NUnit, Epam||\n" +
                "||4||Logger|Log4J, TestNG log, Custom|Epam, XML/Json logging, Hyper logging||\n" +
                "||5||Reporter|Jenkins, Allure, Custom|EPAM Report portal, Serenity, TimCity, Hudson||\n" +
                "||6||BDD/DSL|Custom|Cucumber, Jbehave, Thucydides, SpecFlow||");
    }

}
