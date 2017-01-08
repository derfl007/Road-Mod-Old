package derfl007.roads.entities;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityCar extends EntityMinecart {

	public EntityCar(World worldIn) {
		super(worldIn);
	}

	@Override
	public Type getType() {
		return Type.RIDEABLE;
	}
	
	@Override
	protected void moveDerailedMinecart() {
		double d0 = onGround ? this.getMaximumSpeed() : getMaxSpeedAirLateral();
        this.motionX = MathHelper.clamp_double(this.motionX, -d0, d0);
        this.motionZ = MathHelper.clamp_double(this.motionZ, -d0, d0);

        double moveY = motionY;
        if(getMaxSpeedAirVertical() > 0 && motionY > getMaxSpeedAirVertical())
        {
            moveY = getMaxSpeedAirVertical();
            if(Math.abs(motionX) < 0.3f && Math.abs(motionZ) < 0.3f)
            {
                moveY = 0.15f;
                motionY = moveY;
            }
        }

//        if (this.onGround)
//        {
//            this.motionX *= 0.5D;
//            this.motionY *= 0.5D;
//            this.motionZ *= 0.5D;
//        }

        this.moveEntity(this.motionX, moveY, this.motionZ);

        if (!this.onGround)
        {
            this.motionX *= getDragAir();
            this.motionY *= getDragAir();
            this.motionZ *= getDragAir();
        }
	}
	
	@Override
	public boolean canUseRail() {
		// TODO Auto-generated method stub
		return false;
	}

}
