package com.example.goodn.simplepiechart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static android.view.View.MeasureSpec.getSize;

/**
 * Created by goodn on 2017-08-29.
 */

public class SimplePieChartView extends View {
    private Paint pnt;
    private RectF rect;
    private int width;
    private int height;
    private int progress;
    private int max = 100;

    public SimplePieChartView(Context context) {
        super(context);
        init();
    }

    public SimplePieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init() {
        pnt = new Paint();
        rect = new RectF();

        pnt.setAntiAlias(true);
        pnt.setStrokeWidth(6f);
        pnt.setColor(Color.parseColor("#edf8e2"));
        pnt.setStyle(Paint.Style.FILL_AND_STROKE);

        setProgress(120);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        rect.set(getLeft(), getTop(), getRight(), getBottom());
        canvas.drawArc(rect, 0, 360, true, pnt);

        pnt.setColor(Color.parseColor("#b7db93"));
        canvas.drawArc(rect, 0, -getProgress(), true, pnt);
    }


    public void setProgress(int progress) {
        if (progress >= 100) {
            progress = max;
        }
        this.progress = progress;
        invalidate();
    }

    public int getProgress() {
        return (int) ((progress / 100f) * 360);
    }
}
