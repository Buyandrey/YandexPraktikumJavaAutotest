package ru.praktikum.yandex;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.switchTo;

public class CommonElementsOfPages {
    private String nameOfTitle;
    private void setNameOfTitle(String nameOfTitle){
        this.nameOfTitle=nameOfTitle;
    }

    //head > title
    ///html/head/title
    @FindBy(how = How.XPATH, using = "/html/head/title") private SelenideElement titleOfThePage;
    // Кликабельный логотип Яндекса в шапке
    @FindBy(how = How.CLASS_NAME, using = "Header_LogoYandex__3TSOI") private SelenideElement yandexLogo;
    // Кликабельный логотип Самокат в шапке
    @FindBy(how = How.CLASS_NAME, using = "Header_LogoScooter__3lsAR") private SelenideElement scooterLogo;
    // Надпись тренажёра
    @FindBy(how = How.XPATH, using = "//div[@class='Header_Disclaimer__3VEni']") private SelenideElement trainer;
    // Кнопка Заказать (верхняя)
    @FindBy(how = How.XPATH, using = "//div/button[text()='Заказать']")private SelenideElement orderTopButton;
    // Кнопка Статус Заказа
    @FindBy(how = How.XPATH, using = "//div/button[text()='Статус заказа']")private SelenideElement statusOfTheOrderButton;
    // Поле ввода заказа
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder='Введите номер заказа']")private SelenideElement numberOfTheOrderInputField;
    // Кнопка Go!
    @FindBy(how = How.XPATH, using = "//div/button[text()='Go!']")private SelenideElement goButton;
    // Плашка Куки
    @FindBy(how = How.CLASS_NAME, using = "App_CookieConsent__1yUIN")private SelenideElement cookieForm;
    // Кнопка Куки
    @FindBy(how = How.XPATH, using = "//div/button[text()='да все привыкли']")private SelenideElement cookieAcceptButton;
    public String getTitleOfThePageText(){
        return titleOfThePage.getText();
    }

    public void goToThePage(){
        switchTo().window(0); //криво
    }
    public String getUrl(){
//коряво
        return switchTo().window(0).getCurrentUrl();
    }
    public void click_yandexLogo(){
        yandexLogo.click();
    }
    public void click_scooterLogo(){
        scooterLogo.click();
    }
    public void click_orderTopButton(){
        orderTopButton.click();
    }
    public void click_statusOfTheOrderButton(){
        statusOfTheOrderButton.click();
    }
    public void click_cookieAcceptButton(){
        cookieAcceptButton.click();
    }
    public void click_goButton(){
        goButton.click();
    }
    public boolean isVisible_cookieForm(){
        return cookieForm.is(Condition.visible);
    }
    public boolean isVisible_goButton(){
        return goButton.is(Condition.visible);
    }
    public boolean isVisible_numberOfTheOrderInputField(){
        return numberOfTheOrderInputField.is(Condition.visible);
    }

    public void setValue_numberOfTheOrderInputField(String value){
        numberOfTheOrderInputField.setValue(value);
    }
    public String getText_trainer(){
        return trainer.getText();
    }
    public String getText_orderTopButton(){
        return orderTopButton.getText();
    }
    public String getText_statusOfTheOrderButton(){
        return statusOfTheOrderButton.getText();
    }
    public String getText_numberOfTheOrderInputField(){
        return numberOfTheOrderInputField.getText();
    }
}
