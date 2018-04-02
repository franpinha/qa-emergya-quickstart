package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

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
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleByXPath(LOGOJQUERY);

		if (driver.isElementDisplayed(By.xpath("//*[@id='logo-events']/h2/a")))
			System.err.println("se ve por xpath1");
		if (driver.isElementDisplayed(By.xpath(getXPath(LOGOJQUERY))))
			System.err.println("se ve por xpath2");

		if (this.isElementVisibleByXPath(LOGOJQUERY)) {
			System.err.println("se ve por xpath");
		} else {

			System.err.println("no se ve por xpath");
		}

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public boolean isJQueryLogoDisplayed() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isJQueryLogoDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isJQueryLogoDisplayed method");

		return this.isElementVisibleByXPath(LOGOJQUERY);

	}

}
