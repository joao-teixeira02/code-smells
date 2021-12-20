package pt.up.fe.ldts.example4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WorkerTest {

    @Test
    public void testWorker() {
        Worker worker = new Worker("John Doe", "+1 222-22222", "john", "secret");
        Assertions.assertEquals("John Doe", worker.getName());
        Assertions.assertEquals("+1 222-22222", worker.getPhone());
        Assertions.assertFalse(worker.login("john", "wrong"));
        Assertions.assertTrue(worker.login("john", "secret"));
    }

    @Test
    public void testSupervisor() {
        Supervisor supervisor = new Supervisor("John Doe", "+1 222-22222", "john", "secret");

        Worker minion1 = new Worker("Minion 1", "+1 123-12345", "minion1", "1234");
        Worker minion2 = new Worker("Minion 2", "+1 123-12345", "minion2", "1234");
        supervisor.addSupervisee(minion1);

        Assertions.assertEquals("John Doe", supervisor.getName());
        Assertions.assertEquals("+1 222-22222", supervisor.getPhone());
        Assertions.assertFalse(supervisor.login("john", "wrong"));
        Assertions.assertTrue(supervisor.login("john", "secret"));
        Assertions.assertTrue(supervisor.isSupervisee(minion1));
        Assertions.assertFalse(supervisor.isSupervisee(minion2));
    }

    @Test
    public void testClient() {
        Client client = new Client("John Doe", "+1 222-22222");
        Assertions.assertEquals("John Doe", client.getName());
        Assertions.assertEquals("+1 222-22222", client.getPhone());
    }
}