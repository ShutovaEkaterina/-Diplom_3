package pomconstructor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ConstructorPage {
    private WebDriver driver;
    private By textBuildBurger = By.xpath("//h1[contains(text(), 'Соберите бургер')]");

    public ConstructorPage(WebDriver driver) {
        this.driver = driver;
    }
    public void checkVisibilityBuildBurgerText() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Соберите бургер')]")));
        assert driver.findElement(textBuildBurger).isDisplayed();
    }
}
