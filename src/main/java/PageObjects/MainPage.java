package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

// Элементы главной страницы сайта:
public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private static WebDriver driver;

    // Локатор кнопки "да все привыкли" сообщения о кукисах
    private By cookieButton = By.id("rcc-confirm-button");

    // Локатор Кнопки заказа в хэдере сайта
    private By headerOrderButton = By.className("Button_Button__ra12g");

    // Локатор кнопки заказа в середине сайта
    private By middleOrderButton = By.className("Button_Middle__1CSJM");


    // Методы для работы с элементами главной страницы

    // Открыть сайт
    public MainPage openSite() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        return this;
    }

    // Кликнуть по кнопке "да все привыкли" в сообщении о кукисах
    public MainPage clickCookieButton() {
        driver.findElement(cookieButton).click();
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

    // Массив локаторов стрелочек списка с вопросами
    private static final String[] accordionArrowsArray = new String[]{
            "accordion__heading-0",
            "accordion__heading-1",
            "accordion__heading-2",
            "accordion__heading-3",
            "accordion__heading-4",
            "accordion__heading-5",
            "accordion__heading-6",
            "accordion__heading-7"};

    // Массив локаторов панелей с текстом ответов
    private static final String[] accordionPanelArray = new String[]{
            "accordion__panel-0",
            "accordion__panel-1",
            "accordion__panel-2",
            "accordion__panel-3",
            "accordion__panel-4",
            "accordion__panel-5",
            "accordion__panel-6",
            "accordion__panel-7"};

        // Прокрутка главной страницы до списка
    public MainPage scrollPageToList() {
    WebElement lastArrow = driver.findElement(By.id(accordionArrowsArray[7]));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", lastArrow);
    return this;
}
    // Клик по стрелке выпадающего списка
    public static void clickAccordionArrow(int arrowNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(By.id(accordionArrowsArray[arrowNumber])));
        driver.findElement(By.id(accordionArrowsArray[arrowNumber])).click();
    }

    // Проверка текста в открытой панели
    public static void checkTextInOpenPanel(String expectedText, int panelNumber) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(accordionPanelArray[panelNumber])));
        String openPanelText = driver.findElement(By.id(accordionPanelArray[panelNumber])).getText();
        assertEquals(expectedText, openPanelText);
    }
    // Массив с текстом ожидаемых ответов
    private final String[] expectedAnswersList = new String[]{
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

}
