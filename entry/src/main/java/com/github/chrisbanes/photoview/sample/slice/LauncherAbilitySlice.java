package com.github.chrisbanes.photoview.sample.slice;

import com.github.chrisbanes.photoview.sample.ResourceTable;
import com.github.chrisbanes.photoview.sample.provider.ListProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

import ohos.aafwk.content.Operation;
import ohos.agp.components.Component;
import ohos.agp.components.ListContainer;
import ohos.agp.window.dialog.ToastDialog;

import java.util.ArrayList;
import java.util.List;

public class LauncherAbilitySlice extends AbilitySlice {

    public static final String[] options = {
            "Simple Sample",
            "ViewPager Sample",
            "Rotation Sample",
            "Picasso Sample",
            "Coil Sample",
            "Activity Transition Sample",
            "Immersive Sample"
    };

    private ListContainer listText;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_launcher);
        listText = (ListContainer) findComponentById(ResourceTable.Id_listText);
        // 拿到ListProvider的对象
        ListProvider listProvider = new ListProvider(this, options);
        // 将ListProvider的对象设置给ListContainer控件,展示数据
        listText.setItemProvider(listProvider);
        listText.setItemClickedListener((listContainer, component, position, id) -> {
            new ToastDialog(LauncherAbilitySlice.this).setContentText(String.format("你点击了第%d行", position)).show();
            switch (position) {
                case 0:
                    Intent intent0 = new Intent();
                    Operation operation0 = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.github.chrisbanes.photoview.sample")
                            .withAbilityName("com.github.chrisbanes.photoview.sample.SimpleSampleAbility")
                            .build();
                    intent0.setOperation(operation0);
                    startAbility(intent0);
                    break;
                case 1:
//                    clazz = ViewPagerActivity.class;
                    break;
                case 2:
                    Intent intent2 = new Intent();
                    Operation operation2 = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.github.chrisbanes.photoview.sample")
                            .withAbilityName("com.github.chrisbanes.photoview.sample.RotationSampleAbility")
                            .build();
                    intent2.setOperation(operation2);
                    startAbility(intent2);
                    break;
                case 3:
//                    clazz = PicassoSampleActivity.class;
                    break;
                case 4:
//                    clazz = CoilSampleActivity.class;
                    break;
                case 5:
//                    clazz = ActivityTransitionActivity.class;
                    break;
                case 6:
//                    clazz = ImmersiveActivity.class;
                    break;
            }

        });
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

}
