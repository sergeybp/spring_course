package testsite.section;

import com.epam.jdi.uitests.core.interfaces.common.ICheckBox;
import com.epam.jdi.uitests.core.interfaces.common.IText;
import com.epam.jdi.uitests.web.selenium.elements.base.Clickable;
import com.epam.jdi.uitests.web.selenium.elements.base.Element;
import com.epam.jdi.uitests.web.selenium.elements.common.Link;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class TechCell extends Section {
    @FindBy(css = "input[type=checkbox]")
    public ICheckBox select;
    @FindBy(tagName = "a")
    public Link seeMore;
    @FindBy(css = "p:not(.checkbox)")
    public IText title;

    @FindBy(css = "[for^=g]")
    public Element sel;
}
