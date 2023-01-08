import PageObjects.MainPage;
import PageObjects.OrderPage;
import PageObjects.RentPage;
import org.junit.Test;

public class TestSamokatOrdering extends CommonBaseTest {

    // Тест заказа через кнопку в хэдере
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

//        new RentPage(driver)
//                .
    }
    // Тест заказа через кнопку в середине страницы
    @Test
    public void samokatOrderingByMiddleOrderButton() {
        new MainPage(driver)
                .openSite()
                .clickCookieButton()
                .clickMiddleOrderButton();

        new OrderPage(driver)
                .sendClientFirstName("Арарат")
                .sendClientLastName("Мкртчян")
                .sendDeliveryAddress("Москва, Дербеневская, 16")
                .selectMetroStation("Павелецкая")
                .sendDeliveryClientPhoneNumber("87776996969")
                .clickNextButton();

//        new RentPage(driver)
//                .
    }
}
