import com.sun.jna.platform.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.krb5.internal.crypto.Des;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import static org.openqa.selenium.OutputType.FILE;

/**
 * Created by yegres on 01.05.2017.
 */
public class L1Tests {

    @Before
    public void init() {
        System.setProperty("webdriver.gecko.driver", "/home/sergeybp/geckodriver");
    }

    @Test
    // Changing window size
    public void windowSizeTest() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.yandex.ru");

        driver.manage().window().setSize(new Dimension(800, 600));
        Dimension check = driver.manage().window().getSize();
        Assert.assertEquals(check, new Dimension(800, 600));

        driver.manage().window().maximize();
        Dimension realSize = driver.manage().window().getSize();
        assert (800d <= realSize.getWidth());
        assert (600d <= realSize.getHeight());

        driver.close();
    }

    @Test
    // Setting capabilities
    public void capabilitiesTest() throws MalformedURLException {

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setJavascriptEnabled(false);
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.ANDROID);

        WebDriver driver = new FirefoxDriver(capabilities);
        driver.navigate().to("https://www.piliapp.com/what-is-my/http-request-headers/");
        String text = driver.getPageSource();
        if(text.contains("chrome") || text.contains("android")){
            System.out.print("Ok");
        } else {
            System.out.print("Not working. Why?");
        }
        driver.close();
    }


    @Test
    // Avito item search
    public void avitoSearchTest() {
        WebDriver driver = new FirefoxDriver();

        // Moving to avito and choosing SPB region.
        driver.navigate().to("http://www.avito.ru");
        WebElement element = driver.findElement(By.linkText("Санкт-Петербург"));
        element.click();

        // Waiting for loading complete and inserting search query
        WebDriverWait wait = new WebDriverWait(driver, 10);
        element = wait.until(ExpectedConditions.elementToBeClickable(By.id("search")));
        element.sendKeys("Nokia");

        // Setting category
        driver.findElement(By.xpath("//select[@id='category']/option[text()='Телефоны']")).click();

        // Submitting query
        element.submit();

        // Waiting for page and elements loading complete
        wait.until(ExpectedConditions.titleContains("Nokia"));
        wait.until(ExpectedConditions.elementToBeClickable(By.className("item-description-title-link")));

        // Getting all goods from page and choosing fourth one in list
        ArrayList<WebElement> elements = (ArrayList<WebElement>) driver.findElements(By.className("item-description-title-link"));
        element = elements.get(4);
        element.click();

        // Getting the name of got product, pushing to System.out and terminating
        wait.until(ExpectedConditions.elementToBeClickable(By.className("title-info-favorite-star")));
        element = driver.findElement(By.className("title-info-title-text"));
        System.out.println(element.getText());

        assert (element.getText().length() > 0);

        driver.close();
    }

    @Test
    // Screenshot of page
    public void screenshotPage() throws IOException {

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.yandex.ru");

        // Taking screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File out = ts.getScreenshotAs(FILE);
        File file = new File("screenshotTest.png");
        file.createNewFile();
        org.apache.commons.io.FileUtils.copyFile(out, file);

        // Checking that everything is alright
        File f = new File("screenshotTest.png");
        assert (f.exists() && !f.isDirectory());

        driver.close();
    }

    @Test
    // Screenshot of element
    public void screenshotElement() throws IOException {

        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://www.yandex.ru");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-logo")));
        WebElement element = driver.findElement(By.className("home-logo"));

        // Getting page screenshot and cropping it
        TakesScreenshot ts = (TakesScreenshot) driver;
        File screen = ts.getScreenshotAs(FILE);
        BufferedImage tmp = ImageIO.read(screen);
        Point point = element.getLocation();
        BufferedImage result = tmp.getSubimage(point.getX(), point.getY(), element.getSize().getWidth(), element.getSize().getHeight());
        ImageIO.write(result, "png", screen);
        File file = new File("screenshotElementTest.png");
        file.createNewFile();
        org.apache.commons.io.FileUtils.copyFile(screen, file);

        // Checking that everything is alright
        File f = new File("screenshotElementTest.png");
        assert (f.exists() && !f.isDirectory());

        driver.close();
    }


}
