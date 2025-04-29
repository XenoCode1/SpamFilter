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
    public boolean check(String[][] phrases, double p){
        int matchpoints = 0;
        int temppoints = 0;
        for (int i = 0; i < phrases.length; i++){
            for(int e  = 0; e < emailText.length; e++){
                if(emailText[e].equals(phrases[i][0])){
                    temppoints = 1;
                    for(int x = 1; x < phrases[i].length; x++){
                        if(emailText[x].equals(phrases[i][x])){
                            //temppoints are used to store the total amount of matching words from a phrase
                            temppoints++;
                        }
                    }
                    //if the total tempoints matches the length of a phrase we have a match and add the poiints to the total
                    if(temppoints == phrases[i].length){
                        matchpoints+=temppoints;
                    }
                }
            }
        }
        if(matchpoints/emailText.length >= p){
            return true;
        }
        else{
            return false;
        }
    }
}
