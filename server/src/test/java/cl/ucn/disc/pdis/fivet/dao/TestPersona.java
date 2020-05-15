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

package cl.ucn.disc.pdis.fivet.dao; import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * The persona class
 *
 * @author Beatriz Alvarez-Rojas.
 */

@DatabaseTable(tableName = "testPersona")
public final class TestPersona {

    /**
     * The id: Primary Key and autoincrement.
     */
    @DatabaseField(generatedId = true)
    private Long id;

    /**
     * The Nombre.
     */
    @DatabaseField(canBeNull = false)
    private String nombre;

    /**
     * The Apellido
     */
    @DatabaseField(canBeNull = false)
    private String apellido;

    /**
     * The Rut.
     */
    @DatabaseField(canBeNull = false, index = true)
    private String rut;

    /**
     * Empty constructor; Default visibility + empty body.
     */
    TestPersona(){
        //nothing Here.
    }
    TestPersona(String nombre, String apellido, String rut) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getRut() {
        return rut;
    }
}
