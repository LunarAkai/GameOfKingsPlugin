package de.lunarakai.yugioh;

import com.google.common.base.Preconditions;
import de.lunarakai.yugioh.cards.AbstractBoosterPack;
import de.lunarakai.yugioh.cards.AbstractCard;
import de.lunarakai.yugioh.utils.Rarity;
import org.bukkit.NamespacedKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CardRegistry {

    private final Map<NamespacedKey, AbstractCard> cardMap;
    private final Yugioh plugin;

    CardRegistry(Yugioh plugin) {
        this.cardMap = new HashMap<>();
        this.plugin = plugin;
    }

    public void register(AbstractBoosterPack boosterPack, Rarity rarity, AbstractCard card) {
        Preconditions.checkArgument(boosterPack != null, "Booster Pack can't be null");
        Preconditions.checkArgument(rarity != null, "Rarity can't be null");
        boosterPack.addToCardList(card, rarity);
        Preconditions.checkArgument(card != null, "Card can't be null!");
        NamespacedKey key = card.getKey();
        Preconditions.checkArgument(!cardMap.containsKey(key), "A card with the key " + key + " has already been registered");
        cardMap.put(key, card);
    }

    public AbstractCard get(NamespacedKey key) {
        return cardMap.get(key);
    }

    public List<NamespacedKey> getKeys() {
        return List.copyOf(cardMap.keySet());
    }
}
