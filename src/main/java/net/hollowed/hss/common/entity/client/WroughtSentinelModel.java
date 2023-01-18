package net.hollowed.hss.common.entity.client;

import net.hollowed.hss.HollowedsSwordsAndSorcery;
import net.hollowed.hss.common.entity.custom.WroughtSentinelEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class WroughtSentinelModel extends AnimatedGeoModel<WroughtSentinelEntity> {
    @Override
    public ResourceLocation getModelResource(WroughtSentinelEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "geo/wrought_sentinel.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WroughtSentinelEntity object) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "textures/entity/wrought_sentinel.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WroughtSentinelEntity animatable) {
        return new ResourceLocation(HollowedsSwordsAndSorcery.MOD_ID, "animations/wrought_sentinel.animation.json");
    }


    public void setCustomAnimations(WroughtSentinelEntity animatable, int instanceId, AnimationEvent<software.bernie.geckolib3.core.IAnimatable> animationEvent) {
        super.setLivingAnimations(animatable, instanceId, animationEvent);
        IBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData extraData = animationEvent.getExtraDataOfType(EntityModelData.class).get(0);
        AnimationData manager = animatable.getFactory().getOrCreateAnimationData(instanceId);
        int unpausedMultiplier = !Minecraft.getInstance().isPaused() || manager.shouldPlayWhilePaused ? 1 : 0;
        head.setRotationX(head.getRotationX() + extraData.headPitch * ((float) Math.PI / 180F) * unpausedMultiplier);
        head.setRotationY(head.getRotationY() + extraData.netHeadYaw * ((float) Math.PI / 180F) * unpausedMultiplier);
    }

}
