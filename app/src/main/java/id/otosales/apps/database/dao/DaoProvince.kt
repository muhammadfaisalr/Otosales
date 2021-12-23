package id.otosales.apps.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import id.otosales.apps.database.entity.EntityProvince

@Dao
interface DaoProvince {

    @Query("SELECT * FROM m_province")
    fun getAll(): List<EntityProvince>

    @Query("SELECT name FROM m_province")
    fun getAllByName(): List<String>

    @Query("SELECT id FROM m_province WHERE name = :name")
    fun getId(name: String): Int

    @Insert
    fun insert(entityProvince: EntityProvince)
}