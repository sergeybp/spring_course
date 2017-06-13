package testsite.pages;

import com.epam.jdi.uitests.core.interfaces.base.IComposite;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.WebCascadeInit;
import com.epam.jdi.uitests.web.selenium.elements.base.Clickable;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.settings.WebSettings;
import testsite.elements.CustomDatePicker;
import testsite.elements.CustomTimePicker;

import java.awt.*;

/**
 * Created by sergeybp on 27.05.17.
 */
public class DatesPage extends WebPage implements IComposite{

    @JFindBy(className = "fa-calendar")
    public IButton openDatePicker;

    @JFindBy(className = "fa-clock-o")
    public IButton openTimePicker;

    @JFindBy(className = "bootstrap-timepicker-widget")
    public CustomTimePicker timePicker;

    @JFindBy(className = "datepicker")
    public CustomDatePicker datePicker;

    @JFindBy(text = "Submit")
    public Clickable submit;

    @JFindBy(className = "info-panel-body-log")
    public IText log;

    @JFindBy(className = "results")
    public IText result;

    public void findInvisibleBefore() {
        new WebCascadeInit().initElements(this, WebSettings.getDriverFactory().currentDriverName());
    }

}
