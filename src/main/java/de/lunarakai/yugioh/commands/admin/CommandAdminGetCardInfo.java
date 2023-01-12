package de.lunarakai.yugioh.commands.admin;

import de.iani.cubesideutils.bukkit.commands.SubCommand;
import de.iani.cubesideutils.commands.ArgsParser;
import de.lunarakai.yugioh.Yugioh;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandAdminGetCardInfo extends SubCommand {

    private final Yugioh plugin;
    public CommandAdminGetCardInfo(Yugioh plugin) {
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String s1, ArgsParser argsParser) {
        return true;
    }
}
