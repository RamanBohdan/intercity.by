package test;

import org.testng.annotations.Test;
import pageobject.HomePage;


public class HomePageTest extends AbstractTest {
    private final String placeOfArrival = "Египет";
    private final String placeOfArrivalResort = "Хургада";

    @Test
    public void testCheckAvailabilityEgyptPlace() {

        HomePage homePage = new HomePage(driver)
                .openHomePage()
                .chooseDeparturePointCity()
                .choosePlaceOfArrival();

    }
}
