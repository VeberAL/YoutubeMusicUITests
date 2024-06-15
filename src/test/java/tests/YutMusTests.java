package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ChartPage;
import pages.HomePage;

public class YutMusTests extends TestBase {
    HomePage homePage = new HomePage();
    ChartPage chartPage = new ChartPage();


    @Test
    @DisplayName("Проверка отображения карточки исполнителя.")
    @Tag("singer")
    void singerCardExistTest() {
        homePage.openPage()
                .searchButtonClick()
                .searchFieldWrite("Sting")
                .checkArtistCard("Sting");
    }

    @Test
    @DisplayName("Проверка отображения боковой панели с треками исполнителя.")
    @Tag("singer")
    void singerSideTrackPanelExistTest() {
        homePage.openPage()
                .searchButtonClick()
                .searchFieldWrite("Sting")
                .choiceArtistCard("Sting")
                .checkArtistSideBar();
    }

    @Test
    @DisplayName("Проверка наличия разделов в списке Рекомендуемых.")
    @Tag("chart")
    void chartTracksExistTest() {
        chartPage.openPage()
                .checkFirstTrack();
    }

    @Test
    @DisplayName("Проверка наличия кнопки Найстройки на странице Рекомендуемое.")
    @Tag("chart")
    void chartSettingsButtonExistTest() {
        chartPage.openPage()
                .checkSettingsButton();
    }

    @Test
    @DisplayName("Проверка наличия разделов в меню Настройки.")
    @Tag("chart")
    void chartSettingsMenuExistTest() {
        chartPage.openPage()
                .clickSettingsButton()
                .checkSettingsItem();
    }


}
