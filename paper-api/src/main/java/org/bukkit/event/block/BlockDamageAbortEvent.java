package org.bukkit.event.block;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/**
 * Called when a player stops damaging a Block.
 *
 * @see BlockDamageEvent
 */
public class BlockDamageAbortEvent extends BlockEvent {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    private final Player player;
    private final ItemStack itemstack;
    private final Reason reason;

    @ApiStatus.Internal
    public BlockDamageAbortEvent(@NotNull final Player player, @NotNull final Block block, @NotNull final ItemStack itemInHand, @NotNull final Reason reason) {
        super(block);
        this.player = player;
        this.itemstack = itemInHand;
        this.reason = reason;
    }

    /**
     * Gets the player that stopped damaging the block involved in this event.
     *
     * @return The player that stopped damaging the block
     */
    @NotNull
    public Player getPlayer() {
        return this.player;
    }

    /**
     * Gets the ItemStack for the item currently in the player's hand.
     *
     * @return The ItemStack for the item currently in the player's hand
     */
    @NotNull
    public ItemStack getItemInHand() {
        return this.itemstack;
    }

    /**
     * Gets the Reason for the block damage to abort.
     *
     * @return The Reason for the block damage to abort
     */
    public Reason getReason() {
        return this.reason;
    }

    @NotNull
    @Override
    public HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @NotNull
    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }

    public enum Reason {
        /**
         * Unknown reason
         */
        UNKNOWN,
        /**
         * Player stopped damaging the block
         */
        PLAYER,
        /**
         * Block is in an unloaded chunk
         */
        UNLOADED_CHUNK,
        /**
         * Block is air
         */
        IS_AIR
    }
}
