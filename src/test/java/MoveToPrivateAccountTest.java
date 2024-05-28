import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pomPrivateAccount.PrivateAccount;
import pomlogin.LoginPage;
import pommainpackage.MainPage;
import pomregister.RegisterPage;

public class MoveToPrivateAccountTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();

    @Test
    public void testMoveToPrivateAccount() {

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

    }
}
