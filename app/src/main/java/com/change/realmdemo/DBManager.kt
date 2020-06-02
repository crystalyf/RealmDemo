package com.change.realmdemo

import com.change.realmdemo.bean.dbmodel.RMDayModel
import com.change.realmdemo.bean.dbmodel.RMDayMsgModel
import com.change.realmdemo.bean.dbmodel.RMTerminalInfoModel
import io.realm.RealmResults


/**
 * realm database execute
 * Created by xjc on 2019/4/4.
 */
class DBManager private constructor() {
    companion object {
        private var mDbManager: DBManager? = null
        val instance: DBManager
            get() {
                if (mDbManager == null) {
                    mDbManager = DBManager()
                }
                return mDbManager!!
            }
    }

    fun clearRealmDatabase() {
        RealmApplication.instance.mRealm.beginTransaction()
        RealmApplication.instance.mRealm.deleteAll()
        RealmApplication.instance.mRealm.commitTransaction()
    }

    /**
     * Find all TerminalInfo
     */
    fun findAllTerminalInfoFromDB(): RealmResults<RMTerminalInfoModel>? {
        RealmApplication.instance.mRealm.beginTransaction()
        val result =
            RealmApplication.instance.mRealm.where(RMTerminalInfoModel::class.java)?.findAll()
        RealmApplication.instance.mRealm.commitTransaction()
        return result
    }

    /**
     * Insert one TerminalInfo
     */
    fun insertTerminalInfoToDB(mCmlUser: RMTerminalInfoModel) {
        RealmApplication.instance.mRealm.beginTransaction()
        RealmApplication.instance.mRealm.insert(mCmlUser)
        RealmApplication.instance.mRealm.commitTransaction()
    }

    /**
     * delete One TerminalInfo
     */
    fun deleteOneTerminalInfoFromDB(index: Int) {
        RealmApplication.instance.mRealm.beginTransaction()
        val mCmlUser =
            RealmApplication.instance.mRealm.where(RMTerminalInfoModel::class.java)?.findAll()
        mCmlUser?.get(index)?.deleteFromRealm()
        RealmApplication.instance.mRealm.commitTransaction()
    }

    fun generateTerminalInfoPrimaryKey(): Int {
        var primaryKey = 0
        val results =
            RealmApplication.instance.mRealm.where(RMTerminalInfoModel::class.java)?.findAll()
        if (results != null && results.size > 0) {
            val last = results.last()
            primaryKey = last?.id!! + 1
        }
        return primaryKey
    }

    fun insertOrUpdateReadMessage(message: RMDayMsgModel, date: String) {
        RealmApplication.instance.mRealm.beginTransaction()
        val result = RealmApplication.instance.mRealm.where(RMDayModel::class.java)
            ?.equalTo("nowDate", date)?.findFirst()
        for (data in result?.messages!!) {
            if (data.promptId == message.promptId) {
                data.evaluation = message.evaluation
                data.readTime = message.readTime
                break
            }
        }
        RealmApplication.instance.mRealm.copyToRealmOrUpdate(result)
        RealmApplication.instance.mRealm.commitTransaction()
    }
}
