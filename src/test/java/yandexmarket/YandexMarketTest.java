package yandexmarket;

import org.junit.Test;
import yandexmarket.base.BaseTests;

public class YandexMarketTest extends BaseTests {

    @Test
    public void yandexMarketTest(){
        pageManager.getMainYandexMarketPage()
                //.checkPageUploaded()
                .catalogButtonClick()
                .selectCategoryType("Ноутбуки и компьютеры")
                //.checkCategoryType("Ноутбуки и планшеты")
                .selectCategory("Ноутбуки")
                .printItems(5)
                .selectFilter("Состояние товара", "Уценка");
                //.searchProduct(10);
    }
}
