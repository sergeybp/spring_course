package testsite.pages;

import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import testsite.forms.LoginForm;
import testsite.other.User;

/**
 * Created by sergeybp on 22.05.17.
 */
public class MainPage extends WebPage {

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
            loginForm.fill(new User("",""));
            loginOpen.clickCenter();
        }
    }


}
