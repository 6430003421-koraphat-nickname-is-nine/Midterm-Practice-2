package logic.rocks;

import logic.zombies.Zombie;

public class PoisonRock extends NormalRock{
	private int damageOverTime;
	
	
	public int getDamageOverTime() {
		return damageOverTime;
	}


	public void setDamageOverTime(int damageOverTime) {
		if(damageOverTime < 0) {
			damageOverTime = 0;
		}
		this.damageOverTime = damageOverTime;
	}


	public PoisonRock(int damage,int damageOverTime) {
		super(damage);
		this.setDamageOverTime(damageOverTime);
	}
	
	public int dealDamage(Zombie zombie) {
		zombie.setDecay(zombie.getDecay() + this.getDamageOverTime());
		if(zombie.getDefense() < this.damage) {
			int damage_deal = this.getDamage() - zombie.getDefense();
			zombie.setHealth(zombie.getHealth() - damage_deal);
			return damage_deal;
		}
		return 0;
	}


	@Override
	public String toString() {
		return "PoisonRock (" + getDamage() + ", DoT =" + getDamageOverTime() + ")";
	}
	
}
