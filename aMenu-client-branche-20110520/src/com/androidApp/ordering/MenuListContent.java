package com.androidApp.ordering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MenuListContent extends Activity {
    private ListView                  menuList;
    private List<Map<String, Object>> menus;
    private ProgressDialog            progressDialog = null;
    private GridView                  toolbarView;
    private Handler                   handler        = new Handler();
    private final int[]               toolbar_images = { R.drawable.toolbar_homepage,
            R.drawable.toolbar_backward, R.drawable.toolbar_forward, R.drawable.toolbar_back };
    private final String[]            toolbar_names  = { "主界面", "上一页", "下一页", "返回" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menulistcontent);
        toolbarView=(GridView) findViewById(R.id.list_toolbar);
        toolbarView.setSelector(R.drawable.toolbar_menu_item);
        toolbarView.setBackgroundResource(R.drawable.toolbar_menu_bg);
        toolbarView.setNumColumns(4);
        toolbarView.setGravity(Gravity.CENTER);
        toolbarView.setVerticalSpacing(10);
        toolbarView.setHorizontalSpacing(10);
        toolbarView.setAdapter(getMenuAdapter());
        menuList = (ListView) findViewById(R.id.menu_list_content);
        this.getMenus();
       
    }

    private void getMenus() {
        progressDialog = ProgressDialog.show(MenuListContent.this, "请稍等...", "获取闲聊列表...", true);
        new Thread() {

            @Override
            public void run() {
                menus = new ArrayList<Map<String, Object>>();
                Map<String, Object> menuInfo = new HashMap<String, Object>();
                menuInfo.put("image", R.drawable.item_list);
                menuInfo.put("title", "菜油花蛤");
                menuInfo.put("info", "非常好吃啊...");
                menus.add(menuInfo);
                Map<String, Object> menuInfo1 = new HashMap<String, Object>();
                menuInfo1.put("image", R.drawable.order_cart);
                menuInfo1.put("title", "菜油花蛤11");
                menuInfo1.put("info", "非常好吃啊111...");
                menus.add(menuInfo1);
                Map<String, Object> menuInfo2 = new HashMap<String, Object>();
                menuInfo2.put("image", R.drawable.promotion);
                menuInfo2.put("title", "菜油花蛤22");
                menuInfo2.put("info", "非常好吃啊222...");
                menus.add(menuInfo2);
                handler.post(new Runnable() {
                    public void run() {
                        //                        SimpleAdapter simpleAdapter = new SimpleAdapter(MenuListContent.this, menus, R.layout.menuadapter,
                        //                                new String[] { "image", "title", "info" }, new int[] { R.id.menu_image,
                        //                                        R.id.menu_title, R.id.menu_info });
                        menuList.setAdapter(new MenuAdapter(MenuListContent.this, menus));
                        progressDialog.dismiss();
                    }
                });

            }

        }.start();
    }

    private SimpleAdapter getMenuAdapter() {
        ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> toolbarItem=null;
        for (int i = 0; i < this.toolbar_names.length; i++) {
            toolbarItem= new HashMap<String, Object>();
            toolbarItem.put("itemImage", this.toolbar_images[i]);
            toolbarItem.put("itemText", this.toolbar_names[i]);
            items.add(toolbarItem);
        }
        SimpleAdapter simperAdapter = new SimpleAdapter(this, items, R.layout.toolbar_item,
                new String[] { "itemImage", "itemText" }, new int[] { R.id.item_image,
                        R.id.item_text });
        return simperAdapter;
    }

}
