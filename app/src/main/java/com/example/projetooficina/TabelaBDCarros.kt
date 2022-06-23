package com.example.projetooficina

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelaBDCarros(override val db: SQLiteDatabase): TabelaBD(db, NOME) {
    override fun cria(){
        db.execSQL("CREATE TABLE $NOME (${BaseColumns._ID} TEXT PRIMARY KEY , $MARCA TEXT NOT NULL, $MODELO TEXT NOT NULL, $COR TEXT NOT NULL, $HISTORICO TEXT NOT NULL, $CAMPO_ID_REPARACAO TEXT NOT NULL)")

    }
    companion object{

        const val NOME = "matricula"
        const val MARCA = "marca"
        const val MODELO ="modelo"
        const val COR = "cor"
        const val HISTORICO = "historico"
        const val CAMPO_ID_REPARACAO = "id_reparacao"
    }
}