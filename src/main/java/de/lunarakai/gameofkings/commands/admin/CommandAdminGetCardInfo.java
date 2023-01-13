package de.lunarakai.gameofkings.commands.admin;

import de.iani.cubesideutils.bukkit.commands.SubCommand;
import de.iani.cubesideutils.commands.ArgsParser;
import de.lunarakai.gameofkings.GameOfKings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandAdminGetCardInfo extends SubCommand {

    private final GameOfKings plugin;
    public CommandAdminGetCardInfo(GameOfKings plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String s1, ArgsParser argsParser) {
        return true;
    }
}
