package plugin.advancementblocker.Events;

import org.bukkit.Bukkit;
import org.bukkit.advancement.Advancement;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAdvancementDoneEvent;
import org.bukkit.plugin.java.JavaPlugin;
import plugin.advancementblocker.AdvancementBlocker;

import java.util.List;

public class PlayerAdvancement implements Listener {

    private final JavaPlugin plugin = JavaPlugin.getPlugin(AdvancementBlocker.class);

    @EventHandler (priority = EventPriority.HIGHEST)
    public void onPlayerAdvancement(PlayerAdvancementDoneEvent event) {
        Player player = event.getPlayer();
        int playerLevel = player.getLevel();
        float playerExp = player.getExp();
        Advancement advancement = event.getAdvancement();
        String world = player.getWorld().getName();
        List<String> worlds = plugin.getConfig().getStringList("worlds");
        if (!advancement.getKey().getNamespace().contains("minecraft")) return;
        if (worlds.contains(world)) {
            for (String criteria : advancement.getCriteria()) {
                player.getAdvancementProgress(advancement).revokeCriteria(criteria);
            }
            Bukkit.getScheduler().runTaskLater(plugin, () -> {
                int playerNewLevel = player.getLevel();
                float playerNewExp = player.getExp();
                if (playerNewExp != playerExp || playerNewLevel != playerLevel) {
                    player.setLevel(playerLevel);
                    player.setExp(playerExp);
                }
            }, 2L);
        }
    }

}
