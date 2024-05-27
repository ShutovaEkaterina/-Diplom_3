package pomlogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By registerButton = By.xpath("//a[text()='Зарегистрироваться']");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
