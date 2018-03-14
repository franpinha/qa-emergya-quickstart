package com.emergya.testSets;

import static org.testng.AssertJUnit.assertTrue;

import java.lang.reflect.Method;
import java.util.List;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.emergya.pageObjects.EmergyaMainPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.LosArcosCineMainPage;
import com.emergya.pageObjects.LosArcosMainPage;
import com.emergya.pageObjects.LosArcosTiendasMainPage;
import com.emergya.pageObjects.NoTodoCodigoMainPage;
import com.emergya.pageObjects.LosArcosAccesosMainPage;
import com.emergya.utils.BasicTestSet;

/**
 * A test class contain the tests of a specific page in the application
 * 
 * @author Jose Antonio Sanchez <jasanchez@emergya.com>
 * @author Ivan Bermudez <ibermudez@emergya.com>
 * @author Ivan Gomez <igomez@emergya.com>
 */
public class GoogleTestSet extends BasicTestSet {

	static Logger log = Logger.getLogger(GoogleTestSet.class);

	public GoogleTestSet() {
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

	// **************** TESTS ****************
	// ------ EMERGYA QA SAMPLE TEST ------ //
	// ------ US00001 - Check google main page and do a search ------ //
	/**
	 * Description: Check the main page elements and do a search on google
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Go to www.google.es - Check that the google logo is displayed -
	 * Check that the 'Buscar con Google' button is displayed - Check that the 'Voy
	 * a tener suerte' button is displayed - Check that the search field is
	 * displayed - Do this search 'Hello world!' - Check that several results are
	 * displayed
	 * 
	 * Post steps: - Close the browser
	 * 
	 */

	@Test(description = "googleMainPageSearch")
	public void googleMainPageSearch(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		isReady(googleMainPage = new GoogleMainPage(driver));

		// Steps to build the stage (Pre steps)

		try {
			// Go to www.google.es
			// Check that the google logo is displayed
			isLogoDisplayed();

			// Check that the 'Buscar con Google' button is displayed
			isSearchButtonDisplayed();

			// Check that the 'Voy a tener suerte' button is displayed
			isLuckButtonDisplayed();

			// Check that the search field is displayed
			isSearchFieldDisplayed();

			// Do this search 'Hello world!'
			googleMainPage.doSearch("Hello world");

			// Check that several results are displayed
			areSeveralResults();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	/**
	 * Description: Do a search in Google and access to a page
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Go to www.google.es - Do this search 'www.cclosarcos.es' - Access to
	 * 'www.cclosarcos.com' - Check that the navBar is displayed
	 * 
	 * 
	 * 
	 * Post steps: - Close the browser
	 * 
	 * @throws InterruptedException
	 * 
	 */
	@Test(description = "googleDoSearchAndAccessToPage")
	public void googleDoSearchAndAccessToPage(Method method) throws InterruptedException {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		isReady(googleMainPage = new GoogleMainPage(driver));

		// Steps to build the stage (Pre steps)

		try {
			// Go to www.google.es
			// Do this search 'www.cclosarcos.com'
			googleMainPage.doSearch("cclosarcos");

			// Access to 'cclosarcos.com'
			losArcosMainPage = googleMainPage.clickOnLosArcosPage();

			// check navBar,Accesos and Noticias
			isLosArcosNavBarDisplayed();
			isLosArcosAccesosDisplayed();
			isLosArcosNoticiasDisplayed();

			losArcosAccesosMainPage = losArcosMainPage.clickOnLosArcosAccesosPage();

			isLosArcosCinesDisplayed();
			losArcosCineMainPage = losArcosAccesosMainPage.clickOnLosArcosCinePage();

			isLosArcosTiendasDisplayed();

			losArcosTiendasMainPage = losArcosCineMainPage.moveOnLosArcosTiendasPage();

			// isLosArcosDeportesDisplayed();
			System.err.println("DEPORTES COMPROBADO");
			losArcosTiendasMainPage = losArcosCineMainPage.clickOnLosArcosTiendasPage();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "googleDoSearchAndAccessToPageAccesos")
	public void googleDoSearchAndAccessToPageAccesos(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		isReady(googleMainPage = new GoogleMainPage(driver));

		// Steps to build the stage (Pre steps)

		try {

			isLosArcosAccesosDisplayed();

			// TODO: Remove the following line when you complete the test
			assertTrue("Developing test", false);

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	/**
	 * Description: Do a search in Google and access to a page
	 * 
	 * Pre steps: - Open the browser
	 * 
	 * Steps: - Go to www.google.es - Do this search 'www.emergya.es' - Access to
	 * 'www.emergya.es' - Check that the logo is displayed - Access to the
	 * 'Contacto' page - Check that the address is displayed - Access to the
	 * 'Trabaja con nosotros' page - Check '¿QUÉ OFRECEMOS?' section is displayed
	 * 
	 * Post steps: - Close the browser
	 * 
	 */

	@Test(description = "googleDoSearchAndAccessToPageEmegya")
	public void googleDoSearchAndAccessToPageEmergya(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		isReady(googleMainPage = new GoogleMainPage(driver));

		// Steps to build the stage (Pre steps)

		try {
			// Go to www.google.es
			// Do this search 'www.emergya.es'
			googleMainPage.doSearch("www.emergya.es");

			// Access to 'www.emergya.es'
			emergyaMainPage = googleMainPage.clickOnEmergyaPage();

			// Check that the logo is displayed
			isEmergyaLogoDisplayed();

			// TODO: Remove the following line when you complete the test
			// assertTrue("Developing test", false);

			// Access to the 'Contacto' page

			// Check that Sevilla address is displayed

			// Click on top right slide menu

			// Access to 'Trabaja con nosotros' page

			// Check 'Ofertas de trabajo' title

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "googleDoSearchAndAccessToPageNoTodoCodigo")
	public void googleDoSearchAndAccessToPageNoTodoCodigo(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		isReady(googleMainPage = new GoogleMainPage(driver));

		// Steps to build the stage (Pre steps)

		try {
			// Go to www.google.es
			// Do this search 'www.emergya.es'
			googleMainPage.doSearch("notodocodigo");

			// Access to 'www.emergya.es'
			noTodoCodigoMainPage = googleMainPage.clickOnNoTodoCodigoPage();

			// Check that the logo is displayed
			isNoTodoCodigoDisplayed();

			// TODO: Remove the following line when you complete the test
			// assertTrue("Developing test", false);

			// Access to the 'Contacto' page

			// Check that Sevilla address is displayed

			// Click on top right slide menu

			// Access to 'Trabaja con nosotros' page

			// Check 'Ofertas de trabajo' title

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	// ************************ Methods *************************
	/**
	 * Checks if the search return several results
	 * 
	 * @return true if there are several results and false in the opposite case
	 */
	public boolean checkSeveralResults() {
		String resultClassName = "r";
		List<WebElement> elements = null;
		boolean isSeveral = false;

		driver.wait(By.className(resultClassName), 20);

		if (driver.isElementDisplayed(By.className(resultClassName))) {
			elements = driver.findElements(By.className(resultClassName));

			if (elements.size() > 1) {
				isSeveral = true;
			}
		}

		return isSeveral;
	}

	// ************************ Assertions *************************
	/**
	 * This assertion check if the search return several results
	 */
	public void areSeveralResults() {
		assertTrue("There aren't several results, it should have several results", this.checkSeveralResults());
	}

	/**
	 * This assertion check if logo is displayed
	 */
	public void isLogoDisplayed() {
		if (googleMainPage == null) {
			googleMainPage = new GoogleMainPage(driver);
		}
		assertTrue("The logo isn't displayed, it should be displayed", googleMainPage.isLogoDisplayed());
	}

	/**
	 * This assertion check if search button is displayed
	 */
	public void isSearchButtonDisplayed() {
		if (googleMainPage == null) {
			googleMainPage = new GoogleMainPage(driver);
		}

		/* Check by Name */
		assertTrue("The search button isn't displayed, it should be displayed",
				googleMainPage.isSearchButtonDisplayed());
	}

	/**
	 * This assertion check if luck button is displayed
	 */
	public void isLuckButtonDisplayed() {
		if (googleMainPage == null) {
			googleMainPage = new GoogleMainPage(driver);
		}
		assertTrue("The luck button isn't displayed, it should be displayed", googleMainPage.isLuckButtonDisplayed());
	}

	/**
	 * This assertion check if search field is displayed
	 */
	public void isSearchFieldDisplayed() {
		if (googleMainPage == null) {
			googleMainPage = new GoogleMainPage(driver);
		}
		assertTrue("The search field isn't displayed, it should be displayed", googleMainPage.isSearchFieldDisplayed());
	}

	/**
	 * This assertion check if emergya logo is displayed
	 */
	public void isEmergyaLogoDisplayed() {
		if (emergyaMainPage == null) {
			emergyaMainPage = new EmergyaMainPage(driver);
		}
		assertTrue("The logo isn't displayed, it should be displayed", emergyaMainPage.isEmergyaLogoDisplayed());
	}

	/**
	 * This assertion check if los arcos navbar is displayed
	 */
	public void isLosArcosNavBarDisplayed() {
		if (losArcosMainPage == null) {
			losArcosMainPage = new LosArcosMainPage(driver);
		}
		assertTrue("The navbar isn't displayed, it should be displayed", losArcosMainPage.isLosArcosNavBarDisplayed());
	}

	/**
	 * This assertion check if los arcos accesos is displayed
	 */
	public void isLosArcosAccesosDisplayed() {
		if (losArcosAccesosMainPage == null) {
			losArcosAccesosMainPage = new LosArcosAccesosMainPage(driver);
		}
		assertTrue("Accesos isn't displayed, it should be displayed",
				losArcosAccesosMainPage.isLosArcosAccesosDisplayed());
	}

	/**
	 * This assertion check if los arcos cines is displayed
	 */
	public void isLosArcosCinesDisplayed() {
		if (losArcosCineMainPage == null) {
			losArcosCineMainPage = new LosArcosCineMainPage(driver);
		}
		assertTrue("Cines isn't displayed, it should be displayed", losArcosCineMainPage.isLosArcosCinesDisplayed());
	}

	/**
	 * This assertion check if los arcos noticias is displayed
	 */

	public void isLosArcosNoticiasDisplayed() {

		if (losArcosMainPage == null) {

			losArcosMainPage = new LosArcosMainPage(driver);
		}
		assertTrue("Noticias isn't displayed, it should be displayed", losArcosMainPage.isLosArcosNoticiasDisplayed());

	}

	/**
	 * This assertion check if los arcos tiendas is displayed
	 */
	public void isLosArcosTiendasDisplayed() {

		if (losArcosTiendasMainPage == null) {

			losArcosTiendasMainPage = new LosArcosTiendasMainPage(driver);
		}
		assertTrue("Tiendas isn't displayed, it should be displayed",
				losArcosTiendasMainPage.isLosArcosTiendasDisplayed());

	}

	/**
	 * This assertion check if los arcos deportes is displayed
	 */
	public void isLosArcosDeportesDisplayed() {

		if (losArcosTiendasMainPage == null) {

			losArcosTiendasMainPage = new LosArcosTiendasMainPage(driver);
		}
		assertTrue("Deportes isn't displayed, it should be displayed",
				losArcosTiendasMainPage.isLosArcosDeportesDisplayed());

	}

	/**
	 * This assertion check if notodocodigo header is displayed
	 */
	public void isNoTodoCodigoDisplayed() {

		if (noTodoCodigoMainPage == null) {

			noTodoCodigoMainPage = new NoTodoCodigoMainPage(driver);
		}
		assertTrue("Tiendas isn't displayed, it should be displayed",
				noTodoCodigoMainPage.isNoTodoCodigoPageDisplayed());

	}

}
