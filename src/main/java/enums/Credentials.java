package enums;

public enum Credentials {

    USER_WITH_INCORRECT_PASSWORD("user@email.com", "pass"),
    USER_WITH_INCORRECT_EMAIL("user", "pass"),
    USER_WITHOUT_EMAIL("", "pass"),
    USER_WITHOUT_PASSWORD("user@email.com", ""),
    USER_WITH_CORRECT_EMAIL_AND_PASSWORD("correct_user@gm.com", "qwerty12345");

    String email;

    public String getEmail() {
        return email;
    }

    public String getPass() {
        return pass;
    }

    String pass;

    Credentials(String email) {
        this.email = email;
    }

    Credentials(String email, String pass) {
        this(email);
        this.pass = pass;
    }

}
