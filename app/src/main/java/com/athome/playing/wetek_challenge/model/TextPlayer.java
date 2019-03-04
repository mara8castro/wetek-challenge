package com.athome.playing.wetek_challenge.model;

import com.athome.playing.wetek_challenge.Channel1;
import com.athome.playing.wetek_challenge.ChannelTypeUtils;

public class TextPlayer extends Player {
    private String mChannel = "";

    public String getChannel() {
        return mChannel;
    }

    @Override
    public void play(final ChannelTypeUtils.ChannelType channelType) {

        if (channelType == mChannelType) {
            mChannel = Channel1.getTextView();
        }
    }

    @Override
    public void setup() {
        mChannelType = ChannelTypeUtils.ChannelType.TYPE_TEXT;
    }
}
