package model;

public enum Dictionary {
    GREETING("GREETING"),
    SAYOUNARA("SAYOUNARA"),
    THANKS("THANKS"),
    DIFFICULTY("DIFFICULTY"),
    CHAMPION_INFO("CHAMPION_INFO"),
    DONT_UNDERSTAND("DONT_UNDERSTAND"),
    STATS("STATS");

    public final String label;

    Dictionary(String label) {
        this.label = label;
    }
}
