package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class FirstPage extends BasePage {	
	
	/**
     * определение локатора меню пользовател€
     */  	
    @FindBy(xpath = "//*[contains(text(), '¬ойти')]/..")   
    private WebElement firstloginBtn;        
    
    /**
     * метод дл€ нажати€ кнопки ¬ойти на первой странице g-mail
     */      
    public void clickFirstLoginBtn() {   
    	firstloginBtn.click(); 
    } 
    
    @Step("ќткрываем страницу gmail и переходим на страницу логина")
    public void openPageRedirectAndCheck(String goTo) {    
    goTo(goTo); 
    clickFirstLoginBtn();
    }   
}
