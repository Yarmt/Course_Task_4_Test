package framework.managers;

import lambda.pages.MainLambdaPage;
import mospolytech.pages.DmamiPage;
import mospolytech.pages.MainPolytechPage;
import mospolytech.pages.SchedulePolytechPage;
import yandexmarket.pages.CategoryYandexMarketPage;
import yandexmarket.pages.MainYandexMarketPage;
import yandexmarket.pages.ProductYandexMarketPage;

public class PageManager {

    private static PageManager INSTANCE;

    private MainLambdaPage mainLambdaPage;

    private MainPolytechPage mainPolytechPage;

    private SchedulePolytechPage schedulePolytechPage;

    private DmamiPage dmamiPage;

    private MainYandexMarketPage mainYandexMarketPage;

    private CategoryYandexMarketPage categoryYandexMarketPage;

    private ProductYandexMarketPage productYandexMarketPage;


    private PageManager(){
    }

    public static PageManager getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

    public MainLambdaPage getMainLambdaPage(){
        if (mainLambdaPage == null){
            mainLambdaPage = new MainLambdaPage();
        }
        return mainLambdaPage;
    }

    public MainPolytechPage getMainPolytechPage(){
        if (mainPolytechPage == null){
            mainPolytechPage = new MainPolytechPage();
        }
        return mainPolytechPage;
    }

    public SchedulePolytechPage getSchedulePolytechPage(){
        if (schedulePolytechPage == null){
            schedulePolytechPage = new SchedulePolytechPage();
        }
        return schedulePolytechPage;
    }

    public DmamiPage getDmamiPage(){
        if (dmamiPage == null){
            dmamiPage = new DmamiPage();
        }
        return dmamiPage;
    }

    public MainYandexMarketPage getMainYandexMarketPage(){
        if (mainYandexMarketPage == null){
            mainYandexMarketPage = new MainYandexMarketPage();
        }
        return mainYandexMarketPage;
    }

    public CategoryYandexMarketPage getCategoryYandexMarketPage(){
        if (categoryYandexMarketPage == null){
            categoryYandexMarketPage = new CategoryYandexMarketPage();
        }
        return categoryYandexMarketPage;
    }

    public ProductYandexMarketPage getProductYandexMarketPage(){
        if (productYandexMarketPage == null){
            productYandexMarketPage = new ProductYandexMarketPage();
        }
        return productYandexMarketPage;
    }

}
