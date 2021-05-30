package com.chithien.vvct.bai_3_vovanchithien_b1704852;

import android.accessibilityservice.AccessibilityService;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.renderscript.Sampler;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class VeCoBan extends View {

    private final Paint paint = new Paint();
    Context vcontext;

    public VeCoBan(Context context) {
        super(context);
    }

    public VeCoBan(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public VeCoBan(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public VeCoBan(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Lấy kích thước màn hình
        int w_canvas = canvas.getWidth();
        int h_canvas = canvas.getHeight();

        // Vẽ nền
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);
        // Vẽ chuỗi ký tự
        paint.setColor(Color.RED);
        paint.setTextSize(60);
        canvas.drawText("LẬP TRÌNH GIAO DIỆN MỨC THẤP", 10, 100, paint);
        // Vẽ chuỗi kích thước
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        canvas.drawText("Chiều rộng màn hình: " + w_canvas, 10, 180, paint);
        canvas.drawText("Chiều rộng màn hình: " + h_canvas, 10, 260, paint);

        // Vẽ 1 cung
        paint.setColor(Color.RED);
        canvas.drawArc(5,300,485,950,225, 90,true, paint);

        // Vẽ hình tròn
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10);
        canvas.drawCircle(615,500,160,paint);

        // Vẽ đường line
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);
        canvas.drawLine(800,350,1050,600, paint);

        // Vẽ hình chữ nhật
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(50, 800, 1050, 2000, paint);



        // Vẽ chuỗi ký tự
        paint.setColor(Color.RED);
        canvas.rotate(-45, canvas.getWidth()/4, canvas.getHeight()/4+450); // Quay canvas -45 độ
        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
        canvas.drawText("Seahorse", canvas.getWidth()/4-50, 3*canvas.getHeight()/4+150, paint);
        //canvas.restore();
        canvas.rotate(45, (canvas.getWidth()/2), canvas.getHeight()/4+450); // Quay canvas trở lại (thay hàm restore)

        // Vẽ bitmap
        Resources res = this.getResources();
        Bitmap bit = BitmapFactory.decodeResource(res,R.drawable.seahorse);
        float d=bit.getWidth(); //the width of the bitmap
        float xstar=canvas.getWidth()/8; //the coordinates of the left edge of the rectangle
        float ystar=3*canvas.getHeight()/4 ; //the coordinates of the top edge of the rectangle
        RectF rectF2 = new RectF(xstar+20,ystar-20, xstar+d,ystar+d+20); //defined rectangle

        canvas.drawBitmap(bit,null,rectF2,paint);
    }
}
