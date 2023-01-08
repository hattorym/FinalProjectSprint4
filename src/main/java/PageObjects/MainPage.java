package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

// Элементы главной страницы сайта:
public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    // Кнопка заказа в хэдере сайта
    private By headerOrderButton = By.className("Button_Button__ra12g");

    // Кнопка заказа в середине сайта
    private By middleOrderButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");

    // Кнопка "да все привыкли" сообщения о кукисах
    private By cookieButton = By.id("rcc-confirm-button");

    // Лого Яндекс в хэдере
    private By logoYandexHeader = By.className("Header_LogoYandex__3TSOI");

    // Лого Самокат в хэдере
    private By logoSamokatHeader = By.className("Header_LogoScooter__3lsAR");

    // Раздел "Вопросы о важном", массив локаторов стрелочек вопросов
    private String[] accordionArrowsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"
    };
    // Раздел "Вопросы о важном", массив локаторов панелей с текстом ответов
    private String[] accordionItemPanelArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"
    };


// Методы для работы с элементами главной страницы

    // Открыть сайт
    public MainPage openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }
    // Кликнуть по кнопке заказа в хэдере сайта

    public MainPage clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
        return this;
    }

    // Кликнуть по кнопке заказа в середине сайта
    public MainPage clickMiddleOrderButton() {
        driver.findElement(middleOrderButton).click();
        return this;
    }

    // Кликнуть по кнопке "да все привыкли" сообщения о кукисах
    public MainPage clickCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }

    // Кликнуть по лого Яндекс в хэдере
    public MainPage clickLogoYandexHeader() {
        driver.findElement(logoYandexHeader).click();
        return this;
    }

    // Кликнуть по лого Самокат в хэдере
    public MainPage clickLogoSamokatHeader() {
        driver.findElement(logoSamokatHeader).click();
        return this;
    }

    // Кликнуть по стрелочке вопросов по списку
    public void clickAccordionArrow(int arrowNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(accordionArrowsArray[arrowNumber])));
        driver.findElement(By.id(accordionArrowsArray[arrowNumber])).click();
    }

    // Сравнить текст ответа с вопросом
    public void compareAnswerWithQuestionTextAccordionItemPanel(String accordionExpectedText, int panelNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(accordionItemPanelArray[panelNumber])));
        String accordionAnswerText = driver.findElement(By.id(accordionItemPanelArray[panelNumber])).getText();
        assertEquals(accordionExpectedText, accordionAnswerText);
    }
}
