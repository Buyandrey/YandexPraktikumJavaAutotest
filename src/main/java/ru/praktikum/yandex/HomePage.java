package ru.praktikum.yandex;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.JavascriptExecutor;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;

public class HomePage {

    @FindBy(how = How.XPATH, using = "//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']")
    private SelenideElement orderButton;
    @FindBy(how = How.XPATH, using = "//div/div/div[@class='accordion__item']")
    private List<SelenideElement> getQuestionButtons;

    public void click_orderButton() {
        orderButton.click();
    }

    //скролл до кнопки Заказать
    public void scrollToTheOrderButton() {
        orderButton.scrollTo();
    }
    public void clickQuestion(int index ){
        getQuestionButtons.get(index).scrollTo().click();
    }
    public String getQuestion(int index) {
        return getQuestionButtons.get(index).findElement(byAttribute("role", "heading")).getText();
    }

    public String getAnswer(int index) {
        return getQuestionButtons.get(index).findElement(byAttribute("role", "region")).getText();
    }
}
