package com.chithien.vvct.bai_3_vovanchithien_b1704852;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    // Khai báo điều kiện
    boolean b1= false, b2= false, b3= false, b4= false, btrove= false;

    VeCoBan ve = null;
    ChuyenDong chuyenDong = null;
    TuongTac tuongTac = null;
    SurfaceView view = null;
    MainScreen mainScreen = null;
//    // Chạy lớp VeCoBan
//    VeCoBan ve;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        ve = new VeCoBan(this);
//        setContentView(ve);
//    }

//    // Chạy lớp ChuyenDong
//    ChuyenDong cd;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        cd = new ChuyenDong(this);
//        setContentView(cd);
//    }

//    // Chạy lớp GamePanel
//    GamePanel gp;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //setContentView(R.layout.activity_main);
//        gp = new GamePanel(this);
//        setContentView(gp);
//    }
    // Chạy tất cả
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Khai báo
        final FrameLayout hienthi = (FrameLayout)findViewById(R.id.framelayout);
        Button bai1 = (Button) findViewById(R.id.class1);
        Button bai2 = (Button) findViewById(R.id.class2);
        Button bai3 = (Button) findViewById(R.id.class3);
        Button bai4 = (Button) findViewById(R.id.class4);
        Button thoat = (Button)findViewById(R.id.button1);
        Button trove = (Button)findViewById(R.id.button2);





        // Xử lý sự kiện
        // Hiển thị lớp VeCoBan
        bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view!=null || tuongTac!=null || chuyenDong!=null || mainScreen!=null) {
                    hienthi.removeView(view);
                    hienthi.removeView(tuongTac);
                    hienthi.removeView(chuyenDong);
                    hienthi.removeView(mainScreen);
                }
                ve = new VeCoBan(hienthi.getContext());
                hienthi.addView(ve);
            }
        });

        // Hiển thị lớp ChuyenDong
        bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view!=null || ve!=null || tuongTac!=null || mainScreen!=null) {
                    hienthi.removeView(view);
                    hienthi.removeView(ve);
                    hienthi.removeView(tuongTac);
                    hienthi.removeView(mainScreen);
                }
                chuyenDong = new ChuyenDong(hienthi.getContext());
                hienthi.addView(chuyenDong);
            }
        });

        // Hiển thị lớp TuongTac
        bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view!=null || ve!=null || chuyenDong!=null || mainScreen!=null) {
                    hienthi.removeView(view);
                    hienthi.removeView(ve);
                    hienthi.removeView(chuyenDong);
                    hienthi.removeView(mainScreen);
                }
                tuongTac = new TuongTac(hienthi.getContext());
                hienthi.addView(tuongTac);
            }
        });

        // Hiển thị lớp GamePanel
        bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view!=null || ve!=null || chuyenDong!=null || mainScreen!=null){
                    hienthi.removeView(ve);
                    hienthi.removeView(tuongTac);
                    hienthi.removeView(chuyenDong);
                    hienthi.removeView(mainScreen);
                }
                view = new GamePanel(hienthi.getContext());
                hienthi.removeView(view);
                hienthi.addView(view);
            }
        });

        // Setting nút Thoát
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });

        // Setting nút Trở về
        trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view!=null || ve!=null || chuyenDong!=null || tuongTac!=null){
                    hienthi.removeView(ve);
                    hienthi.removeView(tuongTac);
                    hienthi.removeView(chuyenDong);
                    hienthi.removeView(tuongTac);
                }
                    mainScreen = new MainScreen(hienthi.getContext());
                hienthi.addView(mainScreen);
            }
        });
    }
}
