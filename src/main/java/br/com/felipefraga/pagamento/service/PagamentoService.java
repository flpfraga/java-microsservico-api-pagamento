package br.com.felipefraga.pagamento.service;

import br.com.felipefraga.pagamento.dto.PagamentoDto;
import br.com.felipefraga.pagamento.enums.EStatus;
import br.com.felipefraga.pagamento.model.Pagamento;
import br.com.felipefraga.pagamento.repository.PagamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    public ModelMapper mapper;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    public Page<PagamentoDto> buscarTodos(Pageable pageable){
        return pagamentoRepository.findAll(pageable)
                .map(pagamento -> mapper.map(pagamento, PagamentoDto.class));
    }

    public PagamentoDto buscarPorId(Long id){
        return mapper.map(pagamentoRepository.findById(id), PagamentoDto.class);
    }

    public PagamentoDto criarNovoPagamento(PagamentoDto pagamentoDto){
        var pagamento = mapper.map(pagamentoDto, Pagamento.class);
        pagamento.setStatus(EStatus.CRIADO);
        return mapper.map(pagamentoRepository.save(pagamento), PagamentoDto.class);
    }

    public PagamentoDto atualizarPagamento(Long id, PagamentoDto pagamentoDto){
        var pagamento = mapper.map(pagamentoDto, Pagamento.class);
        pagamento.setId(id);
        return mapper.map(pagamentoRepository.save(pagamento), PagamentoDto.class);
    }

    public void deletarPagamento(Long id){
        pagamentoRepository.deleteById(id);
    }


}
