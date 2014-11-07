package com.testabc.app.webdriver;

import junit.framework.TestCase;

public class Demo1Test extends TestCase {
	public void testCase1(){
        Webdriver wd=new Webdriver();
        
        wd.browserFFStart();
        wd.gotoURL("http://www.baidu.com");
        wd.browserMax();
        wd.waitTimeThread(2);
        // Assert Title
//        String title=wd.getTitle();
//        wd.testassertEqual("百度一下，你就知道", title);
        // send search keyword ,and click search button
        wd.SendKeysWebElementById("kw1", "13测试公会");
        wd.ClickWebElementById("su1");
        // Assert Title
        String title1=wd.getTitle();
        wd.testassertEqual("13测试公会_百度搜索", title1);
	}
	

}
