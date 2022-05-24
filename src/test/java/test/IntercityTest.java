package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.IntercityPage;
import pageobject.ResultSearchTourPage;


public class IntercityTest extends AbstractTest {
    String departureCity = "Минск";
    String nameCountry = "Египет";
    String nameResort = "Хургада";
    String nameResortInResult = "Египет, Хургада";
    String nameResortInResultIsAll = "Египет, Хургада";

    @Test
    public void testSearchPlaceOfEgypt() {
        ResultSearchTourPage searchTourPage = new IntercityPage(driver)
                .openHomePage()
                .chooseDepartureCity(departureCity)
                .choosePlaceOfArrival(nameCountry, nameResort)
                .chooseDateOfDeparture()
                .choosePeopleOfDeparture()
                .openResultSearchTourPage();

        Assert.assertTrue(searchTourPage.isSingleResortContainsName(nameResortInResult));
        Assert.assertTrue(searchTourPage.isAllResortsContainsName(nameResortInResultIsAll));
    }
}
