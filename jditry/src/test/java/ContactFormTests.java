import helpers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import testsite.entities.User;

import static testsite.TestEpamWebSite.contactFormPage;
import static testsite.TestEpamWebSite.mainPage;

/**
 * Created by sergeybp on 23.05.17.
 */
public class ContactFormTests extends InitTests{

    @BeforeMethod
    public void openMainAndLogout(){
        mainPage.shouldBeOpened();
        mainPage.header.tryLogout();
    }

    @Test(dataProvider = "usersSetHardcoded", dataProviderClass = DataProviders.class)
    public void testContactForm(User user, boolean isCorrect){
        mainPage.header.loginOpen.clickCenter();
        mainPage.header.loginForm.loginAs(user);
        Assert.assertEquals(mainPage.header.logoutButton.isDisplayed(), isCorrect);
        if(!isCorrect){
            return;
        }
        contactFormPage.shouldBeOpened();
        contactFormPage.contactForm.submit(user);
        Assert.assertTrue(contactFormPage.result.getText().contains(user.getDescription()));
        Assert.assertTrue(contactFormPage.result.getText().contains(user.getName()));
        Assert.assertTrue(contactFormPage.result.getText().contains(user.getLastName()));
    }



}
