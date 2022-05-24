package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultSearchTourPage extends BasePage {

    public ResultSearchTourPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<String> getResultSearchResorts() {
        String selectAllResorts = "//div[@class='hotel__location-main']";
        List<String> resultSearchResorts = driver.findElements(By.xpath(selectAllResorts)).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        return resultSearchResorts;
    }

    public boolean isSingleResortContainsName(String nameResort) {
        List<String> resultSearchResorts = getResultSearchResorts();
        return resultSearchResorts.stream().anyMatch(nameResort::equals);
    }

    public boolean isAllResortsContainsName(String nameResort){
        List<String> resultSearchResorts=getResultSearchResorts();
        return resultSearchResorts.stream().allMatch(resort->resort.contains(nameResort));
    }
}
