package com.arfajarsetiaji.digitalprocessmeasurementmobile.repository

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize



@Parcelize
@Entity(tableName = "Data Entries")
data class DataEntry(
    @SerializedName("no") @ColumnInfo(name = "no") val no: Int,
    @SerializedName("jid_no") @ColumnInfo(name = "jid_no") val jid_no: Int,
    @SerializedName("part_no") @ColumnInfo(name = "part_no") val part_no: String,
    @SerializedName("program") @ColumnInfo(name = "program") val program: String,
    @SerializedName("work_center") @ColumnInfo(name = "work_center") val work_center: String,
    @SerializedName("date") @ColumnInfo(name = "date") val date: String,
    @SerializedName("package_source") @ColumnInfo(name = "package_source") val package_source: String,
    @SerializedName("package_status") @ColumnInfo(name = "package_status") val package_status: String,
    @SerializedName("package_if_incomplete") @ColumnInfo(name = "package_if_incomplete") val package_if_incomplete: String,
    @SerializedName("qty") @ColumnInfo(name = "qty") val qty: Int,
    @SerializedName("status") @ColumnInfo(name = "status") val status: String,
    @SerializedName("descrepancy") @ColumnInfo(name = "descrepancy") val descrepancy: String,
    @SerializedName("remarks_sqg") @ColumnInfo(name = "remarks_sqg") val remarks_sqg: String,
    @SerializedName("remarks_fpy") @ColumnInfo(name = "remarks_fpy") val remarks_fpy: String
): Parcelable