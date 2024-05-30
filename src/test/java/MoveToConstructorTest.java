import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pomPrivateAccount.PrivateAccount;
import pomconstructor.ConstructorPage;
import pomlogin.LoginPage;
import pommainpackage.MainPage;
import userpackage.User;
import userpackage.UserPath;
import userpackage.UserResponse;

import java.util.concurrent.TimeUnit;

public class MoveToConstructorTest {
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
    @DisplayName("Move to constructor")
    @Test
    public void testMoveToPrivateAccount() {

        WebDriver driver = driverFarm.getDriver();

        driver.get("https://stellarburgers.nomoreparties.site");


        MainPage mainPagePage = new MainPage(driver);
        mainPagePage.waitForModalOverlayToDisappear();
        mainPagePage.waitForButtonEnterMainPageToBeClickable();
        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.buttonEnterMainPage);
        //mainPagePage.clickButtonEnterMainPage();

        LoginPage loginPagePage = new LoginPage(driver);
        loginPagePage.fillEmailFieldLogin(email);
        loginPagePage.fillPasswordFieldLogin(password);
        loginPagePage.clickButtonEnterLoginPage();

        mainPagePage.checkVisibilityTextMainPage();
        mainPagePage.waitForModalOverlayToDisappear();
        mainPagePage.scrollToElement(mainPagePage.personalAccount);
        mainPagePage.waitForPersonalAccountToBeClickable();
        MainPage.JSUtils.clickElementByJS(driver, mainPagePage.personalAccount);
       // mainPagePage.clickPersonalAccount();

        PrivateAccount privateAccountPage = new PrivateAccount(driver);
        privateAccountPage.checkVisibilityHistoryOrdersText();
        privateAccountPage.clickConstructorButton();

        ConstructorPage constructorPagePage = new ConstructorPage(driver);
        constructorPagePage.checkVisibilityBuildBurgerText();

        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        System.out.println(accessToken);
    }
}
