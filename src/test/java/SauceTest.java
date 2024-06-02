import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pommainpackage.MainPage;

import static org.junit.Assert.assertTrue;


public class SauceTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();

    @DisplayName("Ingredient sauce tab is selected")
    @Test
    public void testSaucesTab() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPagePage = new MainPage(driver);
        mainPagePage.waitForModalOverlayToDisappear();
        mainPagePage.waitForSaucesLinkToBeClickable();

        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.saucesTab);
        mainPagePage.waitForSaucesTabToBeSelected();
        WebElement fillingsTabElement = driver.findElement(mainPagePage.saucesTab);
        String classAttribute = fillingsTabElement.getAttribute("class");

        assertTrue("Sauce tab is not selected", classAttribute.contains("current"));
    }
}
