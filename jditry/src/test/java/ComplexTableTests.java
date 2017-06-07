import com.epam.jdi.uitests.core.interfaces.complex.interfaces.Row;
import helpers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testsite.entities.CustomDate;
import testsite.entities.TableRow;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static testsite.TestEpamWebSite.complexTablePage;
import static testsite.TestEpamWebSite.datesPage;
import static testsite.TestEpamWebSite.mainPage;
import static testsite.enums.States.LOGGED_IN;

/**
 * Created by sergeybp on 01.06.17.
 */
public class ComplexTableTests extends InitTests {

    @BeforeClass
    public void loginAndOpenPage(){
        mainPage.shouldBeOpened();
        isInState(LOGGED_IN);
        complexTablePage.shouldBeOpened();
    }


    @Test
    public void testDates(){
        complexTablePage.table.cell(2,2).click();
        //TableRow rr = complexTablePage.table.getRow(2);
        //System.out.print(rr.number);
    }

}
