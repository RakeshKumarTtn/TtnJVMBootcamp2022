package enums;

public enum AccountType {
    CURRENT("Current"), SAVINGS("Savings");

    public final String status;

    AccountType(final String state) {
        this.status = state;
    }
}
