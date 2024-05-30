import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pommainpackage.MainPage;


public class BunSauceFillingTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();
    @DisplayName("Ingredient tabs changing")
    @Test
    public void testBunSauceFilling() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPagePage = new MainPage(driver);

        mainPagePage.waitForModalOverlayToDisappear();
        mainPagePage.waitForFillingsLinkToBeClickable();
        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.fillingsLink);

        mainPagePage.checkVisibilityFillingsText();
        mainPagePage.scrollToElement(mainPagePage.saucesLink);
        mainPagePage.waitForSaucesLinkToBeClickable();
        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.saucesLink);

        mainPagePage.checkVisibilitySaucesText();
        mainPagePage.waitForBunsLinkToBeClickable();
        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.bunsLink);

        mainPagePage.checkVisibilityBunsText();
    }
}
