package com.example.cleverp.controladors;

import com.example.cleverp.Interface.PartidesInterface;
import com.example.cleverp.dao.PartidesDAO;
import com.example.cleverp.model.Partides;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Aitor
 */
@Service
@Slf4j
public class PartidesService implements PartidesInterface {

    @Autowired
    private PartidesDAO partides;

    @Override
    @Transactional
    public List<Partides> listarPartides() {
        return (List<Partides>) partides.findAll();
    }

    @Override
    @Transactional
    public void addPartida(Partides partides) {
        this.partides.save(partides);
    }

    @Override
    @Transactional
    public void eliminarPartida(Partides partides) {
        this.partides.delete(partides);
    }
    
    @Override
    @Transactional
    public Partides buscarPartida(Partides partides) {
        return this.partides.findById(partides.getId()).orElse(null);
    }
}
