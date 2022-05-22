package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {
    WebDriver driver;

    @FindBy(xpath = "(//button[@class='ps-form__trigger ps-form__trigger--filled'])[1]")
    private WebElement buttonDeparturePoint;
    @FindBy(xpath = "//div[@class='ps-filter-item__select-option active']")
    private WebElement selectDeparturePoint;
    @FindBy(xpath = "(//button[@class='ps-form__trigger ps-form__trigger--filled'])[2]")
    private WebElement buttonPlaceOfArrival;
    @FindBy(xpath = "(//span[@class='checkbox-row__text'])[4]")
    private WebElement selectPlaceOfArrivalCountry;
    @FindBy(xpath = "(//span[@class='checkbox-row__text'])[14]")
    private WebElement selectPlaceOfArrivalResort;
    //   @FindBy(xpath = "//span[@class='checkbox-row__text']")
    //   private WebElement selectPlaceOfArrivalCheck;
    @FindBy(xpath = "(//div[@class='ps-form__dd-footer-action'])[1]")
    private WebElement inputPlaceOfArrivalComplete;
    @FindBy(xpath = "//img[@src='/local/images/markup-images/filters/filter-from.svg']")
    private WebElement selectDateOfDeparture;
    @FindBy(xpath = "//table[@class='datepicker__calendar']//td[@class=' date-active date-highlight']")
    private WebElement buttonDateOfDepartureStart;
    @FindBy(xpath = "//table[@class='datepicker__calendar']//td[@class=' date-active']")
    private WebElement buttonDateOfDepartureFinish;
    @FindBy(xpath = "//form/div[1]//div[3]/div/div/div[2]/div/div[1]/button")
    private WebElement inputDateOfArrivalComplete;
    @FindBy(xpath = "//img[@src='/local/images/markup-images/filters/filter-adult.svg']")
    private WebElement selectPeople;
    @FindBy(xpath = "//div/div/div/div/div/div[2]/div[2]/div/div/div/div[3]")
    private WebElement buttonPeopleAboutChildren;
    @FindBy(xpath = "//form/div[1]/div[1]//div[4]/div/div/div[2]/div/div[1]/button")
    private WebElement inputPeopleOfArrivalComplete;
    @FindBy(xpath = "//div[@class='ps-form__row']//button[@type='submit']")
    private WebElement buttonSearch;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openHomePage() {
        driver.get(BASE_URL);
        return this;
    }


    public HomePage chooseDeparturePointCity() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonDeparturePoint)).click();
        buttonDeparturePoint.click();
        selectDeparturePoint.click();
        return this;
    }

    public HomePage choosePlaceOfArrival() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonPlaceOfArrival)).click();
        selectPlaceOfArrivalCountry.click();
        selectPlaceOfArrivalResort.click();
        inputPlaceOfArrivalComplete.click();
        return this;
    }

   /* public SearchTourPage choosePlaceOfArrival(String nameCountry) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonPlaceOfArrival));
        String selectPlaceOfArrival = "//span[@class='checkbox-row__text']";
        List<WebElement> countries = driver.findElements(By.xpath(selectPlaceOfArrival));
        for (WebElement country : countries) {
            if (nameCountry.equals(country.getText().trim())) {
                logger.info("Country: " + country.getText());
                country.click();
                break;
            }
        }
        return this;
    }

    public SearchTourPage choosePlaceOfArrivalResort(String nameResort) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(buttonPlaceOfArrival));
        String selectPlaceOfArrivalCheckResort = "//span[@class='checkbox-row__text']";
        List<WebElement> resorts = driver.findElements(By.xpath(selectPlaceOfArrivalCheckResort));
        for (WebElement resort : resorts) {
            if (nameResort.equals(resort.getText().trim())) {
                logger.info("resort: " + resort.getText());
                resort.click();
                break;
            }
        }
        return this;
    }

    public SearchTourPage fillFormPlaceOfArrival(String placeOfArrival, String placeOfArrivalResort) {
        choosePlaceOfArrival(placeOfArrival);
        choosePlaceOfArrivalResort(placeOfArrivalResort);
        inputPlaceOfArrivalComplete.click();
        return this;
    }*/

    public HomePage chooseDateOfDeparture() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectDateOfDeparture));
        selectDateOfDeparture.click();
        buttonDateOfDepartureStart.click();
        buttonDateOfDepartureFinish.click();
        inputDateOfArrivalComplete.click();
        return this;
    }

    public HomePage choosePeopleOfDeparture() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS))
                .until(ExpectedConditions.elementToBeClickable(selectPeople));
        selectPeople.click();
        buttonPeopleAboutChildren.click();
        buttonPeopleAboutChildren.click();
        inputPeopleOfArrivalComplete.click();
        return this;
    }

    public HomePage clickSearchButton() {
        buttonSearch.click();
        return this;
    }

    public boolean isResultsSearchCountry(String nameCountry) {
        return clickSearchButton().isResultsSearchCountry(nameCountry);
    }

    public boolean isResultsSearchCity(String nameCity) {
        return clickSearchButton().isResultsSearchCity(nameCity);
    }

}
