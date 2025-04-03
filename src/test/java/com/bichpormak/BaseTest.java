package com.bichpormak;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static com.codeborne.selenide.Selenide.open;

@DisplayName("General class for everyone")
public abstract class BaseTest {

    @BeforeEach
    public void setUp() {

        open("https://ok.ru");

    }

    @AfterEach
    public void tearDown() {

        Selenide.clearBrowserCookies();

    }

}
