package enums;

public enum Credentials {

    USER_WITH_INCORRECT_PASSWORD("user@email.com", "pass"),
    USER_WITH_INCORRECT_EMAIL("user", "pass"),
    USER_WITHOUT_EMAIL("", "pass"),
    USER_WITHOUT_PASSWORD("user@email.com", ""),
    USER_WITH_CORRECT_EMAIL_AND_PASSWORD("testAQA@epam.ru", "qwerty12345", "Cool", "Guy"),
    NEW_USER("1111testAQA@epam.ru");


    String email;
    String firstName;
    String lastName;
    String pass;

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    Credentials(String email) {
        this.email = email;
    }

    Credentials(String email, String pass) {
        this(email);
        this.pass = pass;
    }

    Credentials(String email, String pass, String firstName, String lastName) {
        this(email,pass);
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
