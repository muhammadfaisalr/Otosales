package id.otosales.apps.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "m_city")
data class EntityCity(
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "province_id") var provinceId: Int,
    @ColumnInfo(name = "name") var name: String
) {}