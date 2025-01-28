package com.app.EquipoBridge;

public class EquipoBlanco implements Equipo{

    @Override
    public String seleccionarEquipo() {
        return "Fichas Blancas";
    }
    @Override
    public String getEquipo() {
        return "Blanco";
    }
    public String getDirImg(String ficha){
        return "../Images/Blancas/"+ficha+"-blanco.png";
    }
    
    
}
