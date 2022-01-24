package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class InboxPage extends BasePage {	
	private static ChromeDriver driver; 
      
    /**
     * определение локатора кнопки "Написать письмо"
     */
    @FindBy(xpath = "//*[@id=\":9x\"]/div/div")
    private WebElement WriteLetterBtn;		
    
    /**
     * определение локатора поля Кому
     */
    @FindBy(xpath = "//*[@id=\":gq\"]")
    private WebElement WhoomField;	
    
    /**
     * определение локатора поля Тема письма
     */
    @FindBy(xpath = "//*[@id=\":g8\"] ")
    private WebElement TopicField;	
    
    /**
     * определение локатора поля Текст письма
     */
    @FindBy(xpath = "//*[@id=\":he\"]")
    private WebElement TextField;	
    
    /**
     * определение локатора поля кнопки Отправить
     */
    @FindBy(xpath = "//*[contains(text(), 'Отправить')]/..")
    private WebElement SendBtn;
    
    /**
     * определение локатора поля кнопки Выйти
     */    
    @FindBy(xpath = "//*[contains(text(), 'Выйти')]/..")
    private WebElement OutBtn;    
     
    @Step("Подсчитываем количество писем с темой {0}")  
    public String findLetters(String searchTopic) {    	
    	final String xpath = "//*[contains(text(), '" + searchTopic + "')]";
    	final int xpathCount = driver.findElements(By.xpath(xpath)).size();  	
    	final String topicCount = String.valueOf(xpathCount);
    	return topicCount;        
    }    
    
    @Step("Нажимаем на кнопку Написать письмо")
    public void writeLetterBtnСlick() {    	
    	WriteLetterBtn.click(); 
    } 
       
    @Step("Вводим реквизиты письма: кому, тема, текст письма {0}, {1}, {2} и нажимаем кнопку Отправить")
    public void topicWriteLetterBtn(String whoom, String topic, String topicForCount) {    	
    	WhoomField.sendKeys(whoom);
    	TopicField.sendKeys(topic);
    	TextField.sendKeys(topicForCount);     	
    	SendBtn.click(); 
    }  
    
    @Step("Нажимаем на кнопку Выйти из аккаунта")
    public void clickOutBtn() {    	
    	OutBtn.click(); 
    }
    
    @Step("Считаем количество элементов Тема письма и выход ")
    public void writeLetter(String whoom, String topic, String topicForCount) {
 	   writeLetterBtnСlick();   
 	   topicWriteLetterBtn(whoom, topic, topicForCount);
 	   clickOutBtn();   	   
    }
}



