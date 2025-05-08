package DesafioItau.springboot.dto;

public class TransacaoDTO {
    private String valor;
    private String dataHora;

    public String getValor(){
        return valor;
    }

    public String getDataHora(){
        return dataHora;
    }

    public void setValor(String valor){
        this.valor = valor;
    }

    public void setDataHora(String dataHora){
        this.dataHora = dataHora;
    }
}
