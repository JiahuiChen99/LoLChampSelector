package model;

public enum Dictionary {
    DIFFICULTY("DIFFICULTY"),
    CHAMPION_INFO("CHAMPION_INFO"),
    GREETING("GEETING"),
    SAYOUNARA("SAYOUNARA");

    public final String label;

    Dictionary(String label) {
        this.label = label;
    }
}
