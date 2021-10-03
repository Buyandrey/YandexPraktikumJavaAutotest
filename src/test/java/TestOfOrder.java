import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import ru.praktikum.yandex.CommonElementsOfPages;
import ru.praktikum.yandex.OrderPage;
import ru.praktikum.yandex.TrackPage;
import ru.praktikum.yandex.HomePage;


import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.*;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

public class TestOfOrder {

    //получение сегодняшнего числа в формате день + месяц в родительном падеже
    Date date = new Date();
    Calendar calendar = Calendar.getInstance();
    int day = date.getDate();
    String month = calendar.getDisplayName(Calendar.MONTH,
            Calendar.LONG_FORMAT, new Locale("ru"));

    private String urlScooter = "https://qa-scooter.praktikum-services.ru/";
    private String urlTrack = "https://qa-scooter.praktikum-services.ru/track?t=";
    //тестовый заказ формируется с такими данными:
    private String trackDate = day + " " + month;
    private String trackNumber = "126013";
    private String trackName = "Андрей";
    private String trackSecondName = "Буянов";
    private String trackAdress = "Погонный проезд, 14к2, 305";
    private String trackMetro = "Бульвар Рокоссовского";
    private String trackPhone = "89161917225";
    //private String trackDate = "3 октября";
    private String trackDuration = "Двое суток";
    private String trackColor = "серая безысходность";
    private String trackComment = "У меня красивый кот";

    private void Order(){
    //чтобы не дублирвоать код

    Selenide.page(OrderPage.class).setValue_nameInputField(trackName);
    Selenide.page(OrderPage.class).setValue_secondNameInputField(trackSecondName);
    Selenide.page(OrderPage.class).setValue_adressInputField(trackAdress);
    Selenide.page(OrderPage.class).setValue_metroInputField(trackMetro);
    Selenide.page(OrderPage.class).setValue_phoneInputField(trackPhone);
    Selenide.page(OrderPage.class).click_nextButton();
    Selenide.page(OrderPage.class).click_whenInputField();
    Selenide.page(OrderPage.class).click_calendarDayToday();
    Selenide.page(OrderPage.class).click_durationInputField();
    Selenide.page(OrderPage.class).click_durationInDays(3);
    Selenide.page(OrderPage.class).click_colorOfScooter("grey");
    Selenide.page(OrderPage.class).setValue_commentInputField(trackComment);
    Selenide.page(OrderPage.class).click_previousButton();
    Selenide.page(OrderPage.class).click_nextButton();
    Selenide.page(OrderPage.class).click_orderButton();
    Selenide.page(OrderPage.class).click_disagreeButton();
    Selenide.page(OrderPage.class).click_orderButton();
    Selenide.page(OrderPage.class).click_agreeButton();
    Selenide.page(OrderPage.class).click_checkStatusButton();
    assertEquals("Мы должны быть на странице с заказом" + trackNumber,Selenide.page(CommonElementsOfPages.class).getUrl(),urlTrack+trackNumber );

}

@Before // закрывать браузер после теста или нет.
    public void DontCloseTheBrowser(){
    if(true) Configuration.holdBrowserOpen = true;
    }

@Test //проверка возможности заказать нажав на кнопку заказать в шапке
    public void TestTopButtonOrder() {
        CommonElementsOfPages ceop = open(urlScooter, CommonElementsOfPages.class);
        OrderPage op = new OrderPage();
        ceop.click_orderTopButton();

        if(Selenide.page(CommonElementsOfPages.class).isVisible_cookieForm())
            Selenide.page(CommonElementsOfPages.class).click_cookieAcceptButton();

        Order();
    }
@Test //проверка возможности заказать нажав на кнопку заказать в середине домашней страницы
    public void TestMidButtonOrder(){
        HomePage hp = open(urlScooter, HomePage.class);
        OrderPage op = new OrderPage();

    if(Selenide.page(CommonElementsOfPages.class).isVisible_cookieForm())
        Selenide.page(CommonElementsOfPages.class).click_cookieAcceptButton();

    hp.scrollToTheOrderButton();
        hp.click_orderButton();

        Order();
}
@Test //проверка того что заказ с трекномером существует по ссылке
    public void TestCorrectOrder(){

    CommonElementsOfPages ceop = open(urlScooter, CommonElementsOfPages.class);

    if(Selenide.page(CommonElementsOfPages.class).isVisible_cookieForm())
        Selenide.page(CommonElementsOfPages.class).click_cookieAcceptButton();

    ceop.click_statusOfTheOrderButton();
    ceop.setValue_numberOfTheOrderInputField(trackNumber);
    ceop.click_goButton();
    assertEquals("Мы должны быть на странице с заказом" + trackNumber,ceop.getUrl(),urlTrack+trackNumber );
    System.out.println(ceop.getUrl());
}
@Test //проверка того что при переходе на несуществующий заказ будет уведомление о том что заказа не существует (коряво, т.к. не знаю какие номера заказов точно несуществующие и есть риск натунсться на существующий заказ)
    public void TestUnCorrectOrder(){


    if(Selenide.page(CommonElementsOfPages.class).isVisible_cookieForm())
        Selenide.page(CommonElementsOfPages.class).click_cookieAcceptButton();

    TrackPage tp = open(urlTrack + trackNumber+99489, TrackPage.class);
        MatcherAssert.assertThat("Несуществующий трек", true, is(tp.isExist_warningThatTrackNotOk()));

    }
@Test //проверка корректности заказа. то что введено при заказе = то что показывается в заказе
    public void CheckTheOrder() {

    TrackPage tp = open(urlTrack + trackNumber, TrackPage.class);


    if(Selenide.page(CommonElementsOfPages.class).isVisible_cookieForm())
        Selenide.page(CommonElementsOfPages.class).click_cookieAcceptButton();

    if (tp.isExist_warningThatTrackNotOk()) {
            MatcherAssert.assertThat("Имя", trackName, is(tp.returnNameFromTrack()));
            MatcherAssert.assertThat("Фамилия", trackSecondName, is(tp.returnSecondNameFromTrack()));
            MatcherAssert.assertThat("Адрес", trackAdress, is(tp.returnAdressFromTrack()));
            MatcherAssert.assertThat("Станция метро", trackMetro, is(tp.returnMetroFromTrack()));
            MatcherAssert.assertThat("Телефон", trackPhone, is(tp.returnPhoneFromTrack()));
            MatcherAssert.assertThat("Дата доставки", trackDate, is(tp.returnDeliveryDateFromTrack()));
            MatcherAssert.assertThat("Срок Аренды", trackDuration, is(tp.returnDurationOfUsageFromTrack()));
            MatcherAssert.assertThat("Цвет", trackColor, is(tp.returnColorFromTrack()));
            MatcherAssert.assertThat("Коментарий", trackComment, is(tp.returnCommentFromTrack()));
        }else{
            System.out.println();
            MatcherAssert.assertThat("Трэка нет!!!", 1, is(0)); //костыль
        }
    }
}
