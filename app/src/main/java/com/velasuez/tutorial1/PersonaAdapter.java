package com.velasuez.tutorial1;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.personaView> implements Filterable {

    private List<Persona> personaList = new ArrayList<>();
    private Context context;

    private ArrayList<Persona> personaArrayList;


    private IAxiliarPersona iAxiliarPersona;


    public PersonaAdapter(IAxiliarPersona iAxiliarPersona, ArrayList<Persona> personaList) {
        this.iAxiliarPersona = iAxiliarPersona;
        this.personaList = personaList;
        this.personaArrayList = personaList;
    }

    @NonNull
    @Override
    public personaView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mostrar, viewGroup, false);
        return new personaView(view);

    }

    @Override
    public void onBindViewHolder(personaView personaView, int i) {
        Persona persona = personaList.get(i);
        personaView.txtcodigoMostrar.setText(String.valueOf(persona.getCodigo()));
        personaView.txtFuncionarioMostrar.setText(persona.getFuncionario());
        personaView.txtCargoMostrar.setText(persona.getCargo());
        personaView.txtAreaMostrar.setText(persona.getArea());
        personaView.txtHijosMostrar.setText(persona.getHijos());
        personaView.txtEstadoMostrar.setText(persona.getEstado());
        personaView.txtDescuentoMostrar.setText(persona.getDescuento());
        personaView.btnEliminar.setOnClickListener(new eventoEliminar(persona));
    }


    @Override
    public int getItemCount() {
        return personaList.size();
    }


    public void agregarPersona(Persona persona) {
        personaList.add(persona);
        this.notifyDataSetChanged();
    }

    public void eliminarPersona(Persona persona) {
        personaList.remove(persona);
        this.notifyDataSetChanged();
    }

    @Override
    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String palabra = constraint.toString();

                if (palabra.isEmpty()) {
                    personaList = personaArrayList;
                } else {
                    ArrayList<Persona> filtrarLista = new ArrayList<>();
                    for (Persona persona : personaArrayList) {
                        if (persona.getFuncionario().toLowerCase().contains(constraint)) {
                            filtrarLista.add(persona);
                        }
                    }
                    personaList = filtrarLista;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = personaList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                personaList = (ArrayList<Persona>) results.values;
                notifyDataSetChanged();
            }
        };
    }




    class eventoEliminar implements View.OnClickListener {
        private Persona persona;

        public eventoEliminar(Persona persona) {
            this.persona = persona;
        }

        @Override
        public void onClick(View v) {
            iAxiliarPersona.OpcionEliminar(persona);
        }
    }


    public class personaView extends RecyclerView.ViewHolder {
        private TextView txtcodigoMostrar, txtFuncionarioMostrar, txtCargoMostrar,txtAreaMostrar,txtHijosMostrar,txtEstadoMostrar, txtDescuentoMostrar;
        private Button btnEditar, btnEliminar;

        public personaView(@NonNull View itemView) {
            super(itemView);
            txtcodigoMostrar = itemView.findViewById(R.id.txtcodigoMostrar);
            txtFuncionarioMostrar = itemView.findViewById(R.id.txtFuncionarioMostrar);
            txtCargoMostrar = itemView.findViewById(R.id.txtCargoMostrar);
            txtAreaMostrar = itemView.findViewById(R.id.txtAreaMostrar);
            txtHijosMostrar = itemView.findViewById(R.id.txtHijosMostrar);
            txtEstadoMostrar = itemView.findViewById(R.id.txtEstadoMostrar);
            txtDescuentoMostrar = itemView.findViewById(R.id.txtDescuentoMostrar);
            btnEliminar = itemView.findViewById(R.id.btnEliminar);
        }
    }

}
