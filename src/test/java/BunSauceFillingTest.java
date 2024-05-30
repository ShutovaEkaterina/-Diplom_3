import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pomlogin.LoginPage;
import pommainpackage.MainPage;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class BunSauceFillingTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();

    @Test
    public void testBunSauceFilling() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPagePage = new MainPage(driver);
        // Клик на ссылку с начинками
        //mainPagePage.clickFillingsLink();

        // Проверка, что у выбранного элемента из таба ингредиентов есть класс "current"
       // assertTrue(mainPagePage.checkCurrentAttribute());

        // Клик на ссылку с соусами
       // mainPagePage.clickSaucesLink();

        // Проверка, что у выбранного элемента из таба ингредиентов есть класс "current"
        //assertTrue(mainPagePage.checkCurrentAttribute());

        // Клик на ссылку с булками
        //mainPagePage.clickBunsLink();

        // Проверка, что у выбранного элемента из таба ингредиентов есть класс "current"
        //assertTrue(mainPagePage.checkCurrentAttribute());
        mainPagePage.waitForFillingsLinkToBeClickable();
        mainPagePage.clickFillingsLink();
        mainPagePage.checkVisibilityFillingsText();
        mainPagePage.waitForSaucesLinkToBeClickable();
        mainPagePage.clickSaucesLink();
        mainPagePage.checkVisibilitySaucesText();
        mainPagePage.waitForBunsLinkToBeClickable();
        mainPagePage.clickBunsLink();
        mainPagePage.checkVisibilityBunsText();
    }
}
