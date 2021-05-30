package com.chithien.vvct.bai_3_vovanchithien_b1704852;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

// tạo ra 1 luồng và 1 bề mặt để lớp GamePanel thể hiện trong thời gian chạy
public class ThreadView extends Thread {
    private GamePanel gamePanel; // Khai báo 1 GamePanel
    private SurfaceHolder holder; // Khai báo 1 đối tượng quản lý giao diện mức thấp
    private boolean running = false; // Khai báo biến điều kiện cho vòng lặp while
    private boolean alive;

    public ThreadView(GamePanel panel){
        gamePanel = panel;
        holder = gamePanel.getHolder();
    }

    public void setRunning(boolean r){
        running = r;
    }

    public void run(){
        Canvas canvas = null;
        while (running){
            canvas = holder.lockCanvas(); // Hàm lockCanvas() dùng để tạo ra một canvas để vẽ

            if (canvas!=null){
                gamePanel.doDraw(canvas); // Thực hiện vẽ trên canvas (hiển thị)
                holder.unlockCanvasAndPost(canvas); // Hoàn thành việc vẽ trên canvas
            }
        }
    }

}
