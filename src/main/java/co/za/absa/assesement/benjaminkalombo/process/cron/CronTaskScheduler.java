package co.za.absa.assesement.benjaminkalombo.process.cron;

import co.za.absa.assesement.benjaminkalombo.model.Bill;
import co.za.absa.assesement.benjaminkalombo.process.FileExporter;
import co.za.absa.assesement.benjaminkalombo.service.BillService;

import java.io.*;
import java.util.List;

import co.za.absa.assesement.benjaminkalombo.process.dropbox.DropBox;
import com.dropbox.core.DbxException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronTaskScheduler implements CommandLineRunner {

    private final FileExporter fileExporter;
    private final DropBox dropBox;
    private final BillService billService;
    public CronTaskScheduler(FileExporter fileExporter, DropBox dropBox, BillService billService){
        this.fileExporter = fileExporter;
        this.dropBox = dropBox;
        this.billService = billService;
    }
    @Scheduled(cron = "0 0 7 1 * ?")
    public void process(){
        try {
            uploadFile();
        } catch (IOException | DbxException e) {
            e.printStackTrace();
        }
    }
    public void uploadFile() throws IOException, DbxException {
        File file = fileExporter.generateBillReport();
        dropBox.uploadFile(file);
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
       // uploadFile();
    }
}
