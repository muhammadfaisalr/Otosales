package id.otosales.apps.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.otosales.apps.database.entity.EntityCity

@Dao
interface DaoCity {

    @Query("SELECT * FROM m_city")
    fun getAll(): List<EntityCity>

    @Query("SELECT * FROM m_city WHERE province_id = :id")
    fun getByProvinceId(id: Int) : List<EntityCity>

    @Query("SELECT name FROM m_city WHERE province_id = :id")
    fun getNameByProvinceId(id: Int) : List<String>

    @Insert
    fun insert(entityCity: EntityCity)
}