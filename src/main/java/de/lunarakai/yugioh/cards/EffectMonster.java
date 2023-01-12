package de.lunarakai.yugioh.cards;

import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

import java.io.UnsupportedEncodingException;

public abstract class EffectMonster extends MonsterCard {
    protected EffectMonster(@NotNull NamespacedKey key) throws UnsupportedEncodingException {
        super(key);
    }
}
