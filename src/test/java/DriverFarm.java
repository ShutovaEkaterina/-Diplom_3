import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFarm extends ExternalResource {
    private WebDriver driver;

    @Override
    protected void before() throws Throwable {
        initDriver();
    }

    @Override
    protected void after() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void initDriver() {
        if ("yandex".equals(System.getProperty("browser"))) {
            initYandex();
        } else {
            initChrome();
        }
    }

    private void initYandex() {
        WebDriverManager.chromedriver().driverVersion("120.0.6099.109").setup();
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/Applications/Yandex.app"); // Укажите путь к исполняемому файлу Yandex браузера
        driver = new ChromeDriver(options);
    }

    private void initChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
