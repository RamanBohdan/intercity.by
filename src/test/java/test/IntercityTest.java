package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.IntercityPage;
import pageobject.ResultSearchTourPage;


public class IntercityTest extends AbstractTest {
    String nameResort = "Египет, Хургада";

    @Test
    public void testSearchPlaceOfEgypt() {
        ResultSearchTourPage searchTourPage = new IntercityPage(driver)
                .openHomePage()
                .choosePlaceOfArrivalResort()
                .chooseDateOfDeparture()
                .choosePeopleOfDeparture()
                .openResultSearchTourPage();

  //      Assert.assertTrue(searchTourPage.isSingleResortContainsName(nameResort));
       Assert.assertTrue(searchTourPage.isAllResortsContainsName(nameResort));
    }
}
