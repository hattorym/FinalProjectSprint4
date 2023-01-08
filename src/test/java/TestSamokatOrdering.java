import PageObjects.MainPage;
import PageObjects.OrderPage;
import PageObjects.RentPage;
import org.junit.Test;

public class TestSamokatOrdering extends CommonBaseTest {

    @Test
    public void samokatOrderingByHeaderOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickHeaderOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Изя")
                .sendClientLastName("Шлимансон")
                .sendDeliveryAddress("Москва, Образцова, 11")
                .selectMetroStation("Марьина Роща")
                .sendDeliveryClientPhoneNumber("83223223322")
                .clickNextButton();

        new RentPage(driver)
                .
    }

}
