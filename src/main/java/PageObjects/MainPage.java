package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
// Элементы главной страницы сайта
    private final WebDriver webDriver;

    // Кнопка заказа в хэдере сайта
    private By headerOrderButton = By.className("Button_Button__ra12g");

    // Кнопка заказа в середине сайта
    private By middleOrderButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");

    // Раздел "Вопросы о важном", стрелочки вопросов
    private By accordionArrow48 = By.id("accordion__heading-48");
    private By accordionArrow49 = By.id("accordion__heading-49");
    private By accordionArrow50 = By.id("accordion__heading-50");
    private By accordionArrow51 = By.id("accordion__heading-51");
    private By accordionArrow52 = By.id("accordion__heading-52");
    private By accordionArrow53 = By.id("accordion__heading-53");
    private By accordionArrow54 = By.id("accordion__heading-54");
    private By accordionArrow55 = By.id("accordion__heading-55");

    // Вопросы о важном, ответы
    private By accordionItemPanel48 = By.id("accordion__panel-48");
    private By accordionItemPanel49 = By.id("accordion__panel-49");
    private By accordionItemPanel50 = By.id("accordion__panel-50");
    private By accordionItemPanel51 = By.id("accordion__panel-51");
    private By accordionItemPanel52 = By.id("accordion__panel-52");
    private By accordionItemPanel53 = By.id("accordion__panel-53");
    private By accordionItemPanel54 = By.id("accordion__panel-54");
    private By accordionItemPanel55 = By.id("accordion__panel-55");

// Методы для работы с элементами главной страницы

    //Открыть сайт
    public MainPage openSite() {
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }
    public MainPage clickHeaderOrderButton() {
        webDriver.findElement(headerOrderButton).click();
        return this;
    }
    public MainPage clickMiddleOrderButton() {
        webDriver.findElement(middleOrderButton).click();
        return this;
    }
}
