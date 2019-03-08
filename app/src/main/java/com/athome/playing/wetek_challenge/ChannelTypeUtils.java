package com.athome.playing.wetek_challenge;

public class ChannelTypeUtils {

    public enum ChannelType {
        TYPE_TEXT(0),
        TYPE_IMAGE(1);

        final int mId;

        ChannelType(final int id) {
            this.mId = id;
        }

    }
}
