import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pomlogin.LoginPage;
import pommainpackage.MainPage;
import pomregister.RegisterPage;
import pomrestorepassword.RestorePasswordPage;
import userpackage.User;
import userpackage.UserPath;
import userpackage.UserResponse;

public class EnterRestorePasswordTest {
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
    @DisplayName("Login trough restore password page")
    @Test
    public void testRestorePasswordTest() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site/forgot-password");

        RestorePasswordPage restorePasswordPagePage = new RestorePasswordPage(driver);
        restorePasswordPagePage.waitForModalOverlayToDisappear();
        restorePasswordPagePage.scrollToElement(restorePasswordPagePage.buttonEnterRestorePasswordPage);
        MainPage.JSUtils.clickElementByJS(driver, restorePasswordPagePage.buttonEnterRestorePasswordPage);
        //restorePasswordPagePage.clickButtonEnterRestorePasswordPage();

        LoginPage loginPagePage = new LoginPage(driver);
        loginPagePage.fillEmailFieldLogin(email);
        loginPagePage.fillPasswordFieldLogin(password);
        loginPagePage.clickButtonEnterLoginPage();

        MainPage mainPagePage = new MainPage(driver);
        mainPagePage.checkVisibilityTextMainPage();

        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);
    }
}
