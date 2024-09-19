public abstract class Pet{
    public String voice;
    private final int pawscount;

    protected Pet(String voice, int pawscount) {
        this.voice = voice;
        this.pawscount=pawscount;
    }
    public void sleep() {
        System.out.println("Сплю");
    }
    public void play() {
        System.out.println("Играю");
    }

    public String giveVoice() {

        return null;
    }


    public int getPawscount() {
        return pawscount;
    }
}