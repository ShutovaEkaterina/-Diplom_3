import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pomPrivateAccount.PrivateAccount;
import pomlogin.LoginPage;
import pommainpackage.MainPage;

public class LogoutTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();
//тест упадет, так как текст кнопки для выхода отличается в задании
    @Test
    public void testLogout() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPage mainPagePage = new MainPage(driver);
        mainPagePage.clickButtonEnterMainPage();

        LoginPage loginPagePage = new LoginPage(driver);
        String email = "wewew@example.com";
        String password = "1111111";
        loginPagePage.fillEmailFieldLogin(email);
        loginPagePage.fillPasswordFieldLogin(password);
        loginPagePage.clickButtonEnterLoginPage();

        MainPage mainPagePagePage = new MainPage(driver);
        mainPagePagePage.checkVisibilityTextMainPage();
        mainPagePagePage.clickPersonalAccount();

        PrivateAccount privateAccountPage = new PrivateAccount(driver);
        privateAccountPage.checkVisibilityHistoryOrdersText();
        privateAccountPage.clickLogoutButton();

        LoginPage loginPagePagePage = new LoginPage(driver);
        loginPagePagePage.checkVisibilityEnterText();

    }
}
