public class Dog extends Pet {
    protected Dog (){
        super("Bark",4);
    }
    void bringStick(){
        System.out.println("Принёс палочку, как хороший мальчик!");
    }

    @Override
    public String giveVoice() {

        return null;
    }
}