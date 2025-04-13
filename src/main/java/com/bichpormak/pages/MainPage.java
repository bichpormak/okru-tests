package com.bichpormak.pages;

import com.bichpormak.common.Button;
import com.bichpormak.common.ElementFactory;
import com.bichpormak.components.LeftMenu;
import com.bichpormak.components.TopMenu;

public class MainPage {

    private final Button userProfile = ElementFactory.createButton("//*[@id='hook_Block_UserMainMRB']", ElementFactory.SelectorType.XPATH, true);

    private final LeftMenu leftMenu = new LeftMenu();
    private final TopMenu topMenu = new TopMenu();


    public MainPage() {
        verifyPageLoaded();
    }

    private void verifyPageLoaded() {
        userProfile.verifyVisible();
    }

    public LeftMenu leftMenuDisplayed() {
        return leftMenu.verifyAllElements();
    }

    public TopMenu topMenuDisplayed() {
        return topMenu.verifyAllElements();
    }

}