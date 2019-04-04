package com.jake.viewlocationutils;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity";
  private View mButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    mButton = findViewById(R.id.button);
    mButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        getScreenSize2();
        getScreenSize4();
        getScreenSize5();
        getScreenSize6();
        getScreenSize3();
        getScreenSize7();
        getLocation1();
        getLocation2();
        getLocation3();
        getLocation4();
      }
    });
  }

  private void getScreenSize7() {
    Display defaultDisplay = getWindowManager().getDefaultDisplay();
    Log.e(TAG, "getScreenSize7->width=" + defaultDisplay.getWidth() + " height="
        + defaultDisplay.getHeight());
  }

  /**
   * 获取的尺寸大小
   *
   * width=1080 height=2029
   */
  private void getScreenSize2() {
    WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    DisplayMetrics displayMetrics = new DisplayMetrics();
    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    Log.e(TAG, "getScreenSize2->width=" + displayMetrics.widthPixels + " height="
        + displayMetrics.heightPixels);
  }

  /**
   * 获取的尺寸大小
   *
   * width=1080 height=2029
   */
  private void getScreenSize4() {
    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
    Log.e(TAG, "getScreenSize4->width=" + displayMetrics.widthPixels + " height="
        + displayMetrics.heightPixels);
  }

  /**
   * 获取的尺寸大小
   *
   * width=1080 height=2248
   */
  private void getScreenSize5() {
    WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    Point point = new Point();
    windowManager.getDefaultDisplay().getSize(point);
    Log.e(TAG, "getScreenSize5->width=" + point.x + " height=" + point.y);
  }

  /**
   * 获取的尺寸大小
   *
   * width=1080 height=2029
   */
  private void getScreenSize6() {
    WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    Point point = new Point();
    windowManager.getDefaultDisplay().getRealSize(point);
    Log.e(TAG, "getScreenSize6->width=" + point.x + " height=" + point.y);
  }

  /**
   * 获取的尺寸大小
   *
   * width=1080 height=2248
   */
  private void getScreenSize3() {
    WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
    DisplayMetrics displayMetrics = new DisplayMetrics();
    windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
    Log.e(TAG, "getScreenSize3->width=" + displayMetrics.widthPixels + " height="
        + displayMetrics.heightPixels);
  }

  /**
   * 获取的位置是基于屏幕顶端, 包括状态栏
   *
   * 全屏状态下屏幕尺寸
   * width=1080 height=2248
   *
   * 全屏状态下:
   * left=0 top=2028 right=530 bottom=2248
   *
   * 底部有导航栏:
   * left=0 top=1898 right=530 bottom=2118
   */
  private void getLocation1() {
    int[] location = new int[2];
    mButton.getLocationOnScreen(location);
    Log.e(TAG, "getLocationOnScreen: x=" + location[0] + " y=" + location[1]);
    Log.e(TAG,
        "getLocationOnScreen: left=" + location[0] + " top=" + location[1] + " right=" + mButton
            .getWidth()
            + " bottom="
            + (location[1] + mButton.getHeight()));
  }

  /**
   * 获取的位置是基于屏幕顶端, 包括状态栏
   *
   * 全屏状态下屏幕尺寸
   * width=1080 height=2248
   *
   * 全屏状态下:
   * left=0 top=2028 right=530 bottom=2248
   *
   * 底部有导航栏:
   * left=0 top=1898 right=530 bottom=2118
   */
  private void getLocation2() {
    int[] location = new int[2];
    mButton.getLocationInWindow(location);
    Log.e(TAG, "getLocationInWindow: x=" + location[0] + " y=" + location[1]);
    Log.e(TAG,
        "getLocationInWindow: left=" + location[0] + " top=" + location[1] + " right=" + mButton
            .getWidth()
            + " bottom="
            + (location[1] + mButton.getHeight()));
  }

  /**
   * 获取的位置是基于屏幕顶端, 包括状态栏
   *
   * 全屏状态下屏幕尺寸
   * width=1080 height=2248
   *
   * 全屏状态下:
   * left=0 top=2028 right=530 bottom=2248
   *
   * 底部有导航栏:
   * left=0 top=1898 right=530 bottom=2118
   */
  private void getLocation3() {
    Rect rect = new Rect();
    mButton.getGlobalVisibleRect(rect);
    Log.e(TAG,
        "getGlobalVisibleRect: left=" + rect.left + " top=" + rect.top + " right=" + rect.right
            + " bottom="
            + rect.bottom);
  }

  private void getLocation4() {
    Rect rect = new Rect();
    mButton.getLocalVisibleRect(rect);
    Log.e(TAG,
        "getLocalVisibleRect: left=" + rect.left + " top=" + rect.top + " right=" + rect.right
            + " bottom="
            + rect.bottom);
  }
}
