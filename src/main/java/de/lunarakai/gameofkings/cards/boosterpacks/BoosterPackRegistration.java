package de.lunarakai.gameofkings.cards.boosterpacks;

import de.lunarakai.gameofkings.BoosterPackRegistry;
import de.lunarakai.gameofkings.GameOfKings;
import de.lunarakai.gameofkings.utils.KeyUtil;


public record BoosterPackRegistration(GameOfKings plugin) {

    public void registerBoosterPacks() {
        BoosterPackRegistry registry = plugin.getBoosterPackRegistry();

        registry.register(new LegendOfTheBlueEyesWhiteDragon(KeyUtil.getBoosterPackKey("lob"))); //LOB
    }
}
