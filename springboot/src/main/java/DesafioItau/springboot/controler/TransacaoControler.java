package DesafioItau.springboot.controler;

import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import DesafioItau.springboot.dto.StatisticsDTO;
import DesafioItau.springboot.dto.TransacaoDTO;
import DesafioItau.springboot.model.Transacao;
import DesafioItau.springboot.service.StatisticsService;
import DesafioItau.springboot.service.TransacaoService;

@RestController
@RequestMapping("/")
public class TransacaoControler {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping("/transacao")
     public ResponseEntity<?> criarTransacao(@RequestBody TransacaoDTO dto) {
        try {
            double valor = Double.parseDouble(dto.getValor());
            OffsetDateTime dataHora = OffsetDateTime.parse(dto.getDataHora());

            OffsetDateTime agora = OffsetDateTime.now();
            if (dataHora.isAfter(agora)) return ResponseEntity.unprocessableEntity().build();
            if (valor < 0) return ResponseEntity.unprocessableEntity().build();
            //if (dataHora.isBefore(agora.minusSeconds(60))) return ResponseEntity.noContent().build();

            transacaoService.adicionarTransacao(new Transacao(valor, dataHora));
            return ResponseEntity.status(201).build();

        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/transacao")
    public ResponseEntity<?> deletarTransacoes() {
        transacaoService.limparTransacoes();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<?> getStats() {
        StatisticsDTO staticsDTO = statisticsService.calcularStatistics();
        return ResponseEntity.ok(staticsDTO);
    }

    /*
    @GetMapping("/transacao")
    public ResponseEntity<?> getTransacao(){
        return ResponseEntity.ok(transacaoService.getTransacoes());
    }
    */
}
