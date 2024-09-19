public class Hamster extends Pet {
    protected Hamster (){
        super("peek",4);
    }
    void hideFood(){
        System.out.println("Вся еда — в щёчках!");
    }

    @Override
    public String giveVoice() {

        return null;
    }
}