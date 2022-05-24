package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends AbstractPage {
    public final static int WAIT_TIMEOUT_SECONDS = 5;
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));

    public BasePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
