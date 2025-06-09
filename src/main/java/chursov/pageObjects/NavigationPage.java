package chursov.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage extends BasePage {
    private static final String NAV_FORM_URL = "navigation1.html";

    @FindBy(linkText = "Next")
    private WebElement nextButton;

    public NavigationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Get subpage url")
    public String getUrl() {
        return NAV_FORM_URL;
    }

    @Step("Click next")
    public void clickNextButton() {
        nextButton.click();
    }

}
