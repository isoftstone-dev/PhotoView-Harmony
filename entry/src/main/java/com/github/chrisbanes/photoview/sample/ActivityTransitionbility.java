package com.github.chrisbanes.photoview.sample;

import com.github.chrisbanes.photoview.sample.slice.ActivityTransitionbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class ActivityTransitionbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(ActivityTransitionbilitySlice.class.getName());
    }
}
