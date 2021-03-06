package com.github.alexthe666.alexsmobs.entity.ai;

import com.github.alexthe666.alexsmobs.entity.EntityElephant;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.merchant.villager.AbstractVillagerEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.vector.Vector3d;

import java.util.EnumSet;

public class ElephantAIVillagerRide  extends Goal {

    private EntityElephant elephant;
    private AbstractVillagerEntity villager;
    private double speed;

    public ElephantAIVillagerRide(EntityElephant dragon, double speed) {
        elephant = dragon;
        this.speed = speed;
    }

    @Override
    public boolean shouldExecute() {
        if(elephant.getControllingVillager() != null){
           villager = elephant.getControllingVillager();
            return true;
        }
        return false;
    }

    @Override
    public void startExecuting() {
    }

    @Override
    public void tick() {
        if(this.villager.getNavigator().hasPath()){
            this.elephant.getNavigator().setPath(this.villager.getNavigator().getPath(), 1.6D);
        }
    }
}
