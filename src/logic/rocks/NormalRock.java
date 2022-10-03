package logic.rocks;

import logic.zombies.Zombie;

public class NormalRock {
	protected int damage;

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		if (damage < 0) {
			damage = 0;
		}
		this.damage = damage;
	}

	public NormalRock(int damage) {
		this.setDamage(damage);
	}
	
	public int dealDamage(Zombie zombie) {
		if(zombie.getDefense() < this.damage) {
			int damage_deal = this.getDamage() - zombie.getDefense();
			zombie.setHealth(zombie.getHealth() - damage_deal);
			return damage_deal;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "NormalRock (" + getDamage() + ")";
	}
	
}
