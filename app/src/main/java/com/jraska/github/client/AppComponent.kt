package com.jraska.github.client

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import com.jraska.github.client.about.AboutModule
import com.jraska.github.client.chrome.ChromeCustomTabsModule
import com.jraska.github.client.core.android.CoreAndroidModule
import com.jraska.github.client.core.android.OnAppCreate
import com.jraska.github.client.core.android.ServiceModel
import com.jraska.github.client.identity.IdentityModule
import com.jraska.github.client.inappupdate.InAppUpdateModule
import com.jraska.github.client.navigation.deeplink.DeepLinkNavigationModule
import com.jraska.github.client.networkstatus.NetworkStatusModule
import com.jraska.github.client.push.PushModule
import com.jraska.github.client.settings.SettingsModule
import com.jraska.github.client.shortcuts.ShortcutsModule
import com.jraska.github.client.users.UsersModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AppModule::class,
    CoreAndroidModule::class,
    ChromeCustomTabsModule::class,
    DeepLinkNavigationModule::class,
    IdentityModule::class,
    NetworkStatusModule::class,
    InAppUpdateModule::class,
    UsersModule::class,
    PushModule::class,
    SettingsModule::class,
    AboutModule::class,
    ShortcutsModule::class],
  dependencies = [
    HasRetrofit::class,
    CoreComponent::class
  ]
)
interface AppComponent {

  fun onAppCreateActions(): Set<OnAppCreate>

  fun serviceModelFactory(): ServiceModel.Factory

  fun viewModelFactory(): ViewModelProvider.Factory

  @Component.Builder
  interface Builder {
    fun build(): AppComponent

    fun coreComponent(coreComponent: CoreComponent): Builder
    fun httpComponent(retrofit: HasRetrofit): Builder

    @BindsInstance
    fun appContext(context: Context): Builder
  }
}
