package com.dragosghinea.royale.core.config;

import com.dragosghinea.royale.internal.utils.number.ShortFormatCfg;
import com.dragosghinea.royale.internal.utils.number.ShortFormatPairCfg;
import com.dragosghinea.yaml.ConfigValues;
import com.dragosghinea.yaml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NumberSettingsCfg extends ConfigValues {

    @JsonProperty("short-format-settings")
    private ShortFormatCfg shortFormatCfg = new ShortFormatCfg(new LinkedHashMap<>() {{
        put("unit1", new ShortFormatPairCfg(3, "K"));
        put("unit2", new ShortFormatPairCfg(6, "M"));
        put("unit3", new ShortFormatPairCfg(9, "G"));
        put("unit4", new ShortFormatPairCfg(12, "T"));
        put("unit5", new ShortFormatPairCfg(15, "Q"));
    }});
}
