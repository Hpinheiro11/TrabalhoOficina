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
        fun fromCursor(cursor: Cursor): Reparacao{

            val posMatricula = cursor.getColumnIndex(TabelaBDReparacao.MATRICULA)
            val posTipoReparacao = cursor.getColumnIndex(TabelaBDReparacao.TIPOREPARACAO)
            val posDescricao= cursor.getColumnIndex(TabelaBDReparacao.DESCRICAO)
            val posIDFuncionario = cursor.getColumnIndex(TabelaBDReparacao.IDFUNCIONARIO)



            val Matricula = cursor.getString(posMatricula)
            val TipoReparacao = cursor.getString(posTipoReparacao)
            val Descricao = cursor.getString(posDescricao)
            val IDFuncionario = cursor.getString(posIDFuncionario)

            return Reparacao(Matricula, TipoReparacao, Descricao,IDFuncionario )
        }
    }
}