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
}
