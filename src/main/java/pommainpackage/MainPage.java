package pommainpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;
    private By personalAccount = By.xpath("//p[text()='Личный Кабинет']");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickPersonalAccount() {
        driver.findElement(personalAccount).click();
    }

}
