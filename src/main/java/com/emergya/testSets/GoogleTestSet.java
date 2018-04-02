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

import com.emergya.pageObjects.CheckBoxMainPage;
import com.emergya.pageObjects.EmergyaMainPage;
import com.emergya.pageObjects.GoogleMainPage;
import com.emergya.pageObjects.JQueryControlGroupMainPage;
import com.emergya.pageObjects.JQueryProgressBarMainPage;
import com.emergya.pageObjects.JQuerySelectMenu;
import com.emergya.pageObjects.JQueryToolTipMainPage;
import com.emergya.pageObjects.LosArcosCineMainPage;
import com.emergya.pageObjects.LosArcosMainPage;
import com.emergya.pageObjects.LosArcosTiendasMainPage;
import com.emergya.pageObjects.NoTodoCodigoMainPage;
import com.emergya.pageObjects.StackOverFlowMainPage;
import com.emergya.pageObjects.TestingAlertsMainPage;
import com.emergya.pageObjects.TestingMainPage;
import com.emergya.pageObjects.TestingSliderMainPage;
import com.emergya.pageObjects.UploadImageMainPage;
import com.emergya.pageObjects.WidgetColorMainPage;
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
			// Do this search 'www.notodocodigo.com'
			googleMainPage.doSearch("notodocodigo");

			// Access to 'www.notodocodigo.com'
			noTodoCodigoMainPage = googleMainPage.clickOnNoTodoCodigoPage();

			// Check that the logo is displayed
			isNoTodoCodigoDisplayed();
			isNoTodoCodigoBuscarDisplayed();

			noTodoCodigoMainPage.doSearchNoTodoCodigo("maven");

			// assertTrue("Developing test", false);

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "googleDoSearchAndAccessToPageUploadImage")
	public void googleDoSearchAndAccessToPageUploadImage(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		isReady(googleMainPage = new GoogleMainPage(driver));

		// Steps to build the stage (Pre steps)

		try {
			// Go to www.google.es
			// Do this search 'zamzar'
			googleMainPage.doSearch("zamzar");

			// Access to 'zamzar.com'
			uploadImageMainPage = googleMainPage.clickOnUploadImagePage();

			// Check that the logo Demos is displayed
			isUploadeImageLogoDisplayed();

			uploadImageMainPage.clickOnUploadFiles();

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// driver.wait(5);

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "googleDoSearchAndAccessToPageStackOverFlow")
	public void googleDoSearchAndAccessToPageStackOverFlow(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		// Variable declaration and definition
		isReady(googleMainPage = new GoogleMainPage(driver));

		// Steps to build the stage (Pre steps)

		try {
			// Go to www.google.es
			// Do this search 'Stackoverflow'
			googleMainPage.doSearch("Stackoverflow");

			// Access to 'stackoverflow.com'
			stackOverFlowMainPage = googleMainPage.clickOnStackOverFlowPage();

			// Check that the logo Demos is displayed
			isStackoverflowImageLogoDisplayed();

			isStackOverFlowLabelsDisplayed();

			stackOverFlowMainPage.registerStackOverFLow("FranPina", "juanitpprueba@yopmail.com", "12341234f");

			// stackOverFlowMainPage.searchInPageRobot();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "googleDoSearchAndAccessToPageTesting")
	public void googleDoSearchAndAccessToPageTesting(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("http://demo.automationtesting.in/Register.html");
			// Check that the logo TestingPage is displayed
			isTestingPageLogo();
			// testingMainPage.dragAndDrop();
			testingMainPage.doAll();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "googleDoSearchAndAccessToPageTestingAlerts")
	public void googleDoSearchAndAccessToPageTestingAlerts(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("http://demo.automationtesting.in/Alerts.html");
			// Check that the logo TestingPage alert is displayed

			isTestingAlertsPageLogo();
			testingAlertsMainPage.clickOnButtonAlertOk();
			// testingAlertsMainPage.clickOnAlertTextbox();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "moveToSliderTesting")
	public void moveToSliderTesting(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("http://demo.automationtesting.in/Slider.html");
			// Check that the logo TestingPage alert is displayed
			isTestingSliderPageLogo();
			testingSliderMainPage.moveToSlider();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "AccesToPageDragDropTest")
	public void AccesToPageDragDropTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("https://jqueryui.com/draggable/");
			// Check that the logo TestingPage alert is displayed

			isTestingDragDrop();
			testingMainPage.dragTheItemByActions();

		} catch (InterruptedException e) {
			System.err.println("excepcion de dragdrop");
			e.printStackTrace();
		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "AccesToPageResizableTest")
	public void AccesToPageResizableTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("https://jqueryui.com/resizable/");
			// Check that the logo TestingPage alert is displayed

			isTestingResizable();
			testingMainPage.resizableItemByActions();

		} catch (InterruptedException e) {
			System.err.println("excepcion de AccesToPageResizableTest");
			e.printStackTrace();
		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "AccesToPageDropableTest")
	public void AccesToPageDropableTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("https://jqueryui.com/droppable/");
			// Check that the logo TestingPage alert is displayed

			isTestingDropapable();
			testingMainPage.droppableItemByActions();

		} catch (InterruptedException e) {
			System.err.println("excepcion de AccesToPageDropableTest");
			e.printStackTrace();
		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "AccesToPageControlGroupTest")
	public void AccesToPageControlGroupTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("https://jqueryui.com/controlgroup/");
			// Check that the logo JQUERY alert is displayed

			isJQueryLogoVisible();
			jQueryControlGroupMainPage.clickOnArrowUp();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "AccesToPageSelectMenu")
	public void AccesToPageSelectMenu(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("https://jqueryui.com/selectmenu/");
			// Check that the logo JQUERY alert is displayed

			isJQuerySelectMenuLogoVisible();
			jQuerySelectMenu.clickAndSelectSpeed();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "AccesToPageCheckbox")
	public void AccesToPageCheckbox(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("https://jqueryui.com/checkboxradio/");
			// Check that the logo JQUERY is displayed

			isJQueryCheckboxLogoVisible();
			checkBoxMainPage.checkParis();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "ProgressBarTest")
	public void ProgressBarTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("https://jqueryui.com/progressbar/#indeterminate");
			// Check that the logo JQUERY is displayed

			isJQueryProgressBarLogoVisible();
			jQueryProgressBarMainPage.evaluateProgressBar();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "ColorBarTest")
	public void ColorBarTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("https://jqueryui.com/progressbar/#indeterminate");
			// Check that the logo JQUERY is displayed

			isJQueryProgressBarLogoVisible();
			jQueryProgressBarMainPage.randomColor();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "toolTipTest")
	public void toolTipTest(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			driver.get("http://jqueryui.com/tooltip/");
			// Check that the logo JQUERY is displayed

			isJQueryToolTipLogoVisible();
			jQueryToolTipMainPage.moveCopyAndPaste();

		} finally {
			// Steps to clear the stage (Post steps)
		}

		log.info("[log-TestSet] " + this.getClass().getName() + " - End test method: " + method.getName());
	}

	@Test(description = "controlChangeColor")
	public void controlChangeColor(Method method) {
		log.info("[log-TestSet] " + this.getClass().getName() + " - Start test method: " + method.getName());

		try {

			// go to url
			driver.get("http://jqueryui.com/widget/");
			
			// Check that the logo JQUERY is displayed
			isWidgetColorLogoVisible();
			widgetColorMainPage.doAll();

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
		assertTrue("NoTodoCodigo isn't displayed, it should be displayed",
				noTodoCodigoMainPage.isNoTodoCodigoPageDisplayed());

	}

	/**
	 * This assertion check if notodocodigo buscar field is displayed
	 */
	public void isNoTodoCodigoBuscarDisplayed() {

		if (noTodoCodigoMainPage == null) {

			noTodoCodigoMainPage = new NoTodoCodigoMainPage(driver);
		}
		assertTrue("Field Buscar isn't displayed, it should be displayed",
				noTodoCodigoMainPage.isNoTodoCodigoBuscarDisplayed());

	}

	/**
	 * This assertion check if fineuploader page logo is displayed
	 */
	public void isUploadeImageLogoDisplayed() {

		if (uploadImageMainPage == null) {

			uploadImageMainPage = new UploadImageMainPage(driver);
		}
		assertTrue("Logo Demo isn't displayed, it should be displayed",
				uploadImageMainPage.isUploadImagePageDisplayed());

	}

	/**
	 * This assertion check if stackoverflow page logo is displayed
	 */
	public void isStackoverflowImageLogoDisplayed() {

		if (stackOverFlowMainPage == null) {

			stackOverFlowMainPage = new StackOverFlowMainPage(driver);
		}
		assertTrue("Logo StackOverFlow isn't displayed, it should be displayed",
				stackOverFlowMainPage.isStackOverFlowPageDisplayed());

	}

	/**
	 * This assertion check if stackoverflow labels name,email and password are
	 * displayed
	 */
	public void isStackOverFlowLabelsDisplayed() {

		if (stackOverFlowMainPage == null) {

			stackOverFlowMainPage = new StackOverFlowMainPage(driver);
		}
		assertTrue("Logo StackOverFlow isn't displayed, it should be displayed",
				stackOverFlowMainPage.isStackOverFlowLabelsDisplayed());

	}

	/**
	 * This assertion check if TestingPage logo are displayed
	 */
	public void isTestingPageLogo() {

		if (testingMainPage == null) {

			testingMainPage = new TestingMainPage(driver);
		}
		assertTrue("Logo testingMainPage isn't displayed, it should be displayed",
				testingMainPage.isTestingPageDisplayed());

	}

	/**
	 * This assertion check if TestingPage logo are displayed
	 */
	public void isTestingAlertsPageLogo() {

		if (testingAlertsMainPage == null) {

			testingAlertsMainPage = new TestingAlertsMainPage(driver);
		}
		assertTrue("Logo testingAlertsMainPage isn't displayed, it should be displayed",
				testingAlertsMainPage.isTestingAlertsPageDisplayed());

	}

	/**
	 * This assertion check if TestingPage logo are displayed
	 */
	public void isTestingSliderPageLogo() {

		if (testingSliderMainPage == null) {

			testingSliderMainPage = new TestingSliderMainPage(driver);
		}
		assertTrue("Logo testingAlertsMainPage isn't displayed, it should be displayed",
				testingSliderMainPage.isTestingSliderPageDisplayed());

	}

	/**
	 * This assertion check if TestingPage logo are displayed
	 */
	public void isTestingDragDrop() {

		if (testingMainPage == null) {

			testingMainPage = new TestingMainPage(driver);
		}
		assertTrue("Logo testingMainPage isn't displayed, it should be displayed",
				testingMainPage.isTestingPageDisplayed());

	}

	/**
	 * This assertion check if TestingPage logo are displayed
	 */
	public void isTestingResizable() {

		if (testingMainPage == null) {

			testingMainPage = new TestingMainPage(driver);
		}
		assertTrue("Logo testingMainPage isn't displayed, it should be displayed",
				testingMainPage.isTestingPageDisplayed());

	}

	/**
	 * This assertion check if TestingPage logo are displayed
	 */
	public void isTestingDropapable() {

		if (testingMainPage == null) {

			testingMainPage = new TestingMainPage(driver);
		}
		assertTrue("Logo isTestingDropapable isn't displayed, it should be displayed",
				testingMainPage.isTestingPageDisplayed());

	}

	/**
	 * This assertion check if JQuery logo are displayed
	 */
	public void isJQueryLogoVisible() {

		if (jQueryControlGroupMainPage == null) {

			jQueryControlGroupMainPage = new JQueryControlGroupMainPage(driver);
		}
		assertTrue("Logo isJQueryLogoVisible isn't displayed, it should be displayed",
				jQueryControlGroupMainPage.isJQueryLogoControlGroupDisplayed());

	}

	/**
	 * This assertion check if JQuery logo are displayed
	 */
	public void isJQuerySelectMenuLogoVisible() {

		if (jQuerySelectMenu == null) {

			jQuerySelectMenu = new JQuerySelectMenu(driver);
		}
		assertTrue("Logo isJQuerySelectMenuLogoVisible isn't displayed, it should be displayed",
				jQuerySelectMenu.isJQueryLogoSelectMenuDisplayed());

	}

	/**
	 * This assertion check if JQuery logo are displayed
	 */
	public void isJQueryCheckboxLogoVisible() {

		if (checkBoxMainPage == null) {

			checkBoxMainPage = new CheckBoxMainPage(driver);
		}
		assertTrue("Logo isJQuerySelectMenuLogoVisible isn't displayed, it should be displayed",
				checkBoxMainPage.isReadyLogoCheckbox());

	}

	/**
	 * This assertion check if JQuery logo are displayed
	 */
	public void isJQueryProgressBarLogoVisible() {

		if (jQueryProgressBarMainPage == null) {

			jQueryProgressBarMainPage = new JQueryProgressBarMainPage(driver);
		}
		assertTrue("Logo isJQueryProgressBarLogoVisible isn't displayed, it should be displayed",
				jQueryProgressBarMainPage.isReadyLogoProgressBar());

	}

	/**
	 * This assertion check if JQuery logo are displayed
	 */
	public void isJQueryToolTipLogoVisible() {

		if (jQueryToolTipMainPage == null) {

			jQueryToolTipMainPage = new JQueryToolTipMainPage(driver);
		}
		assertTrue("Logo isJQueryToolTipLogoVisible isn't displayed, it should be displayed",
				jQueryToolTipMainPage.isReadyLogoToolTip());

	}

	/**
	 * This assertion check if JQuery logo are displayed
	 */
	public void isWidgetColorLogoVisible() {

		if (widgetColorMainPage == null) {

			widgetColorMainPage = new WidgetColorMainPage(driver);
		}
		assertTrue("Logo isWidgetColorLogoVisible isn't displayed, it should be displayed",
				widgetColorMainPage.isReadyWidgetColorLogo());

	}

}
