package DesafioItau.springboot.service;

import java.util.DoubleSummaryStatistics;

import org.springframework.stereotype.Service;

import DesafioItau.springboot.dto.StatisticsDTO;
import DesafioItau.springboot.model.Transacao;

@Service
public class StatisticsService {

    private TransacaoService transacoes;

    public StatisticsService(TransacaoService transacoes){
        this.transacoes = transacoes;
    }

    public StatisticsDTO calcularStatistics(){
        DoubleSummaryStatistics stats = transacoes.getTransacoes().stream()
            .mapToDouble(Transacao::getValor)
            .summaryStatistics();

        return new StatisticsDTO(stats);
    }
}
