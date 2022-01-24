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
    * ����������� �������� ���� ����� ������
    */	 
    @FindBy(xpath = "//*[contains(@id, 'identifierId')]")    
    private WebElement loginField;    
        
    /**
     * ����������� �������� ������ ����� � �������
     */  
    @FindBy(xpath = "//*[@id=\"identifierNext\"]/div/button/span")
    private WebElement loginBtn;	
    
    /**
     * ����� ��� ����� ������
     */
    @Step("������ �����")    
    public void inputLogin(String login) {      	
        loginField.sendKeys(login);
    }          
    
    /**
     * ����� ��� ������������� ������� ������ ����� ��� �������� �� �������� ����� ������
     */
    @Step("�������� ������ ����� �� �������� ����� ������")  
    public void clickLoginBtn() {    	
    	loginBtn.click(); 
    } 
    
    @Step("��������� �������� ����� ������ � ��������� �� �������� ����� ������")
    public void openLoginPageRedirectAndCheck(String login) {    	
    	inputLogin(login);  
    	clickLoginBtn();    	
    }
}

