package com.sipdasrh.ews.service.impl;

import com.sipdasrh.ews.domain.Spas;
import com.sipdasrh.ews.repository.SpasRepository;
import com.sipdasrh.ews.service.SpasService;
import com.sipdasrh.ews.service.dto.SpasDTO;
import com.sipdasrh.ews.service.mapper.SpasMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link com.sipdasrh.ews.domain.Spas}.
 */
@Service
@Transactional
public class SpasServiceImpl implements SpasService {

    private static final Logger LOG = LoggerFactory.getLogger(SpasServiceImpl.class);

    private final SpasRepository spasRepository;

    private final SpasMapper spasMapper;

    public SpasServiceImpl(SpasRepository spasRepository, SpasMapper spasMapper) {
        this.spasRepository = spasRepository;
        this.spasMapper = spasMapper;
    }

    @Override
    public SpasDTO save(SpasDTO spasDTO) {
        LOG.debug("Request to save Spas : {}", spasDTO);
        Spas spas = spasMapper.toEntity(spasDTO);
        spas = spasRepository.save(spas);
        return spasMapper.toDto(spas);
    }

    @Override
    public SpasDTO update(SpasDTO spasDTO) {
        LOG.debug("Request to update Spas : {}", spasDTO);
        Spas spas = spasMapper.toEntity(spasDTO);
        spas = spasRepository.save(spas);
        return spasMapper.toDto(spas);
    }

    @Override
    public Optional<SpasDTO> partialUpdate(SpasDTO spasDTO) {
        LOG.debug("Request to partially update Spas : {}", spasDTO);

        return spasRepository
            .findById(spasDTO.getId())
            .map(existingSpas -> {
                spasMapper.partialUpdate(existingSpas, spasDTO);

                return existingSpas;
            })
            .map(spasRepository::save)
            .map(spasMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<SpasDTO> findOne(Long id) {
        LOG.debug("Request to get Spas : {}", id);
        return spasRepository.findById(id).map(spasMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Spas : {}", id);
        spasRepository.deleteById(id);
    }
}
