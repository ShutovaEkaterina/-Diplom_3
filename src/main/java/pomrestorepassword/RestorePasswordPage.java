package pomrestorepassword;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RestorePasswordPage {
    private WebDriver driver;

    public By buttonEnterRestorePasswordPage = By.xpath("//a[@class='Auth_link__1fOlj' and text()='Войти']");
    private By modalOverlay = By.xpath("//div[@class='Modal_modal_overlay__x2ZCr']");

    public RestorePasswordPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickButtonEnterRestorePasswordPage() {
        driver.findElement(buttonEnterRestorePasswordPage).click();
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
