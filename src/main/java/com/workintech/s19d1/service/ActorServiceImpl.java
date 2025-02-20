package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.repository.ActorRepository;
import com.workintech.s19d1.validation.HollywoodValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ActorServiceImpl implements ActorService {


    private ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository)
    {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        Optional<Actor> optionalActor = actorRepository.findById(id);
        optionalActor.orElseThrow(() -> {
            HollywoodValidation.isActorNull(id);
            return null;
        });
        if(optionalActor.isPresent())
        {
            return optionalActor.get();
        }
        return null;
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void delete(Actor actor) {
        actorRepository.delete(actor);
    }
}
