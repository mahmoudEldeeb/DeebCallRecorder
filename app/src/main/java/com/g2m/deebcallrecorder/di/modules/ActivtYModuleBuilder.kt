package com.g2m.deebcallrecorder.di.modules

import com.g2m.deebcallrecorder.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivtYModuleBuilder {
    @ContributesAndroidInjector(modules = [HomeFragmentModuleBuilder::class])
    internal abstract fun contributeMainActivity(): MainActivity

}