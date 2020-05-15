import Drivers.DriverManager;
import Drivers.DriverManagerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CriarMovimentacao;
import pages.Home;
import pages.Login;

public class FactoryPatternTest {

    DriverManager driverManager;
    WebDriver driver;
    WebDriverWait wait;
    int TIME_OUT = 40;

    @BeforeTest
    public void beforeTest(){
        driverManager = DriverManagerFactory.getManager (DriverManagerFactory.DriverType.CHROME);
    }

    @BeforeMethod
    public void beforeMethod(){
          //System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\chromedriver.exe");

        driver = driverManager.getDriver();
          //driverManager.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
          //wait = new WebDriverWait(driverManager, TIME_OUT);
    }

    @AfterMethod
        public void tearDown (){
        driverManager.quitDriver();
    }

    @Test
    public void testPageFactory(){

        driver.get("http://seubarriga.wcaquino.me/login");
        Login page = PageFactory.initElements(driver, Login.class);
        page.RealizarLogin();
        Home homeNav = PageFactory.initElements(driver, Home.class);
        homeNav.home();
        CriarMovimentacao criarMov = PageFactory.initElements(driver, CriarMovimentacao.class);
        criarMov.CriarMovimentacao();


    }



}
