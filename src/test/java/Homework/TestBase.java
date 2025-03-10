package Homework;

import Homework.manager.AppManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;


public class TestBase {

    protected static  AppManager app = new AppManager(
            System.getProperty("browser", Browser.CHROME.browserName()));


    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void startTest(Method method) {
        logger.info("Start test " + method.getName());
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName() );
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName());
        }
        logger.info("Stop test");
        logger.info("**********************************************************");
    }

    @BeforeMethod
        public void setUp() {
            app.init();
        }

        @AfterMethod
        public void tearDown() {
            app.stop();
        }
    }


