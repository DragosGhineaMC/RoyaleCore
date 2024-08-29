package com.dragosghinea.royale.core.config;

import com.dragosghinea.yaml.ConfigValues;
import com.dragosghinea.yaml.annotations.Comments;

import com.dragosghinea.yaml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultCurrencyCfg extends ConfigValues {

    @JsonProperty("currency-color")
    private String currencyColor = "&6";

    @Comments({
            "The material to be used as the currency icon",
            "in some menus."
    })
    @JsonProperty("currency-icon-material")
    private String material = "GOLD_NUGGET";

    @Comments({
            "Sometimes the names provided by the Vault integration",
            "are not what you want to display to the players.",
    })
    @JsonProperty("override-names")
    DefaultCurrencyOverrideNamesCfg overrideNames = new DefaultCurrencyOverrideNamesCfg();

    @JsonProperty("override-decimals")
    DefaultCurrencyOverrideDecimalsCfg overrideDecimals = new DefaultCurrencyOverrideDecimalsCfg();

    @Comments({
            "If this setting is activated, all decimals will be shown",
            "when formatting numbers. (eg. 1.2 -> 1.2000 when the currency has 4 decimals)"
    })
    @JsonProperty("show-all-decimals")
    private boolean showAllDecimals = false;

    @Comments({
            "If this setting is activated, the currency format will be",
            "overridden with the one provided by the plugin.",
            " ",
            "Possible values: no, short, decimals, plain"
    })
    @JsonProperty("override-currency-format")
    private String overrideCurrencyFormat = "no";
}
