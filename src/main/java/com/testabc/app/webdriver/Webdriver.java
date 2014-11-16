package com.testabc.app.webdriver;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * WebDriver 
 * @author fengfan
 * Create Date:2014-11-09
 *
 */
public class Webdriver {
	public WebDriver driver;
	/** Browser Start **/
	public void browserCRStart(){
		String chromeDriverPath=System.getProperty("user.dir")+"/chromedriver.exe";
	    System.setProperty("webdriver.chrome.driver",chromeDriverPath);
	    ChromeOptions options = new ChromeOptions();
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    driver = new ChromeDriver();
	}
	public void browserCRStartOnIpad(){
		// Open Browser on Ipad-- need to update useragent detail
		String chromeDriverPath=System.getProperty("user.dir")+"/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		ChromeOptions options = new ChromeOptions();
	    options.addArguments("Mozilla/5.0(iPad; U; CPU iPhone OS 3_2 like Mac OS X; en-us) "
	    		+ "AppleWebKit/531.21.10 (KHTML, like Gecko) Version/4.0.4 Mobile/7B314 Safari/531.21.10");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver();
	}
	
	public void browserIEStart(){
		String ieDriverPath=System.getProperty("user.dir")+"/ie.exe";
	    System.setProperty("webdriver.ie.driver",ieDriverPath);
	    ChromeOptions options = new ChromeOptions();
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    driver = new ChromeDriver();
	}
	public void browserFFStart(){
	    driver = new FirefoxDriver();
	}
	public void browserMax(){
		driver.manage().window().maximize();
	}
	public void browserEnd(){
		driver.quit();
	}
	public void gotoURL(String url){
		driver.get(url);
	}
	public String getTitle(){
		return driver.getTitle();
	}
	public void cleanAllCookie(){
		driver.manage().deleteAllCookies();
	}
 
	/** wait Time **/
	public void waitTimeforPageLoad(int sec){
		driver.manage().timeouts().pageLoadTimeout(sec, TimeUnit.SECONDS);
	}
	public void waitTimeThread(int sec){
		try{
			Thread.sleep(1000*sec);
		}catch(Exception ex){
			
		}
	}
	/** webElment   **/
	public WebElement getWebElementById(String uiObject){
		return driver.findElement(By.id(uiObject));
	}
	public WebElement getWebElementByCss(String uiObject){
		return driver.findElement(By.cssSelector(uiObject));
	}
	
	public List<WebElement> getWebElementsById(String uiObject){
		return driver.findElements(By.id(uiObject));
	}
	public List<WebElement> getWebElementsByCss(String uiObject){
		return driver.findElements(By.cssSelector(uiObject));
	}
	
	/** webElment action **/
	public void clickWebElementById(String uiObject){
		WebElement webElment=getWebElementById(uiObject);
		webElment.click();
	}
	public void sendKeysWebElementById(String uiObject,String testData){
		WebElement webElment=getWebElementById(uiObject);
		webElment.clear();
		webElment.sendKeys(testData);
	}
	public void clickWebElementByCss(String uiObject){
		WebElement webElment=getWebElementByCss(uiObject);
		webElment.click();
	}
	public void sendKeysWebElementByCss(String uiObject,String testData){
		WebElement webElment=getWebElementByCss(uiObject);
		webElment.clear();
		webElment.sendKeys(testData);
	}
	/** webElment List Click **/
	public void sendKeysWebElementListByCss(String uiObject,int index){
        List<WebElement> item=getWebElementsByCss(uiObject);
        item.get(index).click();
	}
	/** Action **/
	public void clickWebElement(WebElement webElement){
		Actions action = new Actions(driver);
		action.click(webElement);
		action.perform();
	}
	public void doubleClickWebElement(WebElement webElement){
		Actions action = new Actions(driver);
		action.doubleClick(webElement);
		action.perform();
	}
	public void dragAndDropWebElement(WebElement sourceWebElement,WebElement targetWebElement){
		Actions action = new Actions(driver);
		action.dragAndDrop(sourceWebElement, targetWebElement);
		action.perform();
	}
	public void moveToElement(WebElement webElement){
		Actions action = new Actions(driver);
		action.moveToElement(webElement);
		action.perform();
	}

	/** Scroll **/
	
	public void scrollToTop(){
		String script="window.scrollBy(0,0)";
		runJavaScript(script);
	}
	public void scrolldown(int height){
		String script="window.scrollBy(0,"+height +")";
		runJavaScript(script);
	}
	public String runJavaScript(String script){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("return document.title");
        String result=(String) js.executeScript(script);
        return result;
	} 	 
	
	public void snapshot(String snapshotName){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  // generate file after take snapshot
		try {
			FileUtils.copyFile(file, new File(System.getProperty("user.dir")+"/"+snapshotName+".png"));
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	} 	
	public String switchtoNewWindow(){
		//Store the current window handle
		String winHandleBefore = driver.getWindowHandle();
		//Switch to new window opened
		for(String winHandle : driver.getWindowHandles()){
		if(winHandle != winHandleBefore)
		    driver.switchTo().window(winHandle);
		//System.out.println("Window Change"+winHandle);
		}
		return winHandleBefore;
	}
	public void switchbacktoWindow(String winHandleBefore){
		for(String winHandle : driver.getWindowHandles()){
		if(winHandle == winHandleBefore){
			driver.switchTo().window(winHandle);
		}
		else{
			driver.close();
		}
		//System.out.println("Window Change"+winHandle);
        }
	}
	public boolean assertEqual(String expect,String actual){
		if(actual.equals(expect)){
			return true;
		}
		return false;
	}
	public void testassertEqual(String expect,String actual){
		Assert.assertEquals(expect, actual);
	}
}
