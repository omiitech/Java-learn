public class LiftProgram {
    public static void main(String[] args) throws InterruptedException {
        for (int floor = 1; floor <= 20; floor++) {
            if (floor == 13) {
                System.out.println("Skipping floor 13...");
                break; // stop after reaching 13
            }
            System.out.println("Floor: " + floor);
            Thread.sleep(1000); // wait 1 second
        }
    }
}
