package testsite;

import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import testsite.pages.ContactFormPage;
import testsite.pages.MainPage;

/**
 * Created by sergeybp on 22.05.17.
 **/
@JSite(domain = "https://jdi-framework.github.io/tests/")
public class TestEpamWebSite extends WebSite {

    @JPage(url = "index.htm")
    public static MainPage mainPage;

    @JPage(url = "page1.htm", title = "Contact Form")
    public static ContactFormPage contactFormPage;

}
