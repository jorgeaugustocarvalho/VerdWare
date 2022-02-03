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
public class Tarefa {
    
    private int id;
    private Date horario;
    private int plantaId;
    private String tipoDeCuidado;

    public Tarefa(int id, Date horario, int plantaId, String tipoDeCuidado) {
        this.id = id;
        this.horario = horario;
        this.plantaId = plantaId;
        this.tipoDeCuidado = tipoDeCuidado;
    }
    
    public Tarefa(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public int getPlantaId() {
        return plantaId;
    }

    public void setPlantaId(int plantaId) {
        this.plantaId = plantaId;
    }

    public String getTipoDeCuidado() {
        return tipoDeCuidado;
    }

    public void setTipoDeCuidado(String tipoDeCuidado) {
        this.tipoDeCuidado = tipoDeCuidado;
    }
    
    
    
}
