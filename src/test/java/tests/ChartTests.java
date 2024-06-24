package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.ChartPage;
import pages.HomePage;

@Tag("chart")
public class ChartTests extends TestBase {
    HomePage homePage = new HomePage();
    ChartPage chartPage = new ChartPage();


    @Test
    @Feature("Тестирование отображения сборника карусели популярных треков на главной странице.")
    @DisplayName("Проверка отображения карусели рекомендуемых треков.")
    @Owner("Veber")
    @Severity(SeverityLevel.BLOCKER)
    void chartCarouselExistTest() {
        homePage.openPage()
                .checkChartCarousel();
    }

    @Test
    @Feature("Тестирование отображения разделов в списке на странице Рекомендуемое.")
    @DisplayName("Проверка наличия разделов в списке Рекомендуемых.")
    @Owner("Veber")
    @Severity(SeverityLevel.BLOCKER)
    void chartTracksExistTest() {
        chartPage.openPage()
                .checkFirstTrack();
    }

    @Test
    @Feature("Тестирование отображения кнопки Настройки на странице Рекомендуемое.")
    @DisplayName("Проверка наличия кнопки Настройки на странице Рекомендуемое.")
    @Owner("Veber")
    @Severity(SeverityLevel.CRITICAL)
    void chartSettingsButtonExistTest() {
        chartPage.openPage()
                .checkSettingsButton();
    }

    @Test
    @Feature("Тестирование отображения разделов в меню Настройки на странице Рекомендуемое.")
    @DisplayName("Проверка наличия разделов в меню Настройки.")
    @Owner("Veber")
    @Severity(SeverityLevel.CRITICAL)
    void chartSettingsMenuExistTest() {
        chartPage.openPage()
                .clickSettingsButton()
                .checkSettingsItem();
    }


}
