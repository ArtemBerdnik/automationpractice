package dataProviders;

import base.TestNGBase;
import org.testng.annotations.DataProvider;

import static enums.Credentials.*;
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
}
