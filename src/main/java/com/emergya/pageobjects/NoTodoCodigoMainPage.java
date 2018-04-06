package com.emergya.pageobjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;

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
	private static final String BUSCAR = "buscar";

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

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start isNoTodoCodigoPageDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End isNoTodoCodigoPageDisplayed method");

		return this.isElementVisibleById(HEADER);
	}

	// Page object methods
	/**
	 * Check if NoTodoCodigo field Buscar is displayed
	 * 
	 * @return
	 */
	public boolean isNoTodoCodigoBuscarDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isNoTodoCodigoBuscarDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End isNoTodoCodigoBuscarDisplayed method");

		return this.isElementVisibleByXPath(BUSCAR);
	}

	// Page object methods
	/**
	 * This method do a search in Buscar by a string search and click ENTER to do
	 * the search
	 * 
	 * @param stringSearch
	 * @return
	 */
	public void doSearchNoTodoCodigo(String stringSearch) {

		log.info("[log-" + this.getClass().getSimpleName() + "]- Start doSearchNoTodoCodigo -["
				+ this.getClass().getSimpleName() + "- method]");

		if (this.isElementVisibleByXPath(BUSCAR)) {

			this.getElementByXPath(BUSCAR).sendKeys(stringSearch);
			this.getElementByXPath(BUSCAR).sendKeys(Keys.ENTER);

		}

		log.info("[log-" + this.getClass().getSimpleName() + "]- End doSearchNoTodoCodigo -["
				+ this.getClass().getSimpleName() + "- method]");
	}

}
