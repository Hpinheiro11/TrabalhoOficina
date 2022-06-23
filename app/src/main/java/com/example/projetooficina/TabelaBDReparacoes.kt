package com.example.projetooficina

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns

class TabelBDReparacoes(db: SQLiteDatabase) :TabelaBD(db, MATRICULA){



    override fun cria() {
        db.execSQL("CREATE TABLE $MATRICULA (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, $TIPOREPARACAO TEXT NOT NULL, $DESCRICAO TEXT NOT NULL,  FOREIGN KEY ($IDFUNCIONARIO) REFERENCES ${TabelaBDFuncionario.NOME}(${BaseColumns._ID}) ON DELETE RESTRICT)")
        }

    companion object {
        val MATRICULA = "matricula"
        const val TIPOREPARACAO = "tipoReparacao"
        const val DESCRICAO = "descricao"
        const val IDFUNCIONARIO = "funcionarioId"

        val TODAS_COLUNAS = arrayOf(BaseColumns._ID,MATRICULA, TIPOREPARACAO, DESCRICAO, IDFUNCIONARIO)
    }

}
