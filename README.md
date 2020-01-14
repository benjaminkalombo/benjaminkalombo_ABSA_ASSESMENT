# benjaminkalombo_ABSA_ASSESMENT

BUILDING:
download project, build as a maven project
go to application.prop to set DB password and Username. Kindly create a DB called cron.
NOTES:
for illustration purpose we run the cron job at 7 am on the 1st every month then stored the result in a form .xls on dropbox.

CLASSES:
CronTaskScheduler =>  implements CommandLineRunner this is called at when the application starts:
method:
    @Scheduled(cron = "0 0 7 1 * ?") . //scheduled to run billing processing at 7 am on the 1st every month
    public void process(){
        try {
            uploadFile();
        } catch (IOException | DbxException e) {
            e.printStackTrace();
        }
    }
    
    
    DropBox: implements the DROPBOX API for exporting the processed bills to a sharelocation, please note we can also use TFS.
    please refer to the pdf for answers to other part of the questions and also an in depth explaintion of the application.
    Regards,
    Benjamin
    +27659747056
    
    
    
    
