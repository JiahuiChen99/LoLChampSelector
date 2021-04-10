package model;

public enum Dictionary {
    GREETING("GREETING"),
    SAYOUNARA("SAYOUNARA"),
    THANKS("THANKS"),
    DIFFICULTY("DIFFICULTY"),
    CHAMPION_INFO("CHAMPION_INFO"),
    DONT_UNDERSTAND("DONT_UNDERSTAND"),
    STATS("STATS"),
    ITEMS_ROLE("ITEMS_ROLE"),
    ROLE("ROLE");

    public final String label;

    Dictionary(String label) {
        this.label = label;
    }
}
