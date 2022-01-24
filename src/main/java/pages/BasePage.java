package pages;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropertyManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static ChromeDriver chromeDriver;

    public BasePage() {
        initWebDriver();
        PageFactory.initElements(chromeDriver, this);
    }

    public ChromeDriver getChromeDriver() {
        return chromeDriver;
    }

    private void initWebDriver() {
        if (chromeDriver == null) {        	
        	File chromeDriverFile = new File(PropertyManager.getInstance().getDriverPath());
            System.setProperty("webdriver.chrome.driver", chromeDriverFile.getAbsolutePath());
            chromeDriver = new ChromeDriver();
        }
    }

    @Step("Переходим на страницу по ссылке {0}")
    public void goTo(String url) {
        chromeDriver.manage().window().maximize();
        chromeDriver.get(url);

    }

    @Step("Проверяем загрузился ли необходимый элемент на странице")
    public void checkElementOnPage(By by) {
        chromeDriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(chromeDriver, 40);
        wait.until(ExpectedConditions.elementToBeClickable(by));
        try {
            Assert.assertTrue("Элемент" + by + " отсутствует на странице", chromeDriver.findElement(by).isDisplayed());
        } catch (StaleElementReferenceException e) {
            throw new RuntimeException("Данный элемент не был найден на странице" + by);
        }
    }

    @Step("Проверяем загрузился ли необходимый элемент на странице")
    public void checkElementOnPage(WebElement webElement) {
        chromeDriver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(35, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(chromeDriver, 35);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            Assert.assertTrue("Элемент" + webElement + " отсутствует на странице", webElement.isDisplayed());
        } catch (StaleElementReferenceException e) {
            throw new RuntimeException("Элемент не находится на странице " + webElement);
        }
    }
   
    @After
    @Step("Закрываем браузер")
    public void closeBrowser() {
        if (chromeDriver != null) {
            chromeDriver.close();
            chromeDriver.quit();
        } 
    }           
}