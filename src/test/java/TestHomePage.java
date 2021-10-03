import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.yandex.CommonElementsOfPages;
import ru.praktikum.yandex.HomePage;
import ru.praktikum.yandex.OrderPage;
import java.util.*;

import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.is;

public class TestHomePage {
    private String urlScooter = "https://qa-scooter.praktikum-services.ru/";

    private String q1 = "Сколько это стоит? И как оплатить?", a1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private String q2 = "Хочу сразу несколько самокатов! Так можно?", a2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private String q3 = "Как рассчитывается время аренды?", a3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private String q4 = "Можно ли заказать самокат прямо на сегодня?", a4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private String q5 = "Можно ли продлить заказ или вернуть самокат раньше?", a5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private String q6 = "Вы привозите зарядку вместе с самокатом?", a6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private String q7 = "Можно ли отменить заказ?", a7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private String q8 = "Я живу за МКАДом, привезёте?", a8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    String[] q = {q1, q2, q3, q4, q5, q6, q7, q8};
    String[] a = {a1, a2, a3, a4, a5, a6, a7, a8};


    @Before // закрывать браузер после теста или нет.
    public void CloseTheBrowser() {
        if (!true) Configuration.holdBrowserOpen = true;
    }

    @Test // проклик всех вопросв и убеждаемся что ответы появляются
    public void TestAnswers() {
        HomePage hp = open(urlScooter, HomePage.class);
        if(Selenide.page(CommonElementsOfPages.class).isVisible_cookieForm())
            Selenide.page(CommonElementsOfPages.class).click_cookieAcceptButton();

        for (int j = 0; j < q.length; j++) {
            hp.clickQuestion(j);
            MatcherAssert.assertThat("Ответ на вопрос номер "+ j +" ",hp.getAnswer(j) ,is(a[j]));
        }
    }
    @Test // проклик всех вопросв и убеждаемся что ответы появляются
    public void TestQuestions() {

        HomePage hp = open(urlScooter, HomePage.class);
        if(Selenide.page(CommonElementsOfPages.class).isVisible_cookieForm())
            Selenide.page(CommonElementsOfPages.class).click_cookieAcceptButton();

        for (int j = 0; j < q.length; j++) {
            MatcherAssert.assertThat("Вопрос номер "+ j +" ",hp.getQuestion(j) ,is(q[j]));
        }
    }

}
