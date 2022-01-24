package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class PasswordPage extends BasePage{
       
    /**
     * ����������� �������� ���� ����� ������
     */
    @FindBy(xpath = "//*[contains(text(), '������� ������')]/..")
    private WebElement passwdField;
    
    /**
     * ����������� �������� ������ ����� � �������
     */
    @FindBy(xpath = "//*[contains(text(), '�����')]/..")
    private WebElement loginPaswordBtn;    
       
    /**
     * ����� ��� ����� ������
     */
    @Step("������� ������� input ��� ����� ������ � �������� ������")  
    public void inputPasswd(String passwd) {
    	checkElementOnPage(passwdField);
    	passwdField.sendKeys(passwd);          
    }
    
    /**
     * ����� ��� ������������� ������� ������ ����� � �������
     */
    @Step("������� � �������� ������ ����� �� �������� ����� ������")
    public void clickPaswordBtn() {
    	loginPaswordBtn.click();
    } 
    
    @Step("��������� �������� ����� ������ � ��������� �� �������� ��������� ����� (profile)")
    public void openPasswordPageRedirectAndCheck(String password) {
 	   //PasswordPage page = new PasswordPage();
 	   inputPasswd(password);
 	   clickPaswordBtn();
    }   
}


