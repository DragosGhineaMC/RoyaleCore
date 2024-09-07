package com.dragosghinea.royale.core.vault;

import com.dragosghinea.royale.core.RoyaleCore;
import com.dragosghinea.royale.core.config.DefaultCurrencyCfg;
import com.dragosghinea.royale.currencies.vault.VaultCurrency;
import com.dragosghinea.royale.internal.utils.material.MaterialStringProcessor;
import com.dragosghinea.royale.internal.utils.material.StandardMaterialStringProcessor;
import com.dragosghinea.royale.internal.utils.number.RoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.number.ShortFormatPairCfg;
import com.dragosghinea.royale.internal.utils.number.impl.DecimalsRoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.number.impl.PlainRoyaleNumberFormat;
import com.dragosghinea.royale.internal.utils.number.impl.ShortRoyaleNumberFormat;

public class VaultCurrencyLoader {
    private static final MaterialStringProcessor materialStringProcessor = new StandardMaterialStringProcessor();

    public static VaultCurrency loadFromConfig(DefaultCurrencyCfg config) {
        Integer overrideNumberOfDecimals = config.getOverrideDecimals().isOverrideCurrencyDecimals() ? config.getOverrideDecimals().getNumberOfDecimals() : null;
        String overrideCurrencyNameSingular = config.getOverrideNames().isOverrideCurrencyNames() ? config.getOverrideNames().getCurrencyNameSingular() : null;
        String overrideCurrencyNamePlural = config.getOverrideNames().isOverrideCurrencyNames() ? config.getOverrideNames().getCurrencyNamePlural() : null;

        VaultCurrency vaultCurrency = new VaultCurrency("default",
                config.getCurrencyColor(),
                overrideNumberOfDecimals,
                overrideCurrencyNameSingular,
                overrideCurrencyNamePlural,
                materialStringProcessor.processXMaterial(config.getMaterial()).parseItem()
        );

        RoyaleNumberFormat numberFormat = getNumberFormat(vaultCurrency, config.getOverrideCurrencyFormat());
        if (numberFormat != null)
            vaultCurrency.setFormatMoneyFunction(numberFormat::toFormat);

        return vaultCurrency;
    }

    private static RoyaleNumberFormat getNumberFormat(VaultCurrency vaultCurrency, String format) {
        return switch (format) {
            case "plain" -> new PlainRoyaleNumberFormat();
            case "short" ->
                    new ShortRoyaleNumberFormat(RoyaleCore.getInstance().getCoreConfig().getNumberSettings().getShortFormatCfg().getShortFormats().values().toArray(new ShortFormatPairCfg[0]));
            case "decimals" ->
                    new DecimalsRoyaleNumberFormat(vaultCurrency.numberOfDecimals(), RoyaleCore.getInstance().getCoreConfig().getDefaultCurrency().isShowAllDecimals());
            default -> null;
        };
    }
}
