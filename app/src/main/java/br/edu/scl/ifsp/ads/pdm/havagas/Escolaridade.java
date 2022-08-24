package br.edu.scl.ifsp.ads.pdm.havagas;

public enum Escolaridade {

        FUNDAMENTAL("Fundamental"),
        MEDIO("Médio"),
        GRADUACAO("Graduação"),
        ESPECIALIZACAO("Especialização"),
        MESTRADO("Mestrado"),
        DOUTORADO("doutorado");

        private String escolaridade;

        Escolaridade(String descricao) {
            this.escolaridade = escolaridade;
        }

        public String getEscolaridade() {
            return escolaridade;
        }

}
