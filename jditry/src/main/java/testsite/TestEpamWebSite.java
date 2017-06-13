package testsite;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import testsite.pages.*;

/**
 * Created by sergeybp on 22.05.17.
 **/
@JSite(domain = "https://epam.github.io/JDI")
public class TestEpamWebSite extends WebSite {

    @JPage(url = "index.htm")
    public static MainPage mainPage;

    @JPage(url = "page1.htm", title = "Contact Form")
    public static ContactFormPage contactFormPage;

    @JPage(url = "page4.htm", title = "Dates")
    public static DatesPage datesPage;

    @JPage(url = "page6.htm", title = "Simple Table")
    public static SimpleTablePage simpleTablePage;


    @JPage(url = "page5.htm")
    public static ComplexTablePage complexPage;

    @JPage(url = "page3.htm")
    public static SupportPage supportPage;

}
