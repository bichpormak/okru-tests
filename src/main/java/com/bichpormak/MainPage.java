package com.bichpormak;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    private final SelenideElement userProfile = $x("//*[@id='hook_Block_UserMainMRB']");

    public boolean isUserLoggedIn() {
        return userProfile.isDisplayed();
    }

}