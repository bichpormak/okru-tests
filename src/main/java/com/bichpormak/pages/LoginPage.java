package com.bichpormak.pages;

import com.bichpormak.common.*;
import com.bichpormak.model.Credentials;


public class LoginPage {

    private final Input usernameField = ElementFactory.createInput("#field_email", ElementFactory.SelectorType.CSS);
    private final Input passwordField = ElementFactory.createInput("#field_password", ElementFactory.SelectorType.CSS);
    private final Button loginButton = ElementFactory.createButton("//*[@data-l='t,sign_in' and @type='submit']", ElementFactory.SelectorType.XPATH, true);
    private final Message errorMessage = ElementFactory.createMessage("//*[@class='input-e login_error']", ElementFactory.SelectorType.XPATH);


    public LoginPage() {
        verifyPageLoaded();
    }

    public void verifyPageLoaded() {
        usernameField.verifyVisible();
        passwordField.verifyVisible();
        loginButton.verifyVisible();
    }


    public MainPage login(Credentials credentials) {

        usernameField.setValue(credentials.username());
        passwordField.setValue(credentials.password());
        loginButton.click();

        return new MainPage();

    }

    public Input getUsernameField() {
        return usernameField;
    }

    public Input getPasswordField() {
        return passwordField;
    }

    public Button getLoginButton() {
        return loginButton;
    }

    public Message getErrorMessage() {
        return errorMessage;
    }


}