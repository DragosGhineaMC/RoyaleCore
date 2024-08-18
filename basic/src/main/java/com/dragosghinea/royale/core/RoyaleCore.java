package com.dragosghinea.royale.core;

import com.dragosghinea.royale.core.config.Config;
import com.dragosghinea.royale.core.vault.VaultCurrencyLoader;
import com.dragosghinea.royale.currencies.vault.VaultCurrency;
import com.dragosghinea.yaml.ConfigHandler;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class RoyaleCore extends JavaPlugin {

    @Getter
    private static RoyaleCore instance;

    @Getter
    private ConfigHandler<Config> configHandler;

    private Config config;

    public Config getCoreConfig() {
        return config;
    }

    @Getter
    private VaultCurrency vaultCurrency;

    @SneakyThrows
    @Override
    public void onEnable() {
        instance = this;
        this.configHandler = new ConfigHandler<>(Config.class, new File(getDataFolder(), "config.yml").toPath());

        this.config = configHandler.load();
        this.configHandler.save(config);

        vaultCurrency = VaultCurrencyLoader.loadFromConfig(config.getDefaultCurrency());

        getLogger().info("RoyaleCore has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RoyaleCore has been disabled!");
    }
}
