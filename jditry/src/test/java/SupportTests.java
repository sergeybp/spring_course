import com.epam.commons.LinqUtils;
import com.epam.commons.map.MapArray;
import com.epam.jdi.uitests.core.interfaces.complex.interfaces.Column;
import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ICell;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.web.matcher.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testsite.entities.Item;

import java.awt.*;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static testsite.TestEpamWebSite.mainPage;
import static testsite.TestEpamWebSite.supportPage;
import static testsite.enums.States.LOGGED_IN;

/**
 * Created by sergeybp on 05.06.17.
 */
public class SupportTests extends InitTests {

    @BeforeMethod
    public void init(){
        mainPage.shouldBeOpened();
        isInState(LOGGED_IN);
        supportPage.shouldBeOpened();
    }

    @Test
    public void supportTableTest(){
        Assert.areEquals(supportPage.supportTable.getValue(), "||X||Type|Now|Plans||\n" +
                "||1||Drivers|Selenium, Custom|JavaScript, Appium, WinAPI, Sikuli||\n" +
                "||2||Test Runner|TestNG, JUnit, Custom|MSTest, NUnit, Epam||\n" +
                "||3||Asserter|TestNG, JUnit, Custom|MSTest, NUnit, Epam||\n" +
                "||4||Logger|Log4J, TestNG log, Custom|Epam, XML/Json logging, Hyper logging||\n" +
                "||5||Reporter|Jenkins, Allure, Custom|EPAM Report portal, Serenity, TimCity, Hudson||\n" +
                "||6||BDD/DSL|Custom|Cucumber, Jbehave, Thucydides, SpecFlow||");
    }

    @Test
    public void anotherTest(){
        MapArray<String, ICell> row = supportPage.supportTable.rowContains("MSTest", Column.inColumn("Plans"));
        Assert.areEquals(row.size(),3);
        Assert.areEquals(row.get("Type").getText(), "Test Runner");
    }

    @Test
    public void entityTest(){
        EntityTable<Item, ?> table = supportPage.supportEntityTable;
        //List<Item> rows = table.entities();
        //Item row = LinqUtils.first(rows, r -> r.Type.equals("Test Runner"));
    }

}
