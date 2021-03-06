import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class LaunchBrowser {
    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        //Connect to the browser
        System.setProperty("webdriver.chrome.whitelistedIps", "");
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Open website
        driver.navigate().to("https://Amazon.in");
        driver.manage().window().maximize();
        String title = driver.getTitle();

        //Validate the title
        if (title.equalsIgnoreCase("Amazon.in")){
            System.out.println("Title matches");
        }else{
            System.out.println(title);
        }

        //Select the site component using css selector
        String tagname = "";
        tagname = driver.findElement(By.cssSelector("#searchDropdownBox")).getText();
        System.out.println(tagname);

        WebElement category = driver.findElement(By.cssSelector("#searchDropdownBox"));
        category.click();

    }
}
