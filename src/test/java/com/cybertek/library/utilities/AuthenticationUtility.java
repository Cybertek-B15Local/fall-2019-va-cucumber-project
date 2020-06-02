package com.cybertek.library.utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationUtility {

    public static String getLibrarianToken() {
            String username = ConfigurationReader.getProperty("librarian_email");
            String password = ConfigurationReader.getProperty("librarian_password");

        Response response = given().
                    formParam("email", username).
                    formParam("password", password).
                when().
                    post("login").prettyPeek();
        response.then().statusCode(200);

        return response.jsonPath().getString("token");

    }
}
