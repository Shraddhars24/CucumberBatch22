package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.CommonMethods;

import java.io.IOException;
import java.time.Duration;

public class Hooks extends CommonMethods {
    @Before
    public void start() throws IOException {
        openBrowserAndLaunchApplication();
        //OR
        /*driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");*/




    }
    @After
    public void end() {
        closeBrowser();
        //OR
           // driver.quit();
    }

    }

