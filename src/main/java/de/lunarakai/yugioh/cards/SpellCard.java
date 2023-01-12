package de.lunarakai.yugioh.cards;

import de.lunarakai.yugioh.utils.SpellCardTypes;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;

public abstract class SpellCard extends AbstractCard {
    protected SpellCard(@NotNull NamespacedKey key) throws UnsupportedEncodingException {
        super(key);
    }

    protected ItemMeta setSpellCardMeta(ItemMeta cardMeta, SpellCardTypes spellCardType, String cardName, String... cardText) {

        TextComponent textNameComponent = Component.text(cardName)
                .color(NamedTextColor.WHITE).decoration(TextDecoration.BOLD, true);
        cardMeta.displayName(textNameComponent);


        ArrayList<String> lore = new ArrayList<>();

        String spType = "";

        switch (spellCardType) {
            case NORMAL -> spType = "Normal Spell";
            case CONTINUOUS -> spType = "Continuous Spell";
            case FIELD -> spType = "Field Spell";
            case EQUIP -> spType = "Equip Spell";
            case QUICKPLAY -> spType = "Quick-Play Spell";
            case RITUAL -> spType = "Ritual Spell";
        }

        lore.add("\n");

        lore.add(ChatColor.GREEN + "[" + spType + "]");

        Arrays.stream(cardText).toList().forEach(s -> {
            lore.add(ChatColor.GRAY + s);
        });

        cardMeta.setLore(lore);
        return cardMeta;
    }
}
