
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class SpamFilter{

    public static void main(String args[]){

        File emails = new File("spam_or_not_spam.csv");
        try {
            Scanner scan = new Scanner(emails);
            scan.useDelimiter(",");
            ArrayList<Emails> allEmails = new ArrayList<Emails>();
            int emailsCount = 0;
            String text1 = scan.next();
            String text2;
            while(scan.hasNextLine()){
                text2 = scan.next();
                allEmails.add(new Emails(text1));
                //System.out.println(text2.charAt(0));
                allEmails.get(emailsCount).setType(text2.charAt(0));
                text1 = text2.substring(1);
                //allEmails.get(emailsCount).getType(); //used to ensure that all emails  are being collected
                emailsCount++;
            }

            String[][] phrases= {
                {"buy", "now"},
                {"limited", "time", "offer"},
                {"act", "now"},
                {"compare", "rates"},
                {"Don't", "hesistate"},
                {"lose", "weight"},
                {"action", "required"},
                {"benefical", "offer"},
                {"cancel", "any", "time"},
                {"additonal", "income"},
                {"be", "your", "own", "boss"},
                {"free", "money"},
                {"free", "trial"},
                {"full", "refund"},
                {"apply", "now"},
                {"become", "a", "member"},
                {"call", "now"},
                {"get", "it", "now"},
                {"limited", "time"},
                {"You", "have", "been", "selected"}
                //more phrases more accuracy
            };
            int amountCorrect = 0;
            for(int i = 0; i < allEmails.size(); i++){
                if(!(allEmails.get(i).check(phrases, 0.5)) && allEmails.get(i).getType() == '0'){
                    amountCorrect++;
                }
                else if(allEmails.get(i).check(phrases, 0.5) && allEmails.get(i).getType() == '1'){
                    amountCorrect++;
                }
            }
            System.out.println((double)(amountCorrect)/(double)emailsCount);
        } catch (Exception e) {
            System.out.println("Emails not found");
        } 
    }
}