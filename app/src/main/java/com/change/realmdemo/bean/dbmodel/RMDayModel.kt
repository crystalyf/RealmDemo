package com.change.realmdemo.bean.dbmodel

import com.change.realmdemo.CalenderUtils
import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RMDayModel : RealmObject() {

    @PrimaryKey
    var nowDate: String? = CalenderUtils.getCurrentDateToSpiritString() // YYYY/MM/DD
    var info: RMDayInfoModel? = null // all message count and evaluation count
    var messages: RealmList<RMPromptMsgModel> = RealmList() // message
}