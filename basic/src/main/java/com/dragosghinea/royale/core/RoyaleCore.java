package com.dragosghinea.royale.core;

import org.bukkit.plugin.java.JavaPlugin;

public class RoyaleCore extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("RoyaleCore has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RoyaleCore has been disabled!");
    }
}
