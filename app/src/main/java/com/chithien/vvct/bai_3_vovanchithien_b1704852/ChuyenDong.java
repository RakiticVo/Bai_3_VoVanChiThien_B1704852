package com.chithien.vvct.bai_3_vovanchithien_b1704852;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class ChuyenDong extends View {

    private final Paint paint = new Paint();
    public int x=0;
    public int y=0;
    private int Vx=5,Vy=5;
    private int duongkinh = 30;
    Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.internet);

    public ChuyenDong(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        canvas.drawBitmap(bitmap, x, y, paint);
        duongkinh = bitmap.getWidth();
        update();
        invalidate(); // Vẽ lại
    }

    private void update() {
        // Lấy vị trí mới có tọa độ (x,y)
        x = x + Vx;
        y = y + Vy;
        // Nếu chạm biên thì quay lại
        if (x<=0||(x>=getWidth()-duongkinh))
        {
            Vx = -Vx;
            bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.network);
        }
        if (y<=0||y>=getHeight()-duongkinh)
        {
            Vy = -Vy;
            bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.internet);
        }
    }
}
