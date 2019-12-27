package io.github.ladysnake.pal;

import io.github.ladysnake.pal.impl.PlayerAbilityView;
import io.github.ladysnake.pal.impl.TypedIdentifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

public final class AbilitySource extends TypedIdentifier {

    AbilitySource(Identifier id) {
        super(id);
    }

    public void grantTo(PlayerEntity player, PlayerAbility ability) {
        PlayerAbilityView.of(player).get(ability).grant(this);
    }

    public void revokeFrom(PlayerEntity player, PlayerAbility ability) {
        PlayerAbilityView.of(player).get(ability).revoke(this);
    }

    public boolean grants(PlayerEntity player, PlayerAbility ability) {
        return PlayerAbilityView.of(player).get(ability).isGrantedBy(this);
    }

    public Identifier getId() {
        return this.id;
    }

}