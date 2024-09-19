public class Fish extends Pet {
    protected Fish (){
        super("...",0);
    }


    @Override
    public String giveVoice() {
        return voice;

    }
}