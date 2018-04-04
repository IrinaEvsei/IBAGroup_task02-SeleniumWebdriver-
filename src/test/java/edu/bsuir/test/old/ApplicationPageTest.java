package edu.bsuir.test.old;

import edu.bsuir.driver.WebDriverSingleton;
import edu.bsuir.pages.ApplicationPage;
import org.junit.After;
import org.junit.Test;

public class ApplicationPageTest {
    ApplicationPage applicationPage = new ApplicationPage();

    @Test
    public void createApplication() throws Exception {
        applicationPage.application();

    }

    @After
    public void closeTest() {
        WebDriverSingleton.destroyInstance();
    }
}
