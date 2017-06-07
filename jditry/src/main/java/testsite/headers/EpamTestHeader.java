package testsite.headers;

import com.epam.jdi.uitests.web.selenium.elements.base.Clickable;
import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import testsite.entities.User;
import testsite.entities.Users;
import testsite.forms.LoginForm;

/**
 * Created by sergeybp on 23.05.17.
 */
public class EpamTestHeader extends Section{

    @JFindBy(className = "navbar-right")
    public Element loginOpen;

    @JFindBy(className = "form-horizontal")
    public LoginForm loginForm;

    @JFindBy(className = "logout")
    public Button logoutButton;

    public void tryLogout(){
        if(logoutButton.isDisplayed()){
            logoutButton.click();
            loginOpen.clickCenter();
        } else if (loginForm.isDisplayed()) {
            loginOpen.clickCenter();
            loginForm.fill(Users.EPMTY);
        } else {
            loginOpen.clickCenter();
            if(loginForm.isDisplayed()){
                loginOpen.clickCenter();
            } else {
                logoutButton.click();
                loginOpen.clickCenter();
            }
        }
    }

}
