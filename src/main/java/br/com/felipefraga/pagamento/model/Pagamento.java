package br.com.felipefraga.pagamento.model;


import br.com.felipefraga.pagamento.enums.EStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name="pagamentos")
@Getter
@Setter
@NoArgsConstructor
public class Pagamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Positive
    private BigDecimal valor;
    @NotBlank
    @Size(max = 100)
    private String nome;
    @NotBlank
    @Size(max = 19)
    private String numero;
    @NotBlank
    @Size(max = 7)
    private String explicacao;
    @NotBlank
    @Size(min = 3, max = 3)
    private String codigo;
    @NotNull
    @Enumerated(EnumType.STRING)
    private EStatus status;
    @NotNull
    private Long pedidoId;
    @NotNull
    private Long formaDePagamentoId;
}
