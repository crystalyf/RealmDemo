package com.change.realmdemo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.change.realmdemo.bean.TerminalInfoBean
import com.change.realmdemo.bean.dbmodel.RMTerminalInfoModel
import io.realm.RealmResults

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val result = TerminalInfoBean()
//        result.inserttime = "2020/6/2-16:04"
//        result.latitude = 38.0
//        result.longitude = 127.09
//        result.stepcount = 559
//        insertDb(result)

        findDb()
    }

    //增
    fun insertDb(bean: TerminalInfoBean) {
        val result = RMTerminalInfoModel()
        result.id = DBManager.instance.generateTerminalInfoPrimaryKey()
        result.inserttime = bean.inserttime
        result.latitude = bean.latitude
        result.longitude = bean.longitude
        result.starttime = bean.starttime
        result.endtime = bean.endtime
        result.stepcount = bean.stepcount
        DBManager.instance.insertTerminalInfoToDB(result)
    }

    //查
    fun findDb() {
        val result: RealmResults<RMTerminalInfoModel>? = DBManager.instance.findAllTerminalInfoFromDB()
        result?.forEach { Log.i("print",""+it.stepcount+","+it.latitude
        +","+it.inserttime) }
    }
}
