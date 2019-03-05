package com.athome.playing.wetek_challenge.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.athome.playing.wetek_challenge.ChannelTypeUtils;
import com.athome.playing.wetek_challenge.R;
import com.athome.playing.wetek_challenge.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    private MainPresenter mPresenter;
    private TextView mOutputString;
    private ImageView mOutputImage;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
        mPresenter.preparePlayers();

        findViewById(R.id.channel1_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                mPresenter.playChannel(ChannelTypeUtils.ChannelType.TYPE_TEXT);
            }
        });

        findViewById(R.id.channel2_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View view) {
                mPresenter.playChannel(ChannelTypeUtils.ChannelType.TYPE_IMAGE);
            }
        });

        findViewById(R.id.clear_all_text).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final android.view.View view) {
                reset();
            }
        });
    }

    private void reset() {

        if (mOutputString != null) {
            mOutputString.setVisibility(android.view.View.GONE);
        }
        if (mOutputImage != null) {
            mOutputImage.setVisibility(android.view.View.GONE);
        }
    }


    @Override
    public void showText(final String string) {
        mOutputString = findViewById(R.id.output_string);

        if (mOutputString != null) {
            mOutputString.setText(string);
            mOutputString.setVisibility(android.view.View.VISIBLE);
            if (mOutputImage != null) {
                mOutputImage.setVisibility(android.view.View.GONE);

            }
        }
    }

    @Override
    public void showError() {
        Toast.makeText(this, R.string.error_msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showImage(final int drawable) {
        mOutputImage = findViewById(R.id.output_image);

        if (mOutputImage != null) {
            mOutputImage.setImageDrawable(getDrawable(drawable));
            mOutputImage.setVisibility(android.view.View.VISIBLE);
            if (mOutputString != null) {
                mOutputString.setVisibility(android.view.View.GONE);
            }
        }
    }
}
