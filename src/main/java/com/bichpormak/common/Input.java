package com.bichpormak.common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class Input {

    private final SelenideElement element;

    public Input(SelenideElement element) {
        this.element = element;
    }



    public Input setValue(String value) {

        verifyVisible().element.setValue(value);
        return this;

    }

    public Input verifyVisible() {
        element.shouldBe(visible.because("Field should be visible before typing"));
        return this;
    }


}