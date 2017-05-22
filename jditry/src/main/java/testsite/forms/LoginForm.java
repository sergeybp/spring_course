package testsite.forms;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import testsite.other.User;

/**
 * Created by sergeybp on 22.05.17.
 */
public class LoginForm extends Form<User> {

    @JFindBy(id = "Login")
    private ITextField name;

    @JFindBy(id = "Password")
    private ITextField password;

    @JFindBy(css = "[type=submit]")
    private IButton submit;

}
