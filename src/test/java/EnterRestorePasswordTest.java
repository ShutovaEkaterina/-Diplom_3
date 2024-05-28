import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pomlogin.LoginPage;
import pommainpackage.MainPage;
import pomregister.RegisterPage;
import pomrestorepassword.RestorePasswordPage;

public class EnterRestorePasswordTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();

    @Test
    public void testRestorePasswordTest() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        RestorePasswordPage restorePasswordPagePage = new RestorePasswordPage(driver);
        restorePasswordPagePage.clickButtonEnterRestorePasswordPage();

        LoginPage loginPagePage = new LoginPage(driver);
        String email = "wewew@example.com";
        String password = "1111111";
        loginPagePage.fillEmailFieldLogin(email);
        loginPagePage.fillPasswordFieldLogin(password);
        loginPagePage.clickButtonEnterLoginPage();

        MainPage mainPagePagePage = new MainPage(driver);
        mainPagePagePage.checkVisibilityTextMainPage();
    }
}
