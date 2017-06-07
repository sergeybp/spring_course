import helpers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testsite.entities.User;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.isInState;
import static testsite.TestEpamWebSite.contactFormPage;
import static testsite.TestEpamWebSite.mainPage;
import static testsite.enums.States.LOGGED_IN;
import static testsite.enums.States.LOGGED_OUT;

/**
 * Created by sergeybp on 23.05.17.
 */
public class ContactFormTests extends InitTests{

    @BeforeClass
    public void openMainAndLogout(){
        mainPage.shouldBeOpened();
        isInState(LOGGED_IN);
    }

    @Test(dataProvider = "usersSetHardcoded", dataProviderClass = DataProviders.class)
    public void testContactForm(User user, boolean isCorrect){
        contactFormPage.shouldBeOpened();
        contactFormPage.contactForm.submit(user);
        Assert.assertTrue(contactFormPage.result.getText().contains(user.getDescription()));
        Assert.assertTrue(contactFormPage.result.getText().contains(user.getName()));
        Assert.assertTrue(contactFormPage.result.getText().contains(user.getLastName()));
    }



}
