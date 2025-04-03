package com.bichpormak;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement usernameField = $("#field_email");
    private final SelenideElement passwordField = $("#field_password");
    private final SelenideElement loginButton = $x("//input[@type='submit']");
    private final SelenideElement errorMessage = $x("//*[@class='input-e login_error']");


    public boolean isLoginFormDisplayed() {

        return usernameField.isDisplayed()
                && passwordField.isDisplayed()
                && loginButton.isDisplayed();

    }

    public LoginPage attemptLogin(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return this;

    }

    public void enterUsername(String username) {
        usernameField.setValue(username);
    }

    public void enterPassword(String password) {
        passwordField.setValue(password);
    }


    public void clickLoginButton() {
        loginButton.click();
    }

    public LoginPage isFieldWithErrorDisplayed(String message) {

        errorMessage.shouldBe(visible.because(message));
        return this;

    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}