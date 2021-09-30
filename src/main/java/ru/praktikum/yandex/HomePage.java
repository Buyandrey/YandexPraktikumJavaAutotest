package ru.praktikum.yandex;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    //////////////////////////////////////////////////*
    // Заголовок текста
    // Подзаголовок до прокрутки
    // Картинка до прокрутки
    // Таблица после прокрутки
    // Картинка после прокрутки
    ///////////////////////////////////////////////////
    //Заголовок пунктов
    // Цифра 1
    // Название 1
    // Суть 1
    // Цифра 2
    // Название 2
    // Суть 2
    // Цифра 3
    // Название 3
    // Суть 3
    // Цифра 4
    // Название 4
    // Суть 4
    // Кнопка Заказать (нижняя)
    //////////////////////////////////////////////////
    // Заголовок вопроса 1
    // Кнопка раскрытия ответа 1
    // Заголовок вопроса 2
    // Кнопка раскрытия ответа 2
    // Заголовок вопроса 3
    // Кнопка раскрытия ответа 3
    // Заголовок вопроса 4
    // Кнопка раскрытия ответа 4
    // Заголовок вопроса 5
    // Кнопка раскрытия ответа 5
    // Заголовок вопроса 6
    // Кнопка раскрытия ответа 6
    // Заголовок вопроса 7
    // Кнопка раскрытия ответа 7
    // Заголовок вопроса 8
    // Кнопка раскрытия ответа 8
    ////////////////////////////////////////////////*/
    @FindBy(how = How.CLASS_NAME, using = "Button_Button__ra12g") private SelenideElement buttonOrderOnTop;
    @FindBy(how = How.CLASS_NAME, using = "App_CookieButton__3cvqF") private SelenideElement buttonAcceptCookie;
    public String getTextOfTheElement(SelenideElement element){
        return element.getText();
    }

    public SelenideElement getButtonOrderOnTop(){
        return buttonOrderOnTop;
    }
    public void clickButtonOrderOnTop(){
        buttonOrderOnTop.click();
    }

    public SelenideElement getButtonAcceptCookie(){
        return buttonAcceptCookie;
    }
    public void clickButtonAcceptCookie(){
        buttonAcceptCookie.click();
    }
}
