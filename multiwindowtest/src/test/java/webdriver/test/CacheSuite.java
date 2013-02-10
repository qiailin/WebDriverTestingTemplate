package webdriver.test;

import qa.webdriver.util.MultiWinCacheUtils;
import qa.webdriver.util.SiteServer;

import java.io.File;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * To run suite you need to pass the Gradle '-Dtest.single=SuiteOne' option to the JVM
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({ TestHandleCacheOne.class, TestHandleCacheThree.class, TestHandleCacheThree.class })
public class CacheSuite extends MultiWinCacheUtils {

	@BeforeClass
	public static void setUpSuiteOne() {
		returnLoggerState();
		File httpRoot = new File("build/resources/test");
		logger.info("Server root directory is: " + httpRoot.getAbsolutePath() );
		int httpPort = Integer.parseInt("8080");
		try {
			fs = new SiteServer( httpPort , httpRoot );
		} catch (IOException e) {
			e.printStackTrace();
		}
		initializeStandaloneBrowser( "firefox" );
		logger.info("Finished setUpSuiteOne");
	}

	@AfterClass
	public static void tearDownSuiteOne() {
		closeAllBrowserWindows();  
		logger.info("Finished tearDownSuiteOne");
	}

}
