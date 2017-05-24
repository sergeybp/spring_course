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

    @JFindBy(css = "header")
    public EpamTestHeader header;

    @JFindBy(className = "form")
    public ContactForm contactForm;

    @JFindBy(xpath = "/html/body/div/aside[2]/div/div/div[1]/section[2]/div[2]")
    public IText result;

}
