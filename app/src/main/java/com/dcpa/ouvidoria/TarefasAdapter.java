package com.dcpa.ouvidoria;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by mayelli on 06/02/2018.
 */

public class TarefasAdapter extends ArrayAdapter<Mensagem> {
    public TarefasAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Mensagem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Mensagem mensagem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.linha, parent, false);
        }
        TextView assunto = (TextView) convertView.findViewById(R.id.assunto);
        TextView texto = (TextView) convertView.findViewById(R.id.msg);

        assunto.setText(mensagem.getAssunto());
        texto.setText(mensagem.getTexto());

        return convertView;
    }
}