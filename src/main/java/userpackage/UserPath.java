package userpackage;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import pombasic.BasicStaff;

import java.util.Map;

public class UserPath extends BasicStaff {
    private static final String USER_PATH = "/auth";

    @Step("Create unique user")
    public ValidatableResponse createUser(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH + "/register")
                .then().log().all();
    }

    @Step("User is deleting")
    public ValidatableResponse deleteUser(String accessToken) {
        return spec()
                .header("Authorization", accessToken)
                .when()
                .delete(USER_PATH + "/user")
                .then().log().all();
    }
}
