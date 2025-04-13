package com.bichpormak.common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;

public class Button {

    private final SelenideElement element;

    public Button(SelenideElement element) {
        this.element = element;
    }

    public Button click() {

        verifyVisible().element.click();
        return this;

    }

    public Button verifyVisible() {
        element.shouldBe(visible.because("Button should be visible before click"));
        return this;
    }

    public SelenideElement getElement() {
        return element;
    }


}
