package pomPrivateAccount;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PrivateAccount {
    private WebDriver driver;
    private By textHistoryOrders = By.xpath("//a[contains(text(), 'История заказов')]");
    private By constructorButton = By.xpath("//p[contains(text(), 'Конструктор')]");
    private By logoutButton = By.xpath("//button[contains(text(), 'Выйти')]");


    public PrivateAccount(WebDriver driver) {
        this.driver = driver;
    }
    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }
    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
    public void checkVisibilityHistoryOrdersText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'История заказов')]")));
        assert driver.findElement(textHistoryOrders).isDisplayed();
    }
}
