package com.github.chrisbanes.photoview.sample.slice;

import com.github.chrisbanes.photoview.sample.ResourceTable;
import com.github.chrisbanes.photoview.sample.provider.ImageProvider;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

import ohos.aafwk.content.Operation;
import ohos.agp.components.Component;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.DirectionalLayout.LayoutConfig;
import ohos.agp.components.ListContainer;
import ohos.agp.components.Text;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;
import ohos.agp.window.dialog.ToastDialog;

import java.util.ArrayList;
import java.util.List;

public class TransitionAbilitySlice extends AbilitySlice {
    private List<Integer>imgs=new ArrayList<>();
    private ImageProvider imageProvider;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        setUIContent(ResourceTable.Layout_ability_transition);
        ListContainer list =(ListContainer) findComponentById(ResourceTable.Id_list);
        imgs.add(ResourceTable.Media_wallpaper);
        imgs.add(ResourceTable.Media_wallpaper);
        imgs.add(ResourceTable.Media_wallpaper);
        imgs.add(ResourceTable.Media_wallpaper);
        imgs.add(ResourceTable.Media_wallpaper);
        imageProvider=new ImageProvider(this,imgs);
        list.setItemProvider(imageProvider);
        list.setItemClickedListener(new ListContainer.ItemClickedListener() {
            @Override
            public void onItemClicked(ListContainer listContainer, Component component, int i, long l) {
                transition(component);
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

    private void transition(Component view) {
            Intent intent = new Intent();
            Operation option = new Intent.OperationBuilder()
                     .withDeviceId("")
                    .withBundleName("com.github.chrisbanes.photoview.sample")
                    .withAbilityName("com.github.chrisbanes.photoview.sample.SimpleSampleAbility")
                    .build();
            intent.setOperation(option);
            startAbility(intent);
    }
}
