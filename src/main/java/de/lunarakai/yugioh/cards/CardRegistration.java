package de.lunarakai.yugioh.cards;

import de.lunarakai.yugioh.CardRegistry;
import de.lunarakai.yugioh.Yugioh;
import de.lunarakai.yugioh.cards.boosterpacks.LegendOfTheBlueEyesWhiteDragon;
import de.lunarakai.yugioh.cards.defaults.lob.BlueEyesWhiteDragon;
import de.lunarakai.yugioh.cards.defaults.lob.ExodiaTheForbiddenOne;
import de.lunarakai.yugioh.cards.defaults.lob.PotOfGreed;
import de.lunarakai.yugioh.utils.KeyUtil;
import de.lunarakai.yugioh.utils.Rarity;

import java.io.UnsupportedEncodingException;

public record CardRegistration(Yugioh plugin) {
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
