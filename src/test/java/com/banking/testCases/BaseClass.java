package com.banking.testCases;

import com.banking.testUtilities.ReadConfig;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class BaseClass {
    ReadConfig readconfig=new ReadConfig();
    public String baseUrl=readconfig.getApplicationURL();
    public String username=readconfig.getUsername();
    public String password=readconfig.getPassword();
    public WebDriver driver;
    public static Logger logger;
    @Parameters("browser")
    @BeforeClass
    public void setup(String br){
        //System.getProperty("user.id") will fetch your home directory location i.e C:\Users\Shakya\IdeaProjects\BankingWithSDET(Hybrid Framework)
        //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Driver//chromedriver.exe");

        logger= Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");
        if(br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        else if(br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", readconfig.firefoxPath());
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        else if(br.equals("ie")){
            System.setProperty("webdriver.ie.driver", readconfig.getiePath());
            driver = new InternetExplorerDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();

        }
        driver.get(baseUrl);
    }
    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
