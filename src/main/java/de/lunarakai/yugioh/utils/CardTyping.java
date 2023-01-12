package de.lunarakai.yugioh.utils;

public enum CardTyping {

    SPELLCASTER("Spellcaster"),
    AQUA("Aqua"),
    Beast("Beast"),
    BEASTWARRIOR("Beast-Warrior"),
    CYBERSE("Cyberse"),
    DINOSAUR("Dinosaur"),
    DIVINEBEAST("Divine-Beast"),
    DRAGON("Dragon"),
    FAIRY("Fairy"),
    FIEND("Fiend"),
    FISH("Fish");




    private final String cardTyping;


    CardTyping(String cardTyping) {
        this.cardTyping = cardTyping;
    }

    public String getTyping() {
        return cardTyping;
    }
}
