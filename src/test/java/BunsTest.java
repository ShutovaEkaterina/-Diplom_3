import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pommainpackage.MainPage;

import static org.junit.Assert.assertTrue;

public class BunsTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();

    @DisplayName("Ingredient buns tab is selected")
    @Test
    public void testBunsTab() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPagePage = new MainPage(driver);
        mainPagePage.waitForModalOverlayToDisappear();
        mainPagePage.waitForBunsLinkToBeClickable();

        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.bunsTab);
        mainPagePage.waitForBunsTabToBeSelected();
        WebElement bunsTabElement = driver.findElement(mainPagePage.bunsTab);
        String classAttribute = bunsTabElement.getAttribute("class");

        assertTrue("Sauce tab is not selected", classAttribute.contains("current"));
    }
}
