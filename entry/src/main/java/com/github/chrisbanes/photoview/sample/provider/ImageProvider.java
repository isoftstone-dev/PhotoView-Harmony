package com.github.chrisbanes.photoview.sample.provider;

import com.github.chrisbanes.photoview.sample.ResourceTable;
import ohos.agp.components.*;
import ohos.app.Context;

import java.util.List;

public class ImageProvider extends BaseItemProvider {
    private Context context;
    private List<Integer>imgs;

    public ImageProvider(Context context, List<Integer> imgs) {
        this.context = context;
        this.imgs = imgs;
    }

    @Override
    public int getCount() {
        return imgs.size();
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
          ViewHodler viewHolder;
        // component相当于Android中的view，其他的和Android中ListView的适配器adapter差不多。
        // 名字区别也不大，不过Android中ListView基本被淘汰了。
        if (component == null) {
            component =LayoutScatter.getInstance(context).parse(ResourceTable.Layout_item_img, null, false);
            viewHolder = new ViewHodler();
            viewHolder.image = (Image) component.findComponentById(ResourceTable.Id_img);
            component.setTag(viewHolder);
        } else {
            viewHolder = (ViewHodler) component.getTag();
        }
        viewHolder.image.setImageAndDecodeBounds(imgs.get(i));
        return component;
    }

    public static class ViewHodler{
        private  Image image;
    }
}
