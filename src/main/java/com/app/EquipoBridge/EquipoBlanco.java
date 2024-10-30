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
    
}
