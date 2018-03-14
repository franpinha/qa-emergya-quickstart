package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class LosArcosTiendasMainPage extends BasePageObject {

	/**
	 * Items keys selectors.
	 */
	private static final String DEPORTES = "deportes";
	private static final String TIENDAS = "tiendas";

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(LosArcosTiendasMainPage.class);

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */

	public LosArcosTiendasMainPage(EmergyaWebDriver driver) {
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

		boolean status = this.isElementVisibleById(TIENDAS);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	public boolean isLosArcosTiendasDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isLosArcosTiendasDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isLosArcosTiendasDisplayed method");

		return this.isElementVisibleByXPath(TIENDAS);
	}
	
	public boolean isLosArcosDeportesDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isLosArcosDeportesDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isLosArcosDeportesDisplayed method");

		return this.isElementVisibleByXPath(DEPORTES);
	}
	
	

}
