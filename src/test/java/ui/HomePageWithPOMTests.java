package ui;

import chursov.pageObjects.HomePage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("POM")
class HomePageWithPOMTests extends BaseTestForPOM {
    @Test
    void openHomePageTest() {
        HomePage homePage = new HomePage(driver);
//        homePage.open();

        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }
}
