package RPG;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Morten on 05-02-2016.
 */
public class WeaponDamage {
    private List<Double> damage = new ArrayList<>();

    private void axe(){
        damage.add(1.3);
        damage.add(7.2);
        damage.add(9.1);
    }
    private void flail(){
        damage.add(1.4);
        damage.add(1.0);
        damage.add(14.4);
    }
    private void hands(){
        damage.add(1.0);
        damage.add(1.0);
        damage.add(3.9);

    }
    private void sword(){
        damage.add(1.4);
        damage.add(8.4);
        damage.add(10.5);
    }

    public List<Double> getSpeedAndDamage(WeaponTypes weapon){
        switch (weapon){
            case Axe:
                axe();
                break;
            case Flail:
                flail();
                break;
            case Hands:
                hands();
                break;
            case Sword:
                sword();
                break;
        }
        return damage;

    }

}
