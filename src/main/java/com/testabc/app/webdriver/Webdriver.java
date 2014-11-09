package com.testabc.app.webdriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	public void ClickWebElementById(String uiObject){
		WebElement webElment=getWebElementById(uiObject);
		webElment.click();
	}
	public void SendKeysWebElementById(String uiObject,String testData){
		WebElement webElment=getWebElementById(uiObject);
		webElment.clear();
		webElment.sendKeys(testData);
	}
	public void ClickWebElementByCss(String uiObject){
		WebElement webElment=getWebElementByCss(uiObject);
		webElment.click();
	}
	public void SendKeysWebElementByCss(String uiObject,String testData){
		WebElement webElment=getWebElementByCss(uiObject);
		webElment.clear();
		webElment.sendKeys(testData);
	}
	/** webElment List Click **/
	public void SendKeysWebElementListByCss(String uiObject,int index){
        List<WebElement> item=getWebElementsByCss(uiObject);
        item.get(index).click();
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
