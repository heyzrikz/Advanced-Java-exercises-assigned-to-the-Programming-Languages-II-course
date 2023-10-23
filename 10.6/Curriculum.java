public class Curriculum{
    private Job last_job;
    public Job getJob(){
        return last_job;
    }
    private String name;
    Curriculum(String n){
        last_job = null;
        name = n;
    }

    public class Job{
        private String job_name;
        private int job_year;
        private Job next_job;
        Job(String n , int y){
            job_name = n;
            job_year = y;
            next_job = null;
        }

        public Job next(){
            return next_job;
        }

        public void setNext(Job j){
            next_job = j;
        }

        public String toString(){
            return job_name+": "+job_year;
        }

    }

    public Job addJob(String n_job, int y_job){
        if(last_job == null){
            last_job = new Job(n_job,y_job);
            return last_job;
        }else{
            Job j = new Job(n_job,y_job);
            last_job.setNext(j);
            last_job = j;
            return last_job;
        }

    }
}