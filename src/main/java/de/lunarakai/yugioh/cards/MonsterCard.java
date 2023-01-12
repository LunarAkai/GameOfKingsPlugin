package de.lunarakai.yugioh.cards;

import de.lunarakai.yugioh.utils.Attributes;
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

public abstract class MonsterCard extends AbstractCard{
    protected MonsterCard(@NotNull NamespacedKey key) throws UnsupportedEncodingException {
        super(key);
    }

    protected ItemMeta setMonsterCardMeta(ItemMeta cardMeta, int level, Attributes attribute,
                                          String typing, int atk, int def, String cardName, String... cardText) {
        TextComponent textNameComponent = Component.text(cardName)
                .color(NamedTextColor.WHITE).decoration(TextDecoration.BOLD, true);
        cardMeta.displayName(textNameComponent);

        ArrayList<String> lore = new ArrayList<>();
        StringBuilder levelStr = new StringBuilder();

        for(int i = 0; i < level; i++) {
            levelStr.append("(*)");
        }
        lore.add(ChatColor.GOLD + levelStr.toString());

        switch (attribute) {
            case LIGHT -> lore.add(ChatColor.YELLOW + "Light");
            case DARK -> lore.add(ChatColor.DARK_PURPLE + "Dark");
            case FIRE -> lore.add(ChatColor.RED + "Fire");
            case EARTH -> lore.add(ChatColor.BLACK + "Earth");
            case WATER -> lore.add(ChatColor.AQUA + "Water");
            case WIND -> lore.add(ChatColor.DARK_BLUE + "Wind");
            case DIVINE -> lore.add(ChatColor.GOLD + "Divine");
        }
        lore.add("\n"); //Empty Line for better readability

        lore.add(ChatColor.WHITE + "[" + typing + "]");

        Arrays.stream(cardText).toList().forEach(s -> {
            lore.add(ChatColor.GRAY + s);
        });

        lore.add(ChatColor.WHITE + "ATK/" + atk + " DEF/" + def);


        cardMeta.setLore(lore);
        return cardMeta;
    }


}
