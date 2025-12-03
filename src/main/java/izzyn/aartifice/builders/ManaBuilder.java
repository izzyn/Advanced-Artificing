package izzyn.aartifice.builders;

import izzyn.aartifice.Mana;
import izzyn.aartifice.items.ManaBottle;

// :(
public class ManaBuilder {

    private int _purity = 0;
    private int _potency = 0;
    private int _pull = 0;
    private int _amount = 0;
    private int _base_storage = 0;
    public ManaBuilder() {}

    public Mana buildMana(){
        return new Mana(_base_storage, _amount, _purity, _potency, _pull);
    }
    public ManaBuilder purity(int _purity) {
        this._purity = _purity;
            return this;
    }
    public ManaBuilder potency(int _potency) {
        this._potency = _potency;
        return this;
    }
    public ManaBuilder pull(int _pull) {
        this._pull = _pull;
        return this;
    }
    public ManaBuilder amount(int _amount) {
        this._amount = _amount;
        return this;
    }
    public ManaBuilder baseStorage(int _base_storage) {
        this._base_storage = _base_storage;
        return this;
    }

}
