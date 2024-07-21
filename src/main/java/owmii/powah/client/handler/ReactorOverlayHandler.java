package owmii.powah.client.handler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import owmii.powah.Powah;
import owmii.powah.item.ReactorItem;
import owmii.powah.lib.client.util.Render;
import owmii.powah.lib.client.util.RenderTypes;

public class ReactorOverlayHandler {
    static final ResourceLocation OV_TEXTURE = Powah.id("textures/misc/reactor_ov.png");

    public static void onRenderLast(PoseStack poseStack, Camera camera) {
        Minecraft mc = Minecraft.getInstance();
        net.minecraft.world.entity.player.Player player = mc.player;
        if (player == null || mc.level == null)
            return;
        boolean flag = false;
        boolean flag1 = false;
        for (InteractionHand hand : InteractionHand.values()) {
            ItemStack stack = player.getItemInHand(hand);
            if (stack.getItem() instanceof ReactorItem) {
                flag = true;
                if (player.getInventory().countItem(stack.getItem()) >= 36) {
                    flag1 = true;
                    break;
                }
                break;
            }
        }

        if (!flag)
            return;
        HitResult result = mc.hitResult;
        if (result instanceof BlockHitResult br) {
            boolean isReplaceable = mc.level.getBlockState(br.getBlockPos()).canBeReplaced()
                    && !mc.level.isEmptyBlock(br.getBlockPos());
            if (mc.level.isEmptyBlock(br.getBlockPos()) || !isReplaceable && !br.getDirection().equals(Direction.UP))
                return;
            BlockPos pos = isReplaceable ? br.getBlockPos() : br.getBlockPos().relative(br.getDirection());
            List<BlockPos> list = BlockPos.betweenClosedStream(pos.offset(-1, 0, -1), pos.offset(1, 3, 1)).map(BlockPos::immutable)
                    .toList();
            int color = 0x75e096;
            if (!flag1 && !player.isCreative())
                color = 0xcf040e;
            if (color != 0xcf040e) {
                for (BlockPos blockPos : list) {
                    if (!mc.level.getBlockState(blockPos).canBeReplaced()) {
                        color = 0xcf040e;
                        break;
                    }
                }
                List<LivingEntity> entities = mc.level.getEntitiesOfClass(LivingEntity.class, new AABB(pos).inflate(1.0D, 3.0D, 1.0D));
                if (!entities.isEmpty()) {
                    color = 0xcf040e;
                }
            }
            poseStack.pushPose();

            Vec3 projectedView = camera.getPosition();
            Quaternionf rotation = new Quaternionf(camera.rotation());
            rotation.invert();
            poseStack.mulPose(rotation);
            poseStack.translate(-projectedView.x, -projectedView.y, -projectedView.z);

            poseStack.translate(-1.0D, 0.001D, -1.0D);
            float r = (color >> 16 & 0xFF) / 255.0F;
            float g = (color >> 8 & 0xFF) / 255.0F;
            float b = (color & 0xFF) / 255.0F;

            var buffers = mc.renderBuffers().bufferSource();
            var renderType = RenderTypes.createReactorOverlay(OV_TEXTURE);
            VertexConsumer buffer = buffers.getBuffer(renderType);
            buffer.addVertex(poseStack.last().pose(), pos.getX(), pos.getY(), pos.getZ() + 3).setColor(r, g, b, 1.0F).setUv(0.0F, 1.0F)
                    .setLight(Render.MAX_LIGHT);
            buffer.addVertex(poseStack.last().pose(), pos.getX() + 3, pos.getY(), pos.getZ() + 3).setColor(r, g, b, 1.0F).setUv(1.0F, 1.0F)
                    .setLight(Render.MAX_LIGHT);
            buffer.addVertex(poseStack.last().pose(), pos.getX() + 3, pos.getY(), pos.getZ()).setColor(r, g, b, 1.0F).setUv(1.0F, 0.0F)
                    .setLight(Render.MAX_LIGHT);
            buffer.addVertex(poseStack.last().pose(), pos.getX(), pos.getY(), pos.getZ()).setColor(r, g, b, 1.0F).setUv(0.0F, 0.0F)
                    .setLight(Render.MAX_LIGHT);
            poseStack.popPose();
            buffers.endBatch(renderType);
        }
    }
}
