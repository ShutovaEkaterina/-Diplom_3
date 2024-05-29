package userpackage;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import java.net.HttpURLConnection;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class UserResponse {
    @Step("Check creating unique user")
    public void createdSuccessfully(ValidatableResponse createResponse, User expectedUser) {
        boolean success = createResponse
                .assertThat()
                .statusCode(HttpURLConnection.HTTP_OK)
                .extract()
                .path("success");
        assertTrue(success);

        String email = createResponse.extract().path("user.email");
        String name = createResponse.extract().path("user.name");
        String accessToken = createResponse.extract().path("accessToken");
        String refreshToken = createResponse.extract().path("refreshToken");

        assertEquals(expectedUser.getEmail().toLowerCase(), email.toLowerCase());
        assertEquals(expectedUser.getName(), name);
        assertNotNull(accessToken);
        assertNotNull(refreshToken);
    }
    @Step("User is deleted")
    public void deletedSuccesfully(ValidatableResponse response) {
        response.assertThat()
                .statusCode(HttpURLConnection.HTTP_ACCEPTED);
    }

    public String extractToken(ValidatableResponse response) {
        return response.extract().jsonPath().getString("accessToken");
    }
}
