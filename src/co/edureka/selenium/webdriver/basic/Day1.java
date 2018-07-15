package co.edureka.selenium.webdriver.basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day1 {
	
	WebDriver driver;
	JavascriptExecutor jse;
	
	public void invokeBrowser() {
		
		try {
			System.setProperty("webdriver.chrome.driver", "E:\\tools\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			
			driver.get("http://www.edureka.co");
//			driver.get("http://l-tike.com/");
			searchCource();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchCource() {
		try {
			driver.findElement(By.id("homeSearchBar")).sendKeys("Java");
			Thread.sleep(3000);
			driver.findElement(By.id("homeSearchBarIcon")).click();
//			jse = (JavascriptExecutor)driver;
//			jse.executeScript("scroll(0, 10000)");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			driver.findElement(By.className("batch-type-button")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		try {
//			driver.findElement(By.xpath("//div[contains(text(), 'Weekend')]")).click();
			
//			WebDriverWait wait = new WebDriverWait(driver, 50);//待ち時間を指定
//			By courseFilterDroplist = By.className("course-filterdroplist");
//			wait.until(ExpectedConditions.visibilityOfElementLocated(courseFilterDroplist));
//			driver.findElement(By.className("check4")).click();
			
			WebDriverWait wait = new WebDriverWait(driver, 5);//待ち時間を指定
			By weekendDiv = By.xpath("//diWekv[contains(text(), 'Weekend')]");
			wait.until(ExpectedConditions.visibilityOfElementLocated(weekendDiv));
			driver.findElement(weekendDiv).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		
		Day1 myObj = new Day1();
		myObj.invokeBrowser();

	}

}
