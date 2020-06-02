package com.change.realmdemo.bean.dbmodel

import io.realm.RealmObject

open class RMDayInfoModel : RealmObject() {
    var allcount: Int? = 0
    var evaluationcount: Int? = 0
    var evaluationrate: Double? = 0.0
}