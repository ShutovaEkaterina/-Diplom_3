import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pomlogin.LoginPage;
import pommainpackage.MainPage;
import pomregister.RegisterPage;
import userpackage.UserPath;
import userpackage.UserResponse;

public class SuccessRegisterTest {
    private final UserPath userPath = new UserPath();
    private final UserResponse userResponse = new UserResponse();
    private String accessToken;

    @Rule
    public DriverFarm driverFarm = new DriverFarm();

    @After
    public void deleteUser() {
        if (accessToken != null && !accessToken.isEmpty()) {
            ValidatableResponse response = userPath.deleteUser(accessToken);
            userResponse.deletedSuccesfully(response);
        }
    }

    @Test
    public void testSuccessRegister() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site/");

        MainPage mainPagePage = new MainPage(driver);

        mainPagePage.clickPersonalAccount();

        LoginPage loginPagePage = new LoginPage(driver);
        loginPagePage.clickRegisterButton();

        RegisterPage registerPagePage = new RegisterPage(driver);

        String name = "Игнкаdsти";
        String email = "efddsdeed@example.com";
        String password = "1221d1dj1nf34";

        registerPagePage.fillNameField(name);

        registerPagePage.fillEmailField(email);

        registerPagePage.fillPasswordField(password);

        registerPagePage.clickRegisterButtonSuccess();

        loginPagePage.checkVisibilityEnterText();

        //Теперь мы залогиним юзера для того, чтобы потом удалить

        loginPagePage.fillEmailFieldLogin(email);
        loginPagePage.fillPasswordFieldLogin(password);
        loginPagePage.clickButtonEnterLoginPage();

        mainPagePage.checkVisibilityTextMainPage();

        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);

    }
}
