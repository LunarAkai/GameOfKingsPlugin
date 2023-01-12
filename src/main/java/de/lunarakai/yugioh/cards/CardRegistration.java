package de.lunarakai.yugioh.cards;

import de.lunarakai.yugioh.CardRegistry;
import de.lunarakai.yugioh.Yugioh;
import de.lunarakai.yugioh.cards.boosterpacks.LegendOfTheBlueEyesWhiteDragon;
import de.lunarakai.yugioh.cards.defaults.lob.BlueEyesWhiteDragon;
import de.lunarakai.yugioh.cards.defaults.lob.ExodiaTheForbiddenOne;
import de.lunarakai.yugioh.cards.defaults.lob.PotOfGreed;
import de.lunarakai.yugioh.utils.Rarity;

import java.io.UnsupportedEncodingException;

public record CardRegistration(Yugioh plugin) {
    public void registerCards() throws UnsupportedEncodingException {
        CardRegistry registry = plugin.getCardRegistry();

        //Legend of the Blue-Eyes White Dragon (LOB)
        registry.register(new LegendOfTheBlueEyesWhiteDragon(), Rarity.ULTRA_RARE, new BlueEyesWhiteDragon()); // 001
        registry.register(new LegendOfTheBlueEyesWhiteDragon(), Rarity.RARE, new PotOfGreed()); // 119
        registry.register(new LegendOfTheBlueEyesWhiteDragon(), Rarity.ULTRA_RARE, new ExodiaTheForbiddenOne()); // 124
    }
}
