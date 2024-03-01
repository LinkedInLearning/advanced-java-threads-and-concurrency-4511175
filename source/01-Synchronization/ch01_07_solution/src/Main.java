public class Main {
    public static void main(String[] args) {

        InventoryManager inventoryManager = new InventoryManager();
        Thread issuer = new Thread(inventoryManager, "issue");
        Thread receiver = new Thread(inventoryManager, "receive");

        issuer.start();
        receiver.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Current number of items in inventory: " + inventoryManager.getItemCount());
    }
}
