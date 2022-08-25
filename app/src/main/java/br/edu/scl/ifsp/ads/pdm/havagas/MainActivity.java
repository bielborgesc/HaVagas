package br.edu.scl.ifsp.ads.pdm.havagas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

import br.edu.scl.ifsp.ads.pdm.havagas.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;
    private Candidato candidato;
    final Calendar calendar = Calendar.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        DatePickerDialog.OnDateSetListener date = (view, year, month, day) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabel();
        };

        DatePickerDialog.OnDateSetListener dateAno = (view, year, month, day) -> {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, day);
            updateLabelAno();
        };

        activityMainBinding.etDtNasc.setOnClickListener(view -> new DatePickerDialog(MainActivity.this, date, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show());
        activityMainBinding.etAno.setOnClickListener(view -> new DatePickerDialog(MainActivity.this, dateAno, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show());


        activityMainBinding.limparBt.setOnClickListener( (View view) -> {
            activityMainBinding.etNome.setText("");
            activityMainBinding.etEmail.setText("");
            activityMainBinding.ckRecebeEmail.setChecked(false);
            activityMainBinding.etTel.setText("");
            activityMainBinding.spOpTel.setSelection(0);
            activityMainBinding.ckInserirCelular.setChecked(false);
            activityMainBinding.femininoRd.setChecked(true);
            activityMainBinding.etDtNasc.setText("");
            activityMainBinding.spEscolaridade.setSelection(0);
            activityMainBinding.etCel.setText("");
            activityMainBinding.etVaga.setText("");
            activityMainBinding.etOrientador.setText("");
            activityMainBinding.etMonografia.setText("");
            activityMainBinding.etInstituicao.setText("");
            activityMainBinding.etAno.setText("");
            candidato = null;
        });


        activityMainBinding.salvarBt.setOnClickListener( view -> {
            candidato = new Candidato(
                    activityMainBinding.etNome.getText().toString(),
                    activityMainBinding.etEmail.getText().toString(),
                    activityMainBinding.ckRecebeEmail.isChecked(),
                    activityMainBinding.etTel.getText().toString(),
                    ((TextView)activityMainBinding.spOpTel.getSelectedView()).getText().toString(),
                    activityMainBinding.ckInserirCelular.isChecked()?
                            activityMainBinding.etCel.getText().toString() :
                            null,
                    activityMainBinding.femininoRd.isChecked()?
                            activityMainBinding.femininoRd.getText().toString() :
                            activityMainBinding.masculinoRd.getText().toString(),
                    ((TextView)activityMainBinding.spEscolaridade.getSelectedView()).getText().toString(),
                    activityMainBinding.etVaga.getText().toString()
            );
            candidato.setDataNascimento(activityMainBinding.etDtNasc.getText().toString());

            String spinerEscolaridade = ((TextView)activityMainBinding.spEscolaridade.getSelectedView()).getText().toString();

            if(spinerEscolaridade.equals("Graduação") || spinerEscolaridade.equals("Especialização")){
                candidato.setInstituicao(activityMainBinding.etInstituicao.getText().toString());
                candidato.setAnoEscolaridade(activityMainBinding.etAno.getText().toString());
            } else if(spinerEscolaridade.equals("Mestrado" ) || spinerEscolaridade.equals("Doutorado")){
                candidato.setInstituicao(activityMainBinding.etInstituicao.getText().toString());
                candidato.setTituloMonografio(activityMainBinding.etMonografia.getText().toString());
                candidato.setOrientador(activityMainBinding.etOrientador.getText().toString());
                candidato.setAnoEscolaridade(activityMainBinding.etAno.getText().toString());
            } else {
                candidato.setAnoEscolaridade(activityMainBinding.etAno.getText().toString());
            }

            Toast.makeText(this, candidato.toString(), Toast.LENGTH_SHORT).show();
        });

        activityMainBinding.ckInserirCelular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if(activityMainBinding.ckInserirCelular.isChecked()){
                    activityMainBinding.etCel.setVisibility(View.VISIBLE);
                } else {
                    activityMainBinding.etCel.setVisibility(View.GONE);
                }
            }
        });

        activityMainBinding.spEscolaridade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                    case 1:
                        activityMainBinding.etAno.setHint("Ano de Formatura");
                        activityMainBinding.etAno.setVisibility(View.VISIBLE);
                        activityMainBinding.etInstituicao.setVisibility(View.GONE);
                        activityMainBinding.etMonografia.setVisibility(View.GONE);
                        activityMainBinding.etOrientador.setVisibility(View.GONE);
                        break;
                    case 2:
                    case 3:
                        activityMainBinding.etAno.setHint("Ano de Conclusão");
                        activityMainBinding.etAno.setVisibility(View.VISIBLE);
                        activityMainBinding.etInstituicao.setVisibility(View.VISIBLE);
                        activityMainBinding.etMonografia.setVisibility(View.GONE);
                        activityMainBinding.etOrientador.setVisibility(View.GONE);
                        break;
                    case 4:
                    case 5:
                        activityMainBinding.etAno.setHint("Ano de Conclusão");
                        activityMainBinding.etAno.setVisibility(View.VISIBLE);
                        activityMainBinding.etInstituicao.setVisibility(View.VISIBLE);
                        activityMainBinding.etMonografia.setVisibility(View.VISIBLE);
                        activityMainBinding.etOrientador.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                activityMainBinding.etAno.setHint("Ano de");
                activityMainBinding.etAno.setVisibility(View.GONE);
                activityMainBinding.etInstituicao.setVisibility(View.GONE);
                activityMainBinding.etMonografia.setVisibility(View.GONE);
                activityMainBinding.etOrientador.setVisibility(View.GONE);
            }
        });

    }

    private void updateLabel() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        activityMainBinding.etDtNasc.setText(dateFormat.format(calendar.getTime()));
    }

    private void updateLabelAno() {
        String myFormat = "dd/MM/yy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(myFormat, Locale.US);
        activityMainBinding.etAno.setText(dateFormat.format(calendar.getTime()));
    }

}