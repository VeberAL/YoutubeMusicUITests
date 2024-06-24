package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class ArtistPage {
    private final SelenideElement shareButtonInArtistCard = $(".actions").$("[id=button-shape]"),
            shareButton = $(".header-overlay-transition"),
            shareWindow = $(".yt-third-party-network-section-renderer");

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
}
