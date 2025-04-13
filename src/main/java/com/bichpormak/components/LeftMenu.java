package com.bichpormak.components;

import com.bichpormak.common.Button;
import com.bichpormak.common.ElementFactory;

import java.util.HashMap;
import java.util.Map;


public class LeftMenu {

    private final Map<String, Button> items = new HashMap<>();

    public LeftMenu() {
        items.put("nickname", ElementFactory.createButton("//*[@data-l='t,userPage']", ElementFactory.SelectorType.XPATH, true));
        items.put("feed", ElementFactory.createButton("//*[@data-l='t,userMain']", ElementFactory.SelectorType.XPATH, false));
        items.put("hobbies", ElementFactory.createButton("//*[@data-l='t,hobby']", ElementFactory.SelectorType.XPATH, false));
        items.put("friends", ElementFactory.createButton("//*[@data-l='t,userFriend']", ElementFactory.SelectorType.XPATH, false));
        items.put("photo", ElementFactory.createButton("//*[@data-l='t,userPhotos']", ElementFactory.SelectorType.XPATH, false));
        items.put("groups", ElementFactory.createButton("//*[@data-l='t,userAltGroup']", ElementFactory.SelectorType.XPATH, false));
        items.put("plays", ElementFactory.createButton("//*[@data-l='t,appsShowcaseHD']", ElementFactory.SelectorType.XPATH, false));
        items.put("presents", ElementFactory.createButton("//*[@data-l='t,giftsFront']", ElementFactory.SelectorType.XPATH, false));
        items.put("recommendation", ElementFactory.createButton("//*[@data-l='t,discovery']", ElementFactory.SelectorType.XPATH, false));
        items.put("applications", ElementFactory.createButton("//*[@data-l='t,bizApps']", ElementFactory.SelectorType.XPATH, false));
        items.put("acquaintance", ElementFactory.createButton("//*[@data-l='t,appsDating']", ElementFactory.SelectorType.XPATH, false));
        items.put("paymentsAndSubscriptions", ElementFactory.createButton("//*[contains(@data-l,'payments')]", ElementFactory.SelectorType.XPATH, false));
        items.put("okCurrency", ElementFactory.createButton("//*[contains(@data-l,'REPLENISH_BALANCE')]", ElementFactory.SelectorType.XPATH, false));
        items.put("invisibleMode", ElementFactory.createButton("//*[contains(@data-l,'TURN_HIDDEN_ON_OFF_PROMO')]", ElementFactory.SelectorType.XPATH, false));
        items.put("advertisingOffice", ElementFactory.createButton("//*[contains(@data-l,'adsManagerMain')]", ElementFactory.SelectorType.XPATH, false));
        items.put("bookmarks", ElementFactory.createButton("//*[contains(@data-l,'bookmarks')]", ElementFactory.SelectorType.XPATH, false));
        items.put("holidays", ElementFactory.createButton("//*[contains(@data-l,'eventsCalendar')]", ElementFactory.SelectorType.XPATH, false));
        items.put("findFriends", ElementFactory.createButton("//*[contains(@data-l,'FIND_NEW_FRIENDS')]", ElementFactory.SelectorType.XPATH, false));

    }


    public LeftMenu verifyAllElements() {
        items.values().forEach(Button::verifyVisible);
        return this;
    }

    public void clickItem(String name) {
        items.get(name).click();
    }


}