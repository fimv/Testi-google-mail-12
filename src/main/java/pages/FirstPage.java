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
     * ����������� �������� ���� ������������
     */  	
    @FindBy(xpath = "//*[contains(text(), '�����')]/..")   
    private WebElement firstloginBtn;        
    
    /**
     * ����� ��� ������� ������ ����� �� ������ �������� g-mail
     */      
    public void clickFirstLoginBtn() {   
    	firstloginBtn.click(); 
    } 
    
    @Step("��������� �������� gmail � ��������� �� �������� ������")
    public void openPageRedirectAndCheck(String goTo) {    
    goTo(goTo); 
    clickFirstLoginBtn();
    }   
}
