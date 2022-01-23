# Lakotnik - Hunger Preview
A hunger preview mod for Minecraft, working serverside only.

![](https://img.shields.io/badge/Environment-server-green?style=flat-square)
![](https://img.shields.io/badge/Environment-singleplayer-blue?style=flat-square)

Every player with permission `lakotnik.hunger_preview` can see how much nutrition will
the selected food provide (granted by default).


https://user-images.githubusercontent.com/34912839/150651145-a100bc11-b36b-4b6f-bd03-712ee486e468.mp4


## Supported loaders
![](https://img.shields.io/badge/Loader-Fabric-green?style=flat-square)
![](https://img.shields.io/badge/Loader-Sponge-yellow?style=flat-square)
![](https://img.shields.io/badge/Loader-Forge-red?style=flat-square)

## Config
```toml
#Lakotnik Config

# Update rate in ticks.
tick_update_rate=10

# Whether to enable on low hunger (<= 6.0)
# Causes minor problems as client will think it can
# sprint. If you don't care about that, feel free to enable.
enable_on_low_hunger=false

```
*Why can `enable_on_low_hunger` be problematic?*
Sprinting is managed on client - if you hold a food item in your hand
and not have enough hunger points to sprint, you will still be able to sprint
in intervals when your hunger bar is in preview mode.
