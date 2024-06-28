package yandexmarket.pages;

import framework.base.BasePage;
import framework.utils.Product;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ProductYandexMarketPage extends BasePage {

    @FindBy(xpath = "//div[@data-zone-name=\"Filter\"]//h4")
    private List<WebElement> filters;

    @FindBy(xpath = "//h1")
    private WebElement title;

    @FindBy(xpath = "//button[@data-baobab-name=\"sort\"]")
    private List<WebElement> sorts;

    @FindBy(xpath = "//article[@data-auto=\"searchOrganic\"]")
    private List<WebElement> items;

    @FindBy(xpath = "//button[@data-auto=\"search-button\"]")
    private WebElement searchButton;

    @FindBy(xpath = "//h3")
    private List<WebElement> itemNames;


    private List<Product> products = new ArrayList<>();


    @Step("Проверка что открылась нужная страница")
    public ProductYandexMarketPage checkTitle(String expectedTitle) {
        Assert.assertEquals("Открылась не верная страница!", expectedTitle, title.getText());
        System.out.println("Страница " + expectedTitle + " открыта!");
        return pageManager.getProductYandexMarketPage();
    }

    @Step("Выбор фильтра '{filter}' : '{value}'")
    public ProductYandexMarketPage selectFilter(String expectedFilter, String expectedValue) {
        for (WebElement filter : filters) {
            if (filter.getText().equals(expectedFilter)) {
                System.out.println("Фильтр " + expectedFilter + " найден!");
                List<WebElement> values = filter.findElements(By.xpath("./../../..//div[contains(@data-baobab-name,\"filterValue\")]//span[@class=\"_1-LFf\"]"));
                for (WebElement value : values) {
                    if (value.getText().equals(expectedValue)) {
                        WebElement filterCheckbox = value.findElement(By.xpath("./../../..//label[contains(@role,\"checkbox\")]"));
                        buttonClick(filterCheckbox);
                        System.out.println("Значение " + expectedValue + " найдено!");
                        break;
                    }
                }
                return pageManager.getProductYandexMarketPage();
            }
        }
        Assert.fail("Фильтр " + expectedFilter + ": " + expectedValue + " не найден");
        return pageManager.getProductYandexMarketPage();
    }



    @Step("Вывод в консоль товаров и цен")
    public ProductYandexMarketPage printItems(int count) {
        for (int i = 0; i < count; i++) {
            WebElement item = items.get(i);
            String itemName = item.findElement(By.xpath(".//h3")).getText();
            String itemPrice = item.findElement(By.xpath(".//span[@data-auto=\"snippet-price-current\"]/span[@class=\"_1ArMm\"]")).getText();
            System.out.println("Товар " + (i + 1) + ": " + itemName + " " + itemPrice);
            products.add(new Product(itemName, itemPrice));
        }
        return pageManager.getProductYandexMarketPage();
    }

}
