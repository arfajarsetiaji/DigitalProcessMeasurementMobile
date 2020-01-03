package com.arfajarsetiaji.digitalprocessmeasurementmobile.repository

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ReportEntries(@SerializedName("Sheet1") val reportEntryItems: MutableList<ReportEntryItem?>?):
    Parcelable

@Parcelize
@Entity(tableName = "Data Entries")
data class ReportEntryItem(
    @SerializedName("month") @ColumnInfo(name = "month") val month: Int?,
    @SerializedName("rate") @ColumnInfo(name = "rate") val rate: String?,
    @SerializedName("index") @ColumnInfo(name = "index") val index: String?,
    @SerializedName("benefit") @ColumnInfo(name = "benefit") val benefit: String?
): Parcelable