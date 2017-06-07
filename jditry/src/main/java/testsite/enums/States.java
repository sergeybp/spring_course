package testsite.enums;

import com.epam.commons.linqinterfaces.JAction;
import com.epam.jdi.uitests.core.preconditions.IPreconditions;
import com.google.common.base.Supplier;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.alwaysMoveToCondition;
import static testsite.TestEpamWebSite.mainPage;

/**
 * Created by sergeybp on 30.05.17.
 */
public enum  States implements IPreconditions {

    LOGGED_IN(() -> mainPage.isLoggedIn(),
            () -> mainPage.login()),
    LOGGED_OUT(() -> ! mainPage.isLoggedIn() && !mainPage.loginForm.isDisplayed(),
            () -> mainPage.logout());

    public Supplier<Boolean> checkAction;
    public JAction moveToAction;

    States(Supplier<Boolean> checkAction, JAction moveToAction) {
        this.checkAction = checkAction;
        this.moveToAction = moveToAction;
        alwaysMoveToCondition = false;
    }

    public Boolean checkAction() { return checkAction.get();}
    public void moveToAction() { moveToAction.invoke(); }
}
