package testsite.pages;

import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.sun.xml.internal.ws.server.sei.MessageFiller;
import testsite.forms.LoginForm;
import testsite.entities.User;
import testsite.headers.EpamTestHeader;

/**
 * Created by sergeybp on 22.05.17.
 */
public class MainPage extends WebPage {

    @JFindBy(css = "header")
    public EpamTestHeader header;

}
