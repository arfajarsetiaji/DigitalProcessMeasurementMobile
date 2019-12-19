package com.arfajarsetiaji.android.moviecatalogue.api.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataEntryItem(
    val jidNo: String?,
    val partNo: String?,
    val qty: Int?,
    val program: String?,
    val workCenter: String?,
    val date: String?,
    val packageSource: String?,
    val packageStatus: String?,
    val ifIncomplete: String?,
    val status: String?,
    val descrepancy: String?,
    val remarksSQG: String?,
    val remarksFPY: String
): Parcelable