package com.example.heke.test;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import java.io.InputStream;



public class CopartnerActivity extends Activity implements View.OnClickListener {


    ImageView shotIV;
    private Bitmap mBitmap;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_copartner);
        findViewById(R.id.testBtn).setOnClickListener(this);
        findViewById(R.id.testBtn2).setOnClickListener(this);
        shotIV =  findViewById(R.id.imageShotTestIv);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.testBtn:
                mBitmap = readBitMap(getContext(), R.drawable.copartner_bg);
                shotIV.setImageBitmap(mBitmap);
                break;
                case R.id.testBtn2:
                drawTitle();
                break;

        }
    }

    private void drawTitle() {
        Canvas canvas = new Canvas(mBitmap);
        // 建立画笔
        Paint photoPaint = new Paint();
        // 获取更清晰的图像采样，防抖动
        photoPaint.setDither(true);
        // 过滤一下，抗剧齿
        photoPaint.setFilterBitmap(true);
        TextPaint textPaint = myTextPaint();
        String str  ="小燕子 邀请您成为看车玩车合伙人，参与公司每月现金分红和重要决策。";

        drawText(canvas,textPaint,str,97,366,553);
        canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.restore();
        shotIV.setImageBitmap(mBitmap);
    }
    //设置画笔的字体和颜色
    public TextPaint myTextPaint(){

        TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.DEV_KERN_TEXT_FLAG);// 设置画笔
        int TEXT_SIZE = 32;
        textPaint.setTextSize(TEXT_SIZE);// 字体大小
        textPaint.setTypeface(Typeface.DEFAULT);// 采用默认的宽度
        textPaint.setColor(Color.argb(255,94,38,18));// 采用的颜色
//        textPaint.measureText()
        return textPaint;
    }

    //写入文字，自动换行的方法
    public void drawText(Canvas canvas, TextPaint paint, String textString, int x, int y, int width) {
        //int Width=Math.round(width* getRATIO());
//        int start_x=Math.round(x * getRATIO());
//        int start_y=Math.round(y * getRATIO());
        int start_x=x;
        int start_y=y;
//        LinearGradient shader=new LinearGradient(0,0,10,0,
//                new int[]{Color.parseColor("#99ff0000"),
//                        Color.parseColor("#99ff0000"),Color.parseColor("#99ff0000")},null, Shader.TileMode.CLAMP);
//        paint.setShader(shader);

        SpannableString sp = new SpannableString(textString);
        sp.setSpan(new ForegroundColorSpan(Color.RED), 4 ,10,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        StaticLayout staticLayout=new StaticLayout(sp, paint, width,
                Layout.Alignment.ALIGN_NORMAL, 1.5f, 0.0f, false);
        //绘制的位置


        canvas.translate(start_x, start_y);
        staticLayout.draw(canvas);
//        canvas.save(Canvas.ALL_SAVE_FLAG);
//        canvas.restore();
//        Path path = new Path();
//        canvas.clipPath(path);
//        path.addCircle(width / 2, 30 / 2, width / 2, Path.Direction.CCW);
//        canvas.clipPath(path, Region.Op.REPLACE);
//        paint.setColor(Color.parseColor("#99ff0000"));
//        paint.setStyle(Paint.Style.FILL);
//        PorterDuffXfermode porterDuffXfermode=  new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
//        paint.setXfermode(porterDuffXfermode);
//        Rect rect = new Rect(97,366,139,366+46);
//        canvas.drawRect(rect,paint);
    }

    public  Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        //获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt).copy(Bitmap.Config.RGB_565,true);
    }


    public Context getContext() {
        return this;
    }


}
