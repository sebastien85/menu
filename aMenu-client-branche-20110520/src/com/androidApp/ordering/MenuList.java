package com.androidApp.ordering;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.TabHost;

/**
 *  菜单信息列表
 *  Comment of MenuList 2011-6-28
 * 
 * @author 轩
 */
public class MenuList extends TabActivity {
    
    private CheckBox menuSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost tabHost = getTabHost();
        
        LayoutInflater.from(this).inflate(R.layout.menulist, tabHost.getTabContentView(), true);
        Intent menuListContent=new Intent(this, MenuListContent.class);
        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("tab1",getResources().getDrawable(R.drawable.promotion)).setContent(menuListContent));
        
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("tab2",getResources().getDrawable(R.drawable.insert_to_order_cart)).setContent(menuListContent));
       // setContentView(R.layout.menulist);
//        SimpleAdapter simpleAdapter = new SimpleAdapter(this, this.getData(), R.layout.menulist,
//                new String[] { "image", "title", "info" }, new int[] { R.id.menu_image,
//                        R.id.menu_title, R.id.menu_info });
        /**setListAdapter(simpleAdapter);
       
        this.menuSelect= (CheckBox) findViewById(R.id.menu_select);
        menuSelect.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                String str="";
                if(arg1){
                    str="选中";
                }else{
                    str="未选中";
                }
                Toast toast=Toast.makeText(MenuList.this,str , Toast.LENGTH_SHORT);  
                //设置Toast的显示位置  
                toast.setGravity(Gravity.TOP, 0, 220);  
                //显示Toast  
                toast.show();  
                
            }
        });
        */
        
    }


}
