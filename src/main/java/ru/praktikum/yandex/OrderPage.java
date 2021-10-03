package ru.praktikum.yandex;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selectors.*;

public class OrderPage {
    // Локаторы полей ввода имени, фамилии, адреса, метро, кнопки метро Бульвар Рокоссовского, поля ввода телефона и кнопки далее
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder='* Имя']")private SelenideElement nameInputField;
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder='* Фамилия']")private SelenideElement secondNameInputField;
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder='* Адрес: куда привезти заказ']")private SelenideElement adressInputField;
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder='* Станция метро']")private SelenideElement metroInputField;
    @FindBy(how = How.XPATH, using="//li/button[@value='1']")private SelenideElement bulvarRok;
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder='* Телефон: на него позвонит курьер']")private SelenideElement phoneInputField;
    @FindBy(how = How.XPATH, using = "//div/button[text()='Далее']")private SelenideElement nextButton;

    // Локаторы поля ввода даты, текущей даты из календаря, поля ввода длительности
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder='* Когда привезти самокат']")private SelenideElement whenInputField;
    @FindBy(how = How.CSS, using = "html body div#root div.App_App__15LM-" + " div.Order_Content__bmtHS" + " div.Order_Form__17u6u div.Order_MixedDatePicker__3qiay" + " div.react-datepicker__tab-loop" + " div.react-datepicker-popper" + " div div.react-datepicker")private SelenideElement calendar;
    @FindBy(how = How.XPATH, using = "//div/div[@class='Dropdown-placeholder']")private SelenideElement durationInputField;

    // Локаторы на варианты длительности
    @FindBy(how = How.XPATH, using = "//div/div[@class='Dropdown-option']")private List<SelenideElement> durationInDays;
    // Локаторы на варианты цвета
    @FindBy(how = How.CLASS_NAME, using = "Checkbox_Input__14A2w")private List<SelenideElement> colorsOfScooter;
    // Локатор поля ввода комментария
    @FindBy(how = How.XPATH, using = "//div/input[@placeholder='Комментарий для курьера']")private SelenideElement commentInputField;
    // Локатор кнопок Назад, Заказать(внизу), подтвердить заказ, отменить, проверки статуса
    @FindBy(how = How.XPATH, using = "//div/button[text()='Назад']")private SelenideElement previousButton;
    @FindBy(how = How.XPATH, using = "//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']")private SelenideElement orderButton;
    @FindBy(how = How.XPATH, using = "//div/button[text()='Да']")private SelenideElement agreeButton;
    @FindBy(how = How.XPATH, using = "//div/button[text()='Нет']")private SelenideElement disagreeButton;
    @FindBy(how = How.XPATH, using = "//div/button[text()='Посмотреть статус']")private SelenideElement checkStatusButton;

    // Методы заполнения и кликов для локаторов
    public void setValue_nameInputField(String value){
        nameInputField.setValue(value);
    }
    public void setValue_secondNameInputField(String value){
        secondNameInputField.setValue(value);
    }
    public void setValue_adressInputField(String value){
        adressInputField.setValue(value);
    }
    public void setValue_metroInputField(String value){
        metroInputField.setValue(value);
        bulvarRok.click();
    }
    public void setValue_commentInputField(String value){
        commentInputField.setValue(value);
    }
    public void setValue_phoneInputField(String value){
        phoneInputField.setValue(value);
    }
    public void click_whenInputField(){
        whenInputField.click();
    }
    public void click_nextButton(){
        nextButton.click();
    }
    public void click_durationInputField(){
        durationInputField.click();
    }
    public void click_calendarDayToday(){
        calendar.findElement(byClassName("react-datepicker__day--today")).click();
    }
    public void click_durationInDays(int howManyDaysFrom1to7){
        durationInDays.get(howManyDaysFrom1to7-1).click();
    }
    public void click_colorOfScooter(String type_blackORgrey){

        if(type_blackORgrey == "black"){
            colorsOfScooter.get(0).click();
        }else if (type_blackORgrey == "grey"){
            colorsOfScooter.get(1).click();
        }
        else {
            System.out.println("https://youtu.be/iik25wqIuFo");
            colorsOfScooter.get(1).click();
        }
    }
    public void click_previousButton(){
        previousButton.click();
    }
    public void click_orderButton(){
        orderButton.click();
    }
    public void click_agreeButton(){
        agreeButton.click();
    }
    public void click_disagreeButton(){
        disagreeButton.click();
    }
    public void click_checkStatusButton(){
        checkStatusButton.click();
    }
}
