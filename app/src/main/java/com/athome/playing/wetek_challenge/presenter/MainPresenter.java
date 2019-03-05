package com.athome.playing.wetek_challenge.presenter;

import com.athome.playing.wetek_challenge.ChannelTypeUtils;
import com.athome.playing.wetek_challenge.model.ImagePlayer;
import com.athome.playing.wetek_challenge.model.TextPlayer;

public class MainPresenter {

    private final View mView;
    private TextPlayer mTextPlayer;
    private ImagePlayer mImagePlayer;

    public MainPresenter(final View view) {
        this.mView = view;
    }

    public void preparePlayers() {
        if (mTextPlayer == null) {
            mTextPlayer = new TextPlayer();
        }

        if (mImagePlayer == null) {
            mImagePlayer = new ImagePlayer();
        }
    }

    public void playChannel(final ChannelTypeUtils.ChannelType type) {

        if (type == ChannelTypeUtils.ChannelType.TYPE_TEXT) {

            mTextPlayer.play(type);

            final String channel = mTextPlayer.getChannel();
            if (!channel.isEmpty()) {
                mView.showText(channel);
            } else {
                mView.showError();
            }

        } else if (type == ChannelTypeUtils.ChannelType.TYPE_IMAGE) {

            mImagePlayer.play(type);

            final int channel = mImagePlayer.getChannel();
            if (channel != -1) {
                mView.showImage(channel);
            } else {
                mView.showError();
            }
        }
    }


    public interface View {
        /**
         * Shows the channel containing a string
         *
         * @param text The text present in a channel
         */
        void showText(final String text);

        /**
         * Shows the user an error msg when a channel was not reproducible
         */
        void showError();

        /**
         * Shows the channel containing an image
         *
         * @param drawable The image present in a channel
         */
        void showImage(final int drawable);
    }

}
