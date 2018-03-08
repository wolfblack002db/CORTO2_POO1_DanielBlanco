/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Estudiante
 */
public class ModeloSeres {
    int codi_sere;
    String nomb_sere;
    String desc_sere;
    ModeloSeres codi_refe_sere;

    public ModeloSeres() {
    }

    public ModeloSeres(int codi_sere, String nomb_sere, String desc_sere, ModeloSeres codi_refe_sere) {
        this.codi_sere = codi_sere;
        this.nomb_sere = nomb_sere;
        this.desc_sere = desc_sere;
        this.codi_refe_sere = codi_refe_sere;
    }

    public ModeloSeres(int codi_sere, String nomb_sere, String desc_sere) {
        this.codi_sere = codi_sere;
        this.nomb_sere = nomb_sere;
        this.desc_sere = desc_sere;
    }

    public int getCodi_sere() {
        return codi_sere;
    }

    public void setCodi_sere(int codi_sere) {
        this.codi_sere = codi_sere;
    }

    public String getNomb_sere() {
        return nomb_sere;
    }

    public void setNomb_sere(String nomb_sere) {
        this.nomb_sere = nomb_sere;
    }

    public String getDesc_sere() {
        return desc_sere;
    }

    public void setDesc_sere(String desc_sere) {
        this.desc_sere = desc_sere;
    }

    public ModeloSeres getCodi_refe_sere() {
        return codi_refe_sere;
    }

    public void setCodi_refe_sere(ModeloSeres codi_refe_sere) {
        this.codi_refe_sere = codi_refe_sere;
    }

    @Override
    public String toString() {
        return nomb_sere; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
