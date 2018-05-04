package com.jjkj.administrator.storecontrollersystem.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Administrator
 * @date 2018/3/23
 */
@SuppressWarnings("all")
public class BitmapUtils {

    /**
     * bitmap保存为file
     */
    public static void bitmapToFile(File file, Bitmap bitmap, int quality) throws
            IOException {
        if (bitmap != null) {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream
                    (file));
            bitmap.compress(Bitmap.CompressFormat.PNG, quality, bos);
            bos.flush();
            bos.close();
        }

    }

    /**
     * 给图片添加文字到左上角
     */
    public static Bitmap drawTextToLeftTop(Context context, Bitmap bitmap, String text, int size,
                                           int color, int paddingLeft, int paddingTop) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setTextSize(dp2px(context, size));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return drawTextToBitmap(context, bitmap, text, paint, bounds, dp2px(context,
                paddingLeft), dp2px(context, paddingTop) + bounds.height());
    }


    /**
     * 给图片添加文字到右上角
     */
    public static Bitmap drawTextToRightTop(Context context, Bitmap bitmap, String text, int
            size, int color, int paddingRight, int paddingTop) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setTextSize(dp2px(context, size));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return drawTextToBitmap(context, bitmap, text, paint, bounds, bitmap.getWidth() - bounds
                .width() - dp2px(context, paddingRight), dp2px(context, paddingTop) +
                bounds.height());
    }


    /**
     * 给图片添加文字到右下角
     */
    public static Bitmap drawTextToRightBottom(Context context, Bitmap bitmap, String text, int
            size, int color, int paddingRight, int paddingBottom) {
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(color);
        paint.setTextSize(dp2px(context, size));
        Rect bounds = new Rect();
        paint.getTextBounds(text, 0, text.length(), bounds);
        return drawTextToBitmap(context, bitmap, text, paint, bounds, bitmap.getWidth() - bounds
                .width() - dp2px(context, paddingRight), bitmap.getHeight() - dp2px(context,
                paddingBottom));
    }


    /**
     * @param context     上下文环境
     * @param bitmap      需要需改的Bitmap
     * @param text        添加的文字
     * @param paint       画笔
     * @param bounds      形状
     * @param paddingLeft 距离左边位置
     * @param paddingTop  距离右边位置
     * @return 返回新的Bitmap
     */
    private static Bitmap drawTextToBitmap(Context context, Bitmap bitmap, String text, Paint
            paint, Rect bounds, int paddingLeft, int paddingTop) {
        Bitmap.Config bitmapConfig = bitmap.getConfig();
        // 获取跟清晰的图像采样
        paint.setDither(true);
        // 过滤一些
        paint.setFilterBitmap(true);
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888;
        }
        bitmap = bitmap.copy(bitmapConfig, true);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawText(text, paddingLeft, paddingTop, paint);
        return bitmap;
    }

    private static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

}
