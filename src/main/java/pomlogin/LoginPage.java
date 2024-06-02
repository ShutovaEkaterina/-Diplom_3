package pomlogin;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private By registerButton = By.xpath("//a[text()='Зарегистрироваться']");
    private By enterText = By.xpath("//h2[text()='Вход']");
    private By buttonEnterLoginPage = By.xpath("//button[text()='Войти']");
    private By emailLoginField = By.xpath("//input[@type='text' and @name='name']");
    private By passwordLoginField = By.xpath("//input[@type='password' and @name='Пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click on register button")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    @Step("Click on enter button")
    public void clickButtonEnterLoginPage() {
        driver.findElement(buttonEnterLoginPage).click();
    }
    @Step("Fill up email field")
    public void fillEmailFieldLogin(String email) {
        driver.findElement(emailLoginField).sendKeys(email);
    }
    @Step("Fill up password field")
    public void fillPasswordFieldLogin(String email) {
        driver.findElement(passwordLoginField).sendKeys(email);
    }
    @Step("Waiting before element Вход will be visible")
    public void checkVisibilityEnterText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Вход']")));
        assert driver.findElement(enterText).isDisplayed();
    }
}
