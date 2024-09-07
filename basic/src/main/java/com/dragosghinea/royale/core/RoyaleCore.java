package com.dragosghinea.royale.core;

import com.dragosghinea.royale.core.config.Config;
import com.dragosghinea.royale.core.time.TimeCountdowns;
import com.dragosghinea.royale.core.vault.VaultCurrencyLoader;
import com.dragosghinea.royale.currencies.RoyaleCurrencies;
import com.dragosghinea.royale.currencies.vault.VaultCurrency;
import com.dragosghinea.royale.internal.utils.number.RoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.number.ShortFormatPairCfg;
import com.dragosghinea.royale.internal.utils.number.impl.DecimalsRoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.number.impl.PlainRoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.number.impl.ShortRoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.time.SimpleJobScheduler;
import com.dragosghinea.royale.internal.utils.time.quartz.SchedulerException;
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
    private List<RoyaleNumberFormat> numberFormats;

    @Getter
    private TimeCountdowns timeCountdowns;

    @Getter
    private SimpleJobScheduler jobScheduler;

    @SneakyThrows
    @Override
    public void onEnable() {
        instance = this;
        this.configHandler = new ConfigHandler<>(Config.class, new File(getDataFolder(), "config.yml").toPath());

        this.config = configHandler.load();
        this.configHandler.save(config);

        VaultCurrency vaultCurrency = VaultCurrencyLoader.loadFromConfig(config.getDefaultCurrency());
        RoyaleCurrencies.getInstance().registerCurrency(vaultCurrency, true);

        timeCountdowns = new TimeCountdowns(config.getShortFormatTimeDisplays(), config.getNormalFormatTimeDisplays());

        numberFormats = new ArrayList<>() {{
            add(new ShortRoyaleNumberFormat(getCoreConfig().getNumberSettings().getShortFormatCfg().getShortFormats().values().toArray(new ShortFormatPairCfg[0])));
            add(new DecimalsRoyaleNumberFormat(vaultCurrency.numberOfDecimals(), getCoreConfig().getDefaultCurrency().isShowAllDecimals()));
            add(new PlainRoyaleNumberFormat());
        }};

        jobScheduler = new SimpleJobScheduler();

        getLogger().info("RoyaleCore has been enabled!");
    }

    @Override
    public void onDisable() {
        try {
            jobScheduler.shutdown();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

        getLogger().info("RoyaleCore has been disabled!");
    }
}
