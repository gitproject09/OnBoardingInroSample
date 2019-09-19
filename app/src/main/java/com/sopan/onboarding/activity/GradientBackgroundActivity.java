package com.sopan.onboarding.activity;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import com.sopan.onboarding.R;
import com.sopan.onboarding.utils.OnboardingCard;

import java.util.ArrayList;
import java.util.List;

public class GradientBackgroundActivity extends OnboardingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnboardingCard OnboarderCard1 = new OnboardingCard("City Guide", "Detailed guides to help you plan your trip.", R.drawable.backpack);
        OnboardingCard OnboarderCard2 = new OnboardingCard("Travel Blog", "Share your travel experiences with a vast network of fellow travellers.", R.drawable.chalk);
        OnboardingCard OnboarderCard3 = new OnboardingCard("Chat", "Connect with like minded people and exchange your travel stories.", R.drawable.chat);

        OnboarderCard1.setBackgroundColor(R.color.black_transparent);
        OnboarderCard2.setBackgroundColor(R.color.black_transparent);
        OnboarderCard3.setBackgroundColor(R.color.black_transparent);

        List<OnboardingCard> pages = new ArrayList<>();

        pages.add(OnboarderCard1);
        pages.add(OnboarderCard2);
        pages.add(OnboarderCard3);

        for (OnboardingCard page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.grey_200);
            //page.setTitleTextSize(dpToPixels(12, this));
            //page.setDescriptionTextSize(dpToPixels(8, this));
            //page.setIconLayoutParams(width, height, marginTop, marginLeft, marginRight, marginBottom);
        }

        setFinishButtonTitle("Finish");
        showNavigationControls(true);
        setGradientBackground();

        //set the button style you created
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            setFinishButtonDrawableStyle(ContextCompat.getDrawable(this, R.drawable.rounded_button));
        }

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        setFont(face);

        setOnboardPages(pages);
    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show();
    }
}
