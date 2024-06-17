package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private final SelenideElement searchField = $("input.ytmusic-search-box"),
            artistSidebarWindow = $(".undercards-container"),
            carouselChart = $(".ytmusic-carousel"),
            artistCardButton = $(".metadata-container").$(".title"),
            shareButtonInArtistCard = $(".actions").$("[id=button-shape]"),
            shareButton = $(".header-overlay-transition"),
            shareWindow = $(".yt-third-party-network-section-renderer");
    private final ElementsCollection artistInfoWindow = $$(".card-content-container");

    @Step("Открытие главной страницы сайта и соглашение принять cookie (при появлении).")
    public HomePage openPage() {
        open("/");
        if ($(byText("Accept all")).exists()) {
            $(byText("Accept all")).click();
        }
        return this;
    }

    @Step("проверка существования на странице карусели рекомендуемых треков.")
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
    public HomePage searchFieldWrite(String artistName) {
        searchField.sendKeys(artistName);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    @Step("Выбор карточки исполнителя из появившегося списка.")
    public HomePage choiceArtistCard() {
        artistCardButton.click();
        return this;
    }

    @Step("Проверка отображения карточки исполнителя.")
    public HomePage checkArtistCard(String artistName) {
        artistInfoWindow.findBy(text("Sting")).shouldBe(exist);
        return this;
    }

    @Step("Нажатие на кнопку Поделиться в карточке исполнителя.")
    public HomePage clickShareButtonInArtisCard() {
        shareButtonInArtistCard.click();
        return this;
    }

    @Step("Нажатие на кнопку Поделиться в выпадающем списке.")
    public HomePage clickShareButton() {
        shareButton.click();
        return this;
    }

    @Step("Проверка отображения окна Поделиться.")
    public HomePage checkShareWindowInArtisCard() {
        shareWindow.shouldBe(exist);
        return this;
    }

    @Step("Проверка отображения боковой панели с треками исполнителя.")
    public HomePage checkArtistSideBar() {
        artistSidebarWindow.shouldBe(exist);
        return this;
    }
}
