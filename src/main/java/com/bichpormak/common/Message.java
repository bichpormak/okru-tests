package com.bichpormak.common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class Message {

    private final SelenideElement element;

    public Message(SelenideElement element) {
        this.element = element;
    }


    public Message verifyVisible() {
        element.shouldBe(visible.because("Message element should be visible"));
        return this;
    }

    public SelenideElement getElement() {
        return element;
    }
}
