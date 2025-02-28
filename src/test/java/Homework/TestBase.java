package Homework;

import Homework.manager.AppManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class TestBase {

    protected static final AppManager app = new AppManager();

        @BeforeMethod
        public void setUp() {
            app.init();
        }

        @AfterMethod
        public void tearDown() {
            app.stop();
        }
    }


