package com.app.EquipoBridge;

public class EquipoNegro implements Equipo {
    @Override
    public String seleccionarEquipo() {
        return "Fichas Negras";
    }
    @Override
    public String getEquipo() {
        return "Negro";
    }
    public String getDirImg(String ficha){
        return "../Images/Negras/"+ficha+"-negro.png";
    }
}
