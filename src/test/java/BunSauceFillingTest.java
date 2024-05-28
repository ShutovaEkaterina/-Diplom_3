import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pomlogin.LoginPage;
import pommainpackage.MainPage;

public class BunSauceFillingTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();

    @Test
    public void testBunSauceFilling() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPage mainPagePage = new MainPage(driver);
        mainPagePage.clickSaucesLink();
        mainPagePage.checkVisibilitySaucesText();
        mainPagePage.clickFillingsLink();
        mainPagePage.checkVisibilityFillingsText();
        mainPagePage.clickBunsLink();
        mainPagePage.checkVisibilityBunsText();
    }
}
