package testsite.elements;

import com.epam.jdi.uitests.core.interfaces.base.IComposite;
import com.epam.jdi.uitests.core.interfaces.common.IButton;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.WebCascadeInit;
import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JFindBy;
import com.epam.jdi.uitests.web.settings.WebSettings;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import testsite.entities.CustomDate;

import java.util.List;

/**
 * Created by sergeybp on 27.05.17.
 */
public class CustomDatePicker extends Element implements IComposite {

    @JFindBy(className = "datepicker-switch")
    public IButton switcher;

    @JFindBy(className = "next")
    public IButton next;

    @JFindBy(className = "prev")
    public IButton prev;

    @JFindBy(className = "month")
    public List<Element> months;

    @JFindBy(className = "day")
    public List<Element> days;

    @JFindBy(className = "old")
    public List<Element> oldDays;



    public void setDate(CustomDate date) {
        switcher.click();
        int nowYear = Integer.parseInt(switcher.getText());
        if (nowYear < date.year) {
            for (int i = 0; i < (date.year - nowYear); i++) {
                next.click();
            }
        } else if (nowYear > date.year) {
            for (int i = 0; i < (-date.year + nowYear); i++) {
                prev.click();
            }
        }
        months.get(date.month - 1).clickCenter();
        days.get(oldDays.size() + date.day - 2).clickCenter();
    }


}
