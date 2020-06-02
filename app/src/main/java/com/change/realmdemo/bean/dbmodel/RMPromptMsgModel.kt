package com.change.realmdemo.bean.dbmodel

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import java.io.Serializable

open class RMPromptMsgModel : RealmObject(), Serializable {

    @PrimaryKey
    var promptId: Int? = -1
    var num: Int? = -1
    var insertTime: Long? = -1L // millisecond
    var userId: Int? = -1
    var message: String? = ""
    var send: Boolean? = false
    var receiveTime: Long? = -1L // millisecond
    var readTime: Long? = -1L // millisecond
    var evaluation: Int? = -1 // 10/5/1
    var nowdata: String? = "" // YYYY/MM/DD
    var imgname: String? = ""

    fun isRead(): Boolean {
        return !(readTime == null || readTime == -1L)
    }

    fun isEvaluation(): Boolean {
        return !(evaluation == null || evaluation == -1)
    }
}