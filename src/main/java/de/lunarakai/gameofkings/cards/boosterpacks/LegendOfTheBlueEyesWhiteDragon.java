package de.lunarakai.gameofkings.cards.boosterpacks;

import de.lunarakai.gameofkings.GameOfKings;
import de.lunarakai.gameofkings.cards.AbstractBoosterPack;
import de.lunarakai.gameofkings.cards.AbstractCard;
import de.lunarakai.gameofkings.utils.Rarity;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;

public class LegendOfTheBlueEyesWhiteDragon extends AbstractBoosterPack
{

    String key;

    public LegendOfTheBlueEyesWhiteDragon(String boosterKey) {
        super(new NamespacedKey(GameOfKings.getPlugin(), boosterKey));

        this.key = boosterKey;
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
    public String getBoosterPackKey() {
        return key;
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
