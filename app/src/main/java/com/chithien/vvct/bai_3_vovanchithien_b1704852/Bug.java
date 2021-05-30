package com.chithien.vvct.bai_3_vovanchithien_b1704852;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Bug {
    // Khai báo
    Bitmap background; // ảnh nền
    Bitmap bitmap; // ảnh bug
    int dia; // chiều rộng của ảnh bug
//    int x = 70; //vị trí (x,y)
//    int y = 70;
    int w, h;
    int sX = 10; // khoảng cách tịnh tiến
    int sY = 10;

    Random r = new Random();
    int x = r.nextInt(70);
    int y = r.nextInt(70);

//    int sX = r.nextInt(10);; // khoảng cách tịnh tiến
//    int sY = r.nextInt(10);;


    // Hàm xây dựng
    public Bug(Context context){
        Resources res = context.getResources();
        bitmap = BitmapFactory.decodeResource(res, R.drawable.bug);
        background = BitmapFactory.decodeResource(res, R.drawable.background);
    }

    // Hàm hiển thị
    public void onDraw(Canvas c)
    {
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        dia = bitmap.getWidth(); // lấy chiều rộng ảnh bug
        w = c.getWidth(); // lấy chiều rộng của màn hình
        h = c.getHeight(); // lấy chiều cao của màn hình
        c.drawPaint(paint); // Vẽ nền
        c.drawBitmap(background, 0, 0, paint); // Setting ảnh nền
        c.drawBitmap(bitmap, x, y, paint); // Setting ảnh bug
        // tịnh tién
        x += sX;
        y += sY;
        // Nếu chạm biên thì quay lại
        // So sánh x<=0 hoặc x>= chiều rộng của màn hình - cho chiều rộng của ảnh bug
        if (x<=0||(x>=w-dia)) {
            sX = -sX;
        }
        // So sánh y<=0 hoặc y>= chiều cao của màn hình - cho chiều rộng của ảnh bug
        if (y<=0||y>=h-dia) {
            sY = -sY;
        }
    }
}
