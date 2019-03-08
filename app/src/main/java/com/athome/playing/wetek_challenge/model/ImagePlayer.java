package com.athome.playing.wetek_challenge.model;

import com.athome.playing.wetek_challenge.Channel2;
import com.athome.playing.wetek_challenge.ChannelTypeUtils;

import io.reactivex.Observable;
/**
 * Class that plays an image channel
 */
public class ImagePlayer extends Player {

    private int mChannel = -1;

    public int getChannel() {
        return mChannel;
    }

    @Override
    public Observable<Boolean> play(final ChannelTypeUtils.ChannelType channelType) {

        if (channelType == mChannelType) {
           return Observable.just(Channel2.getImage())
                   .doOnNext(image -> mChannel = image)
                   .map(a -> true);
        } else {
            return Observable.just(false);
        }
    }

    @Override
    public void setup() {
        mChannelType = ChannelTypeUtils.ChannelType.TYPE_IMAGE;
    }
}
