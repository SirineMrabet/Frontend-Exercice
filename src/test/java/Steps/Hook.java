package Steps;

import Base.BaseUtile;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;


/**
 * Created by smrabet on 29/11/2017.
 */

public class Hook extends BaseUtile {

    private BaseUtile base;

    public Hook(BaseUtile base) {
        this.base = base;
        this.driver = base.driver;
    }


    @Before
    public void InitializeTest(Scenario scenario) {
        System.out.println("Opening the browser Firefox");
        System.out.println("Scenario Name: "+scenario.getName());
        System.setProperty("webdriver.firefox.marionette", "D:\\libs\\geckodriver.exe");
        //base.driver = new HtmlUnitDriver(true);
        base.driver = new FirefoxDriver();
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }


    @After
    public void TearDownTest(Scenario scenario) {

         if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        System.out.println("Ending test");
        //base.driver.quit();

    }

    public BaseUtile getBase() {
        return base;
    }




}

