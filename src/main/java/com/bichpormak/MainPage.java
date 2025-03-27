package com.bichpormak;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement userProfile = $x("//div[@id='hook_Block_MainMenu']//a[@href='/settings']");

    public boolean isUserLoggedIn() {
        return userProfile.isDisplayed();
    }

}