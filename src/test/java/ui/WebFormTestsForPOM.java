package ui;

import chursov.pageObjects.HomePage;
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
class WebFormTestsForPOM extends BaseTestForPOM {

    @Test
    void openWebFormTest() {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();
        String currentUrl = webFormPage.getCurrentUrl();
        String title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title);
    }

    @Test
    void openWebFormTestWithCheck() {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.checkIsWebPage();
    }

    @Test
    void submitFormTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.submitForm();
        Thread.sleep(3000);
    }

    @Test
    void checkTextareaInput() {
        driver.findElement(By.linkText("Web form")).click();

        WebElement textarea = driver.findElement(By.name("my-textarea"));
        textarea.sendKeys("Test\nTest2");
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        WebElement h1 = driver.findElement(By.xpath("//h1[text()='Form submitted']"));
        assertEquals("Form submitted", h1.getText());
    }

    @Test
    void disabledInput() {
        driver.findElement(By.linkText("Web form")).click();

        WebElement disabled = driver.findElement(By.name("my-disabled"));
        assertEquals("", disabled.getText());
        Exception thrown = assertThrows(ElementNotInteractableException.class, () -> disabled.sendKeys("Test\n"));
        assertThat(thrown.getMessage()).contains("element not interactable");
    }

}
