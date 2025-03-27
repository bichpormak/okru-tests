package com.bichpormak;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement usernameField = $("#field_email");
    private final SelenideElement passwordField = $("#field_password");
    private final SelenideElement loginButton = $("div[id^='tabpanel-login'] input[type='submit']");
    private final SelenideElement errorMessage = $("div[id^='tabpanel-login'] form div[class*='error']");

    public boolean isLoginFormDisplayed() {
        return usernameField.isDisplayed() && passwordField.isDisplayed() && loginButton.isDisplayed();
    }

    public void attemptLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
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

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

}