package plugin.advancementblocker.Commands;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import plugin.advancementblocker.AdvancementBlocker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Command implements TabCompleter, CommandExecutor {

    private final AdvancementBlocker plugin;
    public Command(AdvancementBlocker plugin) {
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String alias, String[] args) {
        boolean isOperator = sender.isOp();
        if (!isOperator) return Collections.emptyList();
        if (args.length == 1) {
            List<String> args1 = new ArrayList<>();
            args1.add("reload");
            return args1;
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull org.bukkit.command.Command command, @NotNull String label, String[] args) {
        if (args.length == 1 && args[0].equals("reload")) {
            plugin.reloadConfig();
            plugin.checkWorlds();
            Player player = (Player) sender;
            player.sendMessage("§a" + "Config successfully reloaded!");
            return true;
        }
        return true;
    }
}
