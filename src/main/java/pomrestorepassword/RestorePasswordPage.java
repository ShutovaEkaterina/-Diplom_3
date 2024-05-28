package pomrestorepassword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RestorePasswordPage {
    private WebDriver driver;

    private By buttonEnterRestorePasswordPage = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Войти']");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonEnterRestorePasswordPage() {
        driver.findElement(buttonEnterRestorePasswordPage).click();
    }
}
