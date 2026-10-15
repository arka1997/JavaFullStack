package multithreading_concurrency.callable.sendemail;
public class EmailSenderTask {
    String email;
    String body;

    EmailSenderTask(String email, String body){
        this.email = email;
        this.body = body;
    }
    public Boolean sendEmail(String email, String body) {
        System.out.println("Email has been sent successfully to "+ email + Thread.currentThread().getName());
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }
}
