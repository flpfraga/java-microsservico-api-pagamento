package br.com.felipefraga.pagamento.controller;

import br.com.felipefraga.pagamento.dto.PagamentoDto;
import br.com.felipefraga.pagamento.service.PagamentoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @GetMapping("/buscar")
    public Page<PagamentoDto> buscarTodosPagamentos(@PageableDefault(size = 10)Pageable pageable){
        return pagamentoService.buscarTodos(pageable);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<PagamentoDto> buscarTodosPagamentos(@PathVariable @NotNull Long id){
        return ResponseEntity.ok(pagamentoService.buscarPorId(id));
    }

    @PostMapping("/criar")
    public ResponseEntity<PagamentoDto> criarNovoPagamentos(@RequestBody @Valid PagamentoDto pagamentoDto){
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(pagamentoService.criarNovoPagamento(pagamentoDto));
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<PagamentoDto> atualizarPagamentoPorId(@PathVariable @NotNull Long id,
                                                            @RequestBody @Valid PagamentoDto pagamentoDto){
        return ResponseEntity.ok(pagamentoService.atualizarPagamento(id, pagamentoDto));
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<PagamentoDto> deletarPagamentoPorId(@PathVariable @NotNull Long id){
        pagamentoService.deletarPagamento(id);
        return ResponseEntity.noContent().build();
    }
}
