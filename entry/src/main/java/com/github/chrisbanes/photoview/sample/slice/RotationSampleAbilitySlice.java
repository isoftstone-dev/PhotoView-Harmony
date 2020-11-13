package com.github.chrisbanes.photoview.sample.slice;

import com.github.chrisbanes.photoview.PhotoView;
import com.github.chrisbanes.photoview.sample.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;

import ohos.agp.animation.AnimatorProperty;
import ohos.agp.components.DirectionalLayout;
import ohos.agp.components.DirectionalLayout.LayoutConfig;
import ohos.agp.components.Text;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;
import ohos.agp.utils.TextAlignment;

/**
 * 旋转AbilitySlice
 */
public class RotationSampleAbilitySlice extends AbilitySlice {

    private DirectionalLayout myLayout = new DirectionalLayout(this);

    private PhotoView mPhotoView;

    private int count = 0;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        LayoutConfig config = new LayoutConfig(LayoutConfig.MATCH_PARENT, LayoutConfig.MATCH_PARENT);
        myLayout.setLayoutConfig(config);
        ShapeElement element = new ShapeElement();
        element.setRgbColor(new RgbColor(255, 255, 255));
        myLayout.setBackground(element);

        mPhotoView = new PhotoView(this);
//        mPhotoView.setWidth(LayoutConfig.MATCH_CONTENT);
//        mPhotoView.setHeight(LayoutConfig.MATCH_CONTENT);
        mPhotoView.setWidth(800);
        mPhotoView.setHeight(400);
        myLayout.addComponent(mPhotoView);
        mPhotoView.setImageAndDecodeBounds(ResourceTable.Media_wallpaper);

        Text text = new Text(this);
        text.setLayoutConfig(config);
        text.setText("向右旋转10°");
        text.setTextColor(new Color(0xFF000000));
        text.setTextSize(25);
        text.setTextAlignment(TextAlignment.START);
        myLayout.addComponent(text);

        Text text2 = new Text(this);
        text2.setLayoutConfig(config);
        text2.setText("向左旋转10°");
        text2.setTextColor(new Color(0xFF000000));
        text2.setTextSize(25);
//        text2.setTextAlignment(TextAlignment.CENTER);
        myLayout.addComponent(text2);

        super.setUIContent(myLayout);

        text.setClickedListener(component -> {
            count += 10;
            AnimatorProperty anim = new AnimatorProperty(mPhotoView);
            anim.rotate(count).setDuration(1000).start();
        });

        text2.setClickedListener(component -> {
            AnimatorProperty anim = new AnimatorProperty(mPhotoView);
            anim.rotate(-10).setDuration(1000).start();
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
