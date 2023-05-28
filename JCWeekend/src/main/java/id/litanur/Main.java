package id.litanur;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

        try {
            Thread.sleep(3000); // delay 3 detik
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
        System.out.println("Close Browser");
    }
}