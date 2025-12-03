package izzyn.aartifice;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import izzyn.aartifice.builders.ManaBuilder;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class Mana {
    public int Purity;
    public int Potency;
    public int Pull;
    public int Amount;
    private int Base_Storage;

    public static final Codec<Mana> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.INT.fieldOf("Base_Storage").forGetter(Mana::getBase_Storage),
            Codec.INT.optionalFieldOf("Amount", 0).forGetter(Mana::getAmount),
            Codec.INT.fieldOf("Purity").forGetter(Mana::getPurity),
            Codec.INT.fieldOf("Potency").forGetter(Mana::getPotency),
            Codec.INT.fieldOf("Pull").forGetter(Mana::getPull)

    ).apply(instance, Mana::new));

    public Mana(int _storage, int _amount, int _purity, int _potency, int _pull){
        this.Base_Storage = _storage;
        this.Amount = _amount;
        this.Purity = _purity;
        this.Potency = _potency;
        this.Pull = _pull;
    }

    public int getPurity() {
        return Purity;
    }

    public int getPotency() {
        return Potency;
    }

    public int getPull() {
        return Pull;
    }

    public int getAmount() {
        return Amount;
    }
    public int getBase_Storage(){
        return Base_Storage;
    }

    public static ManaBuilder builder() {
        return new ManaBuilder();
    }
    public int getTargetStorage(){
        return Pull*Base_Storage;
    }

    public void serialize(ValueOutput writeView){
        writeView.putInt("Purity", Purity);
        writeView.putInt("Potency", Potency);
        writeView.putInt("Pull", Pull);
        writeView.putInt("Amount", Amount);
        writeView.putInt("Base_Storage", Base_Storage);
    }
    public void deserialize(ValueInput readView){
        this.Purity = readView.getIntOr("Purity", 0);
        this.Potency = readView.getIntOr("Potency", 0);
        this.Pull = readView.getIntOr("Pull", 0);
        this.Base_Storage = readView.getIntOr("Base_Storage", 0);
        this.Amount = readView.getIntOr("Amount", 0);
    }
}