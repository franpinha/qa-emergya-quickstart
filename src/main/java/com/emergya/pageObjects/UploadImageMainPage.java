package com.emergya.pageObjects;

import org.apache.log4j.Logger;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;
import com.emergya.utils.MyBasePageObject;

public class UploadImageMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(UploadImageMainPage.class);

	/**
	 * Items keys selectors.
	 */

	private static final String UPLOADBUTTON = "uploadbutton";
	private static final String ELEMENT = "elementparent";

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */
	public UploadImageMainPage(EmergyaWebDriver driver) {
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

		boolean status = this.isElementVisibleById(ELEMENT);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;

	}

	// Page object methods
	/**
	 * Check if FineUploader page is displayed
	 * 
	 * @return
	 */
	public boolean isUploadImagePageDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isUploadImagePageDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isUploadImagePageDisplayed method");

		return this.isElementVisibleById(ELEMENT);
	}

	/**
	 * This method click on "Upload files" button
	 * 
	 * @return
	 * 
	 */
	public UploadImageMainPage clickOnUploadFiles() {
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start clickOnUploadFiles method");
		MyBasePageObject my = new MyBasePageObject();

		this.getElementByXPath(UPLOADBUTTON).click();

		my.uploadArchive("tux.jpg");

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End clickOnUploadFiles method");
		return new UploadImageMainPage(driver);
	}
}
