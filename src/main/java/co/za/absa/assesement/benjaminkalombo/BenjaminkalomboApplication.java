package co.za.absa.assesement.benjaminkalombo;

import co.za.absa.assesement.benjaminkalombo.service.BillService;
import com.dropbox.core.*;
import com.dropbox.core.v1.DbxEntry;
import com.dropbox.core.v1.DbxWriteMode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

//import com.dropbox.core.DbxClient;
//import com.dropbox.core.DbxEntry;

//import com.dropbox.core.DbxWriteMode;


@SpringBootApplication
@EnableScheduling
public class BenjaminkalomboApplication {

    public static void main(String[] args){

        SpringApplication.run(BenjaminkalomboApplication.class, args);
    }


}





