//package com.king.frame.mvvmframe.di.module;
//
//
//import com.king.frame.mvvmframe.base.BaseActivity;
//import com.king.frame.mvvmframe.base.BaseFragment;
//import com.king.frame.mvvmframe.base.ViewModelFactory;
//
//import androidx.lifecycle.ViewModelProvider;
//import dagger.Binds;
//import dagger.Module;
//import dagger.android.AndroidInjectionModule;
//
///**
// * Dagger.Andrdoid 注入{@link BaseActivity#mViewModelFactory}和{@link BaseFragment#mViewModelFactory}
// * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
// */
//@Module(includes = {AndroidInjectionModule.class})
//public abstract class ViewModelFactoryModule {
//
//    @Binds
//    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory viewModelFactory);
//}
