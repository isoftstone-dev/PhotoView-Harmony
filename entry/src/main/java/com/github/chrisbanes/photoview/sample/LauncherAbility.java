package com.github.chrisbanes.photoview.sample;

import com.github.chrisbanes.photoview.sample.slice.LauncherAbilitySlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class LauncherAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(LauncherAbilitySlice.class.getName());
    }
}
