import org.pcap4j.core.PcapHandle;
import org.pcap4j.core.PcapPacket;
import org.pcap4j.core.Pcaps;
import org.pcap4j.packet.Packet;
import org.pcap4j.packet.TcpPacket;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        String fileName = "test.pcap";

        // Check if the file exists before opening it
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File not found under the project structre: " + fileName);
            return;
        }

        try (PcapHandle handle = Pcaps.openOffline(fileName)) {
            while (true) {
                Packet packet = handle.getNextPacket();

                if (packet == null) {
                    break;
                }

                System.out.println("data :  \n" + packet.toString());
                System.out.println("--------------------------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
