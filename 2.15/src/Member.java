
public class Member {
    /*会员姓名*/
    private String name;
    /*会员卡号*/
    private int cardId ;
    /*密码*/
    private String  passWord;
    /*积分*/
    private int score;
    /*开卡日期*/
    private String registDate;
    /*有参构造方法*/
    public Member(String name, int cardId, String passWord, int score,
                  String registDate) {
        super();
        this.name = name;
        this.cardId = cardId;
        this.passWord = passWord;
        this.score = score;
        this.registDate = registDate;
    }
    //无参构造
    public Member() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public String getRegistDate() {
        return registDate;
    }
    public void setRegistDate(String registDate) {
        this.registDate = registDate;
    }
}

