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

package cl.ucn.disc.pdis.fivet.models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "persona")
public class PruebaPersona {
    /**
     *The Id, pk for datatable in db
     */
    @DatabaseField(generatedId = true)
    private Long id;
    /**
     * The Nombre
     */
    @DatabaseField(canBeNull = false)
    private String nombre;

    /**
     * The Apellido
     */
    @DatabaseField(canBeNull = false)
    private String apellido;

    /**
     * The rut
     */
    @DatabaseField(canBeNull = false,index = true)
    private String rut;

    /**
     * Empty Constructor, for test
     */
    PruebaPersona(){
        //nothing here.
    }

    /**
     * Constructor
     * @param nombre
     * @param apellido
     * @param rut
     */
    public PruebaPersona(String nombre, String apellido, String rut) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    /**
     * get ID
     * @return id
     */
    public Long getId() { return id; }

    /**
     * get Nombre
     * @return nombre
     */
    public String getNombre() { return nombre; }

    /**
     * get Apellido
     * @return apellido
     */
    public String getApellido() { return apellido; }

    /**
     * get Rut
     * @return rut
     */
    public String getRut() { return rut; }
}