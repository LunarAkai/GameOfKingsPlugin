package de.lunarakai.yugioh.commands;

import de.iani.cubesideutils.bukkit.commands.SubCommand;
import de.iani.cubesideutils.bukkit.commands.exceptions.*;
import de.iani.cubesideutils.commands.ArgsParser;
import de.lunarakai.yugioh.Yugioh;
import de.lunarakai.yugioh.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class CommandYgo extends SubCommand {
    private final Yugioh plugin;
    public CommandYgo(Yugioh plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String s1, ArgsParser argsParser) throws DisallowsCommandBlockException, RequiresPlayerException, NoPermissionException, IllegalSyntaxException, InternalCommandException {
        ChatUtil.sendNormalMessage(commandSender, "Yugioh Card Game v" + plugin.getDescription().getVersion() + " by " + plugin.getDescription().getAuthors());
        ChatUtil.sendNormalMessage(commandSender, "Yu-Gi-Oh is TM and copyright Konami Holdings Corporation. This plugin is unaffiliated. The plugin does not contain copyrighted material of Konami.");
        return true;
    }
}
