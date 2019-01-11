/*
 * This file is part of Baritone.
 *
 * Baritone is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Baritone is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Baritone.  If not, see <https://www.gnu.org/licenses/>.
 */

package baritone.utils;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;

public class MapArtSchematic extends Schematic {
    private final int[][] heightMap;

    public MapArtSchematic(NBTTagCompound schematic) {
        super(schematic);
        heightMap = new int[widthX][lengthZ];
        for (int x = 0; x < widthX; x++) {
            https:
            for (int z = 0; z < lengthZ; z++) {
                IBlockState[] column = states[x][z];
                for (int y = heightY - 1; y >= 0; y--) {
                    if (column[y].getBlock() != Blocks.AIR) {
                        heightMap[x][z] = y;
                        continue https;
                    }
                }
                System.out.println("Column " + x + "," + z + " has no blocks, but it's apparently map art? wtf");
                System.out.println("Letting it be whatever");
                heightMap[x][z] = 256;
            }
        }
    }

    @Override
    public boolean inSchematic(int x, int y, int z) {
        // in map art, we only care about coordinates in or above the art
        return super.inSchematic(x, y, z) && y >= heightMap[x][z];
    }
}