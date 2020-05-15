/**************************************************************************************************
 * MIT License                                                                                    *
 *                                                                                                *
 * Copyright (c) 2020  Beatriz Álvarez Rojas <bar011@alumnos.ucn.cl>.                             *
 *                                                                                                *
 * Permission is hereby granted, free of charge, to any person obtaining a copy                   *
 * of this software and associated documentation files (the "Software"), to deal                  *
 * in the Software without restriction, including without limitation the rights                   *
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell                      *
 * copies of the Software, and to permit persons to whom the Software is                          *
 * furnished to do so, subject to the following conditions:                                       *
 *                                                                                                *
 * The above copyright notice and this permission notice shall be included in all                 *
 * copies or substantial portions of the Software.                                                *
 *                                                                                                *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR                     *
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,                       *
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE                    *
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER                         *
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,                  *
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE                  *
 * SOFTWARE.                                                                                      *
 **************************************************************************************************/

package cl.ucn.disc.pdis.fivet.dao;import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Model test.
 *
 * @author Beatriz Alvarez-Rojas.
 */

public final class StorageTest {

    /**
     * The Logger
     */

    private static final Logger log = LoggerFactory.getLogger(StorageTest.class);

    /**
     * Testing the ORMLite + H2(Database).
     */

    @Test
    public void TestDatabse() throws SQLException {

        //The data base to use (in RAM memory)
        String databaseUrl = "jdbc:h2:mem:fivet_db";

        //Connection source: autoclose with try/catch
        try(ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl)) {

            //Create The table from the Persona Annotations
            TableUtils.createTableIfNotExists(connectionSource, TestPersona.class);

            //The dao of testPersona

            Dao<TestPersona, Long> daoPersona = DaoManager.createDao(connectionSource, TestPersona.class);

            //New Persona

            TestPersona persona = new TestPersona("Carlos", "Pon", "123456789-0");

            //Insert Persona into the database
            int tuples = daoPersona.create(persona);
            log.debug("id:{}", persona.getId());
            //
            Assertions.assertEquals(1, tuples, "save Tuples !=1");

            //GetGrom db

            TestPersona personaDb = daoPersona.queryForId(persona.getId());

            Assertions.assertEquals(persona.getNombre(),personaDb.getNombre() , "nombre not equals!");
            Assertions.assertEquals(persona.getApellido(), personaDb.getApellido(), "Apellido not equals!");
            Assertions.assertEquals(persona.getRut(), personaDb.getRut(), "Rut not equals!");

            // Search by Rut : SELECT * FROM 'persona' WHERE rut = '123456789-0'
            List<TestPersona> personaList = daoPersona.queryForEq("rut", "123456789-0");
            Assertions.assertEquals(1, personaList.size(), "more than one person?!");

            //not found by rut
            Assertions.assertEquals(0,daoPersona.queryForEq("rut", "19").size(), "Found something ?!");


        } catch (IOException e) {
            log.error("Error", e);
        }

    }
}
