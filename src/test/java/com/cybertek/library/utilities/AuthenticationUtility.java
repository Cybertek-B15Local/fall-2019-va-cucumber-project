package com.cybertek.library.utilities;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationUtility {
    /**
     * reads the librarian username and password from the properties file
     * makes a POST request to the login endpoint, verifies the status 200
     * extracts the token and returns it
     * @return
     *         token
     */
    public static String getLibrarianToken() {
            String username = ConfigurationReader.getProperty("librarian_email");
            String password = ConfigurationReader.getProperty("librarian_password");

        Response response = given().
                    formParam("email", username).
                    formParam("password", password).
                    log().all().
                when().
                    post("login").prettyPeek();
        response.then().statusCode(200);

        return response.jsonPath().getString("token");

    }
}
