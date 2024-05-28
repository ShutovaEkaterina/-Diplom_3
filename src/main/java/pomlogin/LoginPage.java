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
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    public void checkVisibilityEnterText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Вход']")));
        assert driver.findElement(enterText).isDisplayed();
    }
}
