import io.qameta.allure.junit4.DisplayName;
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
    @DisplayName("Ingredient tabs changing")
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
        mainPagePage.waitForModalOverlayToDisappear();
        mainPagePage.waitForFillingsLinkToBeClickable();
        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.fillingsLink);
        //mainPagePage.clickFillingsLink();
        mainPagePage.checkVisibilityFillingsText();
        mainPagePage.scrollToElement(mainPagePage.saucesLink);
        mainPagePage.waitForSaucesLinkToBeClickable();
        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.saucesLink);
        //mainPagePage.clickSaucesLink();
        mainPagePage.checkVisibilitySaucesText();
        mainPagePage.waitForBunsLinkToBeClickable();
        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.bunsLink);
        //mainPagePage.clickBunsLink();
        mainPagePage.checkVisibilityBunsText();
    }
}
