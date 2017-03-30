package com.abe.sztest;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by abe on 17/03/30.
 */

public class CircleView extends View {
    static Random random;
    private boolean effect = false;
    private int wait = 0;
    private TextView textView;
    private int count = 1;
    private int game = 0;
    private int timing = 10;
    private int x;
    private int y;
    private int r = 100;

    static {
        random = new Random(System.currentTimeMillis());
    }

    public CircleView(Context context){
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        if(effect == true){
            paint.setColor(Color.WHITE);
            canvas.drawCircle(x, y, count*r/10,paint);
            count++;

            if(count <= 11){
                invalidate();
            }

            effect = false;
            count = 1;
            invalidate();

        }else {
            setRandom();
            game++;
            paint.setColor(Color.GREEN);
            canvas.drawCircle(x, y, r, paint);
        }
    }

    private void setRandom(){
        x = r + random.nextInt(this.getWidth()-2*r);
        y = r + random.nextInt(this.getHeight()-2*r);
    }

    public synchronized void sleep(long msec)
    {
        try
        {
            wait(msec);
        }catch(InterruptedException e){}
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float xTouch = event.getX();
        float yTouch = event.getY();

        if((xTouch <= x+r/2) && (xTouch >= x-r/2) && (yTouch <= y+r/2) && (yTouch >= y-r/2)){
            if((wait%2)==1){sleep(100);}
            effect = true;
            invalidate();
        }

        if((game%timing)==0){wait++;}

        return super.onTouchEvent(event);
    }
}
