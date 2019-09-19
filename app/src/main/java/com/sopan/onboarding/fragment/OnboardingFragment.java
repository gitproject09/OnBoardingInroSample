package com.sopan.onboarding.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.sopan.onboarding.R;
import com.sopan.onboarding.utils.OnboardingCard;

public class OnboardingFragment extends Fragment {

    private static final String PAGE_TITLE = "page_title";
    private static final String PAGE_TITLE_RES_ID = "page_title_res_id";
    private static final String PAGE_TITLE_COLOR = "page_title_color";
    private static final String PAGE_TITLE_TEXT_SIZE = "page_title_text_size";
    private static final String PAGE_DESCRIPTION = "page_description";
    private static final String PAGE_DESCRIPTION_RES_ID = "page_description_res_id";
    private static final String PAGE_DESCRIPTION_COLOR = "page_description_color";
    private static final String PAGE_DESCRIPTION_TEXT_SIZE = "page_description_text_size";
    private static final String PAGE_IMAGE_RES_ID = "page_image_res_id";
    private static final String PAGE_BACKGROUND_COLOR = "page_background_color";
    private static final String PAGE_ICON_WIDTH = "page_icon_width";
    private static final String PAGE_ICON_HEIGHT = "page_icon_height";
    private static final String PAGE_MARGIN_LEFT = "page_margin_left";
    private static final String PAGE_MARGIN_RIGHT = "page_margin_right";
    private static final String PAGE_MARGIN_TOP = "page_margin_top";
    private static final String PAGE_MARGIN_BOTTOM = "page_margin_bottom";


    private String title;
    private String description;
    @StringRes
    private int titleResId;
    @ColorRes
    private int titleColor;
    @StringRes
    private int descriptionResId;
    @ColorRes
    private int backgroundColor;
    @ColorRes
    private int descriptionColor;
    @DrawableRes
    private int imageResId;
    private float titleTextSize;
    private float descriptionTextSize;

    private View view;
    private ImageView ivOnboarderImage;
    private TextView tvOnboarderTitle;
    private TextView tvOnboarderDescription;
    private CardView cardView;
    private int iconHeight, iconWidth;
    private int marginTop, marginBottom, marginLeft, marginRight;

    public OnboardingFragment() {
    }

    public static OnboardingFragment newInstance(OnboardingCard card) {
        Bundle args = new Bundle();
        args.putString(PAGE_TITLE, card.getTitle());
        args.putString(PAGE_DESCRIPTION, card.getDescription());
        args.putInt(PAGE_TITLE_RES_ID, card.getTitleResourceId());
        args.putInt(PAGE_DESCRIPTION_RES_ID, card.getDescriptionResourceId());
        args.putInt(PAGE_TITLE_COLOR, card.getTitleColor());
        args.putInt(PAGE_DESCRIPTION_COLOR, card.getDescriptionColor());
        args.putInt(PAGE_IMAGE_RES_ID, card.getImageResourceId());
        args.putFloat(PAGE_TITLE_TEXT_SIZE, card.getTitleTextSize());
        args.putFloat(PAGE_DESCRIPTION_TEXT_SIZE, card.getDescriptionTextSize());
        args.putInt(PAGE_BACKGROUND_COLOR, card.getBackgroundColor());
        args.putInt(PAGE_ICON_HEIGHT, card.getIconHeight());
        args.putInt(PAGE_ICON_WIDTH, card.getIconWidth());
        args.putInt(PAGE_MARGIN_LEFT, card.getMarginLeft());
        args.putInt(PAGE_MARGIN_RIGHT, card.getMarginRight());
        args.putInt(PAGE_MARGIN_TOP, card.getMarginTop());
        args.putInt(PAGE_MARGIN_BOTTOM, card.getMarginBottom());

        OnboardingFragment fragment = new OnboardingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        Bundle bundle = getArguments();

        title = bundle.getString(PAGE_TITLE, null);
        titleResId = bundle.getInt(PAGE_TITLE_RES_ID, 0);
        titleColor = bundle.getInt(PAGE_TITLE_COLOR, 0);
        titleTextSize = bundle.getFloat(PAGE_TITLE_TEXT_SIZE, 0f);
        description = bundle.getString(PAGE_DESCRIPTION, null);
        descriptionResId = bundle.getInt(PAGE_DESCRIPTION_RES_ID, 0);
        descriptionColor = bundle.getInt(PAGE_DESCRIPTION_COLOR, 0);
        descriptionTextSize = bundle.getFloat(PAGE_DESCRIPTION_TEXT_SIZE, 0f);
        imageResId = bundle.getInt(PAGE_IMAGE_RES_ID, 0);
        backgroundColor = bundle.getInt(PAGE_BACKGROUND_COLOR, 0);
        iconWidth = bundle.getInt(PAGE_ICON_WIDTH, (int) dpToPixels(128, getActivity()));
        iconHeight = bundle.getInt(PAGE_ICON_HEIGHT, (int) dpToPixels(128, getActivity()));
        marginTop = bundle.getInt(PAGE_MARGIN_TOP, (int) dpToPixels(80, getActivity()));
        marginBottom = bundle.getInt(PAGE_MARGIN_BOTTOM, (int) dpToPixels(0, getActivity()));
        marginLeft = bundle.getInt(PAGE_MARGIN_LEFT, (int) dpToPixels(0, getActivity()));
        marginRight = bundle.getInt(PAGE_MARGIN_RIGHT, (int) dpToPixels(0, getActivity()));

        view = inflater.inflate(R.layout.fragment_onboarding, container, false);
        ivOnboarderImage = (ImageView) view.findViewById(R.id.iv_image);
        tvOnboarderTitle = (TextView) view.findViewById(R.id.tv_title);
        tvOnboarderDescription = (TextView) view.findViewById(R.id.tv_description);
        cardView = (CardView) view.findViewById(R.id.cv_cardview);

        if (title != null) {
            tvOnboarderTitle.setText(title);
        }

        if (titleResId != 0) {
            tvOnboarderTitle.setText(getResources().getString(titleResId));
        }

        if (description != null) {
            tvOnboarderDescription.setText(description);
        }

        if (descriptionResId != 0) {
            tvOnboarderDescription.setText(getResources().getString(descriptionResId));
        }

        if (titleColor != 0) {
            tvOnboarderTitle.setTextColor(ContextCompat.getColor(getActivity(), titleColor));
        }

        if (descriptionColor != 0) {
            tvOnboarderDescription.setTextColor(ContextCompat.getColor(getActivity(), descriptionColor));
        }

        if (imageResId != 0) {
            ivOnboarderImage.setImageDrawable(ContextCompat.getDrawable(getActivity(), imageResId));
        }

        if (titleTextSize != 0f) {
            tvOnboarderTitle.setTextSize(titleTextSize);
        }

        if (descriptionTextSize != 0f) {
            tvOnboarderDescription.setTextSize(descriptionTextSize);
        }

        if (backgroundColor != 0) {
            cardView.setCardBackgroundColor(ContextCompat.getColor(getActivity(), backgroundColor));
        }

        if (iconWidth != 0 && iconHeight != 0) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iconWidth, iconHeight);
            layoutParams.gravity = Gravity.CENTER_HORIZONTAL;
            layoutParams.setMargins(marginLeft, marginTop, marginRight, marginBottom);
            ivOnboarderImage.setLayoutParams(layoutParams);
        }

        return view;
    }

    public float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public CardView getCardView() {
        return cardView;
    }

    public TextView getTitleView() {
        return tvOnboarderTitle;
    }

    public TextView getDescriptionView() {
        return tvOnboarderDescription;
    }
}
