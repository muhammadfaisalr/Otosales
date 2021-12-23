package id.otosales.apps.helper

import android.content.Context
import androidx.room.Room
import id.otosales.apps.Constant
import id.otosales.apps.database.OtosalesDatabase
import id.otosales.apps.database.dao.DaoCity
import id.otosales.apps.database.dao.DaoProvince

class DatabaseHelper {
    companion object{
        private fun connect(context: Context): OtosalesDatabase {
            return Room.databaseBuilder(context, OtosalesDatabase::class.java, Constant.Name.DB).allowMainThreadQueries().build()
        }

        fun daoCity(context: Context): DaoCity {
            val database = connect(context)

            return database.daoCity()
        }

        fun daoProvince(context: Context): DaoProvince {
            val database = connect(context)

            return database.daoProvince()
        }
    }
}