package com.androidApp.ordering;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MenuAdapter extends BaseAdapter {
    
    private LayoutInflater inflater;
    private List<Map<String, Object>> menus;
    private Activity context;
    private int position;
    
    public MenuAdapter(Activity context,List<Map<String, Object>> menus) {
        inflater=LayoutInflater.from(context);
        this.menus=menus;
        this.context=context;
    }

    @Override
    public int getCount() {
        return menus.size();
    }

    @Override
    public Object getItem(int arg0) {
        return arg0;
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        this.position=position;
        Map<String, Object> row;
        if(convertView==null){
            convertView=this.inflater.inflate(R.layout.menuadapter, null);
            viewHolder=new ViewHolder();
            viewHolder.menuImage=(ImageView) convertView.findViewById(R.id.menu_image);
            viewHolder.menuInfo=(TextView) convertView.findViewById(R.id.menu_info);
            viewHolder.menuTitle=(TextView) convertView.findViewById(R.id.menu_title);
            viewHolder.menuButton=(ImageButton) convertView.findViewById(R.id.menu_select);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder) convertView.getTag();
        }
        row=menus.get(position);
//        CharSequence
        int imageId=(Integer) row.get("image");
        viewHolder.menuImage.setImageResource(imageId);
        viewHolder.menuInfo.setText(row.get("info").toString());
        viewHolder.menuTitle.setText(row.get("title").toString());
        viewHolder.menuButton.setId(position);
        viewHolder.menuButton.setOnClickListener(new View.OnClickListener() {
            
            @Override
            public void onClick(View arg0) {
                
                Toast.makeText(context, "当前位置是"+arg0.getId(), Toast.LENGTH_SHORT).show(); 
                
            }
        });
        return convertView;
    }
    
    private int getPosition(){
        return position;
    }
    
    private static  class ViewHolder{
        ImageView menuImage;
        TextView menuTitle;
        TextView menuInfo;
        ImageButton menuButton;
    }

}
