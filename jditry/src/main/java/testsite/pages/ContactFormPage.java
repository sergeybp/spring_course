package testsite.pages;

import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import testsite.forms.ContactForm;
import testsite.headers.EpamTestHeader;

/**
 * Created by sergeybp on 23.05.17.
 */
public class ContactFormPage extends WebPage {

    @JFindBy(className = "form")
    public ContactForm contactForm;

    @JFindBy(className = "results")
    public IText result;

}