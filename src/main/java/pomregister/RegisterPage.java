package pomregister;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    private By registerButtonSuccess = By.xpath("//button[text()='Зарегистрироваться']");
    private By fieldName = By.xpath("//label[text()='Имя']");
    private By fieldEmail = By.xpath("//label[text()='Email']");
    private By fieldPassword = By.xpath("//label[text()='Пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickRegisterButtonSuccess() {
        driver.findElement(registerButtonSuccess).click();
    }
    public void fillNameField(String name) {
        driver.findElement(fieldName).sendKeys(name);
    }
    public void fillEmailField(String email) {
        driver.findElement(fieldEmail).sendKeys(email);
    }
    public void fillPasswordField(String password) {
        driver.findElement(fieldPassword).sendKeys(password);
    }
}
