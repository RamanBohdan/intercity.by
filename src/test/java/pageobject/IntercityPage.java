package pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class IntercityPage extends BasePage {

    @FindBy(xpath = "(//span[@class='ps-form__trigger-title ps-form__trigger-title--full'])[2]")
    private WebElement buttonPlaceOfArrival;
    @FindBy(xpath = "(//span[contains(@class,'checkbox-row__text')])[13]")
    private WebElement selectPlaceOfArrival;
    @FindBy(xpath = "(//div[@class='ps-form__dd-footer-action'])[1]")
    private WebElement inputPlaceOfArrivalComplete;
    @FindBy(xpath = "(//button[@class='ps-form__trigger ps-form__trigger--filled'])[3]")
    private WebElement buttonDateOfDeparture;
    @FindBy(xpath = "//table[@class='datepicker__calendar']//td[@class=' date-active date-highlight']")
    private WebElement buttonDateOfDepartureStart;
    @FindBy(xpath = "(//button[@class='btn btn--primary'])[2]")
    private WebElement inputDateOfArrivalComplete;
    @FindBy(xpath = "(//button[@class='ps-form__trigger ps-form__trigger--filled'])[4]")
    private WebElement selectPeople;
    @FindBy(xpath = "(//input[@class='number-input__input text-input'])[2]")
    private WebElement inputPeopleAboutChildren;
    @FindBy(xpath = "(//button[@class='btn btn--primary'])[3]")
    private WebElement buttonPeopleOfArrivalComplete;
    @FindBy(xpath = "//div[@class='ps-form__row']//button[@type='submit']")
    private WebElement buttonSearch;

    public IntercityPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

 /*   public HomePage choosePlaceOfArrival(String nameCountry) {
        buttonPlaceOfArrival.click();
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

    public HomePage choosePlaceOfArrivalResort(String nameResort) {
        buttonPlaceOfArrival.click();
        List<WebElement> resorts = driver.findElements(By.xpath(selectPlaceOfArrivalCheckResort));
        for (WebElement resort : resorts) {
            if (nameResort.equals(resort.getText().trim())) {
                logger.info("resort: " + resort.getText());
                resort.click();
                break;
            }
        }
        return this;
    }*/

    public IntercityPage choosePlaceOfArrivalResort() {
        buttonPlaceOfArrival.click();
        selectPlaceOfArrival.click();
        inputPlaceOfArrivalComplete.click();
        return this;
    }


    public IntercityPage chooseDateOfDeparture() {
        buttonDateOfDeparture.click();
        buttonDateOfDepartureStart.click();
        inputDateOfArrivalComplete.click();
        return this;
    }

    public IntercityPage choosePeopleOfDeparture() {
        selectPeople.click();
        inputPeopleAboutChildren.clear();
        wait.until(ExpectedConditions.elementToBeClickable(inputPeopleAboutChildren));
        inputPeopleAboutChildren.sendKeys("2");
        wait.until(ExpectedConditions.elementToBeClickable(buttonPeopleOfArrivalComplete));
        buttonPeopleOfArrivalComplete.click();
        return this;
    }

    public ResultSearchTourPage openResultSearchTourPage() {
        buttonSearch.click();
        return new ResultSearchTourPage(driver);
    }

}
