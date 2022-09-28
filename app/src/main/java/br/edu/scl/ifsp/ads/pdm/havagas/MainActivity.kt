package br.edu.scl.ifsp.ads.pdm.havagas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.DatePickerDialog.OnDateSetListener
import android.widget.DatePicker
import android.app.DatePickerDialog
import android.view.View
import android.widget.TextView
import android.widget.Toast
import android.widget.AdapterView
import br.edu.scl.ifsp.ads.pdm.havagas.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private val amb : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private companion object{
        const val VALOR_DINAMICO = "VALOR_DINAMICO"
    }

    private var candidato: Candidato? = null

    val calendar = Calendar.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(amb.root)

        amb.etNome.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")
        amb.etEmail.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")
        amb.ckRecebeEmail.isChecked = (savedInstanceState?.getString(VALOR_DINAMICO)?:false) as Boolean
        amb.etTel.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")
        amb.spOpTel.setSelection((savedInstanceState?.getString(VALOR_DINAMICO)?:0) as Int)
        amb.ckInserirCelular.isChecked = (savedInstanceState?.getString(VALOR_DINAMICO)?:true) as Boolean
        amb.femininoRd.isChecked = (savedInstanceState?.getString(VALOR_DINAMICO)?:true) as Boolean
        amb.etDtNasc.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")
        amb.spEscolaridade.setSelection((savedInstanceState?.getString(VALOR_DINAMICO)?:0) as Int)
        amb.etCel.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")
        amb.etVaga.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")
        amb.etOrientador.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")
        amb.etMonografia.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")
        amb.etInstituicao.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")
        amb.etAno.setText(savedInstanceState?.getString(VALOR_DINAMICO)?:"")

        val date = OnDateSetListener { view: DatePicker?, year: Int, month: Int, day: Int ->
            calendar[Calendar.YEAR] = year
            calendar[Calendar.MONTH] = month
            calendar[Calendar.DAY_OF_MONTH] = day
            updateLabel()
        }
        val dateAno = OnDateSetListener { view: DatePicker?, year: Int, month: Int, day: Int ->
            calendar[Calendar.YEAR] = year
            calendar[Calendar.MONTH] = month
            calendar[Calendar.DAY_OF_MONTH] = day
            updateLabelAno()
        }
        amb.etDtNasc.setOnClickListener { view: View? ->
            DatePickerDialog(
                this@MainActivity,
                date,
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            ).show()
        }
        amb.etAno.setOnClickListener { view: View? ->
            DatePickerDialog(
                this@MainActivity,
                dateAno,
                calendar[Calendar.YEAR],
                calendar[Calendar.MONTH],
                calendar[Calendar.DAY_OF_MONTH]
            ).show()
        }

        amb.limparBt.setOnClickListener { view: View? ->
            amb.etNome.setText("")
            amb.etEmail.setText("")
            amb.ckRecebeEmail.isChecked = false
            amb.etTel.setText("")
            amb.spOpTel.setSelection(0)
            amb.ckInserirCelular.isChecked = false
            amb.femininoRd.isChecked = true
            amb.etDtNasc.setText("")
            amb.spEscolaridade.setSelection(0)
            amb.etCel.setText("")
            amb.etVaga.setText("")
            amb.etOrientador.setText("")
            amb.etMonografia.setText("")
            amb.etInstituicao.setText("")
            amb.etAno.setText("")
            candidato = null
        }
        amb.salvarBt.setOnClickListener { view: View? ->
            candidato = (if (amb.ckInserirCelular.isChecked) amb.etCel.text.toString() else null)?.let {
                Candidato(
                    amb.etNome.text.toString(),
                    amb.etEmail.text.toString(),
                    amb.ckRecebeEmail.isChecked,
                    amb.etTel.text.toString(),
                    (amb.spOpTel.selectedView as TextView).text.toString(),
                    it,
                    if (amb.femininoRd.isChecked) amb.femininoRd.text.toString() else amb.masculinoRd.text.toString(),
                    (amb.spEscolaridade.selectedView as TextView).text.toString(),
                    amb.etVaga.text.toString()
                )
            }
            candidato!!.dataNascimento = amb.etDtNasc.text.toString()
            val spinerEscolaridade =
                (amb.spEscolaridade.selectedView as TextView).text.toString()
            if (spinerEscolaridade == "Graduação" || spinerEscolaridade == "Especialização") {
                candidato!!.instituicao = amb.etInstituicao.text.toString()
                candidato!!.anoEscolaridade = amb.etAno.text.toString()
            } else if (spinerEscolaridade == "Mestrado" || spinerEscolaridade == "Doutorado") {
                candidato!!.instituicao = amb.etInstituicao.text.toString()
                candidato!!.tituloMonografio = amb.etMonografia.text.toString()
                candidato!!.orientador = amb.etOrientador.text.toString()
                candidato!!.anoEscolaridade = amb.etAno.text.toString()
            } else {
                candidato!!.anoEscolaridade = amb.etAno.text.toString()
            }
            Toast.makeText(this, candidato.toString(), Toast.LENGTH_SHORT).show()
        }
        amb.ckInserirCelular.setOnClickListener {
            if (amb.ckInserirCelular.isChecked) {
                amb.etCel.visibility = View.VISIBLE
            } else {
                amb.etCel.visibility = View.GONE
            }
        }


//        Erro nessa função
        amb.spEscolaridade.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?,
                    view: View,
                    i: Int,
                    l: Long
                ) {
                    when (i) {
                        0, 1 -> {
                            amb.etAno.hint = "Ano de Formatura"
                            amb.etAno.visibility = View.VISIBLE
                            amb.etInstituicao.visibility = View.GONE
                            amb.etMonografia.visibility = View.GONE
                            amb.etOrientador.visibility = View.GONE
                        }
                        2, 3 -> {
                            amb.etAno.hint = "Ano de Conclusão"
                            amb.etAno.visibility = View.VISIBLE
                            amb.etInstituicao.visibility = View.VISIBLE
                            amb.etMonografia.visibility = View.GONE
                            amb.etOrientador.visibility = View.GONE
                        }
                        4, 5 -> {
                            amb.etAno.hint = "Ano de Conclusão"
                            amb.etAno.visibility = View.VISIBLE
                            amb.etInstituicao.visibility = View.VISIBLE
                            amb.etMonografia.visibility = View.VISIBLE
                            amb.etOrientador.visibility = View.VISIBLE
                        }
                    }
                }

                override fun onNothingSelected(adapterView: AdapterView<*>?) {
                    amb.etAno.hint = "Ano de"
                    amb.etAno.visibility = View.GONE
                    amb.etInstituicao.visibility = View.GONE
                    amb.etMonografia.visibility = View.GONE
                    amb.etOrientador.visibility = View.GONE
                }
            }
    }

    private fun updateLabel() {
        val myFormat = "dd/MM/yy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        amb.etDtNasc.setText(dateFormat.format(calendar.time))
    }

    private fun updateLabelAno() {
        val myFormat = "dd/MM/yy"
        val dateFormat = SimpleDateFormat(myFormat, Locale.US)
        amb.etAno.setText(dateFormat.format(calendar.time))
    }
}