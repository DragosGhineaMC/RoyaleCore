package com.dragosghinea.royale.core;

import com.dragosghinea.royale.core.config.Config;
import com.dragosghinea.royale.core.time.TimeCountdowns;
import com.dragosghinea.royale.core.vault.VaultCurrencyLoader;
import com.dragosghinea.royale.currencies.vault.VaultCurrency;
import com.dragosghinea.royale.internal.utils.number.RoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.number.ShortFormatPairCfg;
import com.dragosghinea.royale.internal.utils.number.impl.DecimalsRoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.number.impl.PlainRoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.number.impl.ShortRoyaleNumberFormat;
import com.dragosghinea.yaml.ConfigHandler;
import lombok.Getter;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

    @Getter
    private TimeCountdowns timeCountdowns;

    @Getter
    private List<RoyaleNumberFormat> numberFormats;

    @SneakyThrows
    @Override
    public void onEnable() {
        instance = this;
        this.configHandler = new ConfigHandler<>(Config.class, new File(getDataFolder(), "config.yml").toPath());

        this.config = configHandler.load();
        this.configHandler.save(config);

        vaultCurrency = VaultCurrencyLoader.loadFromConfig(config.getDefaultCurrency());
        timeCountdowns = new TimeCountdowns(config.getShortFormatTimeDisplays(), config.getNormalFormatTimeDisplays());

        numberFormats = new ArrayList<RoyaleNumberFormat>() {{
            add(new ShortRoyaleNumberFormat(getCoreConfig().getNumberSettings().getShortFormatCfg().getShortFormats().values().toArray(new ShortFormatPairCfg[0])));
            add(new DecimalsRoyaleNumberFormat(vaultCurrency.numberOfDecimals(), getCoreConfig().getDefaultCurrency().isShowAllDecimals()));
            add(new PlainRoyaleNumberFormat());
        }};

        getLogger().info("RoyaleCore has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("RoyaleCore has been disabled!");
    }
}
