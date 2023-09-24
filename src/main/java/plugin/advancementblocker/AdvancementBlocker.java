package plugin.advancementblocker;

import org.bukkit.Bukkit;
import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.advancementblocker.Commands.Command;
import plugin.advancementblocker.Events.PlayerAdvancement;

import java.util.List;
import java.util.Objects;

public final class AdvancementBlocker extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        checkWorlds();
        Bukkit.getPluginManager().registerEvents(new PlayerAdvancement(), this);
        Objects.requireNonNull(Bukkit.getPluginCommand("advblock")).setExecutor(new Command(this));
        Objects.requireNonNull(Bukkit.getPluginCommand("advblock")).setTabCompleter(new Command(this));
        Bukkit.getLogger().info("[AdvancementBlocker] Created by @jairusu");
        Bukkit.getLogger().info("[AdvancementBlocker] Successfully Enabled!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[AdvancementBlocker] Created by @jairusu");
        Bukkit.getLogger().info("[AdvancementBlocker] Successfully Disabled!");
    }

    public void checkWorlds() {
        List<String> worlds = getConfig().getStringList("worlds");
        for (String worldName : worlds) {
            World world = Bukkit.getWorld(worldName);
            if (world == null) continue;
            if (Boolean.TRUE.equals(world.getGameRuleValue(GameRule.ANNOUNCE_ADVANCEMENTS))) {
                world.setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, false);
            }
        }
    }

}
