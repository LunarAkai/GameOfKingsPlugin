package de.lunarakai.gameofkings.cards;

import de.lunarakai.gameofkings.GameOfKings;
import de.lunarakai.gameofkings.utils.Rarity;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.ChatColor;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

public abstract class AbstractBoosterPack implements Keyed {

    public static final NamespacedKey PACK_ID = new NamespacedKey(GameOfKings.getPlugin(), "yugioh_pack");
    private final NamespacedKey key;
    protected final ItemStack itemStack;

    protected AbstractBoosterPack(@NotNull NamespacedKey key) {
        this.key = Objects.requireNonNull(key, "Key must not be null");
        this.itemStack = initItemStack(Objects.requireNonNull(createItemStack(), "ItemStack must not be null"));
    }

    public abstract String getBoosterPackKey();

    protected abstract ItemStack createItemStack();

    public abstract void addToCardList(AbstractCard card, Rarity rarity);

    public abstract Map<AbstractCard, Rarity> getCardList();

    private void applyToPersistentDataContainer(PersistentDataContainer container) {
        container.set(PACK_ID, PersistentDataType.STRING, getKey().toString());
    }

    private ItemStack initItemStack(ItemStack itemStack) {
        ItemMeta meta = itemStack.getItemMeta();
        if (meta != null) {
            this.applyToPersistentDataContainer(meta.getPersistentDataContainer());
            itemStack.setItemMeta(meta);
        }
        return itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack.clone();
    }

    @Override
    public @NotNull NamespacedKey getKey() {
        return key;
    }

    protected ItemMeta setBoosterPackMeta(ItemMeta boosterMeta, String boosterPackName) {

        TextComponent textNameComponent = Component.text(boosterPackName)
                .color(NamedTextColor.GOLD).decoration(TextDecoration.BOLD, true);
        boosterMeta.displayName(textNameComponent);

        ArrayList<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "A Yu-Gi-Oh! Booster Pack.");
        lore.add(ChatColor.WHITE + "Right-Click to open.");

        boosterMeta.setLore(lore);
        return boosterMeta;
    }
}
