package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class PhpTravelsMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(PhpTravelsMainPage.class);

	private static final String LOGOPHP = "logophp";

	public PhpTravelsMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	@Override
	public boolean isReady() {

		return false;
	}

	public boolean isPhpTravelsPageLogoDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isPhpTravelsPageLogoDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End isPhpTravelsPageLogoDisplayed method");

		return this.isElementVisibleByXPath(LOGOPHP);
	}

	public PhpTravelsLoginMainPage goToLogin() {
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start goToLogin method");

		String xpathLink = "//*[@id='main-menu']/ul/li[8]";

		driver.clickIfExists(By.xpath(xpathLink));

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End goToLogin method");

		return new PhpTravelsLoginMainPage(driver);

	}
}
