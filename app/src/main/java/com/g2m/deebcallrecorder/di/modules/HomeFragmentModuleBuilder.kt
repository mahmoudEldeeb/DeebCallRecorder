package com.g2m.deebcallrecorder.di.modules

import com.g2m.deebcallrecorder.views.fragments.InboxFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class HomeFragmentModuleBuilder {

    @ContributesAndroidInjector
    internal abstract fun contributeInboxFragment(): InboxFragment


}