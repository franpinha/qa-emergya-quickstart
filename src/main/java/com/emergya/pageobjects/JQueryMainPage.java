package com.emergya.pageobjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class JQueryMainPage extends BasePageObject {

	static Logger log = Logger.getLogger(JQueryMainPage.class);

	private static final String LOGOJQUERY = "logojquery";

	public JQueryMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleByXPath(LOGOJQUERY);


		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public boolean isJQueryLogoDisplayed() {
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start isJQueryLogoDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End isJQueryLogoDisplayed method");

		return this.isElementVisibleByXPath(LOGOJQUERY);

	}

}
