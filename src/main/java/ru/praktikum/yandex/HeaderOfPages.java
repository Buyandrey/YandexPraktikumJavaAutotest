package ru.praktikum.yandex;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.WebDriverConditions.url;

public class HeaderOfPages {
    //Header_LogoYandex__3TSOI
    // Кнопка Яндекса в шапке
    @FindBy(how = How.CLASS_NAME, using = "Header_LogoYandex__3TSOI") private SelenideElement yandexLogo;
    // Кнопа Самокат в шапке
    @FindBy(how = How.CLASS_NAME, using = "Header_LogoScooter__3lsAR") private SelenideElement scooterLogo;
    // Надпись тренажёра
    @FindBy(how = How.XPATH, using = "//div[@class='Header_Disclaimer__3VEni']") private SelenideElement trainer;
    // Кнопка Заказать (верхняя)
    @FindBy(how = How.XPATH, using = "//div/button[text()='Заказать']")private SelenideElement orderTopButton;
    // Кнопка Статус Заказа
    @FindBy(how = How.XPATH, using = "//div/button['Статус заказа']")private SelenideElement statusOfTheOrderButton;
    // Поле ввода заказа
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder='Статус заказа']")private SelenideElement numberOfTheOrderInputField;
    // Кнопка Go!
    @FindBy(how = How.XPATH, using = "//div/button[text()='Go!']")private SelenideElement goButton;
    // Текст Куки

    // Кнопка Куки

    public String getText_trainer(){
        return trainer.getText();
    }

    public void click_yandexLogo(){ yandexLogo.click();}

    public void click_orderTopButton(){ orderTopButton.click();}

    public String getText_orderTopButton(){
        return orderTopButton.getText();
    }

    public void click_statusOfTheOrderButton(){statusOfTheOrderButton.click();}

    public void setValue_numberOfTheOrderInputField(String value){ numberOfTheOrderInputField.setValue(value);}

    public String getText_numberOfTheOrderInputField(){
        return numberOfTheOrderInputField.getText();
    }

    public void click_goButton(){ goButton.click();}


}
