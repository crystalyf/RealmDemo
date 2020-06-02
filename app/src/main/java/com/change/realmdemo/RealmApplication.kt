package com.change.realmdemo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.RealmMigration
import kotlin.properties.Delegates


class RealmApplication : Application(), Application.ActivityLifecycleCallbacks {

    lateinit var mRealm: Realm

    override fun onCreate() {
        super.onCreate()
        instance = this
        initRealm()
        registerActivityLifecycleCallbacks(this)
    }

    companion object {
        var instance: RealmApplication by Delegates.notNull()
    }

    override fun onActivityPaused(activity: Activity?) {
    }

    override fun onActivityResumed(activity: Activity?) {
    }

    override fun onActivityStarted(activity: Activity?) {
    }

    override fun onActivityDestroyed(activity: Activity?) {
    }

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
    }

    override fun onActivityStopped(activity: Activity?) {
    }

    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
    }

    /**
     * 初始化Realm
     *
     */
    private fun initRealm() {
        Realm.init(this)
        val migration = RealmMigration { _, oldVersion, newVersion ->
            if (oldVersion.toInt() == 1 && newVersion.toInt() == 2) {
//                oldVersion += 1
            }
        }

        val realmConfig = RealmConfiguration.Builder()
            .schemaVersion(BuildConfig.REALM_VERSION)
            .migration(migration)
            .name(BuildConfig.REALM_DB_NAME)
            .build()
        mRealm = Realm.getInstance(realmConfig)
    }
}