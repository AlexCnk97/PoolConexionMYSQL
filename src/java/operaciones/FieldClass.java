/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package operaciones;

/**
 *
 * @author DARQ
 */
public class FieldClass {
    
    private String nombre;
    private Object valor;
    private boolean primary;
    private boolean autoincrement;
    private boolean notnull;
    private Class tipo;

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the valor
     */
    public Object getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Object valor) {
        this.valor = valor;
    }

    /**
     * @return the primary
     */
    public boolean isPrimary() {
        return primary;
    }

    /**
     * @param primary the primary to set
     */
    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    /**
     * @return the autoincrement
     */
    public boolean isAutoincrement() {
        return autoincrement;
    }

    /**
     * @param autoincrement the autoincrement to set
     */
    public void setAutoincrement(boolean autoincrement) {
        this.autoincrement = autoincrement;
    }

    /**
     * @return the notnull
     */
    public boolean isNotnull() {
        return notnull;
    }

    /**
     * @param notnull the notnull to set
     */
    public void setNotnull(boolean notnull) {
        this.notnull = notnull;
    }

    /**
     * @return the tipo
     */
    public Class getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Class tipo) {
        this.tipo = tipo;
    }
}
