package testsite.pages;

import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.core.interfaces.complex.interfaces.ITable;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import org.openqa.selenium.support.FindBy;

/**
 * Created by sergeybp on 29.05.17.
 */
public class SimpleTablePage extends WebPage {

    @JFindBy(className = "info-panel-body-log")
    public IText log;

    @JFindBy(css = "table.uui-table.stripe.tbl-without-header.table-td-click")
    public Table table;


}
