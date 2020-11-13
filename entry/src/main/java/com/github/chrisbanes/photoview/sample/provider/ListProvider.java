package com.github.chrisbanes.photoview.sample.provider;

import com.github.chrisbanes.photoview.sample.ResourceTable;
import ohos.agp.components.*;
import ohos.app.Context;

/**
 * 适配器
 */
public class ListProvider extends RecycleItemProvider {

    private String[] data;
    private LayoutScatter layoutScatter;

    public ListProvider(Context context, String[] data) {
        this.data = data;
        this.layoutScatter = LayoutScatter.getInstance(context);
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public Component getComponent(int i, Component component, ComponentContainer componentContainer) {
        ViewHolder viewHolder;
        // component相当于Android中的view，其他的和Android中ListView的适配器adapter差不多。
        // 名字区别也不大，不过Android中ListView基本被淘汰了。
        if (component == null) {
            component = layoutScatter.parse(ResourceTable.Layout_item_layout, null, false);
            viewHolder = new ViewHolder();
            viewHolder.tvItemName = (Text) component.findComponentById(ResourceTable.Id_tvItemName);
            component.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) component.getTag();
        }
        viewHolder.tvItemName.setText(data[i]);
        return component;
    }

    /**
     * 类似于Android中的listView缓存。
     * 将已经显示在屏幕上的item缓存在ViewHolder中，下次再次出现直接从缓存中读取
     */
    static class ViewHolder {
        public Text tvItemName;
    }

}