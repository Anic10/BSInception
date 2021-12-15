package com.browserstack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SingleTest extends BrowserStackTestNGTest {

	@Test
	public void test() throws Exception {
		//Loading google
		driver.get("https://www.google.com/ncr");
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("BrowserStack");
		element.submit();
		Thread.sleep(5000);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		//verifying the title
		if (driver.getTitle().equals("BrowserStack - Google Search")) {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Title matched!\"}}");
		} else {
			jse.executeScript(
					"browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"Title not matched\"}}");
		}
		
		//Maximizing the browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);

		//Clicking on Sign In button
		WebElement signIn = driver.findElement(By.xpath("//a[text() = 'Sign in' and @class = 'l']"));
		signIn.click();

		//Sending username
		WebElement userName = driver.findElement(By.xpath("//input[@id = 'user_email_login']"));
		userName.sendKeys("aniket.k+demo@browserstack.com");

		//Sending password
		WebElement password = driver.findElement(By.xpath("//input[@id = 'user_password']"));
		password.sendKeys("Anic10()messi");

		//Clicking on Sign In button
		WebElement signInButton = driver.findElement(By.xpath("//input[@id = 'user_submit']"));
		signInButton.click();
		Thread.sleep(9000);

		//Clicking close
		WebElement closeX = driver.findElement(By.xpath("//a[@class ='close']"));
		if (closeX.isDisplayed()) {
			closeX.click();
		}

		//Navigating to live 
		WebElement liveLink = driver.findElement(By.xpath("//a[text() = 'Live']"));
		liveLink.click();


		//Clicking on Win 10
		WebElement win10 = driver.findElement(By.xpath("//div[@data-test-ositem= 'win10']"));
		win10.click();

		//Clicking on Chrome
		WebElement chromebutton = driver.findElement(By.xpath("//div[@data-rbd-draggable-id= 'win10__chrome__95.0']"));
		chromebutton.click();

		Thread.sleep(10000);

		//Clicking on  Close button
		WebElement closeButton = driver.findElement(By.xpath("//button[@class = 'spotlight__button']"));
		closeButton.click();

		//Clicking on setting div
		WebElement settingButton = driver.findElement(By.xpath("//label[text() = 'Settings']"));
		settingButton.click();

		//Checking if skip local installation popup is present
		try {
			WebElement skiplocal = driver.findElement(By.xpath("(//a[@aria-label = 'skip local installation'])[1]"));
			if (skiplocal.isDisplayed()) {
				skiplocal.click();
			}
		} catch (Exception e) {
		}

		Thread.sleep(10000);

		//Switching to active element
		driver.switchTo().activeElement();

		//Waiting and Clicking on the browser which is inside div
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//canvas[@id ='flashlight-overlay']")));
		WebElement ele = driver.findElement(By.xpath("//canvas[@id ='flashlight-overlay']"));
		ele.click();

		//Sending the keys and url
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys("l").keyUp(Keys.CONTROL).build().perform();

		Thread.sleep(10000);
		
		//Sending the browserstack keyword and clicking enter
		act.sendKeys("https://www.google.com/search?q=browerstack" + Keys.ENTER).build().perform();
	}
}
