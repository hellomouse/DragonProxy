/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dragonet.proxy.network.translator.itemsblocks;

import org.dragonet.common.data.itemsblocks.IItemDataTranslator;

/**
 * @author vincent
 */
public class BedDataTranslator extends IItemDataTranslator {

    //https://minecraft.gamepedia.com/Trapdoor

    @Override
    public Integer translateToPE(Integer damage) {
        // Here is the magic
        int facing = damage & 0x03;
        boolean headOccupied = (damage & 0x04) > 0; // head bed occupied
        boolean footOccupied = (damage & 0x08) > 0; // foot bed occupied
        return facing + (headOccupied ? 0x04 : 0x00) + (footOccupied ? 0x08 : 0x00);
    }

    @Override
    public Integer translateToPC(Integer damage) {
        // Here too
        return damage;
    }
}
