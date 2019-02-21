package dataProviders;

import base.TestNGBase;
import org.testng.annotations.DataProvider;

import static enums.Credentials.*;
import static enums.SubjectsForContactForm.CUSTOMER_SERVICE;
import static enums.SubjectsForContactForm.EMPTY;
import static enums.SubjectsForContactForm.WEBMASTER;
import static enums.UsersForSignIn.*;

public class DataProviders extends TestNGBase {

    @DataProvider
    public Object[][] usernamesAndPasswords() {
        return new Object[][] {
                {USER_WITHOUT_EMAIL},
                {USER_WITH_INCORRECT_EMAIL},
                {USER_WITH_INCORRECT_PASSWORD},
                {USER_WITHOUT_PASSWORD}
        };
    }

    @DataProvider
    public Object[][] textsForSearching() {
        return new Object[][]{
                {"T-shirt"},
                {"Dress"},
                {"Faded"}
        };
    }

    @DataProvider
    public Object[][] usersForSignInWithErrors() {
        return new  Object[][]{
                {USER_ERROR_1},
                {USER_ERROR_2},
                {USER_ERROR_3},
                {USER_ERROR_4}
        };
    }

    @DataProvider
    public Object[][] dataForContactForm() {
        return new Object[][] {
                {WEBMASTER, "eee@", "test", "testMessage"},
                {CUSTOMER_SERVICE, "e", "test", "testMessage"},
                {WEBMASTER,"eee@gmail.ru", "test", "testMessage"},
                {CUSTOMER_SERVICE, "eee@gmail.ru", "test", ""},
                {CUSTOMER_SERVICE, "eee@gmail.ru", "", ""},
                {EMPTY, "eee@gmail.ru", "", "testMessage"},
        };
    }
}
//String email, String ref, String message