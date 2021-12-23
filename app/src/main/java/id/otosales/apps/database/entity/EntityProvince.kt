package id.otosales.apps.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "m_province")
class EntityProvince (
    @PrimaryKey(autoGenerate = false) var id: Int,
    @ColumnInfo(name = "name") var name: String,
){}