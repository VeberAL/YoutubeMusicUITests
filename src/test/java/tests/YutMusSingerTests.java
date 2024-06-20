package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.ArtistPage;
import pages.HomePage;
import utils.RandomUtils;


@Tag("singer")
public class YutMusSingerTests extends TestBase {
    HomePage homePage = new HomePage();
    ArtistPage artistPage = new ArtistPage();
    RandomUtils randomUtils = new RandomUtils();
    String singerName = randomUtils.getSingerName();

    @Test
    @Feature("Тестирование появления карточки исполнителя после его поиска.")
    @DisplayName("Проверка отображения карточки исполнителя.")
    @Owner("Veber")
    @Severity(SeverityLevel.CRITICAL)
    void singerCardExistTest() {
        homePage.openPage()
                .searchButtonClick()
                .enterTextInTheSearchField(singerName);
        artistPage.checkArtistCard(singerName);
    }


    @Feature("Тестирование появления боковой панели в карточке исполнителя после его поиска.")
    @DisplayName("Проверка отображения боковой панели с треками исполнителя.")
    @Owner("Veber")
    @Severity(SeverityLevel.BLOCKER)
    @ParameterizedTest(name = "Singer cards.")
    @ValueSource(strings = {"Sting", "Linkin Park", "Eminem"})
    void singerSideTrackPanelExistTest(String singer) {
        homePage.openPage()
                .searchButtonClick()
                .enterTextInTheSearchField(singer);
        artistPage.selectArtistCard()
                .checkArtistSideBar();
    }

    @Test
    @Feature("Тестирование нажатия кнопки Поделиться треками исполнителя после его поиска и перехода в карточку.")
    @DisplayName("Проверка функционирования кнопки Поделиться в карточке исполнителя.")
    @Owner("Veber")
    @Severity(SeverityLevel.NORMAL)
    void singerCardShareButtonTest() {
        homePage.openPage()
                .searchButtonClick()
                .enterTextInTheSearchField(singerName);
        artistPage.selectArtistCard()
                .clickShareButtonInArtisCard()
                .clickShareButton()
                .checkShareWindowInArtisCard();
    }

}
