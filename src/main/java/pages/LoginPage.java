package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.*;
import java.util.concurrent.TimeUnit;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {		 
	
    /**
    * определение локатора поля ввода логина
    */	 
    @FindBy(xpath = "//*[contains(@id, 'identifierId')]")    
    private WebElement loginField;    
        
    /**
     * определение локатора кнопки входа в аккаунт
     */  
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement loginBtn;	
    
    /**
     * метод для ввода логина
     */
    @Step("Вводим логин")    
    public void inputLogin(String login) {      	
        loginField.sendKeys(login);
    }          
    
    /**
     * метод для осуществления нажатия кнопки далее для перехода на страницу ввода пароля
     */
    @Step("Нажимаем кнопку Далее на странице ввода логина")  
    public void clickLoginBtn() {    	
    	loginBtn.click(); 
    } 
    
    @Step("Открываем страницу ввода логина и переходим на страницу ввода пароля")
    public void openLoginPageRedirectAndCheck(String login) {    	
    	inputLogin(login);  
    	clickLoginBtn();    	
    }
}

