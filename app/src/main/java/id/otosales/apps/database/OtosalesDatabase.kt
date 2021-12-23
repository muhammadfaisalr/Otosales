package id.otosales.apps.database

import androidx.room.Database
import androidx.room.RoomDatabase
import id.otosales.apps.database.dao.DaoCity
import id.otosales.apps.database.dao.DaoProvince
import id.otosales.apps.database.entity.EntityCity
import id.otosales.apps.database.entity.EntityProvince

@Database(
    entities = [EntityCity::class, EntityProvince::class],
    version = 1
)
abstract class OtosalesDatabase : RoomDatabase() {

    abstract fun daoCity(): DaoCity

    abstract fun daoProvince(): DaoProvince
}