package baritone.bot.pathing.movement;

public interface ActionCosts extends ActionCostsButOnlyTheOnesThatMakeMickeyDieInside {

    /**
     * These costs are measured roughly in ticks btw
     */
    double WALK_ONE_BLOCK_COST = 20 / 4.317;
    double WALK_ONE_IN_WATER_COST = 20 / 2.2;
    double JUMP_ONE_BLOCK_COST = 5.72854;//see below calculation for fall. 1.25 blocks
    double LADDER_UP_ONE_COST = 20 / 2.35;
    double LADDER_DOWN_ONE_COST = 20 / 3;
    double SNEAK_ONE_BLOCK_COST = 20 / 1.3;
    double SPRINT_ONE_BLOCK_COST = 20 / 5.612;
    /**
     * To walk off an edge you need to walk 0.5 to the edge then 0.3 to start falling off
     */
    double WALK_OFF_BLOCK_COST = WALK_ONE_BLOCK_COST * 0.8;
    /**
     * To walk the rest of the way to be centered on the new block
     */
    double CENTER_AFTER_FALL_COST = WALK_ONE_BLOCK_COST - WALK_OFF_BLOCK_COST;

    /**
     * It doesn't actually take ten ticks to place a block, this cost is so high
     * because we want to generally conserve blocks which might be limited
     */
    double PLACE_ONE_BLOCK_COST = 20;

    /**
     * Add this to the cost of breaking any block. The cost of breaking any
     * block is calculated as the number of ticks that block takes to break with
     * the tools you have. You add this because there's always a little overhead
     * (e.g. looking at the block)
     */
    double BREAK_ONE_BLOCK_ADD = 4;
    double COST_INF = 1000000;
}