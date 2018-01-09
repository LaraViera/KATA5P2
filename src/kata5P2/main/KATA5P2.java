package kata5P2.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import kata5P2.model.Histogram;
import kata5P2.model.Mail;
import kata5P2.view.HistogramDisplay;
import kata5P2.view.MailHistogramBuilder;
import kata5P2.view.MailListReaderDB;

public class KATA5P2 {
    
    private static List<Mail> mailList;
    private static Histogram<String> histogram;
    
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        new KATA5P2().execute();
    }
    
    public void execute() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException{
        input();
        process();
        output();
    }
    
    private static void input() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException {
        mailList =  MailListReaderDB.read();
    }
    private static void process() throws IOException{
        histogram = MailHistogramBuilder.build(mailList);
    }
    private static void output(){
        HistogramDisplay histoDisplay = new HistogramDisplay(histogram);
        histoDisplay.execute();
    }
}
