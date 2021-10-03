package ru.praktikum.yandex;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;


public class TrackPage {
    // Локаторы для значений заказа (имя, фам, адр, метро, тлф, дата, длит, цвет, комент)
    @FindBy(how = How.CLASS_NAME, using = "Track_Value__15eEX")private List<SelenideElement> valuesOfTheOrder;
    // Локатор для плашки несуществования заказа
    @FindBy(how = How.CLASS_NAME, using ="Track_NotFound__6oaoY") private SelenideElement warningThatTrackNotOk;

    // Методы для взаимоддействия с локаторами
    public boolean checkName(String value){
        System.out.println(valuesOfTheOrder.size());
        return (valuesOfTheOrder.get(0).getText() == value);
    }
    public String returnNameFromTrack(){
        return (valuesOfTheOrder.get(0).getText());
    }
    public String returnSecondNameFromTrack(){
        return (valuesOfTheOrder.get(1).getText());
    }
    public String returnAdressFromTrack(){
        return (valuesOfTheOrder.get(2).getText());
    }
    public String returnMetroFromTrack(){
        return (valuesOfTheOrder.get(3).getText());
    }
    public String returnPhoneFromTrack(){
        return (valuesOfTheOrder.get(4).getText());
    }
    public String returnDeliveryDateFromTrack(){
        return (valuesOfTheOrder.get(5).getText());
    }
    public String returnDurationOfUsageFromTrack(){
        return (valuesOfTheOrder.get(6).getText());
    }
    public String returnColorFromTrack(){
        return (valuesOfTheOrder.get(7).getText());
    }
    public String returnCommentFromTrack(){
        return (valuesOfTheOrder.get(7).getText());
    }
    // Метод проверят есть ли плашка "нет заказа" возвращает true если плашка есть(=трека нет), и false если плашки нет(=заказ есть)
    public boolean isExist_warningThatTrackNotOk(){
        if(warningThatTrackNotOk.exists()){
            return true;
        }
        else {
            return false;
        }
    }
}
