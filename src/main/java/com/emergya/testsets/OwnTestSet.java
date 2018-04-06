package com.emergya.testsets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageobjects.JQueryMainPage;
import com.emergya.utils.BasicTestSet;

public class OwnTestSet extends BasicTestSet {

	static Logger log = Logger.getLogger(OwnTestSet.class);

	public OwnTestSet() {
		super();

	}

	@BeforeMethod(description = "startTest")
	public void before() {
		super.before();
	}

	@AfterMethod(description = "endTest")
	public void afterAllIsSaidAndDone() {
		super.afterAllIsSaidAndDone();
	}

	@Test(description = "accesJQueryUIPage")
	public void accesJQueryUIPage(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		jQueryMainPage = new JQueryMainPage(driver);
		jQueryMainPage.isReady();

		try {

			driver.get("http://jqueryui.com/demos/");
			isJQueryLogoDisplayed();

			// assertTrue("Developing test", false);

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	/**
	 * This assertion check if JQueryUiPage logo are displayed
	 */
	public void isJQueryLogoDisplayed() {

		if (jQueryMainPage == null) {

			jQueryMainPage = new JQueryMainPage(driver);
		}
		assertTrue("Logo isJQueryLogoDisplayed isn't displayed, it should be displayed",
				jQueryMainPage.isJQueryLogoDisplayed());

	}

}
