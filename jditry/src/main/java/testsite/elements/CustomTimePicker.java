package testsite.elements;


import com.epam.jdi.uitests.core.interfaces.CascadeInit;
import com.epam.jdi.uitests.core.interfaces.base.IComposite;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.core.interfaces.common.ITextField;
import com.epam.jdi.uitests.web.selenium.elements.WebCascadeInit;
import com.epam.jdi.uitests.web.selenium.elements.base.Clickable;
import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.settings.WebSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import testsite.entities.CustomClock;

/**
 * Created by sergeybp on 29.05.17.
 */
public class CustomTimePicker extends Element implements IComposite {

    @JFindBy(css = "[data-action=incrementHour]")
    public IButton incrementHours;

    @JFindBy(css = "[data-action=incrementMinute]")
    public IButton incrementMinutes;

    @JFindBy(className = "meridian-column")
    public IButton changeMeridian;

    @JFindBy(className = "bootstrap-timepicker-hour")
    public ITextField hoursText;

    @JFindBy(className = "bootstrap-timepicker-minute")
    public ITextField minutesText;

    @JFindBy(className = "bootstrap-timepicker-meridian")
    public ITextField meridianText;

    @JFindBy(className = "bootstrap-timepicker-minute")
    public Clickable clickMinutes;

    /*public CustomTimePicker() {
        new WebCascadeInit().initElements(this, WebSettings.getDriverFactory().currentDriverName());
    }*/

    public void setTime(CustomClock clock){
        if(clock.getMinutes() % 15 == 0) {
            while (!minutesText.getText().equals("" + clock.getMinutes())) {
                incrementMinutes.click();
            }
        } else {
            clickMinutes.clickCenter();
            minutesText.input(""+clock.getMinutes());
        }
        while (!hoursText.getText().equals(""+clock.getHours())){
            incrementHours.click();
        }

        if(clock.isAm()){
            if(!meridianText.getText().equals("AM")){
                changeMeridian.click();
            }
        } else {
            if(!meridianText.getText().equals("PM")){
                changeMeridian.click();
            }
        }

    }

}
