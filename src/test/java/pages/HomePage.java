package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {
    private final SelenideElement searchField = $("input.ytmusic-search-box"),
            carouselChart = $(".ytmusic-carousel");

    @Step("Открытие главной страницы сайта и соглашение принять cookie (при появлении).")
    public HomePage openPage() {
        open("/");
        if ($(byText("Accept all")).exists()) {
            $(byText("Accept all")).click();
        }
        return this;
    }

    @Step("Проверка существования на странице карусели рекомендуемых треков.")
    public HomePage checkChartCarousel() {
        carouselChart.shouldBe(exist);
        return this;
    }

    @Step("Нажатие на кнопку поиска.")
    public HomePage searchButtonClick() {
        searchField.click();
        return this;
    }

    @Step("Ввод информации в окно поиска.")
    public HomePage enterTextInTheSearchField(String artistName) {
        searchField.sendKeys(artistName);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

}
