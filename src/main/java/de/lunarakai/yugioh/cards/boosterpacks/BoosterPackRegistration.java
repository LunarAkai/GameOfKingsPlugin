package de.lunarakai.yugioh.cards.boosterpacks;

import de.lunarakai.yugioh.BoosterPackRegistry;
import de.lunarakai.yugioh.Yugioh;

public record BoosterPackRegistration(Yugioh plugin) {

    public void registerBoosterPacks() {
        BoosterPackRegistry registry = plugin.getBoosterPackRegistry();

        registry.register(new LegendOfTheBlueEyesWhiteDragon()); //LOB
    }
}
