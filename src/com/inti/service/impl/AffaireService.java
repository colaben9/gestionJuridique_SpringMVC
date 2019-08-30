package com.inti.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inti.entities.Affaire;
import com.inti.service.interfaces.IAffaireService;

@Service
@Transactional
public class AffaireService extends ManagerService<Affaire> implements IAffaireService {

}
