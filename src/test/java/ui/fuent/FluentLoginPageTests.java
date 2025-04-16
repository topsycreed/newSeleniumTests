package ui.fuent;

import chursov.fluentPages.FluentLoginPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.BaseTest;

@Feature("Fluent")
class FluentLoginPageTests extends BaseTest {
    FluentLoginPage loginPage;

    @BeforeEach
    void initPages() {
        loginPage = new FluentLoginPage(driver);
    }

    @Test
    void testLoginSuccess() {
        loginPage
                .login("user", "user")
                .checkSuccessBoxPresent()
                .checkInvalidCredentialsBoxIsNotPresent();
    }

    @Test
    void testLoginFailure() {
        loginPage
                .login("test", "test")
                .checkInvalidCredentialsBoxPresent()
                .checkSuccessBoxIsNotPresent();
    }
}
