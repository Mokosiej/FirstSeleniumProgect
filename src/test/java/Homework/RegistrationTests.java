package Homework;

import Homework.models.Contact;
import Homework.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.getUserHelper().isLoggedIn()) {
            app.getUserHelper().logout();
        }
    }
    @AfterMethod
    public void tearDown() {
        if (app.getUserHelper().isLoggedIn()) {
            app.getUserHelper().logout();
        }
    }


    @Test(dataProvider = "registrationData", dataProviderClass = DataProviders.class)
    public void registerNewUserTest(Contact contact) {
        app.getUserHelper().openRegistrationForm();
        app.getUserHelper().fillRegistrationForm(contact);
        app.getUserHelper().submitRegistration();

        Assert.assertFalse(app.getUserHelper().isRegisteredSuccessfully(),
                "Ошибка: Пользователь не зарегистрирован!");
    }


}

