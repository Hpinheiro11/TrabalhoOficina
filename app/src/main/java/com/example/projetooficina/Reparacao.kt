package com.example.projetooficina

import android.content.ContentValues
import android.database.Cursor

class Reparacao (var Matricula : String,
                 var TipoReparacao: String,
                 var Descricao: String,
                 var IDFuncionario: String,
                 var id: Long =-1) {


    fun toContentValues() : ContentValues {
        val valores = ContentValues()

        valores.put(TabelaBDReparacao.MATRICULA, Matricula)
        valores.put(TabelaBDReparacao.TIPOREPARACAO, TipoReparacao)
        valores.put(TabelaBDReparacao.DESCRICAO, Descricao)
        valores.put(TabelaBDReparacao.IDFUNCIONARIO, IDFuncionario)

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