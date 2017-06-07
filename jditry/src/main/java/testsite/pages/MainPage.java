package testsite.pages;

import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.common.Text;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import testsite.entities.Users;
import testsite.forms.LoginForm;
import testsite.entities.User;

/**
 * Created by sergeybp on 22.05.17.
 */
public class MainPage extends WebPage {

    @JFindBy(css = ".profile-photo")
    public Label profileLabel;

    @JFindBy(css = ".profile-photo span")
    public Text userName;

    @JFindBy(xpath = "//span[.='Logout']")
    public Button logout;

    @JFindBy(className = "form-horizontal")
    public LoginForm loginForm;

    public boolean isLoggedIn() {
        return userName.isDisplayed();
    }

    public void login() {
        login(Users.DEFAULT);
    }

    public void login(User user) {
        profileLabel.click();
        loginForm.login(user);
    }

    public void logout() {
        if(loginForm.isDisplayed()){
            loginForm.fill(Users.EPMTY);
            profileLabel.click();
            return;
        }
        if(!logout.isDisplayed())
            profileLabel.click();
        logout.click();
        profileLabel.click();
    }


}
