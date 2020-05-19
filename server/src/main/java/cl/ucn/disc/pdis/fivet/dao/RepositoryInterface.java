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

package cl.ucn.disc.pdis.fivet.dao;
import java.sql.SQLException;
import java.util.List;

public interface RepositoryInterface <T,K> {

        /**
         * Create a regisrty in table from database.
         * @param element
         */
        boolean crear(T element) throws SQLException;

        /**
         * Delete a registry from table inde database.
         * @param id
         */
        boolean eliminar(K id) throws SQLException;

        /**
         * Update registry T.
         * @param element
         */
        boolean actualizar(T element) throws SQLException;

        /**
         * Find a registry in database.
         * @param id that has to be found.
         */
        T buscar(K id) throws SQLException;

        /**
         * Get all registrys from Table T.
         */
        List<T> obtenerTodos() throws SQLException;

        /**
         * Get list by param from query
         * @return
         * @throws SQLException
         */
        List<T> buscarParametro(String param, String value) throws SQLException;

    }

