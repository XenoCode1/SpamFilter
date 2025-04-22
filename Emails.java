public class Emails {
    private String[] emailText;
    private char emailType;
    public Emails(String t){
        emailText = t.split(" ");
        //emailType is set to 2 here incase of a error
        emailType = '2';
    }
     
    public void setType(char t){
        emailType = t;
    }
        
    public String toString(){
        String r="";
        for(int i = 0; i<emailText.length; i++)
            r+=emailText[i]+" ";
        return r;
    }
    public char getType(){
        return emailType;
    }
}
