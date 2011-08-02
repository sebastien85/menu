package com.androidApp.ordering;

import com.androidApp.ordering.service.OrderService;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TableLayout;

/**
 * TODO Comment of Main 2011-6-26
 * 
 * @author 轩
 */
public class Main extends Activity {

    private LayoutInflater inflater;
    private TableLayout    mainLayout;
    private Animation      slideLeft;
    private ImageButton    itemList, createOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        this.slideLeft = AnimationUtils.loadAnimation(this, R.anim.slide_left);
        this.mainLayout = (TableLayout) findViewById(R.id.main_layout);
        itemList = (ImageButton) findViewById(R.id.item_list);
        createOrder = (ImageButton) findViewById(R.id.create_order);
        //        this.itemList=(ImageView) findViewById(R.id.item_list);
        //        mainLayout.startAnimation(slideLeft);
        //        this.itemList.startAnimation(slideLeft);
        itemList.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                turnToMenuList();

            }
        });

        createOrder.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                inflater = LayoutInflater.from(Main.this);
                final View orderDialogView = inflater.inflate(R.layout.orderdialog, null);
                
                AlertDialog orderDialog = new AlertDialog.Builder(Main.this)
                        .setTitle(getResources().getText(R.string.order_dialog_title))
                        .setView(orderDialogView)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            
                            private OrderService orderService=new OrderService();

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                                if(orderService.createOrder())
                                    turnToMenuList();

                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            
                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
                               
                                
                            }
                        }).create();
                orderDialog.show();
            }
        });
    }

    private void turnToMenuList() {
        new Thread() {
            @Override
            public void run() {
                Intent menuList = new Intent(Main.this, MenuList.class);
                startActivity(menuList);
                finish();
            }

        }.start();
    }

}
