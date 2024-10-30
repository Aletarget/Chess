package com.app.Fichas;

import com.app.EquipoBridge.Equipo;

public abstract class Ficha{
    private Equipo Color;
    private String Tipo;
    private String Img;
    private int[] pos;

    public Ficha(Equipo Color, String Tipo, String Img, int[] pos){
        setColor(Color);
        setImg(Img);
        setTipo(Tipo);
        setPos(pos);
    }

    //SETTERS
    public void setColor(Equipo color) {
        Color = color;
    }
    public void setImg(String img) {
        Img = img;
    }
    public void setTipo(String tipo) {
        Tipo = tipo;
    }
    public void setPos(int[] pos) {
        this.pos = pos;
    }

    //GETTERS
    public String getColor() {
        return Color.getEquipo();
    }
    public String getImg() {
        return Img;
    }
    public String getTipo() {
        return Tipo;
    }
    public int[] getPos() {
        return pos;
    }
}
