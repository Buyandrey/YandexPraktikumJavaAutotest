import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import ru.praktikum.yandex.CommonElementsOfPages;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

public class TestCommonElementsOfPages {
    private WebDriver driver;
    final String url = "https://qa-scooter.praktikum-services.ru/";
    final String urlYandex = "https://yandex.ru/";
public void cout(String value){
    System.out.println('\n'+ value+'\n');
}

    @Test
    public void TestVisibilityOfElements() {
        //Configuration.holdBrowserOpen = true;
        CommonElementsOfPages ceop = open(url, CommonElementsOfPages.class);

        MatcherAssert.assertThat("At first time cookie form exist",ceop.isVisible_cookieForm(), is(true));
        ceop.click_cookieAcceptButton();
        MatcherAssert.assertThat("After accept cookie form is gone",ceop.isVisible_cookieForm(), is(false));
        MatcherAssert.assertThat("GO! button must be invisible",ceop.isVisible_goButton(), is(false));
        MatcherAssert.assertThat("Input field must be invisible",ceop.isVisible_numberOfTheOrderInputField(), is(false));
        ceop.click_statusOfTheOrderButton();
        MatcherAssert.assertThat("GO! button must be visible",ceop.isVisible_goButton(), is(true));
        MatcherAssert.assertThat("Input field must be visible",ceop.isVisible_goButton(), is(true));

}
    @Test
    public void TestLogoButtons() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(url);

        String url_before= driver.getCurrentUrl();

        driver.findElement(By.className("Header_LogoScooter__3lsAR")).click();
        String url_after=driver.getCurrentUrl();
        MatcherAssert.assertThat("scooter -> scooter", url_before,is(url_after));

        //тут баг. открывается не страница яндекса, а новая владка яндекса. поэтому тест стреляет
        driver.findElement(By.className("Header_LogoYandex__3TSOI")).click();
        url_after=driver.getCurrentUrl();
        MatcherAssert.assertThat("scooter -> yandex", url_before,is(urlYandex));
    }
}
