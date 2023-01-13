package de.lunarakai.gameofkings.commands;

import de.iani.cubesideutils.bukkit.commands.SubCommand;
import de.iani.cubesideutils.commands.ArgsParser;
import de.lunarakai.gameofkings.GameOfKings;
import de.lunarakai.gameofkings.cards.AbstractBoosterPack;
import de.lunarakai.gameofkings.cards.AbstractCard;
import de.lunarakai.gameofkings.utils.ChatUtil;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public class CommandYgoGive extends SubCommand {
    private final GameOfKings plugin;
    public CommandYgoGive(GameOfKings plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String s1, ArgsParser argsParser) {
        if(!(commandSender instanceof Player player)) {
            ChatUtil.sendErrorMessage(commandSender, "This command is only available if you are a player.");
            return true;
        }

        if(argsParser.hasNext()) {
            String key = argsParser.getNext();
            AbstractCard card = plugin.getCardRegistry().get(NamespacedKey.fromString(key));
            AbstractBoosterPack boosterPack = plugin.getBoosterPackRegistry().get(NamespacedKey.fromString(key));
            int amount;
            if (argsParser.hasNext()) {
                int next = argsParser.getNext(1);
                if (next < 1 || next > 64) {
                    ChatUtil.sendErrorMessage(player, "Quantity must be between 1-64");
                    return true;
                }
                amount = next;
            } else {
                ChatUtil.sendWarningMessage(player, "/yugioh give [key] <amount>");
                return true;
            }
            Inventory inv = player.getInventory();
            if(card != null) {
                ItemStack itemStack = card.getItemStack();
                itemStack.setAmount(amount);
                if(inv.firstEmpty() == -1) {
                    ChatUtil.sendErrorMessage(player, "Item could not be added. Your inventory is full");
                } else {
                    player.getInventory().addItem(itemStack);
                    ChatUtil.sendNormalMessage(player, amount + "x " + itemStack.getItemMeta().displayName() + ChatUtil.GREEN + " has been added to your inventory");
                }
            } else if (boosterPack != null) {
                ItemStack itemStack = boosterPack.getItemStack();
                itemStack.setAmount(amount);
                if(inv.firstEmpty() == -1) {
                    ChatUtil.sendErrorMessage(player, "Item could not be added. Your inventory is full");
                } else {
                    player.getInventory().addItem(itemStack);
                    ChatUtil.sendNormalMessage(player, amount + "x " + itemStack.getItemMeta().displayName() + ChatUtil.GREEN + " has been added to your inventory");
                }
            } else {
                ChatUtil.sendErrorMessage(player, "Card or Booster Pack " + key + " is not available.");
            }
        } else {
            ChatUtil.sendWarningMessage(player, "/yugioh give [key] <amount>");
            return true;
        }
        return true;
    }

    @Override
    public Collection<String> onTabComplete(CommandSender sender, Command command, String alias, ArgsParser args) {
        int i = args.remaining();
        if(i == 1) {
            ArrayList<String> li = new ArrayList<>();
            plugin.getCardRegistry().getKeys().forEach((x) -> li.add(x.toString()));
            plugin.getBoosterPackRegistry().getKeys().forEach((x) -> li.add(x.toString()));
            return li;
        }
        return new ArrayList<>();
    }

}
