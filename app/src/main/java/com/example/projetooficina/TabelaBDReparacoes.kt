package com.example.projetooficina


import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns


class TabelaBDReparacoes(val db: SQLiteDatabase) {
    fun cria(){
        db.execSQL("CREATE TABLE $ID_REPARACAO (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $DATA DATE NOT NULL, $TIPO TEXT NOT NULL, $DESCRICAO TEXT NOT NULL, $MATRICULA TEXT NOT NULL, $CAMPO_ID_FUNCIONARIO INTEGER NOT NULL)")

    }
    companion object{
        const val ID_REPARACAO = "id reparacao"
        const val DATA = "data de rececao"
        const val TIPO = "tipo de reparacao"
        const val DESCRICAO = "descricao"
        const val MATRICULA = "matricula"
        const val CAMPO_ID_FUNCIONARIO ="id funcionario"
    }
}