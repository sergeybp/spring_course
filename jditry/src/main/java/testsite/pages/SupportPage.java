package testsite.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import org.openqa.selenium.support.FindBy;
import testsite.entities.Item;

/**
 * Created by sergeybp on 05.06.17.
 */
public class SupportPage extends WebPage {

    @FindBy(tagName = "table")
    public Table supportTable;

    @FindBy(tagName = "table")
    public EntityTable<Item, ?> supportEntityTable = new EntityTable<Item, Object>(Item.class, Object.class);

}
