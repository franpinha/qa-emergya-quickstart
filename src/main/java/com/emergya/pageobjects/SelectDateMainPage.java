package com.emergya.pageobjects;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class SelectDateMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(SelectDateMainPage.class);

	/**
	 * Items keys selectors from properties.
	 */
	private static final String LOGO = "nameandslogan";

	public SelectDateMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	/**
	 * Check if the Selenium Easy logo's page is visible
	 * 
	 * @return boolean
	 */
	
	public boolean isSeleniumEasyLogoPageDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isTestingPageDisplayed method");

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- End isTestingPageDisplayed method");

		return this.isElementVisibleById(LOGO);

	}
	
	public Date obtainDateToday() {
		
		Calendar dateToday = Calendar.getInstance();
		
		dateToday.get(Calendar.YEAR);
		dateToday.get(Calendar.MONTH);

		return null;
	}

}
