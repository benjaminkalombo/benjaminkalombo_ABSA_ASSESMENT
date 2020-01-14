package co.za.absa.assesement.benjaminkalombo.process.dropbox;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;
import com.dropbox.core.v2.files.ListFolderResult;
import com.dropbox.core.v2.files.Metadata;
import com.dropbox.core.v2.users.FullAccount;
import org.springframework.stereotype.Component;

import java.io.*;


@Component
public class DropBox {


    private  String ACCESS_TOKEN;
    private DbxRequestConfig config;
    private   DbxClientV2 client;

    public DropBox(){
        init();
    }

    private void init(){
       config = new DbxRequestConfig("absa/api-upload", "en_US");
        ACCESS_TOKEN = "XAfnEtPuSeAAAAAAAAAAEXsJrUL6M-RNsbglBGv3WzcMLntZnL_My9v-Zc310jDM";
       client = new DbxClientV2(config, ACCESS_TOKEN);
    }

    public void uploadFile(File file) throws IOException, DbxException {
        System.out.println("uploadignfile to dropbox..");
        try (InputStream in = new FileInputStream(file)) {
            FileMetadata metadata = client.files().uploadBuilder("/" + file.getName() )
                    .uploadAndFinish(in);
            System.out.println("Done uploading file "+ file.getName() + " to DropBox");
        }
        file.deleteOnExit();
    }

    public FullAccount getAccount() throws DbxException {
        return client.users().getCurrentAccount();
    }
    public void viewDir() throws DbxException {
        ListFolderResult result = client.files().listFolder("");
        while (true) {
            for (Metadata metadata : result.getEntries()) {
                System.out.println(metadata.getPathLower());
            }

            if (!result.getHasMore()) {
                break;
            }

            result = client.files().listFolderContinue(result.getCursor());
        }

    }
}
