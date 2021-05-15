package com.example.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class canvas extends View {
    Paint paint;
    Path path;

    public canvas(Context context, @Nullable AttributeSet attributeSet){
        super(context,attributeSet);
        path = new Path();
        paint = new Paint();

        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(7f);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas){

        super.onDraw(canvas);
        canvas.drawPath(path,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        float xPos = event.getX();
        float yPos = event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(xPos,yPos);
                break;

            case MotionEvent.ACTION_UP:
                break;


            case  MotionEvent.ACTION_MOVE:
                path.lineTo(xPos,yPos);
                break  ;


            default:
                break;


        }
        invalidate();
        return true;

    }
}
