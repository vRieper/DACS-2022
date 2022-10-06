package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.coredacs2022.entity.Cidade;
import br.univille.dacs2022.dto.CidadeDTO;

@Mapper(componentModel = "spring")
public interface CidadeMapper {

    List<CidadeDTO> mapListCidade(List<Cidade> Cidade);

    List<Cidade> mapListCidadeDTO(List<CidadeDTO> Cidade);

    CidadeDTO mapCidade(Cidade Cidade);

    Cidade mapCidadeDTO(CidadeDTO Cidade);
}
