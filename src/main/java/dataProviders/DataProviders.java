package dataProviders;

import base.TestNGBase;
import org.testng.annotations.DataProvider;

import static enums.Credentials.*;
import static enums.UsersForSignIn.USER_1;

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
    public Object[][] usersForSignIn() {
        return new  Object[][]{
                {USER_1}
        };
    }
}
