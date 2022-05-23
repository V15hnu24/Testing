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

        System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.navigate().to("https://amazon.in");
        driver.manage().window().maximize();
        String title = driver.getTitle();

        if (title.equalsIgnoreCase("Amazon.in")){
            System.out.println("Title matches");
        }else{
            System.out.println(title);
        }

        String tagname = "";
        tagname = driver.findElement(By.cssSelector("#nav-link-shopall > span.na-line-2")).getText();
        System.out.println(tagname);

        WebElement category = driver.findElement(By.cssSelector("#nav-link-shopall > span.nav-line2 > span"));
        Actions action = new Actions(driver);
        action.moveToElement(category).perform();
        Thread.sleep(2000);

        WebElement books = driver.findElement(By.cssSelector("#nac-flyout-shopAll > div.nav-"))

    }
}
