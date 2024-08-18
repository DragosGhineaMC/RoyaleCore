package com.dragosghinea.royale.core.time;

import com.dragosghinea.royale.core.config.TimeDisplaysCfg;
import com.dragosghinea.royale.internal.utils.time.format.TimeCountdown;
import com.dragosghinea.royale.internal.utils.time.format.TimeCountdownImpl;
import lombok.Getter;

@Getter
public class TimeCountdowns {

    private final boolean useShortTimeDisplaysSpaces;
    private final TimeCountdown shortTimeCountdown;

    private final boolean useNormalTimeDisplaysSpaces;
    private final TimeCountdown normalTimeCountdown;

    public TimeCountdowns(TimeDisplaysCfg shortTimeDisplays, TimeDisplaysCfg normalTimeDisplays) {
        this.useShortTimeDisplaysSpaces = shortTimeDisplays.isUseSpaces();
        this.shortTimeCountdown = new TimeCountdownImpl(shortTimeDisplays.getUnitNames());
        this.useNormalTimeDisplaysSpaces = normalTimeDisplays.isUseSpaces();
        this.normalTimeCountdown = new TimeCountdownImpl(normalTimeDisplays.getUnitNames());
    }
}
