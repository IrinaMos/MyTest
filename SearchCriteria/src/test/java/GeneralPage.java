import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import jdk.internal.org.xml.sax.SAXException;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

//import org.apache.commons.io.FileUtils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


//--------The class contains the tests of pages, reports and webdriver definition --------------
public class GeneralPage {
    private static WebDriver driver;
    @Rule
    public TestName name = new TestName();

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;

    @BeforeClass
    public static WebDriver beforeMyClass() throws org.xml.sax.SAXException, ParserConfigurationException, SAXException, IOException {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C://Users//irina//Desktop//report//extent1.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Project", "Buyme site");

        // add custom system info
        extent.setSystemInfo("Environment", "Test");
        extent.setSystemInfo("Tester", "Irina");

        // log results
        test.log(Status.INFO, "@Before class");
//------Browser definition --IE, Chrome, FF--------------------------
        String browser = new String();
        browser = getData("browser");
        switch (browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\irina\\Downloads\\chromedriver_win32\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            case "IE":
                System.setProperty("webdriver.ie.driver", "C:\\Users\\irina\\Downloads\\IEDriverServer.exe");
                driver = new InternetExplorerDriver();
                driver.manage().window().maximize();
                return driver;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\irina\\Downloads\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
        }
        return null;
    }

    public static String getData1 (String keyName) { //using in xml file which contains url data
        File configXmlFile = new File("C:\\Users\\irina\\Desktop\\miIrina\\Config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = null;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        org.w3c.dom.Document doc = null;
        try {
            assert dBuilder != null;
            doc = dBuilder.parse(configXmlFile);
        } catch (org.xml.sax.SAXException | IOException e) {
            e.printStackTrace();
        }
        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }
    //---------//using in xml file which contains browsers---------------------------------------------
    public static String getData (String tagName) throws ParserConfigurationException, IOException, SAXException, org.xml.sax.SAXException {
        // File xmlFile = new File("C:\\Users\\Irina Moskovich\\Desktop\\miIrina\\browser.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        //   DocumentBuilder dBuilder = factory.newDocumentBuilder();;
        //  dBuilder = factory.newDocumentBuilder();
        org.w3c.dom.Document doc = builder.parse(new File("C:\\Users\\irina\\Desktop\\miIrina\\browser.xml"));

        if (doc != null) {
            doc.getDocumentElement().normalize();
        }
        assert doc != null;
        return doc.getElementsByTagName(tagName).item(0).getTextContent();

    }

    @Test  //openURL
    public void afirstMethod () throws org.xml.sax.SAXException, ParserConfigurationException, SAXException, IOException {
        boolean pageOpened = false;
        try {
            GeneralPage.beforeMyClass().navigate().to(GeneralPage.getData1("URL"));
            pageOpened = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Open url was not found " + e.getMessage());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "Open url " + "Webpage opened successfully");
                //              test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//report//extent.png")).build());
            }
        }
    }

    @Test  //googlePage
    public void bsecondMethod () throws  ParserConfigurationException, SAXException, IOException{
        boolean pageOpened = false;
        try {
            GooglePage.clickSearch(driver);
            GooglePage.verifySearch(driver);
            pageOpened = true;

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "SearchPage page was not found " + e.getMessage());
            //           test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//report//extent01.html")).build());
            pageOpened = false;
        } finally {
            if (pageOpened) {
                test.log(Status.PASS, "SearchPage" + "The page is opened successfully");
                //              test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C://Users//irina//Desktop//report//extent1.html")).build());

            }
        }
    }




    @AfterClass
    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        driver.quit();
        // build and flush report
        extent.flush();
    }
    //   private static String takeScreenShot(String ImagesPath) {
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    //       File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destinationFile = new File(ImagesPath + ".png");
    //      try {
//            FileUtils.copyFile(screenShotFile, destinationFile);
    //      } catch (IOException e) {
    //        System.out.println(e.getMessage());
    //  }
    //return ImagesPath+".png";
    //}

//}
}