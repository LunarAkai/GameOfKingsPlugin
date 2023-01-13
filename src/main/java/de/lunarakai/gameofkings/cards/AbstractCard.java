package de.lunarakai.gameofkings.cards;

import de.lunarakai.gameofkings.GameOfKings;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

public abstract class AbstractCard {

    public static final NamespacedKey CARD_ID = new NamespacedKey(GameOfKings.getPlugin(), "yugioh_card");
    private final String boosterKey;
    private final String cardKey;
    protected final ItemStack itemStack;

    protected AbstractCard(String keyBooster, String keyCard) throws UnsupportedEncodingException {
        this.boosterKey = Objects.requireNonNull(keyBooster, "Booster Key must not be null");
        this.cardKey = Objects.requireNonNull(keyCard, "Card Key must not be null");
        this.itemStack = initItemStack(Objects.requireNonNull(createItemStack(), "ItemStack must not be null"));
    }

    protected abstract ItemStack createItemStack() throws UnsupportedEncodingException;

    private void applyToPersistentDataContainer(PersistentDataContainer container) {
        container.set(CARD_ID, PersistentDataType.STRING, GameOfKings.getPlugin().getName() + "." + getBoosterKey() + "-" + getCardKey());
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


    public @NotNull String getBoosterKey() {
        return boosterKey;
    }
    public @NotNull String getCardKey() {
        return cardKey;
    }
}
