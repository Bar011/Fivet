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
import cl.ucn.disc.pdis.fivet.models.PruebaPersona;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;


public class SingletonRep {
    /**
     * instance for Singleton Patron
     */
    private static SingletonRep instancia;

    /**
     * Persona repository.
     */
    private RepoImpl<PruebaPersona, Long> PruebaPersonaRepository;
    //TODO: create others repositories by models

    private SingletonRep() throws SQLException {
        try {
            ConnectionSource connectionSource = new JdbcConnectionSource("jdbc:h2:mem:fivet_db");
            this.PruebaPersonaRepository = new RepoImpl<PruebaPersona, Long>(connectionSource, PruebaPersona.class);

            //TODO: inicializated others repositories from other todo

        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    /**
     * return a unique instance for Singleton Patron
     *
     * @return instancia
     */
    public static SingletonRep getInstancia() throws SQLException {
        if (instancia == null) {
            instancia = new SingletonRep();
        }
        return instancia;
    }

    /**
     * get Repository Persona
     *
     * @return RepositoryIMPL
     */
    public RepoImpl<PruebaPersona, Long> getPruebaPersonaRepository() {
        return PruebaPersonaRepository;
    }
}

