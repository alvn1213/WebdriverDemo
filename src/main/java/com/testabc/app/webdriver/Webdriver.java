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

public class Webdriver {
	public WebDriver driver;
	/** Browser Start **/
	public void browserCRStart(){
		String chromeDriverPath=System.getProperty("usr.dir")+"/chrome.exe";
	    System.setProperty("webdriver.chrome.driver",chromeDriverPath);
	    ChromeOptions options = new ChromeOptions();
	    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    driver = new ChromeDriver();
	}
	public void browserIEStart(){
		String ieDriverPath=System.getProperty("usr.dir")+"/ie.exe";
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
	public WebElement getWebElementById(String uiOjbect){
		return driver.findElement(By.id(uiOjbect));
	}
	public WebElement getWebElementByCss(String uiOjbect){
		return driver.findElement(By.cssSelector(uiOjbect));
	}
	public List<WebElement> getWebElementsById(String uiOjbect){
		return driver.findElements(By.id(uiOjbect));
	}
	public List<WebElement> getWebElementsByCss(String uiOjbect){
		return driver.findElements(By.cssSelector(uiOjbect));
	}
	
	/** webElment action **/
	public void ClickWebElementById(String uiOjbect){
		WebElement webElment=getWebElementById(uiOjbect);
		webElment.click();
	}
	public void SendKeysWebElementById(String uiOjbect,String testData){
		WebElement webElment=getWebElementById(uiOjbect);
		webElment.clear();
		webElment.sendKeys(testData);
	}
	public void ClickWebElementByCss(String uiOjbect){
		WebElement webElment=getWebElementByCss(uiOjbect);
		webElment.click();
	}
	public void SendKeysWebElementByCss(String uiOjbect,String testData){
		WebElement webElment=getWebElementByCss(uiOjbect);
		webElment.clear();
		webElment.sendKeys(testData);
	}
	
	
	public boolean assertEqual(String expect,String actual){
		if(actual.equals(actual)){
			return true;
		}
		return false;
	}
	public void testassertEqual(String expect,String actual){
		Assert.assertEquals(expect, actual);
	}
}
