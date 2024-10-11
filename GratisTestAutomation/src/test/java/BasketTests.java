import Base.BaseTest;
import Pages.BasketPage;
import Pages.MainPage;
import Pages.ProductPage;
import org.testng.annotations.Test;

public class BasketTests extends BaseTest {

    MainPage mainPage=new MainPage();
    ProductPage product=new ProductPage();
    BasketPage basketPage=new BasketPage();

    @Test
    public void addProductToBasket() throws InterruptedException {

        mainPage.acceptCoocies()
                .categoryMakeUp();
        sleep(3000);
        product.liquidLipstick();
        sleep(3000);
        product.addToBasket();
        sleep(3000);
        String value=basketPage.count();
        assertEquals(value, "1");



    }
    @Test
    public void deleteProductFromBasket() throws InterruptedException {

        mainPage.acceptCoocies()
                .categoryMakeUp();
        sleep(5000);
        product.liquidLipstick();
        sleep(3000);
        product.addToBasket();
        sleep(5000);
        //product.closeTheChat();
        basketPage.clickBasketIcon()
                  .goToBasket();
        sleep(3000);
        basketPage.deleteTheProduct();
        sleep(2000);
        String value=basketPage.emptyBasketMessage();
        assertEquals(value,"Sepetin şu an boş\n" +
                "Gratis’in mükemmel ürünleri için hemen alışverişe devam et. İstersen favori ürünlerine bak ya da aşağıda senin için önerdiğimiz ürünleri incele!");

    }
}
