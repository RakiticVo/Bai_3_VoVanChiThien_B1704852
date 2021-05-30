package com.chithien.vvct.bai_3_vovanchithien_b1704852;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.view.View;

public class MainScreen extends View {
    private final Paint paint = new Paint();

    public MainScreen(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        paint.setColor(Color.BLUE);
        paint.setTextSize(75);
        paint.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        canvas.drawText("BAI THUC HANH BUOI 2", 138, 120, paint);
    }
}
