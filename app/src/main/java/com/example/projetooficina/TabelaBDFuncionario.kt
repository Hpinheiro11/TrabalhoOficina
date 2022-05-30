package com.example.projetooficina

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDFuncionario(val db: SQLiteDatabase) {
    fun cria(){
        db.execSQL("CREATE TABLE $ID_FUNCIONARIO (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $NOME TEXT NOT NULL, $NIF INTEGER NOT NULL, $TELEMOVEL INTEGER NOT NULL, $MORADA TEXT NOT NULL, $CARGO TEXT NOT NULL)")

    }
    companion object{

        const val ID_FUNCIONARIO = "id funcionario"
        const val NOME = "nome"
        const val NIF ="nif"
        const val TELEMOVEL = "telemovel"
        const val MORADA = "morada"
        const val CARGO = "cargo"
    }
}