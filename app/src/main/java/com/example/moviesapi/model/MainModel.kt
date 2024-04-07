package com.example.moviesapi.model

import android.os.Parcel
import android.os.Parcelable

data class MainModel(
    val title: String?,
    val movieModels: List<MovieModel>

) :Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.createTypedArrayList(MovieModel)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeTypedList(movieModels)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainModel> {
        override fun createFromParcel(parcel: Parcel): MainModel {
            return MainModel(parcel)
        }

        override fun newArray(size: Int): Array<MainModel?> {
            return arrayOfNulls(size)
        }
    }
}
