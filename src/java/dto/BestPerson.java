package dto;

public class BestPerson {
    
    public enum Gender implements AutoCloseable {
        MALE (0), FEMALE (1);
        
        private final int gender;
        
        private Gender(int gender) { this.gender = gender;}
        
        public static Gender fromInt(int gender) {
            for (Gender g : Gender.values()) {
                if (g.getGender() == gender)
                    return g;
            }
            return null;  
        }
        
        public int getGender() { return this.gender; }
        
        @Override
        public void close() {}
    }
    
    private String cod;
    private  String name;
    private  String nickname;
    private  String picURL;
    private  boolean couple;
    private  Gender gender;
    private  String text;

    public BestPerson (String cod, String name, String nickname, String picURL, boolean couple, Gender gender, String text) {
        this.cod = cod;
        this.name = name;
        this.nickname = nickname;
        this.picURL = picURL;
        this.couple = couple;
        this.gender = gender;
        this.text = text;
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

    public String getText() {
        return text;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public void setCouple(boolean couple) {
        this.couple = couple;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setText(String text) {
        this.text = text;
    }

}
