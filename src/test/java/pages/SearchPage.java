package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchPage {
    private final SelenideElement artistSidebarWindow = $(".undercards-container"),
            artistCardButton = $(".metadata-container").$(".title");
    private final ElementsCollection artistInfoWindow = $$(".card-content-container");


    @Step("Выбор карточки исполнителя из появившегося списка.")
    public SearchPage selectArtistCard() {
        artistCardButton.click();
        return this;
    }

    @Step("Проверка отображения карточки исполнителя.")
    public SearchPage checkArtistCard(String artistName) {
        artistInfoWindow.findBy(text(artistName)).shouldBe(exist);
        return this;
    }

    @Step("Проверка отображения боковой панели с треками исполнителя.")
    public SearchPage checkArtistSideBar() {
        artistSidebarWindow.shouldBe(exist);
        return this;
    }
}
