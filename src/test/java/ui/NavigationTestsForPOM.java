package ui;

import chursov.pageObjects.HomePage;
import chursov.pageObjects.NavigationPage;
import chursov.pageObjects.WebFormPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import static chursov.pageObjects.HomePage.BASE_URL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Feature("POM")
class NavigationTestsForPOM extends BaseTestForPOM {
    @Test
    void openNavFormTest() {
        HomePage homePage = new HomePage(driver);
//        homePage.open();
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        WebElement title = navigationPage.getTitle();
        String webFormUrl = navigationPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Navigation example", title.getText());
    }
}
