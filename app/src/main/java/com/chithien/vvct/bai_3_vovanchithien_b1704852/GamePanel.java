package com.chithien.vvct.bai_3_vovanchithien_b1704852;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

import java.sql.Time;
import java.util.Timer;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback {
    // Khai báo
    Bitmap bitmap;
    int count = 10;
    Time time = new Time();
    ThreadView thread;
    int dia; // chiều rộng của ảnh bug
    int kq = 0;
    int x, y;
    int X;
    int Y;
    Bug bug;
    float dis;

    // hàm xây dựng của GamePanel
    public GamePanel(Context context) {
        super(context);
        bug = new Bug(context); // Tạo ra 1 ảnh bug và nền
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bug);
        dia = bitmap.getWidth();
        getHolder().addCallback(this);
        thread = new ThreadView(this);
        time.start();
    }

    @SuppressLint("WrongCall")
    public void doDraw(Canvas c){ // Hàm hiển thị
        // Hiển thị bộ đếm
        if(count > 0){
            bug.onDraw(c);
            Paint tpaint = new Paint();
            tpaint.setColor(Color.BLACK);
            tpaint.setTextSize(80);
            c.drawText("Time: " + count, 100, 200, tpaint);
        }
        else if (count <= 0){
            // Hiển thị kết quả
            // >3 => win
            if(kq >= 3){
                Paint spaint = new Paint();
                spaint.setColor(Color.BLACK);
                c.drawPaint(spaint);
                spaint.setColor(Color.WHITE);
                spaint.setTextSize(90);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("YOU WIN!", c.getWidth()/2, c.getHeight()/2 - 80, spaint);
                c.drawText( "Record: " + kq, c.getWidth()/2, c.getHeight()/2, spaint);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("touch to quit",c.getWidth()/2, c.getHeight()/2 + 80, spaint);
            }
            // <3 => lose
            else if(kq < 3){
                Paint spaint = new Paint();
                spaint.setColor(Color.BLACK);
                c.drawPaint(spaint);
                spaint.setColor(Color.WHITE);
                spaint.setTextSize(90);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("YOU LOSE!", c.getWidth()/2, c.getHeight()/2 - 80, spaint);
                c.drawText( "Record: " + kq, c.getWidth()/2, c.getHeight()/2, spaint);
                spaint.setTextAlign(Paint.Align.CENTER);
                c.drawText("touch to quit",c.getWidth()/2, c.getHeight()/2 + 80, spaint);
            }
        }
    }

    @Override   // Hàm tạo 1 SurfaceView
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        if(!thread.isAlive()){
            thread = new ThreadView(this);
            thread.setRunning(true);
            thread.start();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override   // Hàm hủy 1 SurfaceView
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        if(thread.isAlive()){
            thread.setRunning(false);
        }
    }

    // Hàm đếm thời gian
    public class Time extends Thread {
        @Override
        public void run(){
            while (count > 0){
                try{
                    count--;
                    sleep(1000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    // Hàm xác định vị trí của ảnh bug
    public boolean onTouchEvent(MotionEvent event){
        int eventaction = event.getAction();
        X = (int)event.getX();
        Y = (int)event.getY();
        switch (eventaction){
            case MotionEvent.ACTION_DOWN:{
                int centerX = bug.x + dia;
                int centerY = bug.y + dia;
                dis = (float) Math.sqrt((((centerX-X)*(centerX-X)) + (centerY-Y)*(centerY-Y)));
                if(count > 0){
                    if(dis < dia){
                        kq++;
                        bug.x = 100;
                        bug.y = 100;
                    }
                }
                if(count <= 0)
                {
                    System.exit(0);
                }
            }
            default:
                break;
        }
        return super.onTouchEvent(event);
    }
}
