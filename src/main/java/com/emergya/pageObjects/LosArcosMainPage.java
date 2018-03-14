package com.emergya.pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class LosArcosMainPage extends BasePageObject {

	/**
	 * Items keys selectors.
	 */
	private static final String NAVBAR = "navbar";
	private static final String NOTICIAS = "noticias";

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(GoogleMainPage.class);

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */
	public LosArcosMainPage(EmergyaWebDriver driver) {
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

		boolean status = this.isElementVisibleById(NAVBAR);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	// Page object methods
	/**
	 * Check if losArcos navbar is displayed
	 * 
	 * @return
	 */
	public boolean isLosArcosNavBarDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isLosArcosNabBarDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isLosArcosNabBarDisplayed method");

		return this.isElementVisibleById(NAVBAR);
	}

	public boolean isLosArcosNoticiasDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isLosArcosNabBarDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isLosArcosNabBarDisplayed method");

		return this.isElementVisibleByXPath(NOTICIAS);
	}

	/**
	 * This method click on LosArcos page
	 * 
	 * @return
	 */
	public LosArcosAccesosMainPage clickOnLosArcosAccesosPage() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnPage method");

		String xpathLink = "//*[@id='navbar']/div/ul[3]/li[1]/a[contains(@href,'/acces')]";

		driver.clickIfExists(By.xpath(xpathLink));

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnPage method");
		return new LosArcosAccesosMainPage(driver);

	}

}
