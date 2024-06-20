package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ArtistPage {
    private final SelenideElement searchField = $("input.ytmusic-search-box"),
            artistSidebarWindow = $(".undercards-container"),
            artistCardButton = $(".metadata-container").$(".title"),
            shareButtonInArtistCard = $(".actions").$("[id=button-shape]"),
            shareButton = $(".header-overlay-transition"),
            shareWindow = $(".yt-third-party-network-section-renderer");
    private final ElementsCollection artistInfoWindow = $$(".card-content-container");


    @Step("Выбор карточки исполнителя из появившегося списка.")
    public ArtistPage selectArtistCard() {
        artistCardButton.click();
        return this;
    }

    @Step("Проверка отображения карточки исполнителя.")
    public ArtistPage checkArtistCard(String artistName) {
        artistInfoWindow.findBy(text(artistName)).shouldBe(exist);
        return this;
    }

    @Step("Нажатие на кнопку Поделиться в карточке исполнителя.")
    public ArtistPage clickShareButtonInArtisCard() {
        shareButtonInArtistCard.click();
        return this;
    }

    @Step("Нажатие на кнопку Поделиться в выпадающем списке.")
    public ArtistPage clickShareButton() {
        shareButton.click();
        return this;
    }

    @Step("Проверка отображения окна Поделиться.")
    public ArtistPage checkShareWindowInArtisCard() {
        shareWindow.shouldBe(exist);
        return this;
    }

    @Step("Проверка отображения боковой панели с треками исполнителя.")
    public ArtistPage checkArtistSideBar() {
        artistSidebarWindow.shouldBe(exist);
        return this;
    }
}
