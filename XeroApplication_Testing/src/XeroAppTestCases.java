
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class XeroAppTestCases extends ReusableMethods{

	
	@BeforeMethod
	public void intialize() {
		InitializeDriver();
		CreateReport();
		loadData();
		
		}
//	@BeforeMethod
//	public  void OpenUrl () 
//	{
//		logger = report.startTest("OpenUrl");     
//		driver.get("https://login.xero.com/");
//		driver.manage().window().maximize();
//		String actualTitle = driver.getTitle();
//		System.out.println(actualTitle );
//		String expectedTitle = "Login | Xero Accounting Software";
//		Assert.assertEquals(actualTitle, expectedTitle);
//		logger.log(LogStatus.INFO, "Login page opened");
//		}
	@Test
	public void NavigateToXero() throws InterruptedException {
		OpenUrl("https://login.xero.com/");
		logger = report.startTest("NavigateToXero");
		
		WebElement unameTextBox = driver.findElement(By.id("email"));
		 EnterText(unameTextBox, props.getProperty("username"), "email");
		 WebElement password = driver.findElement(By.id("password"));
		 String str = props.getProperty("password");
		 EnterText(password ,str, "password");
		 WebElement loginBtn = driver.findElement(By.id("submitButton"));
		 Click(loginBtn, "login");
		 Thread.sleep(2000);
		 String actual = driver.getTitle();
		 Assert.assertEquals(actual, "My Xero | Add your organisation");
		 logger.log(LogStatus.INFO, "Homepage is dispalyed");
		 System.out.println("login to app");
	}
	@Test
	public void incorrectPassword() throws InterruptedException {
		OpenUrl("https://login.xero.com/");
		logger = report.startTest("incorrectPassword");
		WebElement unameTextBox = driver.findElement(By.id("email"));
		 EnterText(unameTextBox, props.getProperty("username"), "email");
		 WebElement password = driver.findElement(By.id("password"));
		 String str = props.getProperty("incorrectpassword");
		 EnterText(password ,str, "password");
		 WebElement loginBtn = driver.findElement(By.id("submitButton"));
		 Click(loginBtn, "login");
		 Thread.sleep(2000);
		 String actual = driver.findElement(By.cssSelector("body.x-page.marketing-advert.ext-webkit.ext-chrome.ext-mac:nth-child(2) div.content:nth-child(3) div.inner div.document.clear div.login-container:nth-child(2) div.form-container div.x-boxed.warning:nth-child(4) > p:nth-child(1)")).getText();
		 System.out.println(actual);
		 String expected = "Your email or password is incorrect";
		 Assert.assertEquals(actual, expected,"Error message not displayed");
		 logger.log(LogStatus.INFO,"Error message is diplayed");
	}
	@Test
	public void incorrectEmail() {
		OpenUrl("https://login.xero.com/");
		logger = report.startTest("incorrectEmail");
		WebElement unameTextBox = driver.findElement(By.id("email"));
		 EnterText(unameTextBox, props.getProperty("incorrectemail"), "email");
		 WebElement password = driver.findElement(By.id("password"));
		 String str = props.getProperty("password");
		 EnterText(password ,str, "password");
		 WebElement loginBtn = driver.findElement(By.id("submitButton"));
		 Click(loginBtn, "login");
		 String actual = driver.findElement(By.cssSelector("body.x-page.marketing-advert.ext-webkit.ext-chrome.ext-mac:nth-child(2) div.content:nth-child(3) div.inner div.document.clear div.login-container:nth-child(2) div.form-container div.x-boxed.warning:nth-child(4) > p:nth-child(1)")).getText();
		 System.out.println(actual);
		 String expected = "Your email or password is incorrect";
		 Assert.assertEquals(actual, expected,"Error message not displayed");
		 logger.log(LogStatus.INFO,"Error message is diplayed");
		
	}
	@Test
	public void forgotPassword() throws InterruptedException {
		OpenUrl("https://login.xero.com/");
		logger = report.startTest("forgot password");
		
		WebElement forgotPwd = driver.findElement(By.xpath("//*[@id='contentTop']/div[2]/div[1]/a[1]"));
		Click(forgotPwd,"forgot password");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		String expectedTitle = "Forgotten Password";
		Assert.assertEquals(actualTitle, expectedTitle,"password reset page is not displayed");
		logger.log(LogStatus.INFO, "Password reset page is opened");
		WebElement emaiTextbox = driver.findElement(By.id("UserName"));
		 EnterText(emaiTextbox, props.getProperty("username"), "email");
		 driver.findElement(By.xpath("//div//div//div//div//div//div[1]//a[1]")).click();
		 String actual = driver.findElement(By.cssSelector("body.x-page.ext-webkit.ext-chrome.ext-mac:nth-child(2) div.content:nth-child(3) div.inner div.document.clear div.x-boxed.noBorder > p:nth-child(2)")).getText();
		 System.out.println(actual);
		 String expected = "A link to reset your password has been sent to: testQA20mar@gmail.com";
		 Assert.assertEquals(actual, expected,"Link to rest Message is not displayed");
		
		
	}
//	public void sign_upto_xdc() {
//		logger = report.startTest("sign_upto_xdc");
//	}
	@AfterMethod
	public void closeBrowser()
	{
		CloseBrowser();
		CloseReport();
	}

}
