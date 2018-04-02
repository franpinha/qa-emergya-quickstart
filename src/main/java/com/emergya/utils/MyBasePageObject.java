package com.emergya.utils;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.log4j.Logger;

public  class MyBasePageObject {
	
	/**
	 * Logger class initialization.
	 */
	static Logger log = Logger.getLogger(MyBasePageObject.class);
	/**
	    * This method will set any parameter string to the system's clipboard
	    * @param string is the path of the file
	    */
	   private void setClipboardData(String string) {
	       log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - Start setClipboardData method");

	       StringSelection stringSelection = new StringSelection(string);
	       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);

	       log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End setClipboardData method");
	   }
	   
	   
	   /**
	    * Upload a image
	    */
	public void uploadArchive(String imageFile) {
	       log.info("[log-pageObjects]" + this.getClass().getSimpleName() + "]- Start uploadArchive method");

	       File auxfile = new File("src/main/resources/files/" + imageFile);
	       String fileName = auxfile.getAbsolutePath();

	       try {
	           log.info("Uploading the image " + imageFile);
	           // Setting clipboard with file location
	           setClipboardData(fileName);

	           // Some sleep time to detect the window popup
	           Thread.sleep(500);

	           Robot robot = new Robot();

	           // Delete the default string
	           robot.keyPress(KeyEvent.VK_SHIFT);
	           robot.keyPress(KeyEvent.VK_END);
	           robot.keyRelease(KeyEvent.VK_SHIFT);
	           robot.keyRelease(KeyEvent.VK_END);
	           robot.keyPress(KeyEvent.VK_BACK_SPACE);
	           robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	           

	           // Copy the path to the window popup
	           robot.keyPress(KeyEvent.VK_CONTROL);
	           robot.keyPress(KeyEvent.VK_V);
	           robot.keyRelease(KeyEvent.VK_V);
	           robot.keyRelease(KeyEvent.VK_CONTROL);
	           Thread.sleep(2000);

	           // Press enter to execute a file search
	           robot.keyPress(KeyEvent.VK_ENTER);
	           robot.keyRelease(KeyEvent.VK_ENTER);
	           robot.delay(500);

	       } catch (Exception exp) {
	           exp.printStackTrace();
	       }

	       log.info("[log-PageObjects] " + this.getClass().getSimpleName() + " - End uploadArchive method");
	   }

}
