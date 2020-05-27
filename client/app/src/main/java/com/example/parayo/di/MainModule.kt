package com.example.parayo.di

import androidx.lifecycle.ViewModel
import com.example.parayo.MainViewModel
import com.example.parayo.common.di.CommonComponent
import com.example.parayo.common.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [CommonComponent::class])
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindsMainViewModel(viewModel: MainViewModel): ViewModel
}