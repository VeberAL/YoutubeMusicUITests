package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.collections.SizeGreaterThan;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ChartPage {
    private final SelenideElement settingsButton = $("#menu-button");
    private final ElementsCollection chartTracksList = $$("#items"),
            settingsContainer = $$(".ytmusic-popup-container");

    @Step("Открытие страницы Рекомендуемое и соглашение принять cookie (при появлении).")
    public ChartPage openPage() {
        open("/moods_and_genres");
        if ($(byText("Accept all")).exists()) {
            $(byText("Accept all")).click();
        }
        return this;
    }

    @Step("Проверка наличия треков на странице Рекомендуемое.")
    public ChartPage checkFirstTrack() {
        chartTracksList.first().shouldBe(exist);
        return this;
    }

    @Step("Нажатие кнопки Поделиться в окне чарта.")
    public ChartPage clickSettingsButton() {
        settingsButton.click();
        return this;
    }

    @Step("Проверка наличия кнопки Найстройки на странице Рекомендуемое.")
    public ChartPage checkSettingsButton() {
        settingsButton.shouldBe(exist);
        return this;
    }

    @Step("Проверка наличия пунктов меню при нажатии кнопки Настройки.")
    public ChartPage checkSettingsItem() {
        settingsContainer.shouldHave(new SizeGreaterThan(0));
        return this;
    }
}
