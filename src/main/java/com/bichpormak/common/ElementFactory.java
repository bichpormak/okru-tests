package com.bichpormak.common;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ElementFactory {

    public enum SelectorType {
        CSS, XPATH
    }

    public static Button createButton(String selector, SelectorType selectorType, boolean withLogging) {
        SelenideElement element = selectorType == SelectorType.XPATH ? $x(selector) : $(selector);
        return withLogging ? new LoggingButton(element) : new Button(element);
    }

    public static Input createInput(String selector, SelectorType selectorType) {
        SelenideElement element = selectorType == SelectorType.XPATH ? $x(selector) : $(selector);
        return new Input(element);
    }

    public static Message createMessage(String selector, SelectorType selectorType) {
        SelenideElement element = selectorType == SelectorType.XPATH ? $x(selector) : $(selector);
        return new Message(element);
    }

}
