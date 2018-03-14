package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class NoTodoCodigoMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(NoTodoCodigoMainPage.class);

	/**
	 * Items keys selectors.
	 */
	private static final String HEADER = "header";

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */

	public NoTodoCodigoMainPage(EmergyaWebDriver driver) {
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

		return false;
	}
	
	// Page object methods
		/**
		 * Check if NoTodoCodigo page is displayed
		 * 
		 * @return
		 */
		public boolean isNoTodoCodigoPageDisplayed() {

			log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isNoTodoCodigoPageDisplayed method");
			log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isNoTodoCodigoPageDisplayed method");

			return this.isElementVisibleById(HEADER);
		}


}
