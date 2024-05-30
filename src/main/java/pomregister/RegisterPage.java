package pomregister;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private By registerButtonSuccess = By.xpath("//button[contains(@class, 'button_button') and text()='Зарегистрироваться']");
    private By fieldName = By.xpath("//input[@name='name']");
    private By fieldEmail = By.xpath("//fieldset[@class='Auth_fieldset__1QzWN mb-6']//label[text()='Email']/following-sibling::input[@type='text' and @name='name']");
    private By fieldPassword = By.xpath("//input[@type='password' and @name='Пароль']");
    private By incorrectPasswordSign = By.xpath("//p[text()='Некорректный пароль']");
    public By buttonEnterRegisterPage = By.xpath("//a[text()='Войти']");
    private By modalOverlay = By.xpath("//div[@class='Modal_modal_overlay__x2ZCr']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on register button success")
    public void clickRegisterButtonSuccess() {
        driver.findElement(registerButtonSuccess).click();
    }
    public void clickButtonEnterRegisterPage() {
        driver.findElement(buttonEnterRegisterPage).click();
    }
    @Step("Waiting before button Войти will be visible")
    public void waitForButtonEnterRegisterPageToBeClickable() {
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.elementToBeClickable(buttonEnterRegisterPage));
    }
    @Step("Fill up name field")
    public void fillNameField(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }
    @Step("Fill up email field")
    public void fillEmailField(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }
    @Step("Fill up password field")
    public void fillPasswordField(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }
    @Step("Waiting before text Некорректный пароль will be visible")
    public void checkVisibilityIncorrectPasswordText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Некорректный пароль']")));
        assert driver.findElement(incorrectPasswordSign).isDisplayed();
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
