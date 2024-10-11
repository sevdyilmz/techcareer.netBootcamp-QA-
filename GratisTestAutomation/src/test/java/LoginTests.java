import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    LoginPage login = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test
    public void LoginSuccessful() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(2000);
        login.fillMail(mail)
                .fillPassword(password)
                .clickLoginButton();

        sleep(3000);
        String value = login.getAccountName();
        assertEquals(value, "Java İntellij\n"+
                "Hesabım");

    }

    @Test
    public void requiredMailPasswordControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);
        login.clickLoginButton();
        sleep(3000);
        String value = login.errorMessage();
        assertEquals(value, "Bu alan zorunludur");

    }

    @Test
    public void requiredMailControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);
        login.fillPassword(password)
                .clickLoginButton();
        sleep(3000);
        String value = login.errorMessage();
        assertEquals(value, "Bu alan zorunludur");

    }
    @Test
    public void requiredPasswordControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);
        login.fillMail(mail)
                .clickLoginButton();
        sleep(3000);
        String value = login.errorMessagePassword();
        assertEquals(value, "Bu alan zorunludur");

    }
    @Test
    public void invalidMailControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);

        login.fillMail("aaaa")
                .fillPassword(password)
                .clickLoginButton();
        sleep(3000);
        String value = login.errorMessage1();
        assertEquals(value, "Bu geçerli bir e-posta formatı değil");

    }

    @Test
    public void invalidPasswordControl() throws InterruptedException {

        mainPage.acceptCoocies();
        login.signIn()
                .signIn2();
        sleep(3000);
        login.fillMail(mail)
                .fillPassword("987654Sev")
                .clickLoginButton();
        sleep(3000);
        String value = login.informationText();
        assertEquals(value, "Yanlış şifre veya email/cep telefonu.\n" +
                "Lütfen Tekrar Deneyin");

    }
}
