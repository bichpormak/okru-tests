package com.bichpormak;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;


import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Tests for registration on the page")
public class LoginPageTests extends BaseTest {


    @ParameterizedTest(name = "empty or null password")
    @NullAndEmptySource
    @Tag("LoginPage")
    @DisplayName("Check for reaction when entering an empty password")
    public void loginWithEmptyPassword(String password) {

        var loginPage = new LoginPage().attemptLogin("*****", password)
                        .isFieldWithErrorDisplayed("Enter password");

        assertAll("Empty field of password",

                () -> assertEquals("Введите пароль", loginPage.getErrorMessage()),
                () -> assertTrue(loginPage.isLoginFormDisplayed(), () -> "After failure, check that the fields have not disappeared")

        );

    }

    @Test
    @Tag("LoginPage")
    @DisplayName("Check for reaction when no input is present")
    public void loginWithEmptyFields() {

        var loginPage = new LoginPage().attemptLogin("", "")
                        .isFieldWithErrorDisplayed("You have not entered any data");

        assertAll("Empty fields",

                () -> assertEquals("Введите логин", loginPage.getErrorMessage()),
                () -> assertTrue(loginPage.isLoginFormDisplayed(), () -> "After failure, check that the fields have not disappeared")

        );

    }

    @Test
    @Tag("LoginPage")
    @DisplayName("Check for invalid data details")
    public void loginWithIncorrectData() {

        var loginPage = new LoginPage().attemptLogin("*****", "****")
                .isFieldWithErrorDisplayed("You have entered incorrect login details");

        assertAll("Incorrect data",

                () -> assertEquals("Неправильно указан логин и/или пароль", loginPage.getErrorMessage()),
                () -> assertTrue(loginPage.isLoginFormDisplayed(), () -> "After failure, check that the fields have not disappeared")

        );

    }

    @Test
    @Tag("LoginPage")
    @DisplayName("Check that page loaded successfully")
    public void loginPageLoadsCorrectly() {

        assertTrue(new LoginPage().isLoginFormDisplayed());

    }


    @Nested
    @DisplayName("Transition from LoginPage to MainPage")
    class RedirectHandlerTest {

        @ParameterizedTest
        @CsvSource({"technopol60,technopolisPassword", "technopol61,technopolisPassword"})
        @Tag("RedirectPage")
        @DisplayName("Successful redirect")
        public void testSuccessfulLogin(String username, String password) {

            LoginPage loginPage = new LoginPage();

            MainPage mainPage = assertDoesNotThrow(
                    () -> RedirectHandler.expectRedirectToMainPage(loginPage, username, password),
                    () -> "Exception thrown during login redirect with valid credentials"
            );

            assertTrue(RedirectHandler.validatePageState(mainPage), () -> "Test bots unexpectedly have captcha");

        }

        @Test
        @Tag("RedirectPage")
        @DisplayName("Failed redirect")
        public void testFailedLogin() {

            LoginPage loginPage = new LoginPage();
            LoginPage errorPage = assertDoesNotThrow(
                    () -> RedirectHandler.expectRemainOnLoginPageWithError(loginPage, "*****", "****"),
                    () -> "Exception thrown during login redirect"
            );

            assertDoesNotThrow(
                    () -> RedirectHandler.validatePageState(errorPage),
                    () -> "The redirect occurred with an error"
            );

        }

    }

}