import com.epam.jdi.uitests.web.settings.WebSettings;
import helpers.DataProviders;
import org.junit.Ignore;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testsite.entities.CustomClock;
import testsite.entities.CustomDate;
import testsite.entities.User;
import testsite.enums.Months;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static testsite.TestEpamWebSite.contactFormPage;
import static testsite.TestEpamWebSite.datesPage;
import static testsite.TestEpamWebSite.mainPage;
import static testsite.enums.States.LOGGED_IN;
import static testsite.enums.States.LOGGED_OUT;
import static com.epam.jdi.uitests.core.settings.JDISettings.logger;

/**
 * Created by sergeybp on 27.05.17.
 */
public class DatesAndClocksTest extends InitTests {

    @BeforeClass
    public void loginAndOpenPage(){
        mainPage.shouldBeOpened();
        isInState(LOGGED_IN);
        datesPage.shouldBeOpened();
    }

    @BeforeMethod
    public void refreshPage(){
        datesPage.refresh();
    }

    @Test(dataProvider = "datesProvider", dataProviderClass = DataProviders.class)
    public void testDates(CustomDate date){
        datesPage.openDatePicker.click();
        datesPage.datePicker.setDate(date);
        Assert.assertTrue(datesPage.log.getText().contains(date.toString()));
    }

    @Test(dataProvider = "clocksProvider", dataProviderClass = DataProviders.class)
    public void testClocks(CustomClock clock){
        datesPage.openTimePicker.click();
        datesPage.timePicker.setTime(clock);
        Assert.assertTrue(datesPage.log.getText().contains(clock.toString()));

    }

    /*@Test
    public void testSubmit(){
        WebSettings.getJSExecutor().executeScript("document.body.style.zoom = '50%';");
        //datesPage.findInvisibleBefore();
        //WebSettings.getJSExecutor().executeScript("document.getElementByText(\"Submit\").click();");
        WebSettings.getDriver().findElement(By.cssSelector("[type=submit]")).click();


    }*/

}
