package com.bichpormak.components;

import com.bichpormak.common.Button;
import com.bichpormak.common.ElementFactory;

import java.util.HashMap;
import java.util.Map;


public class TopMenu {

    private final Map<String, Button> items = new HashMap<>();

    public TopMenu() {

        items.put("logo", ElementFactory.createButton("//*[@data-l='t,logo']", ElementFactory.SelectorType.XPATH, false));
        items.put("messages", ElementFactory.createButton("//*[@data-l='t,messages']", ElementFactory.SelectorType.XPATH, false));
        items.put("discussions", ElementFactory.createButton("//*[@data-l='t,discussions']", ElementFactory.SelectorType.XPATH, false));
        items.put("notifications", ElementFactory.createButton("//*[@data-l='t,notifications']", ElementFactory.SelectorType.XPATH, false));
        items.put("guests", ElementFactory.createButton("//*[@data-l='t,guests']", ElementFactory.SelectorType.XPATH, false));
        items.put("events", ElementFactory.createButton("//*[@data-l='t,marks']", ElementFactory.SelectorType.XPATH, false));
        items.put("video", ElementFactory.createButton("//*[@data-l='t,video']", ElementFactory.SelectorType.XPATH, false));
        items.put("music", ElementFactory.createButton("//*[@data-l='t,music']", ElementFactory.SelectorType.XPATH, false));
        items.put("eventsToday", ElementFactory.createButton("//*[@data-l='t,today']", ElementFactory.SelectorType.XPATH, false));
        items.put("vkEcosystem", ElementFactory.createButton("//*[@data-l='t,vk_ecosystem']", ElementFactory.SelectorType.XPATH, false));
        items.put("search", ElementFactory.createButton("//*[@data-l='t,search']", ElementFactory.SelectorType.XPATH, false));
        items.put("toolbarDropdown", ElementFactory.createButton("//*[@class='toolbar_dropdown_w h-mod']", ElementFactory.SelectorType.XPATH, false));

    }

    public TopMenu verifyAllElements() {
        items.values().forEach(Button::verifyVisible);
        return this;
    }

    public void clickItem(String name) {
        items.get(name).click();
    }

}