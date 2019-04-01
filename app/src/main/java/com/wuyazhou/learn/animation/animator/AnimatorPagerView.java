package com.wuyazhou.learn.animation.animator;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.animation.R;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class AnimatorPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;
    private View mAnimationView;

    public AnimatorPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public AnimatorPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public AnimatorPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_view_animator_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
        View modelFirst_2  = mLayout.findViewById(R.id.model_button_1_2);
        modelFirst_2.setOnClickListener(this);

        View modelSecond  = mLayout.findViewById(R.id.model_button_2);
        modelSecond.setOnClickListener(this);
        View modelSecond_2  = mLayout.findViewById(R.id.model_button_2_2);
        modelSecond_2.setOnClickListener(this);
        View modelSecond_3  = mLayout.findViewById(R.id.model_button_2_3);
        modelSecond_3.setOnClickListener(this);

        View modelThird  = mLayout.findViewById(R.id.model_button_3);
        modelThird.setOnClickListener(this);
        View modelThird_2  = mLayout.findViewById(R.id.model_button_3_2);
        modelThird_2.setOnClickListener(this);

        View modelFourth  = mLayout.findViewById(R.id.model_button_4);
        modelFourth.setOnClickListener(this);

        View modelFifth = mLayout.findViewById(R.id.model_button_5);
        modelFifth.setOnClickListener(this);

        mAnimationView = mLayout.findViewById(R.id.view);

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            ObjectAnimator.ofFloat(mAnimationView,"translationX",200)
                    .setDuration(1500)
                    .start();
        } else if (i == R.id.model_button_1_2) {
            ObjectAnimator.ofFloat(mAnimationView,"translationY",360)
                    .setDuration(1500)
                    .start();
        }else if (i == R.id.model_button_2) {
            ObjectAnimator.ofFloat(mAnimationView,"rotation",360,0)
                    .setDuration(1500)
                    .start();
        } else if (i == R.id.model_button_2_2) {
            ObjectAnimator.ofFloat(mAnimationView,"rotationX",360,0)
                    .setDuration(1500)
                    .start();
        }else if (i == R.id.model_button_2_3) {
            ObjectAnimator.ofFloat(mAnimationView,"rotationY",360)
                    .setDuration(1500)
                    .start();
        } else if (i == R.id.model_button_3) {
            ObjectAnimator.ofFloat(mAnimationView,"scaleX",0.25f,1)
                    .setDuration(3000)
                    .start();
        } else if (i == R.id.model_button_3_2) {
            ObjectAnimator.ofFloat(mAnimationView,"scaleY",0.25f,1)
                    .setDuration(3000)
                    .start();
        } else if (i == R.id.model_button_4) {
            ObjectAnimator.ofFloat(mAnimationView,"alpha",0.25f,1)
                    .setDuration(3000)
                    .start();
        }else if (i == R.id.model_button_5) {
            Animator animator1 = ObjectAnimator.ofFloat(mAnimationView,"scaleX",0.25f,1)
                    .setDuration(3000);
            Animator animator2 = ObjectAnimator.ofFloat(mAnimationView,"scaleY",0.25f,1)
                    .setDuration(3000);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(animator1).with(animator2);
            animatorSet.start();
        }
    }
}
