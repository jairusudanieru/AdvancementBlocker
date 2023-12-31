## Advancement Blocker v1.0

This plugin works by first checking the world where the player gained an advancement. If that world is listed under "worlds," the advancement will be revoked from the player. Therefore, if the player gains an advancement in a world not listed in "worlds," the achievement will function as usual.

**config.yml**
```yaml
# Advancement Blocker [Created by: @jairusu]
# If you found any problems or bugs in this plugin, please create an issue in this
#   plugin's GitHub repository, and I'll try my best to help you.

# This plugin works by first checking the world where the player gained an advancement.
#   If that world is listed under "worlds," the advancement will be revoked from the player.
#   Therefore, if the player gains an advancement in a world not listed in "worlds," the
#   achievement will function as usual.

# List the worlds where you want to disable gaining achievements.
# Please note that on config reload it will disable the "announce advancement" gamerule
#   for these worlds to prevent advancement announcements in these worlds. If you remove
#   a world from this list, you have to manually set that world's gamerule.
worlds:
#  - creative
#  - lobby
#  - hub

# This plugin might have some compatibility issues with other plugins.
```

I got the idea of this plugin from **[Tajam](https://www.spigotmc.org/members/tajam.627607/)**

![icon.png](images%2Ficon.png)

