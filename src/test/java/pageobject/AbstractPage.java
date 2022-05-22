package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {
    WebDriver driver;
    static final Logger logger = LogManager.getLogger();
    public final static String BASE_URL = "https://intercity.by";
    public final static int WAIT_TIMEOUT_SECONDS = 7;

}
