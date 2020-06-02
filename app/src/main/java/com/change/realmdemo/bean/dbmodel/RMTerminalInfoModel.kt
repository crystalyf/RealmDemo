package com.change.realmdemo.bean.dbmodel

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RMTerminalInfoModel : RealmObject() {

    @PrimaryKey
    var id: Int = 0
    var inserttime: String? = null
    var latitude: Double? = 0.0
    var longitude: Double? = 0.0
    var starttime: String? = null
    var endtime: String? = null
    var stepcount: Int? = 0

}
