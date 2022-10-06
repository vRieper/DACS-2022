
package br.univille.dacs2022.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.univille.coredacs2022.entity.Medico;
import br.univille.dacs2022.dto.MedicoDTO;

@Mapper
public interface MedicoMapper {

    List<MedicoDTO> mapListMedico(List<Medico> medico);

    List<Medico> mapListMedicoDTO(List<MedicoDTO> medico);

    MedicoDTO mapMedico(Medico medico);

    Medico mapMedicoDTO(MedicoDTO medico);

}
