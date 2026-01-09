package net.corneredcube.cubesrpg.block;

import net.corneredcube.cubesrpg.Cubesrpg;
import net.corneredcube.cubesrpg.item.modItems;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class modBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Cubesrpg.MODID);

    public static final RegistryObject<Block> blahaj_block =
            registerBlock("blahaj_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_WOOL)));
    public static final RegistryObject<Block> blahaj_cooked_block =
            registerBlock("blahaj_cooked_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.CAKE)),
                    new Item.Properties().food(
                            new FoodProperties.Builder()
                                    .nutrition(6)
                                    .saturationMod(0.4f)
                                    .alwaysEat()
                                    .build()
                    ));
    private static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Block> registerBlock(String name, Supplier<T> block, Item.Properties properties) {
        RegistryObject<Block> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, properties);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return modItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Item.Properties properties) {
        return modItems.ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
