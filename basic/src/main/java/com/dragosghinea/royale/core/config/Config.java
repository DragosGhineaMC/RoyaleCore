package com.dragosghinea.royale.core.config;

import com.dragosghinea.yaml.ConfigValues;
import com.dragosghinea.yaml.annotations.Comments;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashMap;

@Getter
@Setter
public class Config extends ConfigValues {

    @Comments({
            "Cooldowns across the plugins rely on this setting."
    })
    @JsonProperty("short-format-time")
    private TimeDisplaysCfg shortFormatTimeDisplays = new TimeDisplaysCfg(false,
            new LinkedHashMap<>() {{
                put("second", "s");
                put("seconds", "s");
                put("minute", "m");
                put("minutes", "m");
                put("hour", "h");
                put("hours", "h");
                put("day", "d");
                put("days", "d");
            }}
    );

    @Comments({
            "",
            "Cooldowns across the plugins rely on this setting."
    })
    @JsonProperty("normal-format-time")
    private TimeDisplaysCfg normalFormatTimeDisplays = new TimeDisplaysCfg(true,
            new LinkedHashMap<>() {{
                put("second", " second");
                put("seconds", " seconds");
                put("minute", " minute");
                put("minutes", " minutes");
                put("hour", " hour");
                put("hours", " hours");
                put("day", " day");
                put("days", " days");
            }}
    );
}
