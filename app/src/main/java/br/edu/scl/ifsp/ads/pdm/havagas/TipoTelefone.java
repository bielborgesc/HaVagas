package br.edu.scl.ifsp.ads.pdm.havagas;

public enum TipoTelefone {

        COMERCIAL("Comercial"),
        RESIDENCIAL("Residencial");

        private final String tipo;

        TipoTelefone(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo() {
            return tipo;
        }
}
