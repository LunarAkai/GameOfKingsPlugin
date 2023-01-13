package de.lunarakai.gameofkings.commands;

import de.iani.cubesideutils.bukkit.commands.CommandRouter;
import de.lunarakai.gameofkings.GameOfKings;

public record CommandRegistration(GameOfKings plugin) {
    public void registerCommands() {
        CommandRouter ygoRouter = new CommandRouter(plugin.getCommand("yugioh"));
        ygoRouter.addCommandMapping(new CommandYgo(plugin));
        ygoRouter.addCommandMapping(new CommandYgoGive(plugin), "give");
        //ygoRouter.addCommandMapping(new CommandAdminGetCardInfo(plugin), "getinfo");

    }
}
