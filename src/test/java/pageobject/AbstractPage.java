package pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class AbstractPage {
    WebDriver driver;
    static final Logger logger = LogManager.getLogger();
    public final static String BASE_URL = "https://intercity.by";
    public final static String RESULT_SEARCH_URL = BASE_URL+"/tours/country/egypt/";


    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public IntercityPage openHomePage() {
        driver.get(BASE_URL);
        return new IntercityPage(driver);
    }

    public ResultSearchTourPage openResultSearchTourPage() {
        driver.get(RESULT_SEARCH_URL);
        return new ResultSearchTourPage(driver);
    }
}
