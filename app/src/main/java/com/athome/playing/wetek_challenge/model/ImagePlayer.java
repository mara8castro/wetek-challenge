package com.athome.playing.wetek_challenge.model;

import com.athome.playing.wetek_challenge.Channel2;
import com.athome.playing.wetek_challenge.ChannelTypeUtils;

/**
 * Class that plays an image channel
 */
public class ImagePlayer extends Player {

    private int mChannel = -1;

    public int getChannel() {
        return mChannel;
    }

    @Override
    public void play(final ChannelTypeUtils.ChannelType channelType) {

        if (channelType == mChannelType) {
            mChannel = Channel2.getImage();
        }
    }

    @Override
    public void setup() {
        mChannelType = ChannelTypeUtils.ChannelType.TYPE_IMAGE;
    }
}
