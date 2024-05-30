package pommainpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;

    public By personalAccount = By.xpath("//p[text()='Личный Кабинет']");
    public By buttonEnterMainPage = By.xpath("//button[text()='Войти в аккаунт']");
    private By textMainPage = By.xpath("//h1[text()='Соберите бургер']");
    public By bunsLink = By.xpath("//div[contains(@style, 'display: flex;')]/div[contains(span/text(), 'Булки')]");
    public By saucesLink = By.xpath("//div[contains(@style, 'display: flex;')]/div[contains(span/text(), 'Соусы')]");
    public By fillingsLink = By.xpath("//div[contains(@style, 'display: flex;')]/div[contains(span/text(), 'Начинки')]");
    private By bunsText = By.xpath("//h2[contains(text(), 'Булки')]");
    private By saucesText = By.xpath("//h2[contains(text(), 'Соусы')]");
    private By fillingsText = By.xpath("//h2[contains(text(), 'Начинки')]");
    private By modalOverlay = By.xpath("//div[@class='Modal_modal_overlay__x2ZCr']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

    public void waitForPersonalAccountToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(personalAccount));
    }

    public void clickBunsLink() {
        driver.findElement(bunsLink).click();
    }

    public void clickSaucesLink() {
        driver.findElement(saucesLink).click();
    }

    public void clickFillingsLink() {
        driver.findElement(fillingsLink).click();
    }

    public void checkVisibilityBunsText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Булки')]")));
        assert driver.findElement(bunsText).isDisplayed();
    }

    public void checkVisibilitySaucesText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Соусы')]")));
        assert driver.findElement(saucesText).isDisplayed();
    }

    public void checkVisibilityFillingsText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), 'Начинки')]")));
        assert driver.findElement(fillingsText).isDisplayed();
    }

    public void clickButtonEnterMainPage() {
        driver.findElement(buttonEnterMainPage).click();
    }

    public void waitForButtonEnterMainPageToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(100))
                .until(ExpectedConditions.elementToBeClickable(buttonEnterMainPage));
    }

    public void checkVisibilityTextMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Соберите бургер']")));
        assert driver.findElement(textMainPage).isDisplayed();
    }

    public void waitForSaucesLinkToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(saucesLink));
    }

    public void waitForBunsLinkToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(bunsLink));
    }

    public void waitForFillingsLinkToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(fillingsLink));
    }

    public void waitForModalOverlayToDisappear() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.invisibilityOfElementLocated(modalOverlay));
    }

    public void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static class JSUtils {

        public static void clickElementByJS(WebDriver driver, By locator) {
            WebElement element = driver.findElement(locator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", element);
        }
    }
}
