package de.lunarakai.yugioh.cards;

import de.lunarakai.yugioh.Yugioh;
import org.bukkit.Keyed;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

public abstract class AbstractCard implements Keyed {

    public static final NamespacedKey CARD_ID = new NamespacedKey(Yugioh.getPlugin(), "yugioh_card");
    private final NamespacedKey key;
    protected final ItemStack itemStack;

    protected AbstractCard(@NotNull NamespacedKey key) throws UnsupportedEncodingException {
        this.key = Objects.requireNonNull(key, "Key must not be null");
        this.itemStack = initItemStack(Objects.requireNonNull(createItemStack(), "ItemStack must not be null"));
    }

    protected abstract ItemStack createItemStack() throws UnsupportedEncodingException;

    private void applyToPersistentDataContainer(PersistentDataContainer container) {
        container.set(CARD_ID, PersistentDataType.STRING, getKey().toString());
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
}
