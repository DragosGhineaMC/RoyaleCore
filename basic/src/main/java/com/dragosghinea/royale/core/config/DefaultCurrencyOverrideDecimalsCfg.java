package com.dragosghinea.royale.core.config;

import com.dragosghinea.yaml.ConfigValues;
import com.dragosghinea.yaml.annotations.Comments;
import com.dragosghinea.yaml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DefaultCurrencyOverrideDecimalsCfg extends ConfigValues {

    @Comments({
            "If the currency provided by Vault does not define",
            "the number of decimals to be used, this setting",
            "should be activated, to prevent defaulting to 6 decimals."
    })
    @JsonProperty("override-currency-decimals")
    private boolean overrideCurrencyDecimals = true;

    @Comments({
            "The number of decimals to be used when formatting numbers.",
            "For example, 1.2345 with 2 decimals would be 1.23.",
            "Maximum 6 decimals."
    })
    @JsonProperty("number-of-decimals")
    private int numberOfDecimals = 2;
}
