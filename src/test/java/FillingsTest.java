import io.qameta.allure.junit4.DisplayName;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pommainpackage.MainPage;

import static org.junit.Assert.assertTrue;

public class FillingsTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();

    @DisplayName("Ingredient fillings tab is selected")
    @Test
    public void testFillingTab() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPagePage = new MainPage(driver);
        mainPagePage.waitForModalOverlayToDisappear();
        mainPagePage.waitForFillingsLinkToBeClickable();

        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.fillingsTab);
        mainPagePage.waitForFillingsTabToBeSelected();
        WebElement fillingsTabElement = driver.findElement(mainPagePage.fillingsTab);
        String classAttribute = fillingsTabElement.getAttribute("class");

        assertTrue("Sauce tab is not selected", classAttribute.contains("current"));
    }
}
