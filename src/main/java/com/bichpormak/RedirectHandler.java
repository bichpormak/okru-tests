package com.bichpormak;


public class RedirectHandler {

    /**
     * Attempts to log in with the given credentials and verifies that the user is redirected to the MainPage.
     * If the user profile on the MainPage is not displayed, an AssertionError is thrown.
     *
     * @param loginPage the LoginPage object to perform login actions
     * @param username  the username to use for login
     * @param password  the password to use for login
     * @return MainPage object representing the redirected main page after a successful login
     */
    public static MainPage expectRedirectToMainPage(LoginPage loginPage, String username, String password) {

        loginPage.attemptLogin(username, password);
        MainPage mainPage = new MainPage();

        if (!mainPage.isUserLoggedIn()) {
            throw new AssertionError("Redirect to MainPage failed");
        }

        return mainPage;
    }

    /**
     * Attempts to log in with the provided credentials and verifies that the login page remains visible with an error message.
     * If the error message is not displayed or the login form disappears, an AssertionError is thrown.
     *
     * @param loginPage the LoginPage object to perform login actions
     * @param username  the username to use for login
     * @param password  the password to use for login
     * @return the same LoginPage object to indicate that the login page is still displayed with an error
     */
    public static LoginPage expectRemainOnLoginPageWithError(LoginPage loginPage, String username, String password) {

        loginPage.attemptLogin(username, password);

        try {
            loginPage.isFieldWithErrorDisplayed("No error message appeared");
        } catch (Throwable t) {
            throw new AssertionError("No error message appeared");
        }

        if (!loginPage.isLoginFormDisplayed()) {
            throw new AssertionError("Login form disappeared after an error");
        }
        return loginPage;

    }

    /**
     * Validates the state of the LoginPage by checking if an error message is present.
     * Throws an AssertionError if the error message is empty.
     *
     * @param loginPage the LoginPage object whose state is to be validated
     */
    public static void validatePageState(LoginPage loginPage) {

        if (loginPage.getErrorMessage().isEmpty()) {
            throw new AssertionError("Redirect did not occur");
        }

    }

    /**
     * Validates the state of the MainPage by checking if the user is logged in.
     *
     * @param mainPage the MainPage object whose state is to be validated
     * @return true if the user is logged in (user profile is displayed), otherwise false
     */
    public static boolean validatePageState(MainPage mainPage) {

        return mainPage.isUserLoggedIn();

    }

}