package de.lunarakai.gameofkings.cards;

import de.lunarakai.gameofkings.CardRegistry;
import de.lunarakai.gameofkings.GameOfKings;
import de.lunarakai.gameofkings.cards.boosterpacks.LegendOfTheBlueEyesWhiteDragon;
import de.lunarakai.gameofkings.cards.defaults.lob.BlueEyesWhiteDragon;
import de.lunarakai.gameofkings.cards.defaults.lob.ExodiaTheForbiddenOne;
import de.lunarakai.gameofkings.cards.defaults.lob.PotOfGreed;
import de.lunarakai.gameofkings.utils.KeyUtil;
import de.lunarakai.gameofkings.utils.Rarity;

import java.io.UnsupportedEncodingException;

public record CardRegistration(GameOfKings plugin) {
    public void registerCards() throws UnsupportedEncodingException {


        CardRegistry registry = plugin.getCardRegistry();

        LegendOfTheBlueEyesWhiteDragon lob = new LegendOfTheBlueEyesWhiteDragon(KeyUtil.getBoosterPackKey("lob"));

        //Legend of the Blue-Eyes White Dragon (LOB)
        registry.register(
                lob,
                Rarity.ULTRA_RARE,
                new BlueEyesWhiteDragon(KeyUtil.getBoosterPackKey("lob"), "001")); // 001
        registry.register(
                lob,
                Rarity.RARE,
                new PotOfGreed(KeyUtil.getBoosterPackKey("lob"), "119")); // 119
        registry.register(
                lob,
                Rarity.ULTRA_RARE,
                new ExodiaTheForbiddenOne(KeyUtil.getBoosterPackKey("lob"), "124")); // 124
    }
}
