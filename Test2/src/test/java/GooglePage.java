import org.json.JSONException;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static org.junit.Assert.assertEquals;


public class GooglePage extends Constants {
    protected WebDriver driver;

    public GooglePage() throws JSONException, IOException {
    }

    //-------clickSearch function---------------------------------------------------
    public static void clickSearch(WebDriver driver) throws InterruptedException {
        driver.findElement(Constants.INPUT).click();
        driver.findElement(Constants.INPUT).sendKeys("32.106497 34.811881");
              driver.findElement(Constants.INPUT).getAttribute(Constants.val1);
        //       driver.findElement(Constants.INPUT).getAttribute(Constants.val2);
        driver.findElement(Constants.ICON).click();
        Thread.sleep(5000);
        //driver.findElement(Constants.ICON).sendKeys(Keys.ENTER);
    }


    //-----------VerifyLoadText after search------------
    public static void verifySearch(WebDriver driver) {
        System.out.println(driver.findElement(Constants.GooglePage).getText());
        assertEquals(Constants.expectedText, driver.findElement(Constants.GooglePage).getText());    }
}
