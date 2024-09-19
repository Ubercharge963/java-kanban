public class Cat extends Pet {
    protected Cat (){
        super("Мяу",6);
    }
    void catchMouse(){
        System.out.println("Поймала мышку!");
    }

    @Override
    public String giveVoice() {
        return voice;
    }
}