package testsite.pages;

import com.epam.jdi.uitests.web.selenium.elements.complex.table.EntityTable;
import com.epam.jdi.uitests.web.selenium.elements.complex.table.Table;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import testsite.entities.TableEntity;
import testsite.entities.TableRow;

/**
 * Created by sergeybp on 01.06.17.
 */
public class ComplexTablePage extends WebPage {

    @JFindBy(css = ".uui-table")
    public Table table;
    //public EntityTable<TableEntity, TableRow> table = new EntityTable<TableEntity, TableRow>(TableEntity.class, TableRow.class);




}
