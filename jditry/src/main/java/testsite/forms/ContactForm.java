package testsite.forms;

import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import testsite.entities.User;

/**
 * Created by sergeybp on 23.05.17.
 */
public class ContactForm extends Form<User> {

    @JFindBy(id = "Name")
    private ITextField name;

    @JFindBy(id = "LastName")
    private ITextField lastName;

    @JFindBy(id = "Description")
    private ITextField description;

    @JFindBy(text = "Submit")
    private IButton submit;

}
