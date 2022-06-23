package com.example.projetooficina

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDFuncionario(override val db: SQLiteDatabase): TabelaBD(db,NOME) {

    override fun cria(){
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} TEXT PRIMARY KEY , $NIF INTEGER NOT NULL, $TELEMOVEL INTEGER NOT NULL, $MORADA TEXT NOT NULL, $CARGO TEXT NOT NULL)")

    }
    companion object{

        const val NOME = "nome"
        const val NIF = "nif"
        const val TELEMOVEL ="telemovel"
        const val MORADA = "morada"
        const val CARGO = "cargo"

    }
}

