package com.dragosghinea.royale.core.config;

import com.dragosghinea.yaml.ConfigValues;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultCurrencyOverrideNamesCfg extends ConfigValues {

    private boolean overrideCurrencyNames = false;
    private String currencyNameSingular = "coin";
    private String currencyNamePlural = "coins";
}
