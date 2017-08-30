package dto;

public abstract class BestPerson {
    
    public enum Gender implements AutoCloseable {
        MALE (0), FEMALE (1);
        
        private final int gender;
        
        private Gender(int gender) { this.gender = gender;}
        
        public int getGender() { return this.gender; }
        
        @Override
        public void close() {}
    }
    
    private final String cod;
    private final String name;
    private final String nickname;
    private final String picURL;
    private final boolean couple;
    private final Gender gender;

    public BestPerson (String cod, String name, String nickname, String picURL, boolean couple, Gender gender) {
        this.cod = cod;
        this.name = name;
        this.nickname = nickname;
        this.picURL = picURL;
        this.couple = couple;
        this.gender = gender;
    }

    public String getCod() {
        return cod;
    }
    
    public String getName() {
        return name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPicURL() {
        return picURL;
    }

    public boolean isCouple() {
        return couple;
    }

    public Gender getGender() {
        return gender;
    }

}
