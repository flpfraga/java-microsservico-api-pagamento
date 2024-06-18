package br.com.felipefraga.pagamento.dto;

import br.com.felipefraga.pagamento.enums.EStatus;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PagamentoDto {
    private Long id;
    private BigDecimal valor;
    private String nome;
    private String numero;
    private String explicacao;
    private String codigo;
    private EStatus status;
    private Long pedidoId;
    private Long formaDePagamentoId;
}
