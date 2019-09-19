package com.sopan.onboarding.activity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Toast;

import com.sopan.onboarding.R;
import com.sopan.onboarding.utils.OnboardingCard;

import java.util.ArrayList;
import java.util.List;

public class SolidBackgroundActivity extends OnboardingActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        OnboardingCard OnboarderCard1 = new OnboardingCard("Scan Barcode", "Label your packages with a barcode before we collect it from you.", R.drawable.barcode);
        OnboardingCard OnboarderCard2 = new OnboardingCard("Shipping", "Our huge network of shipping partners ensures that your packages are always on schedule.", R.drawable.truck);
        OnboardingCard OnboarderCard3 = new OnboardingCard("Payment", "Receive payments immediately after the package is delivered.", R.drawable.wallet);

        OnboarderCard1.setBackgroundColor(R.color.white);
        OnboarderCard2.setBackgroundColor(R.color.white);
        OnboarderCard3.setBackgroundColor(R.color.white);

        List<OnboardingCard> pages = new ArrayList<>();

        pages.add(OnboarderCard1);
        pages.add(OnboarderCard2);
        pages.add(OnboarderCard3);

        for (OnboardingCard page : pages) {
            page.setTitleColor(R.color.black);
            page.setDescriptionColor(R.color.grey_600);
        }

        setFinishButtonTitle("Finish");
        showNavigationControls(false);

        List<Integer> colorList = new ArrayList<>();
        colorList.add(R.color.solid_one);
        colorList.add(R.color.solid_two);
        colorList.add(R.color.solid_three);

        setColorBackground(colorList);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        setFont(face);

        setOnboardPages(pages);

    }

    @Override
    public void onFinishButtonPressed() {
        Toast.makeText(this, "Finish Pressed", Toast.LENGTH_SHORT).show();
    }
}
