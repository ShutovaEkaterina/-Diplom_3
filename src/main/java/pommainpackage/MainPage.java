package pommainpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private WebDriver driver;
    private By personalAccount = By.xpath("//p[text()='Личный Кабинет']");
    private By buttonEnterMainPage = By.xpath("//button[text()='Войти в аккаунт']");
    private By textMainPage = By.xpath("//h1[text()='Соберите бургер']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }
    public void clickButtonEnterMainPage() {
        driver.findElement(buttonEnterMainPage).click();
    }
    public void checkVisibilityTextMainPage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[text()='Соберите бургер']")));
        assert driver.findElement(textMainPage).isDisplayed();
    }

}
