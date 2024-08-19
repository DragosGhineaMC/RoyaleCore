package com.dragosghinea.royale.core.config;

import com.dragosghinea.yaml.ConfigValues;
import com.dragosghinea.yaml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeDisplaysCfg extends ConfigValues {

    @JsonProperty("use-spaces")
    private boolean useSpaces;

    @JsonProperty("unit-names")
    private Map<String, String> unitNames;
}
