public class Philosopher implements Runnable{

    private Object leftFork;
    private Object rightFork;
    private Object name;


    public Philosopher(Object leftFork, Object rightFork, Object name) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.name = name;
    }

    @Override
    public void run() {

        int count = 1;
        try {
            while (count <= 3) {

                printAction(" пока размышляет.");
                synchronized (leftFork) {
                    printAction(" взял левую вилку.");
                    synchronized (rightFork) {

                        if(count==1){
                            printAction(" взял правую вилку и поел в "+count+"-ый раз.");
                        } else if (count==2) {
                            printAction(" взял правую вилку и поел во "+count+"-ой раза.");
                        } else{
                            printAction(" взял правую вилку и поел в "+count+"-ий раза.");
                        }
                    }
                    printAction(" полжил левую вилку и снова погрузился в размышления.");
                }
                count++;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }
        private void printAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }

    public void goEat(Philosopher[] philosophers,Object[] forks, Object[] names){
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1) {

                philosophers[i] = new Philosopher(rightFork, leftFork, names);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork, names);
            }

            Thread t = new Thread(philosophers[i], "Философ " + names[i]);
            t.start();
        }

    }

}
