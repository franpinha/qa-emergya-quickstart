package com.emergya.pageobjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.logging.Level;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;

import com.emergya.selenium.drivers.EmergyaWebDriver;
import com.emergya.selenium.pageObject.BasePageObject;

public class StackOverFlowMainPage extends BasePageObject {

	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(StackOverFlowMainPage.class);

	/**
	 * Items keys selectors.
	 */

	private static final String LOGO = "logo";
	private static final String NAME = "labelname";
	private static final String EMAIL = "labelmail";
	private static final String PASS = "labelpass";
	private static final String REGISTER = "signupbutton";
	

	/**
	 * Constructor method
	 * 
	 * @param driver
	 *            selenium webdriver
	 */

	public StackOverFlowMainPage(EmergyaWebDriver driver) {
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

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleByXPath(LOGO);

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	// Page object methods
	/**
	 * Check if stackoverflow logo page is displayed
	 * 
	 * @return
	 */
	public boolean isStackOverFlowPageDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start isUploadImagePageDisplayed method");
		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End isUploadImagePageDisplayed method");

		return this.isElementVisibleByXPath(LOGO);
	}

	// Page object methods
	/**
	 * Check if stackoverflow name label, email label and password label is
	 * displayed
	 * 
	 * @return
	 */
	public boolean isStackOverFlowLabelsDisplayed() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName()
				+ "]- Start isStackOverFlowLabelsDisplayed method");
		log.info(
				com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End isStackOverFlowLabelsDisplayed method");

		return this.isElementVisibleByXPath(NAME) && this.isElementVisibleByXPath(EMAIL)
				&& this.isElementVisibleByXPath(PASS);
	}

	/**
	 * This method write a small form to register in StackOverFlowPage by and click
	 * Sign Up to do the register the search
	 * 
	 * @param name
	 *            , email , password
	 * @return
	 */
	public void registerStackOverFLow(String name, String email, String password) {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start registerStackOverFLow -["
				+ this.getClass().getSimpleName() );

		if (this.isElementVisibleByXPath(NAME) && this.isElementVisibleByXPath(EMAIL)
				&& this.isElementVisibleByXPath(PASS)) {

			this.getElementByXPath(NAME).sendKeys(name);
			this.getElementByXPath(EMAIL).sendKeys(email);
			this.getElementByXPath(PASS).sendKeys(password);

			this.getElementByXPath(REGISTER).sendKeys(Keys.ENTER);
			
				driver.sleep(1);


		}

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- End registerStackOverFLow -["
				+ this.getClass().getSimpleName() );
	}

	public void searchInPageRobot() {

		log.info(com.emergya.utils.MyBasePageObject.CONSTANTPAGEOBJECT + this.getClass().getSimpleName() + "]- Start searchInPageRobot -["
				+ this.getClass().getSimpleName() );

		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			driver.sleep(2);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_F);
			driver.sleep(2);

		} catch (AWTException awt) {

			log.warn(Level.WARNING, awt);
		
	}

}
}
