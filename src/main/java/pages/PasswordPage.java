package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.qameta.allure.Step;

public class PasswordPage extends BasePage{
       
    /**
     * определение локатора поля ввода пароля
     */
    @FindBy(xpath = "//*[contains(text(), 'Введите пароль')]/..")
    private WebElement passwdField;
    
    /**
     * определение локатора кнопки входа в аккаунт
     */
    @FindBy(xpath = "//*[contains(text(), 'Войти')]/..")
    private WebElement loginPaswordBtn;    
       
    /**
     * метод для ввода пароля
     */
    @Step("Находим элемент input для ввода пароля и печатаем пароль")  
    public void inputPasswd(String passwd) {
    	checkElementOnPage(passwdField);
    	passwdField.sendKeys(passwd);          
    }
    
    /**
     * метод для осуществления нажатия кнопки входа в аккаунт
     */
    @Step("Находим и нажимаем кнопку Войти на странице ввода пароля")
    public void clickPaswordBtn() {
    	loginPaswordBtn.click();
    } 
    
    @Step("Открываем страницу ввода пароля и переходим на страницу почтового ящика (profile)")
    public void openPasswordPageRedirectAndCheck(String password) {
 	   //PasswordPage page = new PasswordPage();
 	   inputPasswd(password);
 	   clickPaswordBtn();
    }   
}


