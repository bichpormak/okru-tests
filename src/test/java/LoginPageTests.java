import com.bichpormak.LoginPage;
import com.bichpormak.MainPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;


public class LoginPageTests {

    private final LoginPage loginPage = new LoginPage();
    private final MainPage mainPage = new MainPage();


    @BeforeEach
    public void setUp() {
        Selenide.clearBrowserCookies();
        open("https://ok.ru");
    }


    // верну как дадите тестового пользователя, не проходит из-за капчи
//    @Test
//    public void successfulLogin() {
//        loginPage.attemptLogin("*****", "****");
//        assertTrue(mainPage.isUserLoggedIn());
//    }

    @Test
    public void loginWithIncorrectPassword() {
        loginPage.attemptLogin("*****", "****");
        assertEquals("", loginPage.getErrorMessageText());
        assertFalse(mainPage.isUserLoggedIn());
    }

    @Test
    public void loginWithEmptyFields() {
        loginPage.attemptLogin("", "");
        assertEquals("Mobile phone or e-mail address", loginPage.getErrorMessageText());
        assertFalse(mainPage.isUserLoggedIn());
    }

    @Test
    public void loginWithIncorrectUsername() {
        loginPage.attemptLogin("*****", "****");
        assertEquals("", loginPage.getErrorMessageText());
        assertFalse(mainPage.isUserLoggedIn());
    }

    @Test
    public void loginPageLoadsCorrectly() {
        assertTrue(loginPage.isLoginFormDisplayed());
    }
}