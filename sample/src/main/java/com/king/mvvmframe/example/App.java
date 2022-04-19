package com.king.mvvmframe.example;

import android.app.Application;
import android.content.Context;

import com.king.mvvmframe.example.app.Constants;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import dagger.hilt.android.HiltAndroidApp;
import timber.log.Timber;

/**
 * MVVMFrame 框架基于 Google 官方的 JetPack 构建，在使用 MVVMFrame 时，需遵循一些规范：
 *
 * <p>你需要参照如下方式添加 @HiltAndroidApp 注解
 *
 * <p>Example: Application
 * <pre>
 * //-------------------------
 *    &#64;HiltAndroidApp
 *    public class YourApplication extends Application {
 *
 *    }
 * //-------------------------
 * </pre>
 *
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
@HiltAndroidApp
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
    }

    private void initLogger(){
        //初始化日志打印
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .methodOffset(5)
                .tag(Constants.TAG)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));

        Timber.plant(new Timber.DebugTree() {
            @Override protected void log(int priority, String tag, String message, Throwable t) {
                if(BuildConfig.DEBUG){
                    Logger.log(priority, tag, message, t);
                }
            }
        });
    }
}
