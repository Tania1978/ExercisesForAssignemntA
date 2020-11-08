package ExercisesAssignment1;

public class Pet {

    private String nickname;
    private String type;

    public Pet(String nickname) {
        this.nickname = nickname;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNickname() {
        return nickname;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return " a " + type + " named " + nickname;
    }
}
