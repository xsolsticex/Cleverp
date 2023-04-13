package com.example.cleverp.controladors;

import com.example.cleverp.Interface.PartidesInterface;
import com.example.cleverp.dao.EquipDAO;
import com.example.cleverp.dao.PartidesDAO;
import com.example.cleverp.model.Equip;
import com.example.cleverp.model.Partides;
import java.util.ArrayList;
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

    @Autowired
    private EquipDAO equips;

    @Override
    @Transactional
    public List<Partides> listarPartides() {
        return (List<Partides>) partides.findAll();
    }

    @Override
    @Transactional
    public void addPartida(Partides partides) {
        // Buscar els equips pels seus IDs
        Equip equipA = equips.findById(partides.getEquipa_id().longValue()).orElse(null);
        Equip equipB = equips.findById(partides.getEquipb_id().longValue()).orElse(null);

        // Asignar els equips a les llistes corresponents
        partides.setEquips_a(equipA);
        partides.setEquips_b(equipB);

        // Guardar partida
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
