package de.lunarakai.yugioh.commands;

import de.iani.cubesideutils.bukkit.commands.CommandRouter;
import de.lunarakai.yugioh.Yugioh;

public record CommandRegistration(Yugioh plugin) {
    public void registerCommands() {
        CommandRouter ygoRouter = new CommandRouter(plugin.getCommand("yugioh"));
        ygoRouter.addCommandMapping(new CommandYgo(plugin));
        ygoRouter.addCommandMapping(new CommandYgoGive(plugin), "give");
        //ygoRouter.addCommandMapping(new CommandAdminGetCardInfo(plugin), "getinfo");

    }
}
