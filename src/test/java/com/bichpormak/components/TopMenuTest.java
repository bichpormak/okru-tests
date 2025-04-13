package com.bichpormak.components;

import com.bichpormak.BaseTest;
import com.bichpormak.data.CredentialsProvider;
import com.bichpormak.pages.LoginPage;
import com.bichpormak.pages.MainPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Checking the display of the top menu")
public class TopMenuTest extends BaseTest {


    @Test
    @Tag("PageElement")
    @DisplayName("Check that page loaded successfully")
    public void loginPageLoadsCorrectly() {

        MainPage mainPage = new LoginPage().login(CredentialsProvider.getValidCredentials());
        mainPage.topMenuDisplayed();

    }


}