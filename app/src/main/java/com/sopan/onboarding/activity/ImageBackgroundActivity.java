package com.sopan.onboarding.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Toast;

import com.sopan.onboarding.R;
import com.sopan.onboarding.utils.OnboardingCard;

import java.util.ArrayList;
import java.util.List;

public class ImageBackgroundActivity extends OnboardingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnboardingCard OnboarderCard1 = new OnboardingCard("Link Cards", "Sign up for free by activating your credit cards.", R.drawable.spend);
        OnboardingCard OnboarderCard2 = new OnboardingCard("Dine Out", "Choose from 100's of restaurants with new spots added daily.", R.drawable.food);
        OnboardingCard OnboarderCard3 = new OnboardingCard("Get Cashback", "Earn upto 30% each time you dine with linked cards in network.", R.drawable.reward);

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
        }

        setFinishButtonTitle("Get Started");
        showNavigationControls(true);
        //setGradientBackground();
        setImageBackground(R.drawable.download);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        //setFont(face);

        setInactiveIndicatorColor(R.color.grey_600);
        setActiveIndicatorColor(R.color.white);

        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show();
    }
}
