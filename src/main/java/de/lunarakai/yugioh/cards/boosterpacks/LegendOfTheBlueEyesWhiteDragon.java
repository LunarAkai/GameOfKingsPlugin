package de.lunarakai.yugioh.cards.boosterpacks;

import de.lunarakai.yugioh.Yugioh;
import de.lunarakai.yugioh.cards.AbstractBoosterPack;
import de.lunarakai.yugioh.cards.AbstractCard;
import de.lunarakai.yugioh.utils.Rarity;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class LegendOfTheBlueEyesWhiteDragon extends AbstractBoosterPack
{
    public LegendOfTheBlueEyesWhiteDragon() {
        super(new NamespacedKey(Yugioh.getPlugin(), "lob"));
    }

    Map<AbstractCard, Rarity> cardList = new HashMap<>();

    @Override
    public void addToCardList(AbstractCard card, Rarity rarity) {
        cardList.put(card, rarity);
    }

    @Override
    public Map<AbstractCard, Rarity> getCardList() {
        return cardList;
    }

    @Override
    protected ItemStack createItemStack() {
        ItemStack itemStack = new ItemStack(Material.BOOK, 1);
        ItemMeta meta = itemStack.getItemMeta();
        meta = setBoosterPackMeta(
                meta,
                "Legend of The Blue-Eyes White Dragon"
        );
        itemStack.setItemMeta(meta);

        return itemStack;

    }


}
