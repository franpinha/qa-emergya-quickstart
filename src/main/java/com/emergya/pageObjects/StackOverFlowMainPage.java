package com.emergya.pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

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
	// private static final String PRUEBA = "<span class='-img' style=''>" ;

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

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start isReady method");

		boolean status = this.isElementVisibleByXPath(LOGO);

		log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End isReady method");

		return status;
	}

	// Page object methods
	/**
	 * Check if stackoverflow logo page is displayed
	 * 
	 * @return
	 */
	public boolean isStackOverFlowPageDisplayed() {

		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start isUploadImagePageDisplayed method");
		log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isUploadImagePageDisplayed method");

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

		log.info("[log-pageObjects]" + this.getClass().getSimpleName()
				+ "]- Start isStackOverFlowLabelsDisplayed method");
		log.info(
				"[log-pageObjects]" + this.getClass().getSimpleName() + "]- End isStackOverFlowLabelsDisplayed method");

		/*
		 * if(isElementVisibleByXPath(NAME) && isElementVisibleByXPath(EMAIL) &&
		 * isElementVisibleByXPath(PASS)) {
		 * System.err.println("SE VEN LOS TRES LABELS"); }else {
		 * 
		 * System.err.println("nooooooooooooSE VEN LOS TRES LABELS"); }
		 */
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

		log.info("[log-" + this.getClass().getSimpleName() + "]- Start registerStackOverFLow -["
				+ this.getClass().getSimpleName() + "- method]");

		if (this.isElementVisibleByXPath(NAME) && this.isElementVisibleByXPath(EMAIL)
				&& this.isElementVisibleByXPath(PASS)) {

			this.getElementByXPath(NAME).sendKeys(name);
			this.getElementByXPath(EMAIL).sendKeys(email);
			this.getElementByXPath(PASS).sendKeys(password);

			this.getElementByXPath(REGISTER).sendKeys(Keys.ENTER);
			try {
				Thread.sleep(10000);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

		log.info("[log-" + this.getClass().getSimpleName() + "]- End registerStackOverFLow -["
				+ this.getClass().getSimpleName() + "- method]");
	}

	public void searchInPageRobot() {

		log.info("[log-" + this.getClass().getSimpleName() + "]- Start searchInPageRobot -["
				+ this.getClass().getSimpleName() + "- method]");

		try {
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_F);
			robot.keyPress(KeyEvent.VK_H);
			robot.keyRelease(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_F);
			Thread.sleep(2000);
			// writeRobot("hola mundo");

		} catch (AWTException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	private void writeRobot(String prueba) {

		StringSelection stringSelection = new StringSelection(prueba);
		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection,
		// null);

	}

}
