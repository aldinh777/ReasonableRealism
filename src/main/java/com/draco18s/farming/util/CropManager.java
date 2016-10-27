package com.draco18s.farming.util;

import java.util.HashMap;

import com.draco18s.hardlib.interfaces.IHardCrops;
import com.draco18s.hardlib.internal.CropWeatherOffsets;

import net.minecraft.block.Block;

public class CropManager implements IHardCrops {
	private HashMap<Block,CropWeatherOffsets> cropWeatherOffsets = new HashMap<Block,CropWeatherOffsets>();

	@Override
	public void putCropWeather(Block b, CropWeatherOffsets off) {
		if(b == null) {
			RuntimeException e = new RuntimeException("Attempted to set weather offsets for a null block");
			e.printStackTrace();
			return;
		}
		cropWeatherOffsets.put(b, off);
	}

	@Override
	public boolean isCropBlock(Block block) {
		return cropWeatherOffsets.containsKey(block);
	}

	@Override
	public CropWeatherOffsets getCropOffsets(Block block) {
		return cropWeatherOffsets.get(block);
	}
}
