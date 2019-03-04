package com.athome.playing.wetek_challenge;

public class ChannelTypeUtils {

    private static final int TYPE_TEXT = 0;
    private static final int TYPE_IMAGE = 1;

    public enum ChannelType {
        TYPE_TEXT(0),
        TYPE_IMAGE(1);

        final int mId;

        ChannelType(final int id) {
            this.mId = id;
        }

        public int getValue() {
            return this.mId;
        }

    }
}
