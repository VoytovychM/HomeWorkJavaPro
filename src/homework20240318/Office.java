package homework20240318;

public class Office {
    public static void main(String[] args) {
       Task managerTask = new Task("Coordination", "Givivng task to the workers");
       Task developerTask = new Task("Development", "Write the code");
       Task qaTask = new Task("QA", "Testing the code");


       JobActions developer = new JobActions() {
           @Override
           public void doTask(Task task) {
               System.out.println("Developer taking task: " + task.getName() + " , " + task.getDescription());
           }

           @Override
           public void haveRest() {
               System.out.println("Developer eating salad");
           }
       };

       JobActions qaWorker = new JobActions() {
           @Override
           public void doTask(Task task) {
               System.out.println("QA received task: " + task.getName() + " " + task.getDescription() + " should have started ");
               this.haveRest();
           }

           @Override
           public void haveRest() {
               System.out.println("QA tester idles around");
           }
       };
       JobActions manager = new JobActions() {
           @Override
           public void doTask(Task task) {
               System.out.println("Manager taking task: " + task.getName() + " , " + task.getDescription());
               developer.doTask(developerTask);
               qaWorker.doTask(qaTask);
           }

           @Override
           public void haveRest() {
               System.out.println("Drink coffee ");
           }
       };

       manager.doTask(managerTask);


    }

}
