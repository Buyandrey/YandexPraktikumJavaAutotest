import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import com.codeborne.selenide.Configuration;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import ru.praktikum.yandex.CommonElementsOfPages;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.praktikum.yandex.YandexPage;

import static org.junit.Assert.assertEquals;

public class TestCommonElementsOfPages {

    final private String urlScooter = "https://qa-scooter.praktikum-services.ru/";
    final private String urlScooterOrder = "https://qa-scooter.praktikum-services.ru/order";
    final private String urlScooterTrack = "https://qa-scooter.praktikum-services.ru/track?t=1";
    final private String urlYandex = "https://yandex.ru/";
    final private String titleScooterPage = "Яндекс Самокат";
    final private String titleYandexPage = "Яндекс";
    @Before // закрывать браузер после теста или нет.
    public void CloseTheBrowser() {
        if (!true) Configuration.holdBrowserOpen = true;
    }
    @Test // Проверка невидимости невидимых элементов и их видимости тогда они должны быть видимыми
    public void TestVisibilityOfElements() {

        CommonElementsOfPages ceop = open(urlScooter, CommonElementsOfPages.class);

        MatcherAssert.assertThat("При первом заходе плашка куки есть",ceop.isVisible_cookieForm(), is(true));
        ceop.click_cookieAcceptButton();
        MatcherAssert.assertThat("После нажатия на подтверждение куков плашка исчезает",ceop.isVisible_cookieForm(), is(false));
        MatcherAssert.assertThat("Кнопка Go! невидимая пока нет поля ввода",ceop.isVisible_goButton(), is(false));
        MatcherAssert.assertThat("Поле ввода невидимое пока не нажата кнопка Статуса",ceop.isVisible_numberOfTheOrderInputField(), is(false));
        ceop.click_statusOfTheOrderButton();
        MatcherAssert.assertThat("Кнопка Go! видимая только после нажатия на кнопку Статуса",ceop.isVisible_goButton(), is(true));
        MatcherAssert.assertThat("Поле ввода видимое только после нажатия на кнопку Статуса",ceop.isVisible_goButton(), is(true));

}
    @Test // Проверка перехода на домашнюю страницу скутера с /order, /track, /
    public void TestScooterButton() {

        // Проверка что при нажатии на лого скутера с домашней страницы скурета мы остаемся на странице скутера.
        CommonElementsOfPages ceop = open(urlScooter, CommonElementsOfPages.class);
        ceop.click_scooterLogo();
        assertEquals("Scooter-Home -> Scooter",ceop.getUrl(), urlScooter);
        // Проверка что при нажатии на лого скутера с страницы заказа скурета мы попадаем на домашнюю страницу скутера.
        open(urlScooterOrder);
        ceop.click_scooterLogo();
        assertEquals("Scooter-order -> Scooter",ceop.getUrl(), urlScooter);
        // Проверка что при нажатии на лого скутера с страницы трека заказа скурета мы попадаем на домашнюю страницу скутера.
        open(urlScooterTrack);
        ceop.click_scooterLogo();
        assertEquals("Scooter-track -> Scooter",ceop.getUrl(), urlScooter);
    }
    @Test // Проверка перехода на домашнюю страницу яндекс с /order, /track, /
    public void TestYandexButton(){

        YandexPage yandexPage = new YandexPage(titleYandexPage);
        //Проверка что при нажатии на лого яндекса с домашней страницы скутера мы попадаем на страницу яндекса
        CommonElementsOfPages ceop = open(urlScooter, CommonElementsOfPages.class);
        ceop.click_yandexLogo();
        yandexPage.goToThePage();
        String currentUrl=yandexPage.getUrl();
        yandexPage.outFromThePage();
        //Проверка что при нажатии на лого яндекса со страницы заказа скутера мы попадаем на страницу яндекса
        assertEquals("Scooter -> Yandex",currentUrl, urlYandex);
        open(urlScooterOrder);
        ceop.click_yandexLogo();
        yandexPage.goToThePage();
        currentUrl=yandexPage.getUrl();
        yandexPage.outFromThePage();
        assertEquals("Scooter-order -> Yandex",currentUrl, urlYandex);
        //Проверка что при нажатии на лого яндекса со страницы трека скутера мы попадаем на страницу яндекса
        open(urlScooterTrack);
        ceop.click_yandexLogo();
        yandexPage.goToThePage();
        currentUrl=yandexPage.getUrl();
        assertEquals("Scooter-track -> Yandex",currentUrl, urlYandex);
        yandexPage.outFromThePage();
    }
    @Test // Проверка названия заголовка Яндекс Самокат
    public void TestTitle(){

        CommonElementsOfPages ceop = open(urlScooter, CommonElementsOfPages.class);
        assertEquals("Заголовок должен быть Яндекс Самокат",titleScooterPage,ceop.getTitleOfThePageText());
    }
}
