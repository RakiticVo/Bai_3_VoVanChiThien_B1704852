package com.chithien.vvct.bai_3_vovanchithien_b1704852;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class TuongTac extends View {

    // Khai báo
    public final Paint paint =new Paint();
    public final Canvas canvas =new Canvas();
    public float x= 50;
    public float y=50;
    public int duongkinh;
    public String st=" Begin test touch";

    public TuongTac(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Setting nền
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        // Setting bitmap
        paint.setColor(Color.BLUE);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ball);
        canvas.drawBitmap(bitmap, x,y, paint);
        duongkinh = bitmap.getWidth();

        // Setting text
        paint.setTextSize(70);
        canvas.drawText(st, x, y, paint);
    }

    // Xử lý sự kiện
    public boolean onTouchEvent(MotionEvent event){
        switch (event.getAction()){
            // Khi người dùng nhấn vào quả bóng network
            case MotionEvent.ACTION_DOWN:
                // Xác định vị trí quả bóng và text
                x = event.getX() - (duongkinh/2);
                y = event.getY() - (duongkinh/2);
                st= "ACTION Down";
                break;
            // Khi người dùng chạm và giữ quả bóng network
            case MotionEvent.ACTION_MOVE:
                // Xác định vị trí quả bóng và text
                x = event.getX() - (duongkinh/2);
                y = event.getY() - (duongkinh/2);
                st="ACTION Move";
                break;
            // Khi người dùng nhấy tay ra khỏi màn hình
            case MotionEvent.ACTION_UP:
                // Xác định vị trí quả bóng và text
                x = event.getX() - (duongkinh/2);
                y = event.getY() - (duongkinh/2);
                st="ACTION Up";
                break;
        }
        // Chạy lại hảm
        invalidate();
        return true;
    }
}
