import com.epam.web.matcher.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testsite.section.TechRow;
import org.springframework.util.StringUtils;

import java.util.List;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static testsite.TestEpamWebSite.complexPage;
import static testsite.TestEpamWebSite.mainPage;
import static testsite.enums.States.LOGGED_IN;

/**
 * Created by Roman_Iovlev on 6/1/2017.
 */
public class ComplexTableTests extends InitTests {

    @BeforeClass
    public void before() {
        mainPage.shouldBeOpened();
        isInState(LOGGED_IN);
        complexPage.shouldBeOpened();
    }


    @Test
    // Select checkboxes in Column1 for rows where Column2 contains JavaScript
    public void selectTest(){
        List<TechRow> rows = complexPage.complexTable.getRows(
                row -> row.Column2.title.getText().contains("JavaScript")
        );
        for(TechRow row: rows){
            row.Column1.sel.clickCenter();
        }
        Assert.areEquals(StringUtils.countOccurrencesOf(complexPage.log.getText(), "Select"), 2);
    }

    @Test
    // Check size
    public void sizeTest() {
        Assert.areEquals(complexPage.complexTable.columns().count(), 3);
        Assert.areEquals(complexPage.complexTable.rows().count(), 8);
    }

    @Test
    // Check content
    public void contentTest(){
        Assert.areEquals(complexPage.complexTable.getValue(), "||X||Titles|Column1|Column2||\n" +
                "||1||Microsoft Technologies|Select\n" +
                "See More\n" +
                ".NET Technologies|Select\n" +
                "See More\n" +
                "Internet Technologies||\n" +
                "||2||Mobile|Select\n" +
                "See More\n" +
                "HTML5/CSS3|Select\n" +
                "See More\n" +
                "JQuery Mobile||\n" +
                "||3||UXD|Select\n" +
                "See More\n" +
                "(X)CSS Development|Select\n" +
                "See More\n" +
                "Grunt (The JavaScript Task Runner)||\n" +
                "||4||Version Control Systems|Select\n" +
                "See More\n" +
                "CVS|Select\n" +
                "See More\n" +
                "TortoiseSVN||\n" +
                "||5||JavaScript Components and Frameworks|Select\n" +
                "See More\n" +
                "Backbone marionette js|Select\n" +
                "See More\n" +
                "Bootstrap||\n" +
                "||6||Software Construction|Select\n" +
                "See More\n" +
                "Internet Technologies|Select\n" +
                "See More\n" +
                "JavaScript Components and Frameworks||\n" +
                "||7||Life Sciences|Select\n" +
                "See More\n" +
                "Biology|Select\n" +
                "See More\n" +
                "Chemistry||\n" +
                "||8||Content management|Select\n" +
                "See More\n" +
                "Drupal|Select\n" +
                "See More\n" +
                "Adobe Day CRX||");
    }

}
