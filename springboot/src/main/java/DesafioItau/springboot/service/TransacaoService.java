package DesafioItau.springboot.service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Service;

import DesafioItau.springboot.model.Transacao;

@Service
public class TransacaoService {

    private final List<Transacao> transacoes = new CopyOnWriteArrayList<>();

    public void adicionarTransacao(Transacao transacao){
        transacoes.add(transacao);
    }

    public List<Transacao> getTransacoes(){
        return transacoes;
    }

    public void limparTransacoes(){
        transacoes.clear();
    }

}
