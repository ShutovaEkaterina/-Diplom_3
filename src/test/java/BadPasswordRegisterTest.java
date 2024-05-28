import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pomlogin.LoginPage;
import pommainpackage.MainPage;
import pomregister.RegisterPage;

public class BadPasswordRegisterTest {
    @Rule
    public DriverFarm driverFarm = new DriverFarm();

    @Test
    public void testSuccessRegister() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPage mainPagePage = new MainPage(driver);

        mainPagePage.clickPersonalAccount();

        LoginPage loginPagePagePage = new LoginPage(driver);
        loginPagePagePage.clickRegisterButton();

        RegisterPage registerPagePage = new RegisterPage(driver);

        String name = "Василий";
        String email = "efe@example.com";
        String password = "8912";

        registerPagePage.fillNameField(name);

        registerPagePage.fillEmailField(email);

        registerPagePage.fillPasswordField(password);

        registerPagePage.clickRegisterButtonSuccess();

        registerPagePage.checkVisibilityIncorrectPasswordText();

    }
}
