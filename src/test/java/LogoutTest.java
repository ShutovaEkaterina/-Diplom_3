import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pomPrivateAccount.PrivateAccount;
import pomlogin.LoginPage;
import pommainpackage.MainPage;
import userpackage.User;
import userpackage.UserPath;
import userpackage.UserResponse;

public class LogoutTest {
    private final UserPath userPath = new UserPath();
    private final UserResponse userResponse = new UserResponse();
    private String accessToken;
    private String email;
    private String password;
    @Rule
    public DriverFarm driverFarm = new DriverFarm();
    @Before
    public void setUp() {
        User user = User.random();
        ValidatableResponse createResponse = userPath.createUser(user);
        userResponse.createdSuccessfully(createResponse, user);
        this.email = user.getEmail();
        this.password = user.getPassword();
    }

    @After
    public void deleteUser() {
        if (accessToken != null && !accessToken.isEmpty()) {
            ValidatableResponse response = userPath.deleteUser(accessToken);
            userResponse.deletedSuccesfully(response);
        }
    }
//тест упадет, так как текст кнопки для выхода отличается в задании
    @Test
    public void testLogout() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site");

        MainPage mainPagePage = new MainPage(driver);
        mainPagePage.clickButtonEnterMainPage();

        LoginPage loginPagePage = new LoginPage(driver);
        loginPagePage.fillEmailFieldLogin(email);
        loginPagePage.fillPasswordFieldLogin(password);
        loginPagePage.clickButtonEnterLoginPage();

        mainPagePage.checkVisibilityTextMainPage();
        mainPagePage.clickPersonalAccount();

        PrivateAccount privateAccountPage = new PrivateAccount(driver);
        privateAccountPage.checkVisibilityHistoryOrdersText();
        privateAccountPage.clickLogoutButton();

        loginPagePage.checkVisibilityEnterText();
        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);

    }
}
