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
            mView.showText(mTextPlayer.getChannel());
        } else if (type == ChannelTypeUtils.ChannelType.TYPE_IMAGE) {
            mImagePlayer.play(type);
            mView.showImage(mImagePlayer.getChannel());
        }
    }


    public interface View {
        void showText(final String text);

        void showImage(final int drawable);
    }

}
