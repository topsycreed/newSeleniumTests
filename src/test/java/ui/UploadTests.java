package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;

public class UploadTests extends BaseTest {
    @Test
    void uploadFileTest() throws InterruptedException {
        String fileName = "webdrivermanager.png";
        String filePath = "src/main/resources/" + fileName;

        // Получаем URL ресурса
        URL url = UploadTests.class.getClassLoader().getResource(fileName);

        String absolutePath = null;
        if (url != null) {
            // Получаем абсолютный путь к файлу
            absolutePath = new File(url.getPath()).getAbsolutePath();
            System.out.println("Абсолютный путь к файлу: " + absolutePath);
        } else {
            System.out.println("Ресурс не найден.");
        }

        // Открываем страницу с формой загрузки файла
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        // Находим элемент <input type="file"> по его атрибуту name
        WebElement fileInput = driver.findElement(By.xpath("//input[@name='my-file']"));

        // Загружаем файл, указывая абсолютный путь к файлу
        fileInput.sendKeys(new File(filePath).getAbsolutePath());

        // Далее можно продолжить взаимодействие с элементами на странице или выполнять другие действия
        Thread.sleep(5000);
        WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
        submit.click();
        Thread.sleep(5000);

        assertThat(driver.getCurrentUrl()).contains(fileName);
    }
}
