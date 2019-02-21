package enums;

public enum SubjectsForContactForm {

    CUSTOMER_SERVICE("Customer service"),
    WEBMASTER("Webmaster"),
    EMPTY("-- Choose --");

    String name;

    public String getName() {
        return name;
    }

    SubjectsForContactForm(String name) {
        this.name = name;
    }
}
