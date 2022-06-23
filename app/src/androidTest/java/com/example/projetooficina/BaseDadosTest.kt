package com.example.projetooficina

import android.database.sqlite.SQLiteDatabase
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class BaseDadosTest {

    private fun appContext() =
        InstrumentationRegistry.getInstrumentation().targetContext

    private fun getWritableDatabase(): SQLiteDatabase {
        val openHelper = TabelaBDOpenHelper(appContext())
        return openHelper.writableDatabase
    }

    private fun insereCarros(db: SQLiteDatabase, Carros: Carros) {
        Carros.id = TabelaBDCarros(db).insert(Carros.toContentValues())

        assertNotEquals(-1, Carros.id)
    }

    private fun insereReparacao(db: SQLiteDatabase, Reparacao: Reparacao) {
        Reparacao.id = TabelaBDReparacao(db).insert(Reparacao.toContentValues())

        assertNotEquals(-1, Reparacao.id)
    }


}