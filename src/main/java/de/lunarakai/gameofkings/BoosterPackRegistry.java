package de.lunarakai.gameofkings;

import com.google.common.base.Preconditions;
import de.lunarakai.gameofkings.cards.AbstractBoosterPack;
import org.bukkit.NamespacedKey;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoosterPackRegistry {
    private final Map<NamespacedKey, AbstractBoosterPack> boosterPackMap;
    private final GameOfKings plugin;

    BoosterPackRegistry(GameOfKings plugin) {
        this.boosterPackMap = new HashMap<>();
        this.plugin = plugin;
    }

    public void register(AbstractBoosterPack boosterPack) {
        Preconditions.checkArgument(boosterPack != null, "Booster Pack can't be null");
        NamespacedKey key = boosterPack.getKey();
        Preconditions.checkArgument(!boosterPackMap.containsKey(key), "A Booster pack with the key " + key + " has already been registered");
        boosterPackMap.put(key, boosterPack);
    }

    public AbstractBoosterPack get(NamespacedKey key) {
        return boosterPackMap.get(key);
    }

    public List<NamespacedKey> getKeys() {
        return List.copyOf(boosterPackMap.keySet());
    }

}
