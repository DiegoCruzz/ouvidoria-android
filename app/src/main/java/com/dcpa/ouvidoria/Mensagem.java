package com.dcpa.ouvidoria;

import static android.support.v7.widget.AppCompatDrawableManager.get;

/**
 * Created by mayelli on 06/02/2018.
 */

public class Mensagem {
    private String assunto;
    private String texto;

    public Mensagem(String assunto, String texto) {
        this.assunto = assunto;
        this.texto = texto;

    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    @Override
    public String toString () {
        return getAssunto() + ": " + getTexto();
    }
}
