package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class ListBoxMainPage extends BasePageObject{

	private static final String LOGOEASY="logoeasy";
	private static final String LISTBOXMULTIPLE="//select[@class='form-control pickListSelect pickData']";
	private static final String BUTTONADD="buttonadd";
	
	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(TwoIframesMainPage.class);
	
	public ListBoxMainPage(EmergyaWebDriver driver) {
		super(driver);
		
	}

	@Override
	public boolean isReady() {
		
		return false;
	}
	
	public boolean isSeleniumEasyLogoDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start isSeleniumEasyLogoDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End isSeleniumEasyLogoDisplayed method");
		
		
		return this.isElementVisibleById(LOGOEASY);
	}
	
	public void selectMultipleListBox() {
		
		WebElement listBox = driver.findElementByXPath(LISTBOXMULTIPLE);
		
		Select selection = new Select(listBox);
		selection.selectByVisibleText("Sophia");
		selection.selectByVisibleText("Alice");
		
		if(this.isElementVisibleByXPath(BUTTONADD)) {
			this.getElementByXPath(BUTTONADD).click();
		}
	}

}
