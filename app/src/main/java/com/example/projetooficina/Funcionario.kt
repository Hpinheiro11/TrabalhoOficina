package com.example.projetooficina

import android.content.ContentValues

import android.database.Cursor
import android.provider.BaseColumns


class Funcionario (var nome: String, var id: Long = -1){

    fun toContentValues() : ContentValues {
        val valores = ContentValues()
        valores.put(TabelaBDFuncionario.NOME, nome)

        return valores
    }

    companion object {

        fun fromCursor (cursor: Cursor):  Funcionario{
            val posId = cursor.getColumnIndex(BaseColumns._ID)
            val posNome = cursor.getColumnIndex(TabelaBDFuncionario.NOME)
            val posNif = cursor.getColumnIndex(TabelaBDFuncionario.NIF)
            val posTelemovel = cursor.getColumnIndex(TabelaBDFuncionario.TELEMOVEL)
            val posMorada = cursor.getColumnIndex(TabelaBDFuncionario.MORADA)
            val posCargo = cursor.getColumnIndex(TabelaBDFuncionario.CARGO)


            val id = cursor.getLong(posId)
            val nome = cursor.getString(posNome)
            val nif = cursor.getString(posNif)
            val telemovel = cursor.getString(posTelemovel)
            val morada = cursor.getString(posMorada)
            val cargo = cursor.getString(posCargo)

            return Funcionario(nome, id)
        }
    }
}