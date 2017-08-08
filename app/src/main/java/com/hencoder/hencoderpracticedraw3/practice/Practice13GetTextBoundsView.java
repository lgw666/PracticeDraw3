package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String text1 = "A";
    String text2 = "a";
    String text3 = "J";
    String text4 = "j";
    String text5 = "Â";
    String text6 = "â";
    int top = 200;
    int bottom = 400;
    Rect bounds;

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);
        bounds = new Rect();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        int m = (top + bottom) / 2;

        canvas.drawText(text1, 100, getRealMiddle(m, text1), paint2);
        canvas.drawText(text2, 200, getRealMiddle(m, text2), paint2);
        canvas.drawText(text3, 300, getRealMiddle(m, text3), paint2);
        canvas.drawText(text4, 400, getRealMiddle(m, text4), paint2);
        canvas.drawText(text5, 500, getRealMiddle(m, text5), paint2);
        canvas.drawText(text6, 600, getRealMiddle(m, text6), paint2);
    }

    private int getRealMiddle(int m, String t) {
        paint2.getTextBounds(t, 0, t.length(), bounds);
        Log.e("GetTextBoundsView", "getRealMiddle top: " + bounds.top + " bottom: " + bounds.bottom + " height" + bounds.height());
        return -(bounds.top + bounds.bottom) / 2 + m;
    }
}