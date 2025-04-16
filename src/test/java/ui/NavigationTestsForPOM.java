package ui;

import chursov.pageObjects.HomePage;
import chursov.pageObjects.NavigationPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;

import static chursov.pageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("POM")
class NavigationTestsForPOM extends BaseTestForPOM {
    @Test
    void openNavFormTest() {
        HomePage homePage = new HomePage(driver);
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        String title = navigationPage.getTitle();
        String webFormUrl = navigationPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Navigation example", title);
    }
}
