package com.change.realmdemo.bean.dbmodel

import io.realm.annotations.PrimaryKey

open class RMDayMsgModel {

    @PrimaryKey
    var promptId: Int? = -1
    var nowdata: String? = ""
    var insertTime: Long? = -1
    var userId: Int? = -1
    var message: String? = ""
    var receiveTime: Long? = -1L
    var readTime: Long? = -1
    var imgName: String? = ""
    var num: Int? = -1
    var evaluation: Int? = -1
}