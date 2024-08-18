package com.dragosghinea.royale.core.vault;

import com.dragosghinea.royale.core.config.DefaultCurrencyCfg;
import com.dragosghinea.royale.currencies.vault.VaultCurrency;
import com.dragosghinea.royale.internal.utils.material.MaterialStringProcessor;
import com.dragosghinea.royale.internal.utils.material.StandardMaterialStringProcessor;

public class VaultCurrencyLoader {
    private static final MaterialStringProcessor materialStringProcessor = new StandardMaterialStringProcessor();

    public static VaultCurrency loadFromConfig(DefaultCurrencyCfg config) {
        Integer overrideNumberOfDecimals = config.getOverrideDecimals().isOverrideCurrencyDecimals() ? config.getOverrideDecimals().getNumberOfDecimals() : null;
        String overrideCurrencyNameSingular = config.getOverrideNames().isOverrideCurrencyNames() ? config.getOverrideNames().getCurrencyNameSingular() : null;
        String overrideCurrencyNamePlural = config.getOverrideNames().isOverrideCurrencyNames() ? config.getOverrideNames().getCurrencyNamePlural() : null;

        return new VaultCurrency("default",
                config.getCurrencyColor(),
                overrideNumberOfDecimals,
                overrideCurrencyNameSingular,
                overrideCurrencyNamePlural,
                materialStringProcessor.processXMaterial(config.getMaterial()).parseItem()
        );
    }
}
