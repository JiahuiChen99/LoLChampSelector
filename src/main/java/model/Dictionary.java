package model;

public enum Dictionary {
    WELCOME("GREETING"),
    SAYOUNARA("SAYOUNARA"),
    THANKS("THANKS"),
    RECOMMENDATION_champion_difficulty("RECOMMENDATION_champion_difficulty"),
    CHAMPION_INFO("CHAMPION_INFO"),
    DONT_UNDERSTAND("DONT_UNDERSTAND"),
    STATS("STATS"),
    ITEMS_ROLE("ITEMS_ROLE"),
    INFORMATION_champion_lore("INFORMATION_champion_lore"),
    RECOMMENDATION_champion_role("RECOMMENDATION_champion_role"),
    RECOMMENDATION_item_role("RECOMMENDATION_item_role");
    public final String label;

    Dictionary(String label) {
        this.label = label;
    }
}
