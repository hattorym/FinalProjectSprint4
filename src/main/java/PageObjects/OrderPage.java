package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

// Элементы страницы оформления заказа сайта:
public class OrderPage {
    private final WebDriver driver;
    // Локатор поля "Имя"
    private final By clientFirstName = By.xpath(".//input[@placeholder='* Имя']");
    // Локатор поля "Фамилия"
    private final By clientLastName = By.xpath(".//input[@placeholder='* Фамилия']");
    // Локатор поля "Адрес: куда привезти заказ"
    private final By deliveryAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Локатор поля "Станция метро"
    private final By deliveryMetroStation = By.xpath(".//input[@placeholder='* Станция метро']");
    // Локатор поля "Телефон: на него позвонит курьер"
    private final By deliveryClientPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Локатор кнопки "Далее"
    private final By NextButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");


    // Конструктор класса
    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Методы для работы с элементами страницы заказа
    // Ввод имени клиента
    public OrderPage sendClientFirstName(String firstName) {
        driver.findElement(clientFirstName).sendKeys(firstName);
        return this;
    }

    // Ввод фамилии клиента
    public OrderPage sendClientLastName(String lastName) {
        driver.findElement(clientLastName).sendKeys(lastName);
        return this;
    }

    // Ввод адреса доставки
    public OrderPage sendDeliveryAddress(String address) {
        driver.findElement(deliveryAddress).sendKeys(address);
        return this;
    }

    // Выбор станции метро
    public OrderPage selectMetroStation(String metroStationFromOrder) {
        driver.findElement(deliveryMetroStation).sendKeys(metroStationFromOrder);
        String metroStation = driver.findElement(By.xpath("//div[@class='Order_Text__2broi' and text()='" + metroStationFromOrder + "']")).getText();
        assertEquals(metroStation, metroStationFromOrder);
        driver.findElement(By.xpath("//div[@class='Order_Text__2broi' and text()='" + metroStationFromOrder + "']")).click();
        return this;
    }

    // Ввод телефона клиента
    public OrderPage sendDeliveryClientPhoneNumber(String phoneNumber) {
        driver.findElement(deliveryClientPhoneNumber).sendKeys(phoneNumber);
        return this;
    }

    // Клик по кнопке далее
    public OrderPage clickNextButton() {
        driver.findElement(NextButton).click();
        return this;
    }

}
