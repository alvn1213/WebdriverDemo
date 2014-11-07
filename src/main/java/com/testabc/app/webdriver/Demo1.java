package com.testabc.app.webdriver;
/**
 * WebDriver Demo1
 * @author fengfan
 * Create Date:20140721
 *
 */
public class Demo1 {
	public void TestCase1(){
        Webdriver wd=new Webdriver(); 
        wd.browserFFStart();
        wd.gotoURL("http://www.baidu.com");
        wd.browserMax();
        wd.waitTimeThread(3);
        // Assert Title
        String title=wd.getTitle();
        boolean result=wd.assertEqual( "百度一下，你就知道",title);
        System.out.println(result);
        wd.testassertEqual("百度一下，你就知道", title);
        // send search keyword ,and click search button
        wd.SendKeysWebElementById("kw", "13测试公会");
        wd.ClickWebElementById("su");
        // Assert Title
        String title1=wd.getTitle();
        boolean result1= wd.assertEqual( "13测试公会_百度搜索",title1);
        System.out.println(result1);
	}

}
