package de.lunarakai.gameofkings.commands;

import de.iani.cubesideutils.bukkit.commands.CommandRouter;
import de.lunarakai.gameofkings.GameOfKings;

public record CommandRegistration(GameOfKings plugin) {
    public void registerCommands() {
        CommandRouter gokRouter = new CommandRouter(plugin.getCommand("gameofkings"));
        gokRouter.addCommandMapping(new CommandYgo(plugin));
        gokRouter.addCommandMapping(new CommandYgoGive(plugin), "give");
        //ygoRouter.addCommandMapping(new CommandAdminGetCardInfo(plugin), "getinfo");

    }
}
