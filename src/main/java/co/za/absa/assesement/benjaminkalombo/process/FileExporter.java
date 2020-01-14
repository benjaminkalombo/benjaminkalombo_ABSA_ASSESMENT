package co.za.absa.assesement.benjaminkalombo.process;

import co.za.absa.assesement.benjaminkalombo.model.Bill;
import co.za.absa.assesement.benjaminkalombo.service.BillService;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

@Component
public class FileExporter {

    private final BillService billService;

    public FileExporter(BillService billService) {
        this.billService = billService;
    }

    public File generateBillReport() throws IOException {
        return exportCSV(billService.getAllBills());
    }

    private File exportCSV(final List<Bill> billList) throws IOException {
        File tempFile = null;
        if (billList.isEmpty()) {
            System.out.println("File is empty");
        } else {

            final String CSV_SEPARATOR = ",";
            final String tmpdir = System.getProperty("java.io.tmpdir");
            tempFile = File.createTempFile(tmpdir + "/results" + new Date().toString() + "BillingReport", ".txt");
            try {
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(tempFile), StandardCharsets.UTF_8));
                for (Bill bill : billList) {
                    // String status = promotion.getStatus();

                        StringBuffer oneLine = new StringBuffer();
                        oneLine.append(bill.getClientswiftaddress().trim().length() == 0 ? "" : bill.getClientswiftaddress());
                        oneLine.append(CSV_SEPARATOR);
                        oneLine.append(bill.getTransactionreference().trim().length() == 0 ? "" : bill.getTransactionreference());
                        oneLine.append(CSV_SEPARATOR);
                        oneLine.append(bill.getCurrency().trim().length() == 0 ? "" : bill.getCurrency());
                        oneLine.append(CSV_SEPARATOR);
                        oneLine.append(bill.getAmount() == 0 ? "" : bill.getAmount());
                        oneLine.append(CSV_SEPARATOR);
                        oneLine.append(bill.getMessagestatus().trim().length() == 0 ? "" : bill.getMessagestatus());
                        oneLine.append(CSV_SEPARATOR);
                        oneLine.append(bill.getDatetimecreated() == null ? "" : bill.getDatetimecreated());
                        oneLine.append(CSV_SEPARATOR);
                        bw.write(oneLine.toString());

                        bw.newLine();



                }
                bw.flush();
                bw.close();
            } catch (UnsupportedEncodingException | FileNotFoundException e) {

            } catch (IOException e) {

            }
        }
        return tempFile;

    }
}