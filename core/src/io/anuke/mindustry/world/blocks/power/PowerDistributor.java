package io.anuke.mindustry.world.blocks.power;

import io.anuke.mindustry.world.Tile;
import io.anuke.mindustry.world.blocks.PowerBlock;

public class PowerDistributor extends PowerBlock{

    public PowerDistributor(String name){
        super(name);
        consumesPower = false;
        outputsPower = true;
    }

    @Override
    public void update(Tile tile){
        if(tile.entity != null && tile.entity.power != null && tile.entity.power.graph != null){
            tile.entity.power.graph.update();
        }
    }
}
