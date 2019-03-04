package com.athome.playing.wetek_challenge.model;

import com.athome.playing.wetek_challenge.ChannelTypeUtils;

public abstract class Player {

    protected ChannelTypeUtils.ChannelType mChannelType;

    public abstract void play(final ChannelTypeUtils.ChannelType channelType);

    public abstract void setup();

    public Player() {
        setup();
    }
}
