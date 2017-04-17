package com.bluehomestudio.progressimage;

import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AnimatorRes;
import android.util.AttributeSet;

/**
 * Created by mohamed on 08/04/17.
 */

public class ProgressPicture extends android.support.v7.widget.AppCompatImageView {
    private final int FAD = 0, SCALE = 1, ROTATION = 2, SHAKE = 3;
    private Context mContext;
    private int animationType;
    private Animator mainAnimator;
    private boolean stopAnimation;

    public ProgressPicture(Context context, AttributeSet attrs) {
        super(context, attrs);

        mContext = context;
        handelAttributes(attrs);
    }

    public ProgressPicture(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mContext = context;
        handelAttributes(attrs);
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
            attachAnimation(animationType);
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
                startAnimation(R.animator.fade_in_out);
                break;

            case SCALE:
                startAnimation(R.animator.scale_small_larg);
                break;

            case ROTATION:
                startAnimation(R.animator.rotate_full_round);
                break;

            case SHAKE:
                startAnimation(R.animator.shake);
                break;

        }

    }


    private void startAnimation(@AnimatorRes int id) {

        mainAnimator.setTarget(this);
        mainAnimator.start();
        stopAnimation = true;
        mainAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (stopAnimation) {
                    mainAnimator.start();
                } else {
                    mainAnimator.cancel();
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    public void starAnimation() {
        mainAnimator.start();
    }

    public void stopAnimation() {
        stopAnimation = false;
    }

}
