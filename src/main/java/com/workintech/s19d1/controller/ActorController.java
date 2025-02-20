package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actor")
public class ActorController {

    private ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService)
    {
        this.actorService = actorService;
    }

    @GetMapping
    public List<Actor> findAll()
    {
        return actorService.findAll();
    }

    @GetMapping("/{id}")
    public Actor findById(@PathVariable Long id)
    {
        return actorService.findById(id);
    }

    @PostMapping
    public Actor save(@RequestBody ActorRequest actorRequest)
    {
        return actorService.save(actorRequest.getActor());
    }

    @PutMapping("/{id}")
    public Actor update(@PathVariable Long id, @RequestBody Actor actor)
    {
        Actor updatedActor = findById(id);
        updatedActor.setId(actor.getId());
        updatedActor.setGender(actor.getGender());
        updatedActor.setFirstName(actor.getFirstName());
        updatedActor.setLastName(actor.getLastName());
        updatedActor.setBirthDate(actor.getBirthDate());
        updatedActor.setMovies(actor.getMovies());
        return actorService.save(updatedActor);
    }

    @DeleteMapping("/{id}")
    public Actor delete(@PathVariable Long id)
    {
        Actor deletedActor = actorService.findById(id);
        actorService.delete(deletedActor);
        return deletedActor;
    }
}
