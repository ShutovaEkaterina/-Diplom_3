package pomlogin;

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
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void clickButtonEnterLoginPage() {
        driver.findElement(buttonEnterLoginPage).click();
    }
    public void fillEmailFieldLogin(String email) {
        driver.findElement(emailLoginField).sendKeys(email);
    }
    public void fillPasswordFieldLogin(String email) {
        driver.findElement(passwordLoginField).sendKeys(email);
    }
    public void checkVisibilityEnterText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Вход']")));
        assert driver.findElement(enterText).isDisplayed();
    }
}
