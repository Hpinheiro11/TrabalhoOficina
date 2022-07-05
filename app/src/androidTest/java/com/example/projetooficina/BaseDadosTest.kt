package com.example.projetooficina

import android.database.sqlite.SQLiteDatabase
import android.provider.BaseColumns
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

    private fun insereFuncionarios(db: SQLiteDatabase, Funcionario: Funcionario) {
        Funcionario.id = TabelaBDFuncionario(db).insert(Funcionario.toContentValues())

        assertNotEquals(-1, Funcionario.id)
    }


    @Before
    fun apagaBaseDados() {
        appContext().deleteDatabase(TabelaBDOpenHelper.NOME)
    }

    @Test
    fun consegueAbrirBaseDados() {
        val openHelper = TabelaBDOpenHelper(appContext())
        val db = openHelper.readableDatabase

        assertTrue(db.isOpen)

        db.close()
    }

    @Test
    fun consegueInserirCarros() {
        val db = getWritableDatabase()

        insereCarros(db, Carros("22BW11","BMW","Serie1","Branco"))

        db.close()
    }

    @Test
    fun consegueInserirReparacao() {
        val db = getWritableDatabase()

        val Carros = Carros("HP1212"," Mercedes","ClasseA","Vermelho")
        insereCarros(db, Carros)

        val Reparacao = Reparacao("HP1212", "Chaparia", " Pequena Batidela no Para-Choques","1")
        insereReparacao(db, Reparacao)

        db.close()
    }
    fun consegueInserirFuncionarios() {
        val db = getWritableDatabase()

        insereFuncionarios(db, Funcionario("Hugo Pinheiro"))

        db.close()
    }

    @Test
    fun consegueAlterarCarros() {
        val db = getWritableDatabase()


        val Matricula = Carros("34RT21","Opel", " Astra", "Amarelo")
        insereCarros(db, Matricula)

        Matricula.Matricula = "BM1456"
        val registosAlterados = TabelaBDCarros(db).update(
            Matricula.toContentValues(),
            "${TabelaBDCarros.CAMPO_ID_REPARACAO}=?",
            arrayOf("${Matricula.id}")
        )

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueAlterarFuncionario() {
        val db = getWritableDatabase()

        val Funcionario = Funcionario("Rute Pinheiro")
        insereFuncionarios(db, Funcionario)





        val registosAlterados = TabelaBDFuncionario(db).update(
            Funcionario.toContentValues(),
            "${BaseColumns._ID}=?",
            arrayOf("${Funcionario.id}")
        )

        assertEquals(1, registosAlterados)

        db.close()
    }

    @Test
    fun consegueEliminarCarros() {
        val db = getWritableDatabase()

        val Matricula = Carros("ZW1232","BMW","M4","Preto")
        insereCarros(db, Matricula)

        val registosEliminados = TabelaBDCarros(db).delete(
            "${BaseColumns._ID}=?",
            arrayOf("$Carros")
        )

        assertEquals(1, registosEliminados)

        db.close()
    }

    @Test
    fun consegueEliminarReparacao() {
        val db = getWritableDatabase()

        val reparacao = Reparacao("BM1356","Chaparia","Guarda-Lamas homologado","1")
        insereReparacao(db, reparacao)

        val registosEliminados = TabelaBDReparacao(db).delete(
            "${BaseColumns._ID}=?",
            arrayOf("${Reparacao}")
        )

        assertEquals(1, registosEliminados)

        db.close()
    }



}