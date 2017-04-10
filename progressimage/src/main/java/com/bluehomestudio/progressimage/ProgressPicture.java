package com.bluehomestudio.progressimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/**
 * Created by mohamed on 08/04/17.
 */

public class ProgressPicture extends android.support.v7.widget.AppCompatImageView {
    private final int FAD = 0, SCALE = 1, ROTATION = 2, SHAKE = 3;
    private Context mContext;
    private int animationType;

    public ProgressPicture(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        //handelAttributes(attrs);
    }

    public ProgressPicture(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        //handelAttributes(attrs);
    }

    /**
     * Function to handle xml attributes
     *
     * @param attrs XML attributes
     */
    private void handelAttributes(AttributeSet attrs) {

        TypedArray typedArray = mContext.obtainStyledAttributes(attrs, R.styleable.ProgressPicture, 0, 0);

        try {
            animationType = typedArray.getInt(R.styleable.ProgressPicture_animation, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Function to attach animation to View
     *
     * @param animationType Animation type id
     */
    public void attachAnimation(int animationType) {

        switch (animationType) {

            case FAD:
                break;

            case SCALE:
                break;

            case ROTATION:
                break;

            case SHAKE:
                break;

        }

    }

}
