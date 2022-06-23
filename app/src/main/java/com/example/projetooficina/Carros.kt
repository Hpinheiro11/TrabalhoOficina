package com.example.projetooficina

import android.content.ContentValues
import android.database.Cursor
import android.provider.BaseColumns

class Carros (var Matricula : String,
              var Marca: String,
              var Modelo: String,
              var Cor: String,
              var id: Long =-1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDCarros.MATRICULA, Matricula)
        valores.put(TabelaBDCarros.MARCA, Marca)
        valores.put(TabelaBDCarros.MODELO, Modelo)
        valores.put(TabelaBDCarros.COR, Cor)

        return valores
    }

    companion object {
        fun fromCursor(cursor: Cursor): Carros {

            val posMatricula = cursor.getColumnIndex(TabelaBDCarros.MATRICULA)
            val posMarca = cursor.getColumnIndex(TabelaBDCarros.MARCA)
            val posModelo= cursor.getColumnIndex(TabelaBDCarros.MODELO)
            val posCor = cursor.getColumnIndex(TabelaBDCarros.COR)



            val Matricula = cursor.getString(posMatricula)
            val Marca = cursor.getString(posMarca)
            val MODELO = cursor.getString(posModelo)
            val COR = cursor.getString(posCor)


            return Carros(Matricula, Marca, MODELO, COR)
        }
    }
}