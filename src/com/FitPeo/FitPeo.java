package com.FitPeo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class FitPeo {
	
	static WebDriver driver;
	
	public static void browserLaunch() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Nirisha\\eclipse-workspace\\DataLabs_Project\\src\\WebDriverNew\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.fitpeo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public static void calPage(){
        try {
            driver.findElement(By.xpath("//a[@href='/revenue-calculator']")).click();
            
            WebElement mainSlider = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]/span[1]"));
            WebElement slider = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[2]/div/div/span[1]/span[3]"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Java_Executor.scrollIntoView(driver, mainSlider);
            Java_Executor.scrollBy(driver, 0, -200);
            
            Actions actions = new Actions(driver);
            actions.clickAndHold(slider).moveByOffset(93, 0).release().perform();
            
            WebElement value = driver.findElement(By.xpath("//input[@aria-invalid=\"false\"]"));
            String sliderValue = js.executeScript("return arguments[0].getAttribute('value');", slider).toString();
            
            // Update the text box with the slider value
            value.sendKeys(sliderValue);
        } catch (Exception e) {
            System.out.println("Error in calPage method: " + e.getMessage());
        }
    }
	
	public static void selectCPT1() {
        try {
        	WebElement check = driver.findElement(By.className("PrivateSwitchBase-input"));
        	
            Java_Executor.scrollIntoView(driver, check);
            Java_Executor.scrollBy(driver, 0, -400);
            check.click();
        } catch (Exception e) {
            System.out.println("Error in selectCodes method: " + e.getMessage());
        }
        driver.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[2]")).click();
    };
    
    public static void selectCPT2() {
        try {
        	WebElement check = driver.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[3]"));
        	 Java_Executor.scrollIntoView(driver, check);
             Java_Executor.scrollBy(driver, 0, -800);
            check.click();
        } catch (Exception e) {
            System.out.println("Error in selectCodes method: " + e.getMessage());
        }
    };
    
    public static void selectCPT3() {
        try {
        	WebElement check = driver.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[8]"));
        	 Java_Executor.scrollIntoView(driver, check);
             Java_Executor.scrollBy(driver, 0, -1200);
            check.click();
        } catch (Exception e) {
            System.out.println("Error in selectCodes method: " + e.getMessage());
        }
    };

//    Note:I was unable to set the slider to exactly 820 and instead used 816, I can able to slide the slider values of 816 or 822.

public static void main(String[] args){
	browserLaunch();
	calPage();
	selectCPT1();
	selectCPT2();
	selectCPT3();
}
}
