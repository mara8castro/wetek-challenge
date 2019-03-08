package com.athome.playing.wetek_challenge.model;

import com.athome.playing.wetek_challenge.Channel1;
import com.athome.playing.wetek_challenge.ChannelTypeUtils;

import io.reactivex.Observable;

/**
 * Class that plays a text channel
 */
public class TextPlayer extends Player {
    private String mChannel = "";

    public String getChannel() {
        return mChannel;
    }

    @Override
    public Observable<Boolean> play(final ChannelTypeUtils.ChannelType channelType) {

        if (channelType == mChannelType) {
            return Observable.just(Channel1.getTextView())
                    .doOnNext(image -> mChannel = image)
                    .map(a -> true);
        } else {
            return Observable.just(false);
        }
    }

    @Override
    public void setup() {
        mChannelType = ChannelTypeUtils.ChannelType.TYPE_TEXT;
    }
}
