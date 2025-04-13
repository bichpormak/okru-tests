package com.bichpormak;

import com.bichpormak.model.Credentials;
import com.bichpormak.pages.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;


import static com.codeborne.selenide.Condition.visible;
import static org.junit.jupiter.api.Assertions.*;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Tests for registration on the page")
public class LoginPageTests extends BaseTest {


    @ParameterizedTest(name = "empty or null password")
    @NullAndEmptySource
    @Tag("LoginPage")
    @DisplayName("Check for reaction when entering an empty password")
    public void loginWithEmptyPassword(String password) {

        var loginPage = new LoginPage();
        loginPage.getUsernameField().setValue("*****");
        loginPage.getPasswordField().setValue(password);
        loginPage.getLoginButton().click();

        loginPage.getErrorMessage().verifyVisible();

        assertAll("Empty field of password",
                () -> assertTrue(loginPage.getErrorMessage().getElement().is(visible), "Error message should be visible"),
                () -> assertEquals("Введите пароль", loginPage.getErrorMessage().getElement().getText())
        );

    }

    @Test
    @Tag("LoginPage")
    @DisplayName("Check for reaction when no input is present")
    public void loginWithEmptyFields() {

        var loginPage = new LoginPage();
        loginPage.getUsernameField().setValue("");
        loginPage.getPasswordField().setValue("");
        loginPage.getLoginButton().click();

        loginPage.getErrorMessage().verifyVisible();

        assertAll("Empty fields",

                () -> assertEquals("Введите логин", loginPage.getErrorMessage().getElement().getText()),
                () -> assertTrue(loginPage.getErrorMessage().getElement().is(visible), () -> "After failure, check that the fields have not disappeared")

        );

    }

    @Test
    @Tag("LoginPage")
    @DisplayName("Check for invalid data details")
    public void loginWithIncorrectData() {

        var loginPage = new LoginPage();
        loginPage.getUsernameField().setValue("*****");
        loginPage.getPasswordField().setValue("****");
        loginPage.getLoginButton().click();

        loginPage.getErrorMessage().verifyVisible();

        assertAll("Incorrect data",

                () -> assertEquals("Неправильно указан логин и/или пароль", loginPage.getErrorMessage().getElement().getText()),
                () -> assertTrue(loginPage.getErrorMessage().getElement().is(visible), () -> "After failure, check that the fields have not disappeared")

        );

    }

    @Test
    @Tag("LoginPage")
    @DisplayName("Check that page loaded successfully")
    public void loginPageLoadsCorrectly() {

        new LoginPage();

    }


    @Nested
    @DisplayName("Transition from LoginPage to MainPage")
    class RedirectHandlerTest {

        @ParameterizedTest
        @CsvSource({"technopol60,technopolisPassword", "technopol61,technopolisPassword"})
        @Timeout(30)
        @Tag("RedirectPage")
        @DisplayName("Successful redirect")
        public void testSuccessfulLogin(String username, String password) {

            new LoginPage().login(new Credentials(username, password));

        }

        @Test
        @Tag("RedirectPage")
        @Timeout(10)
        @DisplayName("Failed redirect")
        public void testFailedLogin() {

            LoginPage loginPage = new LoginPage();
            loginPage.getUsernameField().setValue("*****");
            loginPage.getPasswordField().setValue("*****");
            loginPage.getLoginButton().click();

            loginPage.verifyPageLoaded();
            loginPage.getErrorMessage().verifyVisible();

        }

    }

}