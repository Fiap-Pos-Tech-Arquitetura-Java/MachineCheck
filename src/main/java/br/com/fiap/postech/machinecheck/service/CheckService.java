package br.com.fiap.postech.machinecheck.service;

import br.com.fiap.postech.machinecheck.controller.exception.ControllerNotFoundException;
import br.com.fiap.postech.machinecheck.dto.CheckDTO;
import br.com.fiap.postech.machinecheck.entities.Check;
import br.com.fiap.postech.machinecheck.repository.CheckRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckService {
    @Autowired
    private CheckRepository checkRepository;

    public List<CheckDTO> findAll() {
        List<Check> checks = checkRepository.findAll();
        return checks.stream().map(this::toDTO).toList();
    }

    public CheckDTO findById(Long id) {
        Check Check = checkRepository.findById(id)
                .orElseThrow(() -> new ControllerNotFoundException("Checagem não encontrada com o ID: " + id));
        return toDTO(Check);
    }

    public CheckDTO save(CheckDTO checkDTO) {
        Check check = toEntity(checkDTO);
        check = checkRepository.save(check);
        return toDTO(check);
    }

    public CheckDTO update(Long id, CheckDTO checkDTO) {
        try {
            Check check = checkRepository.getReferenceById(id);

            check.setMaquina(checkDTO.maquina());
            check.setObservacao(checkDTO.observacao());
            check.setComponente(checkDTO.componente());
            check.setStatusChecagem(checkDTO.statusChecagem());
            check.setDataChecagem(checkDTO.dataChecagem());
            check.setTempoDaChecagem(checkDTO.tempoDaChecagem());
            check.setUrlFoto(checkDTO.urlFoto());
            check.setUrlVideo(checkDTO.urlVideo());
            check.setExecutante(checkDTO.executante());

            check = checkRepository.save(check);
            return toDTO(check);
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundException("Usuário não encontrado com o ID: " + id);
        }
    }

    public void delete(Long id) {
        checkRepository.deleteById(id);
    }

    private Check toEntity(CheckDTO checkDTO) {
        return new Check(checkDTO.maquina(),
                checkDTO.observacao(),
                checkDTO.componente(),
                checkDTO.statusChecagem(),
                checkDTO.dataChecagem(),
                checkDTO.tempoDaChecagem(),
                checkDTO.urlFoto(),
                checkDTO.urlVideo(),
                checkDTO.executante()
        );
    }

    private CheckDTO toDTO(Check check) {
        return new CheckDTO(
                check.getMaquina(),
                check.getObservacao(),
                check.getComponente(),
                check.getStatusChecagem(),
                check.getDataChecagem(),
                check.getTempoDaChecagem(),
                check.getUrlFoto(),
                check.getUrlVideo(),
                check.getExecutante()
        );
    }
}