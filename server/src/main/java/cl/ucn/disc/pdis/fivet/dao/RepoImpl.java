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

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;

    public class RepoImpl<T,K> implements RepositoryInterface<T,K> {

        /**
         *  Dao to mange de connection from database
         */
        private final Dao<T,K> dao;

        /**
         * Constructor of dao
         * @param connectionSource
         * @param theClass
         * @throws SQLException
         */
        public RepoImpl(ConnectionSource connectionSource, Class<T> theClass) throws SQLException {
            try {
                //Create the table from Persona Class Annotations
                TableUtils.createTableIfNotExists(connectionSource, theClass);
                dao = DaoManager.createDao(connectionSource, theClass);
            } catch (SQLException e) { throw new RuntimeException(e); }
        }

        /**
         * try to insert and element into the database
         * @param element
         * @return
         * @throws SQLException
         */
        @Override
        public boolean crear(T element) throws SQLException {
            try {
                int result  =dao.create(element);
                return result == 1;
            } catch ( SQLException e) {
                throw new SQLException(e);
            }
        }

        /**
         * try to delete a registry by id
         * @param id
         * @return
         */
        @Override
        public boolean eliminar(K id) throws SQLException {
            try {
                int result  =dao.deleteById(id);
                return result == 1;
            } catch ( SQLException e) {
                throw new SQLException(e);
            }
        }

        /**
         * try to update a registry
         * @param element
         * @return
         */
        @Override
        public boolean actualizar(T element) throws SQLException {
            try {
                int result  =dao.update(element);
                return result == 1;
            } catch ( SQLException e) {
                throw new SQLException(e);
            }
        }

        /**
         * try to find and registry
         * @param id that has to be found.
         * @return
         */
        @Override
        public T buscar(K id) throws SQLException {
            try {
                T result  =dao.queryForId(id);
                return result;

            } catch ( SQLException e) {
                throw new SQLException(e);
            }
        }

        /**
         * try to get all registry
         * @return all registry from table T
         */
        @Override
        public List<T> obtenerTodos() throws SQLException {
            try {
                List<T> list = dao.queryForAll();
                return list;
            } catch ( SQLException e) {
                throw new SQLException(e);
            }
        }

        @Override
        public List<T> buscarParametro(String param, String value) throws SQLException {
            try {
                List<T> list = dao.queryForEq(param,value);
                return list;
            } catch ( SQLException e) {
                throw new SQLException(e);
            }
        }
    }
