package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class LosArcosAccesosMainPage extends BasePageObject {

	/**
	 * Items keys selectors.
	 */
	private static final String ACCESOS = "headerclass";

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(LosArcosAccesosMainPage.class);

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */

	public LosArcosAccesosMainPage(EmergyaWebDriver driver) {
		super(driver);

	}

	/**
	 * Checks that the PO is ready
	 * 
	 * @param pageObject
	 *            page object to be used
	 */
	@Override
	public boolean isReady() {
		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleById(ACCESOS);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	// Page object methods
	/**
	 * Check if los Arcos accesos is displayed
	 * 
	 * @return
	 */
	public boolean isLosArcosAccesosDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isLosArcosAccesosDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isLosArcosAccesosDisplayed method");

		return this.isElementVisibleByXPath(ACCESOS);
	}

	/**
	 * This method click on LosArcos cine page
	 * 
	 * @return
	 */
	public LosArcosCineMainPage clickOnLosArcosCinePage() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnPage method");

		String xpathLink = "//*[@id='pictoHome']/li[3]/a/span[2]";

		driver.clickIfExists(By.xpath(xpathLink));

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnPage method");
		return new LosArcosCineMainPage(driver);

	}

}
