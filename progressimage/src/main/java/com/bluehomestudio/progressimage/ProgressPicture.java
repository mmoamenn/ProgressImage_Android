package com.bluehomestudio.progressimage;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.AnimatorRes;
import android.util.AttributeSet;

/**
 * Created by mohamed on 08/04/17.
 */

public class ProgressPicture extends android.support.v7.widget.AppCompatImageView {
    // Final variables
    private final int FAD = 0, SCALE = 1, ROTATION = 2, ROTATE_X = 3, ROTATE_Y = 4;

    // Main component references
    private Context mContext;
    private int animationType;
    private Animator mainAnimator;
    private boolean stopAnimation;

    /**
     * Enums of the animations
     */
    public enum Animations {
        FAD, SCALE, ROTATION, ROTATE_X, ROTATE_Y
    }

    public ProgressPicture(Context context, Animations animations) {
        super(context);

        mContext = context;
        handelAnimation(animations);
    }

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
    private void attachAnimation(int animationType) {

        switch (animationType) {

            case FAD:
                startAnimation(R.animator.fade_in_out);
                break;

            case SCALE:
                startAnimation(R.animator.scale_small_larg);
                break;

            case ROTATION:
                startAnimation(R.animator.rotate);
                break;

            case ROTATE_X:
                startAnimation(R.animator.rotate_x);
                break;

            case ROTATE_Y:
                startAnimation(R.animator.rotate_y);
                break;

        }

    }


    /**
     * Function to handel animation
     *
     * @param animations Type of animation
     */
    private void handelAnimation(Animations animations) {

        if (animations == Animations.FAD) {
            startAnimation(R.animator.fade_in_out);
        } else if (animations == Animations.SCALE) {
            startAnimation(R.animator.scale_small_larg);
        } else if (animations == Animations.ROTATION) {
            startAnimation(R.animator.rotate);
        } else if (animations == Animations.ROTATE_X) {
            startAnimation(R.animator.rotate_x);
        } else if (animations == Animations.ROTATE_Y) {
            attachAnimation(R.animator.rotate_y);
        }

    }

    /**
     * Function to attach animation to view
     *
     * @param id Animation resource ID
     */
    private void startAnimation(@AnimatorRes int id) {

        mainAnimator = AnimatorInflater.loadAnimator(getContext(), id);
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

    /**
     * Function to start animate progress
     */
    public void startAnimation() {
        setVisibility(VISIBLE);
        stopAnimation = true;
        mainAnimator.start();
    }

    /**
     * Function to stop animating and hide progress
     */
    public void stopAnimationAndHide() {
        setVisibility(GONE);
        stopAnimation();
    }

    /**
     * Function to stop animating
     */
    public void stopAnimation() {
        stopAnimation = false;
    }

}
