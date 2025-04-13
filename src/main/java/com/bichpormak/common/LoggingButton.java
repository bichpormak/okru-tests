package com.bichpormak.common;

import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//decorator
public class LoggingButton extends Button {

    private static final Logger log = LoggerFactory.getLogger(LoggingButton.class);

    public LoggingButton(SelenideElement element) {
        super(element);
    }

    @Override
    public Button click() {
        log.info("Clicking: {}", getElement().getSearchCriteria());
        return super.click();
    }

}
