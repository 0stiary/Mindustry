package io.anuke.mindustry.entities.impl;


import io.anuke.mindustry.entities.traits.DamageTrait;
import io.anuke.mindustry.entities.traits.HealthTrait;
import io.anuke.mindustry.entities.traits.SolidTrait;

public abstract class DestructibleEntity extends SolidEntity implements HealthTrait{
    public transient boolean dead;
    public float health;

    @Override
    public boolean collides(SolidTrait other){
        return other instanceof DamageTrait;
    }

    @Override
    public void collision(SolidTrait other, float x, float y){
        if(other instanceof DamageTrait){
            onHit(other);
            damage(((DamageTrait) other).damage());
        }
    }

    @Override
    public void health(float health){
        this.health = health;
    }

    @Override
    public float health(){
        return health;
    }

    @Override
    public boolean isDead(){
        return dead;
    }

    @Override
    public void setDead(boolean dead){
        this.dead = dead;
    }

}
