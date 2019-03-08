package com.athome.playing.wetek_challenge.model;

import com.athome.playing.wetek_challenge.ChannelTypeUtils;

import io.reactivex.Observable;

public abstract class Player {

    ChannelTypeUtils.ChannelType mChannelType;

    public abstract Observable<Boolean> play(final ChannelTypeUtils.ChannelType channelType);

    public abstract void setup();

    Player() {
        setup();
    }
}
