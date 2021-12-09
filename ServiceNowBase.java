package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

public class ServiceNowBase extends AbstractTestNGCucumberTests {

	public static ChromeDriver driver;

		@BeforeMethod
		public void preCondition() throws InterruptedException {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://dev100121.service-now.com/navpage.do");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.id("user_name")).sendKeys("admin");
			driver.findElement(By.id("user_password")).sendKeys("Servicenow@123");
			driver.findElement(By.id("sysverb_login")).click();
			driver.findElement(By.id("filter")).sendKeys("incident");
			Thread.sleep(7000);
			driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
			driver.switchTo().frame("gsft_main");

		}

		@AfterMethod
		public void postCondition() {

		//driver.close();
		}
	}


	
