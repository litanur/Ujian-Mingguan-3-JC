package id.litanur;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.get("https://shop.demoqa.com/my-account");
        System.out.println("Login to Shop Demo QA");
        driver.getTitle();

        driver.findElement(By.id("username")).sendKeys("baner");
        driver.findElement(By.id("password")).sendKeys("@juaracoding123(");
        driver.findElement(By.name("login")).click();
        System.out.println("Button login clicked");

        driver.get("https://shop.demoqa.com/shop");
        System.out.println("Enter to product page");
        driver.findElement(By.xpath("//a[normalize-space()='Black Cross Back Maxi Dress']")).click();

        WebElement color = driver.findElement(By.xpath("//select[@id='pa_color']"));
        Select selectColor = new Select(color);

        List<WebElement> listColor = selectColor.getOptions();

        System.out.println("The dropdown color options are: ");
        for(WebElement options: listColor) System.out.println(options.getText());

        selectColor.selectByVisibleText("Beige");
        System.out.println("Select color value is: " + selectColor.getFirstSelectedOption().getText());
        delay(3);

        WebElement size = driver.findElement(By.xpath("//select[@id='pa_size']"));
        Select selectSize = new Select(size);

        List<WebElement> listSize = selectSize.getOptions();

        System.out.println("The dropdown size options are: ");
        for(WebElement options: listSize) System.out.println(options.getText());

        selectSize.selectByVisibleText("Large");
        System.out.println("Select size value is: " + selectSize.getFirstSelectedOption().getText());
        delay(3);

        driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("Add product to cart");
        delay(10);

        driver.findElement(By.xpath("//a[normalize-space()='View cart']")).click();
        js.executeScript("window.scrollBy(0,500)");
        System.out.println("View cart button clicked");
        System.out.println("Product has been added to cart");
        delay(10);

        driver.quit();
        System.out.println("Close Browser");
    }

    static void delay(long detik){
        try {
            Thread.sleep(detik*1000); // delay 3 detik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}