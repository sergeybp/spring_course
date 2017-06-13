package testsite.pages;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JTable;

import org.openqa.selenium.support.FindBy;
import testsite.entities.Technology;
import testsite.section.TechRow;

import static com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.TableHeaderTypes.ALL_HEADERS;


public class ComplexTablePage extends WebPage {
    @JTable(
        root = @FindBy(css = "table.table-delete-body"),
        headerType = ALL_HEADERS,
        colStartIndex = 2
    )
    public EntityTable<Technology, TechRow> complexTable =
        new EntityTable<>(Technology.class, TechRow.class);

    @JFindBy(className = "info-panel-body-log")
    public IText log;

    @JFindBy(text = "Reestablish")
    public IButton reestablish;

}
