package enums;

public enum UsersForSignIn {

    USER_ERROR_1("Mr.", "", "", "", "", "", "", "", ""),
    USER_ERROR_2("Mrs.", "1", "2", "12345", "address", "city", "Alaska", "aaaaa", ""),
    USER_ERROR_3("Mrs.", "test", "user", "1235", "address", "city", "", "aaaaa", ""),
    USER_ERROR_4("Mrs.", "test", "user", "", "address", "city", "-", "09786", "12345"),
    USER_WITHOUT_ERRORS("Mr.", "Test", "User", "12345", "My address", "My City", "Alaska", "09786", "89994443334");

    String title;
    String fName;
    String lName;
    String passwd;
    String address;
    String city;
    String state;
    String zip;
    String mobile;

    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getTitle() {
        return title;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getMobile() {
        return mobile;
    }

    UsersForSignIn(String title, String fName, String lName, String passwd, String address, String city, String state,
                   String zip, String mobile) {
        this.title = title;
        this.fName = fName;
        this.lName = lName;
        this.passwd = passwd;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.mobile = mobile;
    }
}
