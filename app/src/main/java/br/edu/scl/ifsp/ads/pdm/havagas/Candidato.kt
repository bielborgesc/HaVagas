package br.edu.scl.ifsp.ads.pdm.havagas

class Candidato(
    var nome: String,
    var email: String,
    var recebeEmail: Boolean,
    var telefone: String,
    var tipoTelefone: String,
    var celular: String,
    var sexo: String,
    var escolaridade: String,
    var vagaPretendida: String
) {
    var dataNascimento: String? = null
    var anoEscolaridade: String? = null
    var instituicao: String? = null
    var tituloMonografio: String? = null
    var orientador: String? = null

    override fun toString(): String {
        return """
               Candidato: Nome= $nome
               Email= $email
               Recebe Email= $recebeEmail
               Telefone= $telefone
               Tipo Telefone= $tipoTelefone
               Celular= $celular
               Sexo=$sexo
               Data de Nascimento= $dataNascimento
               Escolaridade= $escolaridade
               Ano Escolaridade= $anoEscolaridade
               Vaga Pretendida= $vagaPretendida
               Instituicao= $instituicao
               Titulo Monografio= $tituloMonografio
               Orientador= $orientador
               """.trimIndent()
    }
}