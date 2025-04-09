package chursov.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends BasePage {
    private static final String NAV_FORM_URL = "navigation1.html";

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get subpage url")
    public String getUrl() {
        return NAV_FORM_URL;
    }


}
