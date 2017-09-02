/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.beans;

import com.sv.udb.controladores.TiposCtrl;
import com.sv.udb.modelos.Tipos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author DanielWilfredo
 */
@Named(value = "tiposBean")
@ViewScoped
public class TiposBean implements Serializable {

    private Tipos objeTipo;
    private List<Tipos> listTipos;
    /**
     * Creates a new instance of TiposBean
     */
    public TiposBean() {
    }

    public Tipos getObjeTipo() {
        return objeTipo;
    }

    public void setObjeTipo(Tipos objeTipo) {
        this.objeTipo = objeTipo;
    }   

    public List<Tipos> getListTipos() {
        return listTipos;
    }
    
    
    
    
  //Se ejecuta despues de que la pagina carga
    @PostConstruct 
    public void init()
    {
      this.objeTipo = new Tipos();
      this.listTipos = new TiposCtrl().cons();
        
    }
    
          public void guar()
    {
        RequestContext ctx = RequestContext.getCurrentInstance(); //Captura el contexto
        if(new TiposCtrl().guar(this.objeTipo))
        {
            this.objeTipo = new Tipos();
            ctx.execute("setMessage('MESS_SUCC', 'Atencion', 'Datos Guardados')");
            System.err.println("Guardó");
        }
        else
        {
         ctx.execute("setMessage('MESS_ERRO', 'Atención', 'No se guardó')");
            System.err.println("No guardó");
        }
    }
    
}
