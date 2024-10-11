import Base.BaseTest;
import Pages.BasketPage;
import Pages.MainPage;
import Pages.ProductPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Feature("Alışveriş Sepeti Test Senaryoları")
public class BasketTests extends BaseTest {

    MainPage mainPage=new MainPage();
    ProductPage product=new ProductPage();
    BasketPage basketPage=new BasketPage();

    @Test (description="Sepete başarılı bir şekilde ürün ekleme")
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
    @Test (description = "Sepetten başarılı bir sekilde ürün silme")
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
        sleep(3000);
        String value=basketPage.emptyBasketMessage();
        assertEquals(value,"Sepetin şu an boş\n" +
                "Gratis’in mükemmel ürünleri için hemen alışverişe devam et. İstersen favori ürünlerine bak ya da aşağıda senin için önerdiğimiz ürünleri incele!");

    }
}
