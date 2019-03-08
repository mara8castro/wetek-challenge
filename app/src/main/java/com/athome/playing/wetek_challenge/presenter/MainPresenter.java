package com.athome.playing.wetek_challenge.presenter;

import android.util.Log;

import com.athome.playing.wetek_challenge.ChannelTypeUtils;
import com.athome.playing.wetek_challenge.model.ImagePlayer;
import com.athome.playing.wetek_challenge.model.TextPlayer;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainPresenter {

    private static final String TAG = "MainPresenter";

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

    public void resetPlayers() {
        mTextPlayer = null;
        mImagePlayer = null;
    }

    public void playChannel(final ChannelTypeUtils.ChannelType type) {

        // make sure we have players
        preparePlayers();

        if (type == ChannelTypeUtils.ChannelType.TYPE_TEXT) {

            final Observer<Boolean> playTextChannel = playTextChannel();

            // play text channel
            mTextPlayer.play(type)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(playTextChannel);
        } else if (type == ChannelTypeUtils.ChannelType.TYPE_IMAGE) {

            final Observer<Boolean> playImageChannel = playImageChannel();

            // play image channel
            mImagePlayer.play(type)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(playImageChannel);
        }
    }


    private Observer<Boolean> playImageChannel() {
        return new Observer<Boolean>() {
            @Override
            public void onSubscribe(final Disposable d) {
                // improvement: add a loader here and remove it onComplete
            }

            @Override
            public void onNext(final Boolean readyToPlay) {

                if (readyToPlay) {
                    final int channel = mImagePlayer.getChannel();
                    if (channel != -1) {
                        mView.showImage(channel);
                        return;
                    }
                }
                mView.showError();
            }

            @Override
            public void onError(final Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
                mView.showError();
            }

            @Override
            public void onComplete() {
                // improvement: add a loader onSubscribe and remove it here
            }
        };
    }

    private Observer<Boolean> playTextChannel() {
        return new Observer<Boolean>() {
            @Override
            public void onSubscribe(final Disposable d) {
                // improvement: add a loader here and remove it onComplete
            }

            @Override
            public void onNext(final Boolean readyToPlay) {

                if (readyToPlay) {
                    final String channel = mTextPlayer.getChannel();
                    if (!channel.isEmpty()) {
                        mView.showText(channel);
                        return;
                    }
                }
                mView.showError();
            }

            @Override
            public void onError(final Throwable e) {
                Log.e(TAG, "onError: " + e.getMessage());
                mView.showError();
            }

            @Override
            public void onComplete() {
                // improvement: add a loader onSubscribe and remove it here
            }
        };
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
