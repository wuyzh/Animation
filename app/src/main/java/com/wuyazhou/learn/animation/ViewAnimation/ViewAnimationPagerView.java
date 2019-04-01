package com.wuyazhou.learn.animation.ViewAnimation;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.wuyazhou.learn.animation.R;

/**
 * @author 吴亚洲
 * @date 2018.7.7
 * @function
 */
public class ViewAnimationPagerView extends FrameLayout implements View.OnClickListener {
    private Context mContext = null;
    private RelativeLayout mLayout;
    private View mAnimationView;
    private Animation mAnimationTranslate;
    private Animation mAnimationScale;
    private Animation mAnimationRotate;
    private Animation mAnimationAlpha;
    private AnimationSet mAnimationSet;

    public ViewAnimationPagerView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public ViewAnimationPagerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public ViewAnimationPagerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }

    public void initView() {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mLayout = (RelativeLayout) inflater.inflate(R.layout.pager_view_animation_layout, null);

        addView(mLayout);

        View modelFirst  = mLayout.findViewById(R.id.model_button_1);
        modelFirst.setOnClickListener(this);
        View modelSecond  = mLayout.findViewById(R.id.model_button_2);
        modelSecond.setOnClickListener(this);
        View modelThird  = mLayout.findViewById(R.id.model_button_3);
        modelThird.setOnClickListener(this);
        View modelFourth  = mLayout.findViewById(R.id.model_button_4);
        modelFourth.setOnClickListener(this);
        View modelFifth = mLayout.findViewById(R.id.model_button_5);
        modelFifth.setOnClickListener(this);

        mAnimationView = mLayout.findViewById(R.id.view);

        mAnimationTranslate = AnimationUtils.loadAnimation(mContext,R.anim.view_translate);
        mAnimationScale = AnimationUtils.loadAnimation(mContext,R.anim.view_scale);
        mAnimationRotate = AnimationUtils.loadAnimation(mContext,R.anim.view_rotate);
        mAnimationAlpha = AnimationUtils.loadAnimation(mContext,R.anim.view_alpha);

        mAnimationSet = new AnimationSet(true);
        mAnimationSet.addAnimation(mAnimationTranslate);
        mAnimationSet.addAnimation(mAnimationScale);
        mAnimationSet.addAnimation(mAnimationRotate);
        mAnimationSet.addAnimation(mAnimationAlpha);
        mAnimationSet.setFillAfter(true);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.model_button_1) {
            mAnimationView.startAnimation(mAnimationTranslate);
        } else if (i == R.id.model_button_2) {
            mAnimationView.startAnimation(mAnimationRotate);
        } else if (i == R.id.model_button_3) {
            mAnimationView.startAnimation(mAnimationScale);
        }else if (i == R.id.model_button_4) {
            mAnimationView.startAnimation(mAnimationAlpha);
        }else if (i == R.id.model_button_5){
            mAnimationView.startAnimation(mAnimationSet);
        }
    }
}
