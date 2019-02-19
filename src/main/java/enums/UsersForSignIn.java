package enums;

public enum UsersForSignIn {

    USER_1("Mr", "Art", "Berd", "12345", "testAdsress", "cicity", "Alaska", "00001", "89133234423");

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
