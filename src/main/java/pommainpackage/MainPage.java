package pommainpackage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    public By saucesTab = By.cssSelector(".tab_tab__1SPyG:nth-child(2)");
    public By fillingsTab = By.cssSelector(".tab_tab__1SPyG:nth-child(3)");
    public By bunsTab = By.cssSelector(".tab_tab__1SPyG:nth-child(1)");
    public By personalAccount = By.xpath("//p[text()='Личный Кабинет']");
    public By buttonEnterMainPage = By.xpath("//button[text()='Войти в аккаунт']");
    private By textMainPage = By.xpath("//h1[text()='Соберите бургер']");
    private By modalOverlay = By.xpath("//div[@class='Modal_modal_overlay__x2ZCr']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on Личный кабинет")
    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }
    @Step("Waiting before element Личный кабинет will be clickable")
    public void waitForPersonalAccountToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(personalAccount));
    }

    @Step("Waiting before element Войти в аккаунт will be clickable")
    public void waitForButtonEnterMainPageToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(buttonEnterMainPage));
    }
    @Step("Waiting before element Соберите бургер will be visible")
    public void checkVisibilityTextMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Соберите бургер']")));
        assert driver.findElement(textMainPage).isDisplayed();
    }
    @Step("Waiting before element sauces will be clickable")
    public void waitForSaucesLinkToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(saucesTab));
    }

    @Step("Waiting before element sauces will be selected")
    public void waitForSaucesTabToBeSelected() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(saucesTab, "class", "current"));
    }
    @Step("Waiting before element fillings will be selected")
    public void waitForFillingsTabToBeSelected() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(fillingsTab, "class", "current"));
    }
    @Step("Waiting before element buns will be selected")
    public void waitForBunsTabToBeSelected() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.attributeContains(bunsTab, "class", "current"));
    }
    @Step("Waiting before element buns will be clickable")
    public void waitForBunsLinkToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(bunsTab));
    }
    @Step("Waiting before element fillings will be clickable")
    public void waitForFillingsLinkToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(fillingsTab));
    }
    @Step("Waiting modal is disappearing")
    public void waitForModalOverlayToDisappear() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(modalOverlay));
    }
    @Step("Scroll to element")
    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static class JSUtils {
        @Step("Click on button")
        public static void clickElementByJS(WebDriver driver, By locator) {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }
}
