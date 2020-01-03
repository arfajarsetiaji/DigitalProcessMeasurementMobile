package com.arfajarsetiaji.digitalprocessmeasurementmobile.repository

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ReportEntries(@SerializedName("report") val reportEntryItems: MutableList<ReportEntryItem?>?): Parcelable

@Parcelize
@Entity(tableName = "Data Entries")
data class ReportEntryItem(
    @SerializedName("month") @ColumnInfo(name = "month") val month: String?,
    @SerializedName("rate") @ColumnInfo(name = "rate") val rate: String?,
    @SerializedName("index") @ColumnInfo(name = "index") val index: String?,
    @SerializedName("benefit") @ColumnInfo(name = "benefit") val benefit: String?,
    @SerializedName("type") @ColumnInfo(name = "type") val type: String?,
    @SerializedName("no") @ColumnInfo(name = "no") val no: String?
): Parcelable