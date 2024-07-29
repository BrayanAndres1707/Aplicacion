/*package com.collanquiandres.nutri

data class Receta(
    val nombre: String,
    val porciones: String,
    val calorias: Int,
    val proteinas: Int,
    val carbohidratos: Int,
    val grasas: Int,
    val imagenUrl: String,
    val ingredientes: String,
    val preparacion: String
)*/
package com.collanquiandres.nutri

import android.os.Parcel
import android.os.Parcelable

data class Receta(
    val nombre: String,
    val porciones: String,
    val calorias: Int,
    val proteinas: Int,
    val carbohidratos: Int,
    val grasas: Int,
    val imagenUrl: String,
    val ingredientes: String,
    val preparacion: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(porciones)
        parcel.writeInt(calorias)
        parcel.writeInt(proteinas)
        parcel.writeInt(carbohidratos)
        parcel.writeInt(grasas)
        parcel.writeString(imagenUrl)
        parcel.writeString(ingredientes)
        parcel.writeString(preparacion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Receta> {
        override fun createFromParcel(parcel: Parcel): Receta {
            return Receta(parcel)
        }

        override fun newArray(size: Int): Array<Receta?> {
            return arrayOfNulls(size)
        }
    }
}


