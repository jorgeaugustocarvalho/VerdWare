/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author javgc
 */
public class Planta {
    
    private int id;
    private String nome;
    private Date dataPlantio;
    private String tipoPlanta;
    private String status;

    public Planta(int id, String nome, Date dataPlantio, String tipoPlanta, String status) {
        this.id = id;
        this.nome = nome;
        this.dataPlantio = dataPlantio;
        this.tipoPlanta = tipoPlanta;
        this.status = status;
    }
    
    public Planta(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataPlantio() {
        return dataPlantio;
    }

    public void setDataPlantio(Date dataPlantio) {
        this.dataPlantio = dataPlantio;
    }

    public String getTipoPlanta() {
        return tipoPlanta;
    }

    public void setTipoPlanta(String tipoPlanta) {
        this.tipoPlanta = tipoPlanta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
    
    
}
