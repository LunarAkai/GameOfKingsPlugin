package de.lunarakai.yugioh.utils;

public enum ExtraDeckType {
    NONE(""),
    FUSION("Fusion"),
    SYNCHRO("Synchro"),
    XYZ("Xyz"),
    LINK("Link");


    private final String extraDeckType;


    ExtraDeckType(String cardExtraDeckType) {
        this.extraDeckType = cardExtraDeckType;
    }

    public String getExtraDeckType() {
        return extraDeckType;
    }
}
