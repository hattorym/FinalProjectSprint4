import PageObjects.MainPage;
import PageObjects.OrderPage;
import PageObjects.RentPage;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

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

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("28.03.2025")
                .setRentalTime()
                .clickCheckBoxColourBlackPearl()
                .sendComment("Таки не поцарапайте мне аппарат, я вас прошу!")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Шо значит не получилось оформить! Я на вас в суд по правам человека подам!", isDisplayed);
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

        boolean isDisplayed = new RentPage(driver)
                .sendRentalDate("07.01.2023")
                .setRentalTime()
                .clickCheckBoxColourGreyDespair()
                .sendComment("Сэрый мапэд хачу!")
                .clickOrderButton()
                .clickOrderButtonYes()
                .isModalOrderWindowDisplayed();
        assertTrue("Нэт окна заказа, нэ купил мапэд!", isDisplayed);
    }
}
