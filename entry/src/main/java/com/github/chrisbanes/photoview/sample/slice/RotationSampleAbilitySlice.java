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

    private int right = 0;
    private int left = 0;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        LayoutConfig config = new LayoutConfig(LayoutConfig.MATCH_PARENT, LayoutConfig.MATCH_PARENT);
        myLayout.setLayoutConfig(config);
        ShapeElement element = new ShapeElement();
        element.setRgbColor(new RgbColor(255, 255, 255));
        myLayout.setBackground(element);

        mPhotoView = new PhotoView(this);
        mPhotoView.setWidth(800);
        mPhotoView.setHeight(400);
        myLayout.addComponent(mPhotoView);
        mPhotoView.setImageAndDecodeBounds(ResourceTable.Media_wallpaper);

        Text turnRight = new Text(this);
        turnRight.setWidth(150);
        turnRight.setHeight(80);
        turnRight.setText("向右旋转10°");
        turnRight.setTextColor(new Color(0xFF000000));
        turnRight.setTextSize(25);
        myLayout.addComponent(turnRight);

        Text turnLeft = new Text(this);
        turnLeft.setWidth(150);
        turnLeft.setHeight(80);
        turnLeft.setText("向左旋转10°");
        turnLeft.setTextColor(new Color(0xFF000000));
        turnLeft.setTextSize(25);
        myLayout.addComponent(turnLeft);

        Text turn90 = new Text(this);
        turn90.setWidth(150);
        turn90.setHeight(80);
        turn90.setText("旋转90°");
        turn90.setTextColor(new Color(0xFF000000));
        turn90.setTextSize(25);
        myLayout.addComponent(turn90);

        Text turn180 = new Text(this);
        turn180.setWidth(150);
        turn180.setHeight(80);
        turn180.setText("旋转90°");
        turn180.setTextColor(new Color(0xFF000000));
        turn180.setTextSize(25);
        myLayout.addComponent(turn180);

//        Text autoRotate = new Text(this);
//        autoRotate.setWidth(150);
//        autoRotate.setHeight(80);
//        autoRotate.setText("自动旋转");
//        autoRotate.setTextColor(new Color(0xFF000000));
//        autoRotate.setTextSize(25);
//        myLayout.addComponent(autoRotate);

        super.setUIContent(myLayout);

        turnRight.setClickedListener(component -> {
            right += 10;
            mPhotoView.setRotationTo(right, 1000);
        });

        turnLeft.setClickedListener(component -> {
            left -= 10;
            mPhotoView.setRotationTo(left, 1000);
        });

        turn90.setClickedListener(component -> {
            mPhotoView.setRotationTo(90, 1000);
        });

        turn180.setClickedListener(component -> {
            mPhotoView.setRotationTo(180, 500);
        });

//        autoRotate.setClickedListener(component -> {
//            AnimatorProperty anim = new AnimatorProperty(mPhotoView);
//            anim.rotate(left).setDuration(1000).start();
//        });

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
